package com.astra.anblicks.pdca.clakpi.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.astra.anblicks.pdca.clakpi.constants.PDCAPortletKeys;
import com.astra.anblicks.pdca.model.kpi;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.CssFile;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

public class PdfUtils {
	
	public static final String DEST = "E:/html_table_2.pdf";
    public static final String CSS = "table,th,td { border: 1px soild black; border-collapse: collapse; } th, td { padding: 5px; text-align: center; } #financial,#strategies { background-color: #FCFC8F; } td p{ font-size: 12px !important; }";
	

	public static String getCompany_Kpis_PdfUrl(long companyId,long year, List<kpi> list_kpis, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
	        String url = null;
	        try {
				ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
				long repositoryId = themeDisplay.getScopeGroupId();
				Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
				Folder folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId,
						PDCAPortletKeys.AstraParentFolderName);
				FileEntry fileEntry = DLAppServiceUtil.getFileEntry(repositoryId, folder.getFolderId(),
						PDCAPortletKeys.AstraSamplePdf);
				File file = DLFileEntryLocalServiceUtil.getFile(fileEntry.getFileEntryId(), "", true);
				boolean isFolderExist = isFolderExist(themeDisplay, PDCAPortletKeys.CLAFolderName);
				if (!isFolderExist) {
					createFolder(resourceRequest, themeDisplay, PDCAPortletKeys.CLAFolderName);
				}
				Folder rootfolder = getFolder(themeDisplay, PDCAPortletKeys.CLAFolderName);
				url = createPdf(companyId,year,list_kpis,themeDisplay, resourceRequest, rootfolder, fileEntry, file);
				System.out.println(url);
				
				
			} catch (Exception e) {
			}
	        return url;
	}
	
	
	private static String createPdf(long companyId,long year, List<kpi> list_kpis,ThemeDisplay themeDisplay, ResourceRequest resourceRequest, Folder rootfolder,
			FileEntry fileEntry, File file) throws PortalException{
		
		
		long timeNow = System.currentTimeMillis();
		final long latest = timeNow;
		String title = "Report_Kpis_"+"_"+year+"_"+latest;
		String description = "Pdf for Kpis Based on company and year";
		String url = null; 
		
		  // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = null;
		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(file));
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // step 3
        document.open();
        // step 4
        String claPdfToHtmlTemplate = null;
		try {
			claPdfToHtmlTemplate = PdftoHtmlTemplate.getClaPdfToHtmlTemplate(companyId,list_kpis);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        CSSResolver cssResolver = new StyleAttrCSSResolver();
        CssFile cssFile = XMLWorkerHelper.getCSS(new ByteArrayInputStream(CSS.getBytes()));
        cssResolver.addCss(cssFile);
 
        // HTML
        HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);
        htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
 
        // Pipelines
        PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
        HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
        CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);
 
        // XML Worker
        XMLWorker worker = new XMLWorker(css, true);
        XMLParser p = new XMLParser(worker);
        try {
			p.parse(new ByteArrayInputStream(claPdfToHtmlTemplate.getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
  
        document.close();
        
        ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),resourceRequest);
		FileEntry addFileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(),rootfolder.getFolderId(), fileEntry.getFileName(),fileEntry.getMimeType(), title, description, "", file, serviceContext);
		url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() +"/documents/" + themeDisplay.getScopeGroupId() + "/" +addFileEntry.getFolderId() + "/" + addFileEntry.getTitle();
		System.out.println(url);
	    return url;
		
	}
	
	
	private static Folder createFolder(ResourceRequest resourceRequest, ThemeDisplay themeDisplay, String clafoldername) {
		Folder folder = null;
		long repositoryId = themeDisplay.getScopeGroupId();
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), resourceRequest);
			folder = DLAppServiceUtil.addFolder(repositoryId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, clafoldername,
					PDCAPortletKeys.CLAFolderDesc, serviceContext);
		} catch (PortalException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		return folder;
	}

	private static boolean isFolderExist(ThemeDisplay themeDisplay, String ROOT_FOLDER_NAME) {
		boolean folderExist = false;
		try {
			DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
					ROOT_FOLDER_NAME);
			folderExist = true;
			System.out.println("Folder is already Exist");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return folderExist;
	}

	private static Folder getFolder(ThemeDisplay themeDisplay, String ROOT_FOLDER_NAME) {
		Folder folder = null;
		try {
			folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return folder;
	}
	
	
	
	
	public static void createPdf(long companyId, List<kpi> list_kpis, String file) throws IOException, DocumentException, PortalException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
        // step 3
        document.open();
        // step 4
        String claPdfToHtmlTemplate = PdftoHtmlTemplate.getClaPdfToHtmlTemplate(companyId,list_kpis);
 
        CSSResolver cssResolver = new StyleAttrCSSResolver();
        CssFile cssFile = XMLWorkerHelper.getCSS(new ByteArrayInputStream(CSS.getBytes()));
        cssResolver.addCss(cssFile);
 
        // HTML
        HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);
        htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
 
        // Pipelines
        PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
        HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
        CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);
 
        // XML Worker
        XMLWorker worker = new XMLWorker(css, true);
        XMLParser p = new XMLParser(worker);
        p.parse(new ByteArrayInputStream(claPdfToHtmlTemplate.getBytes())); 
  
        document.close();
    }
	
}
