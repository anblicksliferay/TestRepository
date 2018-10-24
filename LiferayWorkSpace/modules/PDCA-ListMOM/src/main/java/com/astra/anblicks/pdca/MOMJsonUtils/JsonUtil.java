package com.astra.anblicks.pdca.MOMJsonUtils;

import com.astra.anblicks.pdca.model.MOMPointdiscussoin;
import com.astra.anblicks.pdca.service.MOMPointdiscussoinLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;

public class JsonUtil {

	
	public static JSONArray getPointDiscussionByMeetingId(long meetinId){
		 JSONArray jsonArray=JSONFactoryUtil.createJSONArray();
		try {
			 DynamicQuery dq_pd=MOMPointdiscussoinLocalServiceUtil.dynamicQuery();
			dq_pd.add(PropertyFactoryUtil.forName("MOMpdId").eq(meetinId));
			List<MOMPointdiscussoin> list_=MOMPointdiscussoinLocalServiceUtil.dynamicQuery(dq_pd);
			if(list_.size()>0){
				for(MOMPointdiscussoin val:list_){
					 JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
					 jsonObject.put("pdId", val.getPdId());
					 jsonObject.put("pintdis", val.getPonintDiscussionName());
					 jsonObject.put("notes", val.getNotes());
					 jsonArray.put(jsonObject);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return  jsonArray;
	}
	
}
