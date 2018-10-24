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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link ControlMOM}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ControlMOM
 * @generated
 */
@ProviderType
public class ControlMOMWrapper implements ControlMOM, ModelWrapper<ControlMOM> {
	public ControlMOMWrapper(ControlMOM controlMOM) {
		_controlMOM = controlMOM;
	}

	@Override
	public Class<?> getModelClass() {
		return ControlMOM.class;
	}

	@Override
	public String getModelClassName() {
		return ControlMOM.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ControlMOMId", getControlMOMId());
		attributes.put("ListMOMId", getListMOMId());
		attributes.put("pdId", getPdId());
		attributes.put("userId", getUserId());
		attributes.put("Status", getStatus());
		attributes.put("FollowUp", getFollowUp());
		attributes.put("FollowUpData", getFollowUpData());
		attributes.put("SiteId", getSiteId());
		attributes.put("CreateDate", getCreateDate());
		attributes.put("CreatedBy", getCreatedBy());
		attributes.put("ModifiedDate", getModifiedDate());
		attributes.put("ModifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ControlMOMId = (Long)attributes.get("ControlMOMId");

		if (ControlMOMId != null) {
			setControlMOMId(ControlMOMId);
		}

		Long ListMOMId = (Long)attributes.get("ListMOMId");

		if (ListMOMId != null) {
			setListMOMId(ListMOMId);
		}

		Long pdId = (Long)attributes.get("pdId");

		if (pdId != null) {
			setPdId(pdId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String Status = (String)attributes.get("Status");

		if (Status != null) {
			setStatus(Status);
		}

		String FollowUp = (String)attributes.get("FollowUp");

		if (FollowUp != null) {
			setFollowUp(FollowUp);
		}

		String FollowUpData = (String)attributes.get("FollowUpData");

		if (FollowUpData != null) {
			setFollowUpData(FollowUpData);
		}

		Long SiteId = (Long)attributes.get("SiteId");

		if (SiteId != null) {
			setSiteId(SiteId);
		}

		Date CreateDate = (Date)attributes.get("CreateDate");

		if (CreateDate != null) {
			setCreateDate(CreateDate);
		}

		String CreatedBy = (String)attributes.get("CreatedBy");

		if (CreatedBy != null) {
			setCreatedBy(CreatedBy);
		}

		Date ModifiedDate = (Date)attributes.get("ModifiedDate");

		if (ModifiedDate != null) {
			setModifiedDate(ModifiedDate);
		}

		String ModifiedBy = (String)attributes.get("ModifiedBy");

		if (ModifiedBy != null) {
			setModifiedBy(ModifiedBy);
		}
	}

	@Override
	public ControlMOM toEscapedModel() {
		return new ControlMOMWrapper(_controlMOM.toEscapedModel());
	}

	@Override
	public ControlMOM toUnescapedModel() {
		return new ControlMOMWrapper(_controlMOM.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _controlMOM.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _controlMOM.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _controlMOM.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _controlMOM.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ControlMOM> toCacheModel() {
		return _controlMOM.toCacheModel();
	}

	@Override
	public int compareTo(ControlMOM controlMOM) {
		return _controlMOM.compareTo(controlMOM);
	}

	@Override
	public int hashCode() {
		return _controlMOM.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _controlMOM.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ControlMOMWrapper((ControlMOM)_controlMOM.clone());
	}

	/**
	* Returns the created by of this control mom.
	*
	* @return the created by of this control mom
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _controlMOM.getCreatedBy();
	}

	/**
	* Returns the follow up of this control mom.
	*
	* @return the follow up of this control mom
	*/
	@Override
	public java.lang.String getFollowUp() {
		return _controlMOM.getFollowUp();
	}

	/**
	* Returns the follow up data of this control mom.
	*
	* @return the follow up data of this control mom
	*/
	@Override
	public java.lang.String getFollowUpData() {
		return _controlMOM.getFollowUpData();
	}

	/**
	* Returns the modified by of this control mom.
	*
	* @return the modified by of this control mom
	*/
	@Override
	public java.lang.String getModifiedBy() {
		return _controlMOM.getModifiedBy();
	}

	/**
	* Returns the status of this control mom.
	*
	* @return the status of this control mom
	*/
	@Override
	public java.lang.String getStatus() {
		return _controlMOM.getStatus();
	}

	/**
	* Returns the user uuid of this control mom.
	*
	* @return the user uuid of this control mom
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _controlMOM.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _controlMOM.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _controlMOM.toXmlString();
	}

	/**
	* Returns the create date of this control mom.
	*
	* @return the create date of this control mom
	*/
	@Override
	public Date getCreateDate() {
		return _controlMOM.getCreateDate();
	}

	/**
	* Returns the modified date of this control mom.
	*
	* @return the modified date of this control mom
	*/
	@Override
	public Date getModifiedDate() {
		return _controlMOM.getModifiedDate();
	}

	/**
	* Returns the control mom ID of this control mom.
	*
	* @return the control mom ID of this control mom
	*/
	@Override
	public long getControlMOMId() {
		return _controlMOM.getControlMOMId();
	}

	/**
	* Returns the list mom ID of this control mom.
	*
	* @return the list mom ID of this control mom
	*/
	@Override
	public long getListMOMId() {
		return _controlMOM.getListMOMId();
	}

	/**
	* Returns the pd ID of this control mom.
	*
	* @return the pd ID of this control mom
	*/
	@Override
	public long getPdId() {
		return _controlMOM.getPdId();
	}

	/**
	* Returns the primary key of this control mom.
	*
	* @return the primary key of this control mom
	*/
	@Override
	public long getPrimaryKey() {
		return _controlMOM.getPrimaryKey();
	}

	/**
	* Returns the site ID of this control mom.
	*
	* @return the site ID of this control mom
	*/
	@Override
	public long getSiteId() {
		return _controlMOM.getSiteId();
	}

	/**
	* Returns the user ID of this control mom.
	*
	* @return the user ID of this control mom
	*/
	@Override
	public long getUserId() {
		return _controlMOM.getUserId();
	}

	@Override
	public void persist() {
		_controlMOM.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_controlMOM.setCachedModel(cachedModel);
	}

	/**
	* Sets the control mom ID of this control mom.
	*
	* @param ControlMOMId the control mom ID of this control mom
	*/
	@Override
	public void setControlMOMId(long ControlMOMId) {
		_controlMOM.setControlMOMId(ControlMOMId);
	}

	/**
	* Sets the create date of this control mom.
	*
	* @param CreateDate the create date of this control mom
	*/
	@Override
	public void setCreateDate(Date CreateDate) {
		_controlMOM.setCreateDate(CreateDate);
	}

	/**
	* Sets the created by of this control mom.
	*
	* @param CreatedBy the created by of this control mom
	*/
	@Override
	public void setCreatedBy(java.lang.String CreatedBy) {
		_controlMOM.setCreatedBy(CreatedBy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_controlMOM.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_controlMOM.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_controlMOM.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the follow up of this control mom.
	*
	* @param FollowUp the follow up of this control mom
	*/
	@Override
	public void setFollowUp(java.lang.String FollowUp) {
		_controlMOM.setFollowUp(FollowUp);
	}

	/**
	* Sets the follow up data of this control mom.
	*
	* @param FollowUpData the follow up data of this control mom
	*/
	@Override
	public void setFollowUpData(java.lang.String FollowUpData) {
		_controlMOM.setFollowUpData(FollowUpData);
	}

	/**
	* Sets the list mom ID of this control mom.
	*
	* @param ListMOMId the list mom ID of this control mom
	*/
	@Override
	public void setListMOMId(long ListMOMId) {
		_controlMOM.setListMOMId(ListMOMId);
	}

	/**
	* Sets the modified by of this control mom.
	*
	* @param ModifiedBy the modified by of this control mom
	*/
	@Override
	public void setModifiedBy(java.lang.String ModifiedBy) {
		_controlMOM.setModifiedBy(ModifiedBy);
	}

	/**
	* Sets the modified date of this control mom.
	*
	* @param ModifiedDate the modified date of this control mom
	*/
	@Override
	public void setModifiedDate(Date ModifiedDate) {
		_controlMOM.setModifiedDate(ModifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_controlMOM.setNew(n);
	}

	/**
	* Sets the pd ID of this control mom.
	*
	* @param pdId the pd ID of this control mom
	*/
	@Override
	public void setPdId(long pdId) {
		_controlMOM.setPdId(pdId);
	}

	/**
	* Sets the primary key of this control mom.
	*
	* @param primaryKey the primary key of this control mom
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_controlMOM.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_controlMOM.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the site ID of this control mom.
	*
	* @param SiteId the site ID of this control mom
	*/
	@Override
	public void setSiteId(long SiteId) {
		_controlMOM.setSiteId(SiteId);
	}

	/**
	* Sets the status of this control mom.
	*
	* @param Status the status of this control mom
	*/
	@Override
	public void setStatus(java.lang.String Status) {
		_controlMOM.setStatus(Status);
	}

	/**
	* Sets the user ID of this control mom.
	*
	* @param userId the user ID of this control mom
	*/
	@Override
	public void setUserId(long userId) {
		_controlMOM.setUserId(userId);
	}

	/**
	* Sets the user uuid of this control mom.
	*
	* @param userUuid the user uuid of this control mom
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_controlMOM.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ControlMOMWrapper)) {
			return false;
		}

		ControlMOMWrapper controlMOMWrapper = (ControlMOMWrapper)obj;

		if (Objects.equals(_controlMOM, controlMOMWrapper._controlMOM)) {
			return true;
		}

		return false;
	}

	@Override
	public ControlMOM getWrappedModel() {
		return _controlMOM;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _controlMOM.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _controlMOM.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_controlMOM.resetOriginalValues();
	}

	private final ControlMOM _controlMOM;
}