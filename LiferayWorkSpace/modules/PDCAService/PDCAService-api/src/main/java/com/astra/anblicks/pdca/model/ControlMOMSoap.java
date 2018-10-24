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
 * This class is used by SOAP remote services, specifically {@link com.astra.anblicks.pdca.service.http.ControlMOMServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.http.ControlMOMServiceSoap
 * @generated
 */
@ProviderType
public class ControlMOMSoap implements Serializable {
	public static ControlMOMSoap toSoapModel(ControlMOM model) {
		ControlMOMSoap soapModel = new ControlMOMSoap();

		soapModel.setControlMOMId(model.getControlMOMId());
		soapModel.setListMOMId(model.getListMOMId());
		soapModel.setPdId(model.getPdId());
		soapModel.setUserId(model.getUserId());
		soapModel.setStatus(model.getStatus());
		soapModel.setFollowUp(model.getFollowUp());
		soapModel.setFollowUpData(model.getFollowUpData());
		soapModel.setSiteId(model.getSiteId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static ControlMOMSoap[] toSoapModels(ControlMOM[] models) {
		ControlMOMSoap[] soapModels = new ControlMOMSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ControlMOMSoap[][] toSoapModels(ControlMOM[][] models) {
		ControlMOMSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ControlMOMSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ControlMOMSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ControlMOMSoap[] toSoapModels(List<ControlMOM> models) {
		List<ControlMOMSoap> soapModels = new ArrayList<ControlMOMSoap>(models.size());

		for (ControlMOM model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ControlMOMSoap[soapModels.size()]);
	}

	public ControlMOMSoap() {
	}

	public long getPrimaryKey() {
		return _ControlMOMId;
	}

	public void setPrimaryKey(long pk) {
		setControlMOMId(pk);
	}

	public long getControlMOMId() {
		return _ControlMOMId;
	}

	public void setControlMOMId(long ControlMOMId) {
		_ControlMOMId = ControlMOMId;
	}

	public long getListMOMId() {
		return _ListMOMId;
	}

	public void setListMOMId(long ListMOMId) {
		_ListMOMId = ListMOMId;
	}

	public long getPdId() {
		return _pdId;
	}

	public void setPdId(long pdId) {
		_pdId = pdId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getStatus() {
		return _Status;
	}

	public void setStatus(String Status) {
		_Status = Status;
	}

	public String getFollowUp() {
		return _FollowUp;
	}

	public void setFollowUp(String FollowUp) {
		_FollowUp = FollowUp;
	}

	public String getFollowUpData() {
		return _FollowUpData;
	}

	public void setFollowUpData(String FollowUpData) {
		_FollowUpData = FollowUpData;
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

	private long _ControlMOMId;
	private long _ListMOMId;
	private long _pdId;
	private long _userId;
	private String _Status;
	private String _FollowUp;
	private String _FollowUpData;
	private long _SiteId;
	private Date _CreateDate;
	private String _CreatedBy;
	private Date _ModifiedDate;
	private String _ModifiedBy;
}