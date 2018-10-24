package com.astra.anblicks.pdca.portlet;

import com.astra.anblicks.pdca.model.AstraPdca_CompanyData;
import com.astra.anblicks.pdca.model.ControlMOM;
import com.astra.anblicks.pdca.model.ListMOM;
import com.astra.anblicks.pdca.model.MOMPointdiscussoin;
import com.astra.anblicks.pdca.model.pdca_AdminSettings;
import com.astra.anblicks.pdca.service.AstraPdca_CompanyDataLocalServiceUtil;
import com.astra.anblicks.pdca.service.ControlMOMLocalServiceUtil;
import com.astra.anblicks.pdca.service.ListMOMLocalServiceUtil;
import com.astra.anblicks.pdca.service.MOMPointdiscussoinLocalServiceUtil;
import com.astra.anblicks.pdca.service.pdca_AdminSettingsLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

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
		"javax.portlet.display-name=PDCA-ListMOM Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/ListMOM/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ListMOMPortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		  ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		   renderRequest.setAttribute("ListMOMData", getListMOMInDoview(themeDisplay.getUserId()));
		super.doView(renderRequest, renderResponse);
	}
	
	 public static String getListMOMInDoview(long userId){
		 DynamicQuery dq_ListMOM=ListMOMLocalServiceUtil.dynamicQuery();
		 dq_ListMOM.add(PropertyFactoryUtil.forName("userId").eq(userId));
		 List<ListMOM> listlMOM=ListMOMLocalServiceUtil.dynamicQuery(dq_ListMOM);
		
		 JSONArray jsonArray=JSONFactoryUtil.createJSONArray();
		 JSONObject jsonObject1=JSONFactoryUtil.createJSONObject();

             if(listlMOM.size()>0){
            	 for(ListMOM val:listlMOM){
            		 JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
            		 jsonObject.put("MeegtigType", val.getMomType());
            		 DynamicQuery dq=AstraPdca_CompanyDataLocalServiceUtil.dynamicQuery();
            		 dq.add(PropertyFactoryUtil.forName("companyId").eq(val.getCompanyId()));
            	List<AstraPdca_CompanyData> list=	AstraPdca_CompanyDataLocalServiceUtil.dynamicQuery(dq);
            	if(list.size()>0){
            		jsonObject.put("CompanyName", list.get(0).getCompanyName());
            	}
            		 jsonObject.put ("Group" ,val.getMOMGroup());
            		 jsonObject.put("MOMId", val.getMomId());
            		 jsonObject.put("pdId_", val.getPonitDiscussionId());
            		 jsonObject.put("pointDis", CreatePDJsonArray(val.getPonitDiscussionId()));
            		 jsonArray.put(jsonObject);
            	 }
            	 
             }		 
		 return  jsonObject1.put("listmom", jsonArray).toString();
	 }
	 
	 public static JSONArray CreatePDJsonArray(long pdId){
		 
		 JSONArray jsonArray=JSONFactoryUtil.createJSONArray();
		 DynamicQuery dq_pds=  MOMPointdiscussoinLocalServiceUtil.dynamicQuery();
		 dq_pds.add(PropertyFactoryUtil.forName("MOMpdId").eq(pdId));
		 List<MOMPointdiscussoin> pdsList=MOMPointdiscussoinLocalServiceUtil.dynamicQuery(dq_pds);
		 if(pdsList.size()>0){
			 for(MOMPointdiscussoin val:pdsList){
				 JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
				 jsonObject.put("pdId", val.getPdId());
				 jsonObject.put("PonintDiscussionName", val.getPonintDiscussionName());
				 jsonObject.put("notes", val.getNotes());
				 jsonArray.put(jsonObject);
			 } 
		 }
		 
		 return jsonArray;
	 }
	 public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
				throws IOException, PortletException {
			  ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			    String cmd = ParamUtil.getString(resourceRequest, "cmd");
			    if (cmd.equalsIgnoreCase("ShareMOM")) {
			    	try {
			    		JSONObject json = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("shareMOMData"));
			    		logger.info(json);
			    		  JSONArray toEmailJsonArray = JSONFactoryUtil.createJSONArray( json.getString("toEmals") );
			    		  if(null!=toEmailJsonArray){
			    		     for (int i = 0; i < toEmailJsonArray.length(); i++) {
						    /*	 pdca_AdminSettings adminSettings=pdca_AdminSettingsLocalServiceUtil.createpdca_AdminSettings(CounterLocalServiceUtil.increment());					
						    	 adminSettings.setModuleId(ParamUtil.getLong(resourceRequest, "moduleId"));
						    	 adminSettings.setYear(ParamUtil.getLong(resourceRequest, "yearvalue"));
						    	 adminSettings.setPeriodId(ParamUtil.getLong(resourceRequest, "periodvalue"));
						    	 adminSettings.setCompanyId(configValues.getLong(i));
						    	 pdca_AdminSettingsLocalServiceUtil.updatepdca_AdminSettings(adminSettings);	*/	
			    		    	 
			    		    	 ControlMOM controlMOM=ControlMOMLocalServiceUtil.createControlMOM(CounterLocalServiceUtil.increment());
			    		    	 controlMOM.setUserId(toEmailJsonArray.getLong(i));
			    		    	 controlMOM.setListMOMId(json.getLong("meetingId"));
			    		    	 controlMOM.setPdId(json.getLong("pdId"));
			    		    	 controlMOM.setFollowUpData(getJsonarrayDisPoints(json.getLong("pdId")).toString());
			    		    	 ControlMOMLocalServiceUtil.updateControlMOM(controlMOM);
						    	}}
		  			     	 
					     	JSONObject Sucessjson = JSONFactoryUtil.createJSONObject();
					     	Sucessjson.put("sucess", "added");
			   		      writeJSON(resourceRequest, resourceResponse,Sucessjson);
					} catch (Exception e) {
					     	logger.error(e);
						   JSONObject json = JSONFactoryUtil.createJSONObject();
					      json.put("error", "error");
					       writeJSON(resourceRequest, resourceResponse, json);	
							}
			    }
			    
	 }
	 
	 public static JSONArray getJsonarrayDisPoints(long mompdId){
		 DynamicQuery dynamicQuery=MOMPointdiscussoinLocalServiceUtil.dynamicQuery();
		 dynamicQuery.add(PropertyFactoryUtil.forName("MOMpdId").eq(mompdId));
		 List<MOMPointdiscussoin> list=MOMPointdiscussoinLocalServiceUtil.dynamicQuery(dynamicQuery);
		 JSONArray jsonArray=JSONFactoryUtil.createJSONArray();

		 if(list.size()>0)
		 {
			 for(MOMPointdiscussoin val:list){
				 JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
				 jsonObject.put("pdID", val.getPdId());
				 jsonObject.put("followUP", "");
				 jsonObject.put("status", "");
				 jsonArray.put(jsonObject);
			 }
		 }
		 
		 return jsonArray;
	 }
 private static Log logger = LogFactoryUtil.getLog(ListMOMPortlet.class.getName());

}