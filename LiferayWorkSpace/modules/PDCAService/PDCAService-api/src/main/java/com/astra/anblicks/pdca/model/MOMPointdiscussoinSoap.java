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
 * This class is used by SOAP remote services, specifically {@link com.astra.anblicks.pdca.service.http.MOMPointdiscussoinServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.http.MOMPointdiscussoinServiceSoap
 * @generated
 */
@ProviderType
public class MOMPointdiscussoinSoap implements Serializable {
	public static MOMPointdiscussoinSoap toSoapModel(MOMPointdiscussoin model) {
		MOMPointdiscussoinSoap soapModel = new MOMPointdiscussoinSoap();

		soapModel.setPdId(model.getPdId());
		soapModel.setMOMpdId(model.getMOMpdId());
		soapModel.setPonintDiscussionName(model.getPonintDiscussionName());
		soapModel.setNotes(model.getNotes());
		soapModel.setSiteId(model.getSiteId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static MOMPointdiscussoinSoap[] toSoapModels(
		MOMPointdiscussoin[] models) {
		MOMPointdiscussoinSoap[] soapModels = new MOMPointdiscussoinSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MOMPointdiscussoinSoap[][] toSoapModels(
		MOMPointdiscussoin[][] models) {
		MOMPointdiscussoinSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MOMPointdiscussoinSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MOMPointdiscussoinSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MOMPointdiscussoinSoap[] toSoapModels(
		List<MOMPointdiscussoin> models) {
		List<MOMPointdiscussoinSoap> soapModels = new ArrayList<MOMPointdiscussoinSoap>(models.size());

		for (MOMPointdiscussoin model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MOMPointdiscussoinSoap[soapModels.size()]);
	}

	public MOMPointdiscussoinSoap() {
	}

	public long getPrimaryKey() {
		return _PdId;
	}

	public void setPrimaryKey(long pk) {
		setPdId(pk);
	}

	public long getPdId() {
		return _PdId;
	}

	public void setPdId(long PdId) {
		_PdId = PdId;
	}

	public long getMOMpdId() {
		return _MOMpdId;
	}

	public void setMOMpdId(long MOMpdId) {
		_MOMpdId = MOMpdId;
	}

	public String getPonintDiscussionName() {
		return _PonintDiscussionName;
	}

	public void setPonintDiscussionName(String PonintDiscussionName) {
		_PonintDiscussionName = PonintDiscussionName;
	}

	public String getNotes() {
		return _Notes;
	}

	public void setNotes(String Notes) {
		_Notes = Notes;
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

	private long _PdId;
	private long _MOMpdId;
	private String _PonintDiscussionName;
	private String _Notes;
	private long _SiteId;
	private Date _CreateDate;
	private String _CreatedBy;
	private Date _ModifiedDate;
	private String _ModifiedBy;
}