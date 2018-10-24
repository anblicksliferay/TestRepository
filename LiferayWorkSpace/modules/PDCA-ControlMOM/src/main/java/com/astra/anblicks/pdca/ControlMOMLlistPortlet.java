package com.astra.anblicks.pdca;

import com.astra.anblicks.pdca.model.ControlMOM;
import com.astra.anblicks.pdca.model.ListMOM;
import com.astra.anblicks.pdca.model.MOMPointdiscussoin;
import com.astra.anblicks.pdca.service.AstraPdca_CompanyDataLocalServiceUtil;
import com.astra.anblicks.pdca.service.ControlMOMLocalServiceUtil;
import com.astra.anblicks.pdca.service.ListMOMLocalServiceUtil;
import com.astra.anblicks.pdca.service.MOMPointdiscussoinLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=AstraPDCA",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=PDCA-ControlMOM",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/Controlmomlist/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ControlMOMLlistPortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		 ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		 PermissionChecker permissionChecker =
				    themeDisplay.getPermissionChecker();
		
		 logger.info( permissionChecker.isOmniadmin());
		renderRequest.setAttribute("conrolMOMs", getSharedPointDisscussions(themeDisplay.getUser().getUserId() ,permissionChecker.isOmniadmin()));
		super.doView(renderRequest, renderResponse);
	}
	
	
	public static String getSharedPointDisscussions(long userId , boolean isAdmin){
		JSONArray array=JSONFactoryUtil.createJSONArray();
		try {
			List<ControlMOM> list=null;
			if(!isAdmin){
			DynamicQuery dynamicQuery= ControlMOMLocalServiceUtil.dynamicQuery();
			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(userId));
			 list=ControlMOMLocalServiceUtil.dynamicQuery(dynamicQuery);
			}
			else{
				list=ControlMOMLocalServiceUtil.getControlMOMs(0, ControlMOMLocalServiceUtil.getControlMOMsCount());
			}
			if(list.size()>0){
				for(ControlMOM val:list){
					
					
					DynamicQuery dynamicQuery2= MOMPointdiscussoinLocalServiceUtil.dynamicQuery();
					dynamicQuery2.add(PropertyFactoryUtil.forName("MOMpdId").eq(val.getPdId()));
					List<MOMPointdiscussoin> list_=MOMPointdiscussoinLocalServiceUtil.dynamicQuery(dynamicQuery2);
					      if(list_.size()>0){
					    	  for(MOMPointdiscussoin val1:list_){
					    		  JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
					    		  DynamicQuery dynamicQuery3=ListMOMLocalServiceUtil.dynamicQuery();
					    		  dynamicQuery3.add(PropertyFactoryUtil.forName("ponitDiscussionId").eq(val1.getMOMpdId()));
					    		  List<ListMOM> listMOMs=ListMOMLocalServiceUtil.dynamicQuery(dynamicQuery3);
					    		  if(listMOMs.size()>0){
					    			  jsonObject.put("companyName", AstraPdca_CompanyDataLocalServiceUtil.getAstraPdca_CompanyData(listMOMs.get(0).getCompanyId()).getCompanyName());
					    			  jsonObject.put("group", listMOMs.get(0).getMOMGroup());
					    			  jsonObject.put("type", listMOMs.get(0).getMomType());
					    		  }
					    		  jsonObject.put("pointofDis", val1.getPonintDiscussionName());
					    		  jsonObject.put("notes", val1.getNotes());
					    		  jsonObject.put("ControlMOMId", val.getControlMOMId());
					        	  jsonObject.put("pdId", val1.getPdId());
					        	  jsonObject.put("followUp", getFollowUpStringByControlMOMId(val.getControlMOMId(), val1.getPdId()));
					        	  jsonObject.put("status", getStatusStringByControlMOMId(val.getControlMOMId(), val1.getPdId()));
					    		  array.put(jsonObject);
					    	  }
					      }
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		return array.toString();
	}
	public static String getFollowUpStringByControlMOMId(long controlMOMId, long pdId){
		
		String followUp=StringPool.BLANK;
		try {
			ControlMOM controlMOM= ControlMOMLocalServiceUtil.getControlMOM(controlMOMId);
			   JSONArray jsonArray=JSONFactoryUtil.createJSONArray(controlMOM.getFollowUpData());
	     		if(jsonArray.length()>0){
             	for(int i=0; i<jsonArray.length(); i++){
               JSONObject item = jsonArray.getJSONObject(i);
	     	if(item.getLong("pdID")==pdId) {
	     		followUp=item.getString("followUP");break;
	     	
	     	}}}}
		catch (Exception e) {
       e.printStackTrace();	
     }
		
		return followUp;
	}
	public static String getStatusStringByControlMOMId(long controlMOMId, long pdId){
		String followUp=StringPool.BLANK;
		try {
    			ControlMOM controlMOM= ControlMOMLocalServiceUtil.getControlMOM(controlMOMId);
			   JSONArray jsonArray=JSONFactoryUtil.createJSONArray(controlMOM.getFollowUpData());
	     		if(jsonArray.length()>0){
           	for(int i=0; i<jsonArray.length(); i++){
               JSONObject item = jsonArray.getJSONObject(i);
	     	if(item.getLong("pdID")==pdId) { followUp=item.getString("status"); break;
	     	
	     	}
		     		}}		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return followUp;
	}
	private static Log logger = LogFactoryUtil.getLog(ControlMOMLlistPortlet.class.getName());
}