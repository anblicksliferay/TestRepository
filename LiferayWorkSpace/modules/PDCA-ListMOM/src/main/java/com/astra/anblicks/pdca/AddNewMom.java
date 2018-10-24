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
package com.astra.anblicks.pdca;

import com.astra.anblicks.pdca.MOMJsonUtils.JsonUtil;
import com.astra.anblicks.pdca.model.ListMOM;
import com.astra.anblicks.pdca.model.MOMPointdiscussoin;
import com.astra.anblicks.pdca.service.ListMOMLocalServiceUtil;
import com.astra.anblicks.pdca.service.MOMPointdiscussoinLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
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
import java.util.Date;

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
			"javax.portlet.display-name=Add New MOM",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/AddNewMOM/view.jsp",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class AddNewMom extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		super.doView(renderRequest, renderResponse);
		
		
	}
	

	 @Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		  ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		    String cmd = ParamUtil.getString(resourceRequest, "cmd");
		    if (cmd.equalsIgnoreCase("addMOM")) {
		    	try {
		    		JSONObject json = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("addmom"));
		    		ListMOM listMOM=ListMOMLocalServiceUtil.createListMOM(CounterLocalServiceUtil.increment());
		    		listMOM.setMomId(CounterLocalServiceUtil.increment());
		    		listMOM.setUserId(themeDisplay.getUser().getUserId());
		    		listMOM.setCompanyId(json.getLong("companyId"));
		    		listMOM.setMeetingDate(json.getString("meetingdate"));
		    		listMOM.setMomType(json.getString("type"));
		    		listMOM.setMomTypeId(json.getString("typeId"));
		    		listMOM.setMOMGroup(json.getString("groupName"));
		    		listMOM.setFromTime(json.getString("time"));
		    		listMOM.setAmpm(json.getString("ampm"));
		    		listMOM.setPerformance(json.getString("performance"));
		    		listMOM.setMOMparticipants(json.getString("participants"));
		    		listMOM.setMOMplace(json.getString("place"));
		    		listMOM.setMOMcompanyName("");
		    		long pointDisId=CounterLocalServiceUtil.increment();
					listMOM.setPonitDiscussionId(pointDisId);
					listMOM.setSiteId(themeDisplay.getUser().getCompanyId());
					listMOM.setCreateDate(new Date());
					listMOM.setCreatedBy(themeDisplay.getUser().getFullName());
					listMOM.setModifiedDate(new Date());
					listMOM.setModifiedBy(themeDisplay.getUser().getFullName());
					ListMOMLocalServiceUtil.updateListMOM(listMOM);
				     JSONArray jsonArray=JSONFactoryUtil.createJSONArray(json.getString("pointDis"));
				     		if(jsonArray.length()>0){
	                    	for(int i=0; i<jsonArray.length(); i++){
			                JSONObject item = jsonArray.getJSONObject(i);
				     		logger.info(item.getString("id"));
				     		MOMPointdiscussoin momPointdiscussoin=MOMPointdiscussoinLocalServiceUtil.createMOMPointdiscussoin(CounterLocalServiceUtil.increment());
				     		momPointdiscussoin.setMOMpdId(pointDisId);
				     		momPointdiscussoin.setNotes(item.getString("notes"));
				     		momPointdiscussoin.setPonintDiscussionName(item.getString("pintdis"));
				     		momPointdiscussoin.setSiteId(themeDisplay.getUser().getCompanyId());
				     		momPointdiscussoin.setCreateDate(new Date());
				     		momPointdiscussoin.setCreatedBy(themeDisplay.getUser().getFullName());
				     		momPointdiscussoin.setModifiedDate(new Date());
				     		momPointdiscussoin.setModifiedBy(themeDisplay.getUser().getFullName());
				     		MOMPointdiscussoinLocalServiceUtil.updateMOMPointdiscussoin(momPointdiscussoin);
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
		    else if(cmd.equalsIgnoreCase("loadData")){
		    	
		    	try {
					
		    		JSONObject json = JSONFactoryUtil.createJSONObject();
		    		ListMOM listMOM=ListMOMLocalServiceUtil.getListMOM(ParamUtil.getLong(resourceRequest, "meetingId"));
					   json.put("companyId", listMOM.getCompanyId());
					   json.put("meetingdate", listMOM.getMeetingDate());
					   json.put("momType", listMOM.getMomType());
					   json.put("momTypeId", listMOM.getMomTypeId());
					   json.put("group", listMOM.getMOMGroup());
					   json.put("fromTime", listMOM.getFromTime());
					   json.put("ampm", listMOM.getAmpm());
					   json.put("performanace", listMOM.getPerformance());
					   json.put("participants", listMOM.getMOMparticipants());
					   json.put("place" ,listMOM.getMOMplace());
					   json.put("pointDis", JsonUtil.getPointDiscussionByMeetingId(listMOM.getPonitDiscussionId()));
                      logger.info("onload json mom update" +json);
		   		      writeJSON(resourceRequest, resourceResponse,json);
				} catch (Exception e) {
					logger.error(e);
					   JSONObject json = JSONFactoryUtil.createJSONObject();
				      json.put("error", "error");
				       writeJSON(resourceRequest, resourceResponse, json);					}
		    }
		    else if(cmd.equalsIgnoreCase("updateMOM")){
		    	try {
		    		JSONObject json = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("addmom"));
		    		ListMOM listMOM=ListMOMLocalServiceUtil.getListMOM(json.getLong("meetingId"));
		    		listMOM.setMomId(CounterLocalServiceUtil.increment());
		    		listMOM.setUserId(themeDisplay.getUser().getUserId());
		    		listMOM.setCompanyId(json.getLong("companyId"));
		    		listMOM.setMeetingDate(json.getString("meetingdate"));
		    		listMOM.setMomType(json.getString("type"));
		    		listMOM.setMomTypeId(json.getString("typeId"));
		    		listMOM.setMOMGroup(json.getString("groupName"));
		    		listMOM.setFromTime(json.getString("time"));
		    		listMOM.setAmpm(json.getString("ampm"));
		    		listMOM.setPerformance(json.getString("performance"));
		    		listMOM.setMOMparticipants(json.getString("participants"));
		    		listMOM.setMOMplace(json.getString("place"));
		    		listMOM.setMOMcompanyName("");
		    		long pointDisId=CounterLocalServiceUtil.increment();
					listMOM.setPonitDiscussionId(pointDisId);
					listMOM.setSiteId(themeDisplay.getUser().getCompanyId());
					listMOM.setCreateDate(new Date());
					listMOM.setCreatedBy(themeDisplay.getUser().getFullName());
					listMOM.setModifiedDate(new Date());
					listMOM.setModifiedBy(themeDisplay.getUser().getFullName());
					ListMOMLocalServiceUtil.updateListMOM(listMOM);
					JSONObject Sucessjson = JSONFactoryUtil.createJSONObject();
			     	Sucessjson.put("sucess", "added");
	   		      writeJSON(resourceRequest, resourceResponse,Sucessjson);
				} catch (Exception e) {
					logger.error(e);
					   JSONObject json = JSONFactoryUtil.createJSONObject();
				      json.put("error", "error");
				       writeJSON(resourceRequest, resourceResponse, json);					}

		    }
		    else if(cmd.equalsIgnoreCase("piontDiscussionAdd")){
		    	
		    	try {
			    	JSONObject json = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("createPointDis"));
			    	ListMOM listMOM_=ListMOMLocalServiceUtil.getListMOM(json.getLong("meetingId"));
			    	MOMPointdiscussoin momPointdiscussoin=MOMPointdiscussoinLocalServiceUtil.createMOMPointdiscussoin(CounterLocalServiceUtil.increment());
			    	momPointdiscussoin.setMOMpdId(listMOM_.getPonitDiscussionId());
			    	momPointdiscussoin.setPonintDiscussionName(json.getString("pointDis"));
			    	momPointdiscussoin.setNotes(json.getString("notes"));
			    	momPointdiscussoin.setSiteId(themeDisplay.getUser().getCompanyId());
		     		momPointdiscussoin.setCreateDate(new Date());
		     		momPointdiscussoin.setCreatedBy(themeDisplay.getUser().getFullName());
		     		momPointdiscussoin.setModifiedDate(new Date());
		     		momPointdiscussoin.setModifiedBy(themeDisplay.getUser().getFullName());
		     		MOMPointdiscussoinLocalServiceUtil.updateMOMPointdiscussoin(momPointdiscussoin);
		     		 json.put("pointDis", JsonUtil.getPointDiscussionByMeetingId(listMOM_.getPonitDiscussionId()));
		   		      writeJSON(resourceRequest, resourceResponse,json);
		     		
				} catch (Exception e) {
					// TODO: handle exception
				}
		    }
		    }
	 private static Log logger = LogFactoryUtil.getLog(AddNewMom.class.getName());

}