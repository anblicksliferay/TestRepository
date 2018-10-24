/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.astra.anblicks.pdca.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.astra.anblicks.pdca.service.http.ListMOMServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.http.ListMOMServiceSoap
 * @generated
 */
@ProviderType
public class ListMOMSoap implements Serializable {
	public static ListMOMSoap toSoapModel(ListMOM model) {
		ListMOMSoap soapModel = new ListMOMSoap();

		soapModel.setMomId(model.getMomId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setMeetingDate(model.getMeetingDate());
		soapModel.setFromTime(model.getFromTime());
		soapModel.setAmpm(model.getAmpm());
		soapModel.setMomType(model.getMomType());
		soapModel.setMomTypeId(model.getMomTypeId());
		soapModel.setPerformance(model.getPerformance());
		soapModel.setMOMGroup(model.getMOMGroup());
		soapModel.setMOMparticipants(model.getMOMparticipants());
		soapModel.setMOMcompanyName(model.getMOMcompanyName());
		soapModel.setMOMplace(model.getMOMplace());
		soapModel.setPonitDiscussionId(model.getPonitDiscussionId());
		soapModel.setSiteId(model.getSiteId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static ListMOMSoap[] toSoapModels(ListMOM[] models) {
		ListMOMSoap[] soapModels = new ListMOMSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ListMOMSoap[][] toSoapModels(ListMOM[][] models) {
		ListMOMSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ListMOMSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ListMOMSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ListMOMSoap[] toSoapModels(List<ListMOM> models) {
		List<ListMOMSoap> soapModels = new ArrayList<ListMOMSoap>(models.size());

		for (ListMOM model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ListMOMSoap[soapModels.size()]);
	}

	public ListMOMSoap() {
	}

	public long getPrimaryKey() {
		return _MomId;
	}

	public void setPrimaryKey(long pk) {
		setMomId(pk);
	}

	public long getMomId() {
		return _MomId;
	}

	public void setMomId(long MomId) {
		_MomId = MomId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getMeetingDate() {
		return _meetingDate;
	}

	public void setMeetingDate(String meetingDate) {
		_meetingDate = meetingDate;
	}

	public String getFromTime() {
		return _fromTime;
	}

	public void setFromTime(String fromTime) {
		_fromTime = fromTime;
	}

	public String getAmpm() {
		return _ampm;
	}

	public void setAmpm(String ampm) {
		_ampm = ampm;
	}

	public String getMomType() {
		return _MomType;
	}

	public void setMomType(String MomType) {
		_MomType = MomType;
	}

	public String getMomTypeId() {
		return _MomTypeId;
	}

	public void setMomTypeId(String MomTypeId) {
		_MomTypeId = MomTypeId;
	}

	public String getPerformance() {
		return _performance;
	}

	public void setPerformance(String performance) {
		_performance = performance;
	}

	public String getMOMGroup() {
		return _MOMGroup;
	}

	public void setMOMGroup(String MOMGroup) {
		_MOMGroup = MOMGroup;
	}

	public String getMOMparticipants() {
		return _MOMparticipants;
	}

	public void setMOMparticipants(String MOMparticipants) {
		_MOMparticipants = MOMparticipants;
	}

	public String getMOMcompanyName() {
		return _MOMcompanyName;
	}

	public void setMOMcompanyName(String MOMcompanyName) {
		_MOMcompanyName = MOMcompanyName;
	}

	public String getMOMplace() {
		return _MOMplace;
	}

	public void setMOMplace(String MOMplace) {
		_MOMplace = MOMplace;
	}

	public long getPonitDiscussionId() {
		return _ponitDiscussionId;
	}

	public void setPonitDiscussionId(long ponitDiscussionId) {
		_ponitDiscussionId = ponitDiscussionId;
	}

	public long getSiteId() {
		return _SiteId;
	}

	public void setSiteId(long SiteId) {
		_SiteId = SiteId;
	}

	public Date getCreateDate() {
		return _CreateDate;
	}

	public void setCreateDate(Date CreateDate) {
		_CreateDate = CreateDate;
	}

	public String getCreatedBy() {
		return _CreatedBy;
	}

	public void setCreatedBy(String CreatedBy) {
		_CreatedBy = CreatedBy;
	}

	public Date getModifiedDate() {
		return _ModifiedDate;
	}

	public void setModifiedDate(Date ModifiedDate) {
		_ModifiedDate = ModifiedDate;
	}

	public String getModifiedBy() {
		return _ModifiedBy;
	}

	public void setModifiedBy(String ModifiedBy) {
		_ModifiedBy = ModifiedBy;
	}

	private long _MomId;
	private long _userId;
	private long _companyId;
	private String _meetingDate;
	private String _fromTime;
	private String _ampm;
	private String _MomType;
	private String _MomTypeId;
	private String _performance;
	private String _MOMGroup;
	private String _MOMparticipants;
	private String _MOMcompanyName;
	private String _MOMplace;
	private long _ponitDiscussionId;
	private long _SiteId;
	private Date _CreateDate;
	private String _CreatedBy;
	private Date _ModifiedDate;
	private String _ModifiedBy;
}