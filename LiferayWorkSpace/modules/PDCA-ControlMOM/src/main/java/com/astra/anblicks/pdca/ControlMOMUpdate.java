package com.astra.anblicks.pdca;

import com.astra.anblicks.pdca.model.ControlMOM;
import com.astra.anblicks.pdca.service.ControlMOMLocalServiceUtil;
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
		"javax.portlet.display-name=PDCA-Dis-points-update",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/DisPointUpdate/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ControlMOMUpdate extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		super.doView(renderRequest, renderResponse);

	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		     String cmd = ParamUtil.getString(resourceRequest, "cmd");
			 ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		    if (cmd.equalsIgnoreCase("updateControlMOM")) {
			 try {
				 JSONObject  jsonObject=JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("updateControlMOMData"));
			     ControlMOM controlMOM=ControlMOMLocalServiceUtil.getControlMOM(jsonObject.getLong("ControlMOMId"));
				  JSONArray groupDisArray = JSONFactoryUtil.createJSONArray( controlMOM.getFollowUpData());
				  logger.info(jsonObject.getLong("pdId"));
	    		  if(null!=groupDisArray){
	    			  	for(int i=0; i<groupDisArray.length(); i++){
	    		               JSONObject item = groupDisArray.getJSONObject(i);
	    			     	if(item.getLong("pdID")==jsonObject.getLong("pdId")) {
	    			            item.remove("status");
	    			            item.remove("followUP");
	    			            item.put("status", jsonObject.get("status"));
	    			            item.put("followUP", jsonObject.get("followUp"));
	    			     		break;
	    			     	
	    			     	}   	}
	    		  }
	    		  logger.info(groupDisArray);
	    		  controlMOM.setFollowUpData(groupDisArray.toString());
	    		  ControlMOMLocalServiceUtil.updateControlMOM(controlMOM);
				  JSONObject json = JSONFactoryUtil.createJSONObject();
				  json.put("sucess", "added");
      		 writeJSON(resourceRequest, resourceResponse,json);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e);
				    JSONObject json = JSONFactoryUtil.createJSONObject();
			        json.put("error", "error");
			        writeJSON(resourceRequest, resourceResponse, json);			
			}
		    }
		 
	}
	private static Log logger = LogFactoryUtil.getLog(ControlMOMUpdate.class.getName());

}