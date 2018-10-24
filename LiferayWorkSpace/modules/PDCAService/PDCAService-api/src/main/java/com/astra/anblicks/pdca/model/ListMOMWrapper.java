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
 * This class is a wrapper for {@link ListMOM}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ListMOM
 * @generated
 */
@ProviderType
public class ListMOMWrapper implements ListMOM, ModelWrapper<ListMOM> {
	public ListMOMWrapper(ListMOM listMOM) {
		_listMOM = listMOM;
	}

	@Override
	public Class<?> getModelClass() {
		return ListMOM.class;
	}

	@Override
	public String getModelClassName() {
		return ListMOM.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("MomId", getMomId());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("meetingDate", getMeetingDate());
		attributes.put("fromTime", getFromTime());
		attributes.put("ampm", getAmpm());
		attributes.put("MomType", getMomType());
		attributes.put("MomTypeId", getMomTypeId());
		attributes.put("performance", getPerformance());
		attributes.put("MOMGroup", getMOMGroup());
		attributes.put("MOMparticipants", getMOMparticipants());
		attributes.put("MOMcompanyName", getMOMcompanyName());
		attributes.put("MOMplace", getMOMplace());
		attributes.put("ponitDiscussionId", getPonitDiscussionId());
		attributes.put("SiteId", getSiteId());
		attributes.put("CreateDate", getCreateDate());
		attributes.put("CreatedBy", getCreatedBy());
		attributes.put("ModifiedDate", getModifiedDate());
		attributes.put("ModifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long MomId = (Long)attributes.get("MomId");

		if (MomId != null) {
			setMomId(MomId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String meetingDate = (String)attributes.get("meetingDate");

		if (meetingDate != null) {
			setMeetingDate(meetingDate);
		}

		String fromTime = (String)attributes.get("fromTime");

		if (fromTime != null) {
			setFromTime(fromTime);
		}

		String ampm = (String)attributes.get("ampm");

		if (ampm != null) {
			setAmpm(ampm);
		}

		String MomType = (String)attributes.get("MomType");

		if (MomType != null) {
			setMomType(MomType);
		}

		String MomTypeId = (String)attributes.get("MomTypeId");

		if (MomTypeId != null) {
			setMomTypeId(MomTypeId);
		}

		String performance = (String)attributes.get("performance");

		if (performance != null) {
			setPerformance(performance);
		}

		String MOMGroup = (String)attributes.get("MOMGroup");

		if (MOMGroup != null) {
			setMOMGroup(MOMGroup);
		}

		String MOMparticipants = (String)attributes.get("MOMparticipants");

		if (MOMparticipants != null) {
			setMOMparticipants(MOMparticipants);
		}

		String MOMcompanyName = (String)attributes.get("MOMcompanyName");

		if (MOMcompanyName != null) {
			setMOMcompanyName(MOMcompanyName);
		}

		String MOMplace = (String)attributes.get("MOMplace");

		if (MOMplace != null) {
			setMOMplace(MOMplace);
		}

		Long ponitDiscussionId = (Long)attributes.get("ponitDiscussionId");

		if (ponitDiscussionId != null) {
			setPonitDiscussionId(ponitDiscussionId);
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
	public ListMOM toEscapedModel() {
		return new ListMOMWrapper(_listMOM.toEscapedModel());
	}

	@Override
	public ListMOM toUnescapedModel() {
		return new ListMOMWrapper(_listMOM.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _listMOM.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _listMOM.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _listMOM.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _listMOM.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ListMOM> toCacheModel() {
		return _listMOM.toCacheModel();
	}

	@Override
	public int compareTo(ListMOM listMOM) {
		return _listMOM.compareTo(listMOM);
	}

	@Override
	public int hashCode() {
		return _listMOM.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _listMOM.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ListMOMWrapper((ListMOM)_listMOM.clone());
	}

	/**
	* Returns the ampm of this list mom.
	*
	* @return the ampm of this list mom
	*/
	@Override
	public java.lang.String getAmpm() {
		return _listMOM.getAmpm();
	}

	/**
	* Returns the created by of this list mom.
	*
	* @return the created by of this list mom
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _listMOM.getCreatedBy();
	}

	/**
	* Returns the from time of this list mom.
	*
	* @return the from time of this list mom
	*/
	@Override
	public java.lang.String getFromTime() {
		return _listMOM.getFromTime();
	}

	/**
	* Returns the mom group of this list mom.
	*
	* @return the mom group of this list mom
	*/
	@Override
	public java.lang.String getMOMGroup() {
		return _listMOM.getMOMGroup();
	}

	/**
	* Returns the mo mcompany name of this list mom.
	*
	* @return the mo mcompany name of this list mom
	*/
	@Override
	public java.lang.String getMOMcompanyName() {
		return _listMOM.getMOMcompanyName();
	}

	/**
	* Returns the mo mparticipants of this list mom.
	*
	* @return the mo mparticipants of this list mom
	*/
	@Override
	public java.lang.String getMOMparticipants() {
		return _listMOM.getMOMparticipants();
	}

	/**
	* Returns the mo mplace of this list mom.
	*
	* @return the mo mplace of this list mom
	*/
	@Override
	public java.lang.String getMOMplace() {
		return _listMOM.getMOMplace();
	}

	/**
	* Returns the meeting date of this list mom.
	*
	* @return the meeting date of this list mom
	*/
	@Override
	public java.lang.String getMeetingDate() {
		return _listMOM.getMeetingDate();
	}

	/**
	* Returns the modified by of this list mom.
	*
	* @return the modified by of this list mom
	*/
	@Override
	public java.lang.String getModifiedBy() {
		return _listMOM.getModifiedBy();
	}

	/**
	* Returns the mom type of this list mom.
	*
	* @return the mom type of this list mom
	*/
	@Override
	public java.lang.String getMomType() {
		return _listMOM.getMomType();
	}

	/**
	* Returns the mom type ID of this list mom.
	*
	* @return the mom type ID of this list mom
	*/
	@Override
	public java.lang.String getMomTypeId() {
		return _listMOM.getMomTypeId();
	}

	/**
	* Returns the performance of this list mom.
	*
	* @return the performance of this list mom
	*/
	@Override
	public java.lang.String getPerformance() {
		return _listMOM.getPerformance();
	}

	/**
	* Returns the user uuid of this list mom.
	*
	* @return the user uuid of this list mom
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _listMOM.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _listMOM.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _listMOM.toXmlString();
	}

	/**
	* Returns the create date of this list mom.
	*
	* @return the create date of this list mom
	*/
	@Override
	public Date getCreateDate() {
		return _listMOM.getCreateDate();
	}

	/**
	* Returns the modified date of this list mom.
	*
	* @return the modified date of this list mom
	*/
	@Override
	public Date getModifiedDate() {
		return _listMOM.getModifiedDate();
	}

	/**
	* Returns the company ID of this list mom.
	*
	* @return the company ID of this list mom
	*/
	@Override
	public long getCompanyId() {
		return _listMOM.getCompanyId();
	}

	/**
	* Returns the mom ID of this list mom.
	*
	* @return the mom ID of this list mom
	*/
	@Override
	public long getMomId() {
		return _listMOM.getMomId();
	}

	/**
	* Returns the ponit discussion ID of this list mom.
	*
	* @return the ponit discussion ID of this list mom
	*/
	@Override
	public long getPonitDiscussionId() {
		return _listMOM.getPonitDiscussionId();
	}

	/**
	* Returns the primary key of this list mom.
	*
	* @return the primary key of this list mom
	*/
	@Override
	public long getPrimaryKey() {
		return _listMOM.getPrimaryKey();
	}

	/**
	* Returns the site ID of this list mom.
	*
	* @return the site ID of this list mom
	*/
	@Override
	public long getSiteId() {
		return _listMOM.getSiteId();
	}

	/**
	* Returns the user ID of this list mom.
	*
	* @return the user ID of this list mom
	*/
	@Override
	public long getUserId() {
		return _listMOM.getUserId();
	}

	@Override
	public void persist() {
		_listMOM.persist();
	}

	/**
	* Sets the ampm of this list mom.
	*
	* @param ampm the ampm of this list mom
	*/
	@Override
	public void setAmpm(java.lang.String ampm) {
		_listMOM.setAmpm(ampm);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_listMOM.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this list mom.
	*
	* @param companyId the company ID of this list mom
	*/
	@Override
	public void setCompanyId(long companyId) {
		_listMOM.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this list mom.
	*
	* @param CreateDate the create date of this list mom
	*/
	@Override
	public void setCreateDate(Date CreateDate) {
		_listMOM.setCreateDate(CreateDate);
	}

	/**
	* Sets the created by of this list mom.
	*
	* @param CreatedBy the created by of this list mom
	*/
	@Override
	public void setCreatedBy(java.lang.String CreatedBy) {
		_listMOM.setCreatedBy(CreatedBy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_listMOM.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_listMOM.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_listMOM.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the from time of this list mom.
	*
	* @param fromTime the from time of this list mom
	*/
	@Override
	public void setFromTime(java.lang.String fromTime) {
		_listMOM.setFromTime(fromTime);
	}

	/**
	* Sets the mom group of this list mom.
	*
	* @param MOMGroup the mom group of this list mom
	*/
	@Override
	public void setMOMGroup(java.lang.String MOMGroup) {
		_listMOM.setMOMGroup(MOMGroup);
	}

	/**
	* Sets the mo mcompany name of this list mom.
	*
	* @param MOMcompanyName the mo mcompany name of this list mom
	*/
	@Override
	public void setMOMcompanyName(java.lang.String MOMcompanyName) {
		_listMOM.setMOMcompanyName(MOMcompanyName);
	}

	/**
	* Sets the mo mparticipants of this list mom.
	*
	* @param MOMparticipants the mo mparticipants of this list mom
	*/
	@Override
	public void setMOMparticipants(java.lang.String MOMparticipants) {
		_listMOM.setMOMparticipants(MOMparticipants);
	}

	/**
	* Sets the mo mplace of this list mom.
	*
	* @param MOMplace the mo mplace of this list mom
	*/
	@Override
	public void setMOMplace(java.lang.String MOMplace) {
		_listMOM.setMOMplace(MOMplace);
	}

	/**
	* Sets the meeting date of this list mom.
	*
	* @param meetingDate the meeting date of this list mom
	*/
	@Override
	public void setMeetingDate(java.lang.String meetingDate) {
		_listMOM.setMeetingDate(meetingDate);
	}

	/**
	* Sets the modified by of this list mom.
	*
	* @param ModifiedBy the modified by of this list mom
	*/
	@Override
	public void setModifiedBy(java.lang.String ModifiedBy) {
		_listMOM.setModifiedBy(ModifiedBy);
	}

	/**
	* Sets the modified date of this list mom.
	*
	* @param ModifiedDate the modified date of this list mom
	*/
	@Override
	public void setModifiedDate(Date ModifiedDate) {
		_listMOM.setModifiedDate(ModifiedDate);
	}

	/**
	* Sets the mom ID of this list mom.
	*
	* @param MomId the mom ID of this list mom
	*/
	@Override
	public void setMomId(long MomId) {
		_listMOM.setMomId(MomId);
	}

	/**
	* Sets the mom type of this list mom.
	*
	* @param MomType the mom type of this list mom
	*/
	@Override
	public void setMomType(java.lang.String MomType) {
		_listMOM.setMomType(MomType);
	}

	/**
	* Sets the mom type ID of this list mom.
	*
	* @param MomTypeId the mom type ID of this list mom
	*/
	@Override
	public void setMomTypeId(java.lang.String MomTypeId) {
		_listMOM.setMomTypeId(MomTypeId);
	}

	@Override
	public void setNew(boolean n) {
		_listMOM.setNew(n);
	}

	/**
	* Sets the performance of this list mom.
	*
	* @param performance the performance of this list mom
	*/
	@Override
	public void setPerformance(java.lang.String performance) {
		_listMOM.setPerformance(performance);
	}

	/**
	* Sets the ponit discussion ID of this list mom.
	*
	* @param ponitDiscussionId the ponit discussion ID of this list mom
	*/
	@Override
	public void setPonitDiscussionId(long ponitDiscussionId) {
		_listMOM.setPonitDiscussionId(ponitDiscussionId);
	}

	/**
	* Sets the primary key of this list mom.
	*
	* @param primaryKey the primary key of this list mom
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_listMOM.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_listMOM.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the site ID of this list mom.
	*
	* @param SiteId the site ID of this list mom
	*/
	@Override
	public void setSiteId(long SiteId) {
		_listMOM.setSiteId(SiteId);
	}

	/**
	* Sets the user ID of this list mom.
	*
	* @param userId the user ID of this list mom
	*/
	@Override
	public void setUserId(long userId) {
		_listMOM.setUserId(userId);
	}

	/**
	* Sets the user uuid of this list mom.
	*
	* @param userUuid the user uuid of this list mom
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_listMOM.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ListMOMWrapper)) {
			return false;
		}

		ListMOMWrapper listMOMWrapper = (ListMOMWrapper)obj;

		if (Objects.equals(_listMOM, listMOMWrapper._listMOM)) {
			return true;
		}

		return false;
	}

	@Override
	public ListMOM getWrappedModel() {
		return _listMOM;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _listMOM.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _listMOM.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_listMOM.resetOriginalValues();
	}

	private final ListMOM _listMOM;
}