/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.astra.anblicks.pdca.clakpi.portlet;

import com.astra.anblicks.pdca.clakpi.dto.CompanyDataByUserDto;
import com.astra.anblicks.pdca.clakpi.services.sql.PdcaMySqlConnection;
import com.astra.anblicks.pdca.clakpi.services.sql.PdcaSqlQueries;
import com.astra.anblicks.pdca.clakpi.utils.PdfUtils;
import com.astra.anblicks.pdca.model.cla_kpi;
import com.astra.anblicks.pdca.model.kpi;
import com.astra.anblicks.pdca.model.pdca_AdminSettings;
import com.astra.anblicks.pdca.service.AstraPdca_CompanyDataLocalServiceUtil;
import com.astra.anblicks.pdca.service.achivementFormulaLocalServiceUtil;
import com.astra.anblicks.pdca.service.cla_kpiLocalServiceUtil;
import com.astra.anblicks.pdca.service.itemDescriptionLocalServiceUtil;
import com.astra.anblicks.pdca.service.kpiLocalServiceUtil;
import com.astra.anblicks.pdca.service.pdca_AdminSettingsLocalServiceUtil;
import com.astra.anblicks.pdca.service.typeLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.AdministratorControlPanelEntry;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=AstraPDCA",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=PDCA-CLAKpi Portlet",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
		)
public class CLAUpdateKpiPortlet extends MVCPortlet {
	
	
	public static Connection conn = PdcaMySqlConnection.getConnection();

	public void addKpi(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionResponse.setRenderParameter("mvcPath", "/cla/addkpi.jsp");
	}
	
@Override
public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
	// TODO Auto-generated method stub
	 ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	 PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
     renderRequest.setAttribute("isAdmin", permissionChecker.isOmniadmin());
	super.doView(renderRequest, renderResponse);
}

/*	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		 ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		 PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
	     renderRequest.setAttribute("isAdmin", permissionChecker.isOmniadmin());
		super.doView(renderRequest, renderResponse);
	}*/

	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		    throws IOException, PortletException
		  {
		    String cmd = ParamUtil.getString(resourceRequest, "cmd");
		    if (cmd.equalsIgnoreCase("list")) {
		    	 try {
		    		    JSONObject json = JSONFactoryUtil.createJSONObject();
		    		    JSONArray jsonData = JSONFactoryUtil.createJSONArray();
		    		    ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		    		    DynamicQuery dynamicQuery_kpi = kpiLocalServiceUtil.dynamicQuery();
						Criterion criterion = null;
						criterion = RestrictionsFactoryUtil.eq("companyId", ParamUtil.getLong(resourceRequest, "company"));
						criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("year", ParamUtil.getLong(resourceRequest, "year")));
						criterion = RestrictionsFactoryUtil.and(criterion,RestrictionsFactoryUtil.eq("userId",themeDisplay.getUser().getUserId()) );
						dynamicQuery_kpi.add(criterion);
		    	        List <kpi> list_kpi = kpiLocalServiceUtil.dynamicQuery(dynamicQuery_kpi);
		    	        for (kpi kpiMode_ : list_kpi)
		    	    		try {
		    	    			{
		    	    			  jsonData.put(TOJson(kpiMode_ ,ParamUtil.getLong(resourceRequest, "period"),deleteEditPer(resourceRequest)));
		    	    			}
		    	    		} catch (Exception e) {
		    	    			logger.error(e);
		    	    			e.printStackTrace();
		    	    		}
		    	        json.put("kpi_Data", jsonData);
		    	        writeJSON(resourceRequest, resourceResponse, json);	
				} catch (Exception e) {
					    logger.error("list"+e);
					    JSONObject json = JSONFactoryUtil.createJSONObject();
				        json.put("error", "storeDefault Unsuccessful");
				        writeJSON(resourceRequest, resourceResponse, json);										}
	     
		    }
		    
		    else if(cmd.equalsIgnoreCase("getTableDataOnchage")){
		    	 try {
		    		 JSONObject json = JSONFactoryUtil.createJSONObject();
		    		  JSONArray jsonData = JSONFactoryUtil.createJSONArray();
		    		 ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
 		    		    DynamicQuery dynamicQuery_kpi = kpiLocalServiceUtil.dynamicQuery();
						Criterion criterion = null;
						criterion = RestrictionsFactoryUtil.eq("companyId", ParamUtil.getLong(resourceRequest, "company"));
						criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("year", ParamUtil.getLong(resourceRequest, "year")));
						criterion = RestrictionsFactoryUtil.and(criterion,RestrictionsFactoryUtil.eq("userId",themeDisplay.getUser().getUserId()) ); 
						dynamicQuery_kpi.add(criterion);
		    	        List <kpi> list_kpi = kpiLocalServiceUtil.dynamicQuery(dynamicQuery_kpi);
		    	        for (kpi kpiMode_ : list_kpi)
		    	    		try {
		    	    			{
		    	    			  jsonData.put(TOJson(kpiMode_ ,0l, deleteEditPer(resourceRequest)));
		    	    			}
		    	    		} catch (Exception e) {
		    	    			e.printStackTrace();
		    	    		}
		    	        json.put("kpi_Data", jsonData);
		    	        writeJSON(resourceRequest, resourceResponse, json);	    	        
		    
				} catch (Exception e) {
					  logger.error(e);
					   JSONObject json = JSONFactoryUtil.createJSONObject();
				        json.put("error", "storeDefault Unsuccessful");
				        writeJSON(resourceRequest, resourceResponse, json);										}
	     
		    }
		    else if(cmd.equalsIgnoreCase("onloadAdminSettings")){
		    	 ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		    	try {
		    		JSONArray jsonArray=JSONFactoryUtil.createJSONArray();
			    	JSONObject json=JSONFactoryUtil.createJSONObject();
		    	  	List<CompanyDataByUserDto>  list_=PdcaSqlQueries.getCompanyDataBasedOnModuleId_UserId(conn, themeDisplay.getUser().getUserId(), 1l);
		    	  	pdca_AdminSettings getadminsettingModuleData = getadminsettingModuleData(1l);
		   	    	 if(list_.size()>0){
		   	   		 for(CompanyDataByUserDto model:list_){
		   	   			 JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
		   	   			 jsonObject.put("year",getadminsettingModuleData.getYear());
		   	   			 jsonObject.put("period", getadminsettingModuleData.getPeriodId());
		   	   			 jsonObject.put("companyId", model.getCompanyId());
		   	   			 jsonObject.put("companyName", model.getCompanyName());
		   	   			 jsonArray.put(jsonObject);
		   	   		 }
		   	   		 
		   	   	json.put("settingData", jsonArray);
		   	   		 
		   	   		 writeJSON(resourceRequest, resourceResponse, json);
		   	   	 } 					
				} catch (Exception e) {
					logger.error(e);
					   JSONObject json = JSONFactoryUtil.createJSONObject();
				        json.put("error", "storeDefault Unsuccessful");
				        writeJSON(resourceRequest, resourceResponse, json);
				}
		    }
		    else if(cmd.equalsIgnoreCase("pdfdownload")) {
		    	try {
		    		 JSONObject json = JSONFactoryUtil.createJSONObject();
		       		 ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		       		    	logger.info(ParamUtil.getLong(resourceRequest, "company"));
		       		    	logger.info(ParamUtil.getLong(resourceRequest, "year"));
		       		    DynamicQuery dynamicQuery_kpi = kpiLocalServiceUtil.dynamicQuery();
		    				Criterion criterion = null;
		    				criterion = RestrictionsFactoryUtil.eq("companyId", ParamUtil.getLong(resourceRequest, "company"));
		    				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("year", ParamUtil.getLong(resourceRequest, "year")));
		    				criterion = RestrictionsFactoryUtil.and(criterion,RestrictionsFactoryUtil.eq("userId",themeDisplay.getUser().getUserId()) ); 
		    				
		    				dynamicQuery_kpi.add(criterion);
		    				
		       	        List <kpi> list_kpi = kpiLocalServiceUtil.dynamicQuery(dynamicQuery_kpi);
		       	        
		       	        String DownloadUrl = StringPool.BLANK;
		       	        
		       	        DownloadUrl = PdfUtils.getCompany_Kpis_PdfUrl(ParamUtil.getLong(resourceRequest, "company"),ParamUtil.getLong(resourceRequest, "year"),list_kpi,resourceRequest,resourceResponse);
		       	        
		       	        json.put("success", "success");
		       	        json.put("link", DownloadUrl);
		    	        writeJSON(resourceRequest, resourceResponse, json);	   
		       	        
				} catch (Exception e) {
					logger.error(e);
					   JSONObject json = JSONFactoryUtil.createJSONObject();
				        json.put("error", "storeDefault Unsuccessful");
				        writeJSON(resourceRequest, resourceResponse, json);	
				}
		   	
   	        
		    	
		    }
		    
		    }


  private pdca_AdminSettings getadminsettingModuleData(long moduleId) {
	  
	  DynamicQuery dynamicQuery=pdca_AdminSettingsLocalServiceUtil.dynamicQuery();
	  dynamicQuery.add(PropertyFactoryUtil.forName("moduleId").eq(moduleId));
	  List<pdca_AdminSettings> list_AdminSettings=pdca_AdminSettingsLocalServiceUtil.dynamicQuery(dynamicQuery);
	  
	  return list_AdminSettings.get(0);
		
	}




public void deleteProfile(ActionRequest actionRequest, ActionResponse actionResponse) {
	    long userId = Long.parseLong(actionRequest.getParameter("userid"));
	    try {
	  //    TestimonialAshokLocalServiceUtil.deleteTestimonialAshok(userId);
	    	 actionRequest.setAttribute("deleteId", userId);
	    	 actionResponse.setRenderParameter("jspPage", "/cla/updatekpi.jsp");
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	  
	  public void editProfile(ActionRequest actionRequest, ActionResponse actionResponse) { 
	  String userId = actionRequest.getParameter("editid");
	    try {
	      actionRequest.setAttribute("editid", userId);
	      actionResponse.setRenderParameter("jspPage", "/cla/updatekpi.jsp");
	    } catch (Exception e) {
	      e.printStackTrace();
	  //    _log.error(e);
	    }
	  }
	  

public static JSONObject TOJson(kpi kpiMode_, Long period , boolean editDeleteFalg) throws PortalException 
  {
		DynamicQuery dynamicQueryForCla_Kpi = cla_kpiLocalServiceUtil.dynamicQuery();
		dynamicQueryForCla_Kpi.add(PropertyFactoryUtil.forName("kpiId").eq(kpiMode_.getKpiId()) );
        Criterion reqcriterion = null;
        reqcriterion = RestrictionsFactoryUtil.eq("periodId",period);
        dynamicQueryForCla_Kpi.add(reqcriterion);
        List <cla_kpi> claKpiList = cla_kpiLocalServiceUtil.dynamicQuery(dynamicQueryForCla_Kpi);
	  
 
       JSONObject json   = JSONFactoryUtil.createJSONObject();          
    	   json.put("kpiId", kpiMode_.getKpiId());
    	    json.put("company", AstraPdca_CompanyDataLocalServiceUtil.getAstraPdca_CompanyData(kpiMode_.getCompanyId()).getCompanyName());
		    json.put("type", typeLocalServiceUtil.gettype(kpiMode_.getTypeId()).getTypeName());
		    json.put("weight", kpiMode_.getWeight());
		    json.put("target", kpiMode_.getTarget());
		    json.put("year",  kpiMode_.getYear());
		    json.put("period",  period);
		    json.put("editDeleteFlag", editDeleteFalg);
		    if(kpiMode_.getTypeId()==2){json.put("itemDec", kpiMode_.getItemDescriptionValue());}
		    else{ json.put("itemDec",  itemDescriptionLocalServiceUtil.getitemDescription(Long.parseLong(kpiMode_.getItemDescriptionName())).getItemDescriptionName());}
		    json.put("unit",  kpiMode_.getUnit());
		    json.put("achivementformula",  achivementFormulaLocalServiceUtil.getachivementFormula(kpiMode_.getAchivementFormulaId()).getAchivementFormula());
		    if(!claKpiList.isEmpty()){
		    json.put("CLAPoint",  claKpiList.get(0).getClaPoint());
		    json.put("Achivement",  claKpiList.get(0).getAchivement());
		    json.put("YTD",  claKpiList.get(0).getYtd());
		    json.put("OL1FY", claKpiList.get(0).getOl());
		    json.put("OL2FY", claKpiList.get(0).getOl());
		    json.put("OLAdj", claKpiList.get(0).getOl());
		    json.put("OL3FY", claKpiList.get(0).getOl());
		    json.put("OLFY",  claKpiList.get(0).getOl());
		    }
		    else {
		            json.put("CLAPoint",  " ");
				    json.put("Achivement", " " );
				    json.put("YTD",  " ");
				    json.put("OL1FY", " ");
				    json.put("OL2FY", " ");
				    json.put("OLAdj", " ");
				    json.put("OL3FY", " ");
				    json.put("OLFY",  " ");
		    	
		    }
       		    return json;	
  }
	public static boolean deleteEditPer(ResourceRequest resourceRequest){
		 ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		 boolean editDeletePermission=false;
		 PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
	      if(!permissionChecker.isOmniadmin()){
	     	List<CompanyDataByUserDto>  list_=PdcaSqlQueries.getCompanyDataBasedOnModuleId_UserId(conn, themeDisplay.getUser().getUserId(), 1l);
	     	if(list_.size()>0){
	     		for(CompanyDataByUserDto val:list_){
	     			if(ParamUtil.getLong(resourceRequest, "company")==val.getCompanyId()) editDeletePermission=true;break;
	     		}
	   		  }}else{editDeletePermission=true;}
	        logger.info(editDeletePermission);
	        return editDeletePermission;
	}
	private static Log logger = LogFactoryUtil.getLog(CLAUpdateKpiPortlet.class.getName());
}