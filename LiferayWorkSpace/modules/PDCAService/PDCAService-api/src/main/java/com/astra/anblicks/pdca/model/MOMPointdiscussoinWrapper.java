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
 * This class is a wrapper for {@link MOMPointdiscussoin}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOMPointdiscussoin
 * @generated
 */
@ProviderType
public class MOMPointdiscussoinWrapper implements MOMPointdiscussoin,
	ModelWrapper<MOMPointdiscussoin> {
	public MOMPointdiscussoinWrapper(MOMPointdiscussoin momPointdiscussoin) {
		_momPointdiscussoin = momPointdiscussoin;
	}

	@Override
	public Class<?> getModelClass() {
		return MOMPointdiscussoin.class;
	}

	@Override
	public String getModelClassName() {
		return MOMPointdiscussoin.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PdId", getPdId());
		attributes.put("MOMpdId", getMOMpdId());
		attributes.put("PonintDiscussionName", getPonintDiscussionName());
		attributes.put("Notes", getNotes());
		attributes.put("SiteId", getSiteId());
		attributes.put("CreateDate", getCreateDate());
		attributes.put("CreatedBy", getCreatedBy());
		attributes.put("ModifiedDate", getModifiedDate());
		attributes.put("ModifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PdId = (Long)attributes.get("PdId");

		if (PdId != null) {
			setPdId(PdId);
		}

		Long MOMpdId = (Long)attributes.get("MOMpdId");

		if (MOMpdId != null) {
			setMOMpdId(MOMpdId);
		}

		String PonintDiscussionName = (String)attributes.get(
				"PonintDiscussionName");

		if (PonintDiscussionName != null) {
			setPonintDiscussionName(PonintDiscussionName);
		}

		String Notes = (String)attributes.get("Notes");

		if (Notes != null) {
			setNotes(Notes);
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
	public MOMPointdiscussoin toEscapedModel() {
		return new MOMPointdiscussoinWrapper(_momPointdiscussoin.toEscapedModel());
	}

	@Override
	public MOMPointdiscussoin toUnescapedModel() {
		return new MOMPointdiscussoinWrapper(_momPointdiscussoin.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _momPointdiscussoin.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _momPointdiscussoin.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _momPointdiscussoin.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _momPointdiscussoin.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<MOMPointdiscussoin> toCacheModel() {
		return _momPointdiscussoin.toCacheModel();
	}

	@Override
	public int compareTo(MOMPointdiscussoin momPointdiscussoin) {
		return _momPointdiscussoin.compareTo(momPointdiscussoin);
	}

	@Override
	public int hashCode() {
		return _momPointdiscussoin.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _momPointdiscussoin.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new MOMPointdiscussoinWrapper((MOMPointdiscussoin)_momPointdiscussoin.clone());
	}

	/**
	* Returns the created by of this mom pointdiscussoin.
	*
	* @return the created by of this mom pointdiscussoin
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _momPointdiscussoin.getCreatedBy();
	}

	/**
	* Returns the modified by of this mom pointdiscussoin.
	*
	* @return the modified by of this mom pointdiscussoin
	*/
	@Override
	public java.lang.String getModifiedBy() {
		return _momPointdiscussoin.getModifiedBy();
	}

	/**
	* Returns the notes of this mom pointdiscussoin.
	*
	* @return the notes of this mom pointdiscussoin
	*/
	@Override
	public java.lang.String getNotes() {
		return _momPointdiscussoin.getNotes();
	}

	/**
	* Returns the ponint discussion name of this mom pointdiscussoin.
	*
	* @return the ponint discussion name of this mom pointdiscussoin
	*/
	@Override
	public java.lang.String getPonintDiscussionName() {
		return _momPointdiscussoin.getPonintDiscussionName();
	}

	@Override
	public java.lang.String toString() {
		return _momPointdiscussoin.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _momPointdiscussoin.toXmlString();
	}

	/**
	* Returns the create date of this mom pointdiscussoin.
	*
	* @return the create date of this mom pointdiscussoin
	*/
	@Override
	public Date getCreateDate() {
		return _momPointdiscussoin.getCreateDate();
	}

	/**
	* Returns the modified date of this mom pointdiscussoin.
	*
	* @return the modified date of this mom pointdiscussoin
	*/
	@Override
	public Date getModifiedDate() {
		return _momPointdiscussoin.getModifiedDate();
	}

	/**
	* Returns the mo mpd ID of this mom pointdiscussoin.
	*
	* @return the mo mpd ID of this mom pointdiscussoin
	*/
	@Override
	public long getMOMpdId() {
		return _momPointdiscussoin.getMOMpdId();
	}

	/**
	* Returns the pd ID of this mom pointdiscussoin.
	*
	* @return the pd ID of this mom pointdiscussoin
	*/
	@Override
	public long getPdId() {
		return _momPointdiscussoin.getPdId();
	}

	/**
	* Returns the primary key of this mom pointdiscussoin.
	*
	* @return the primary key of this mom pointdiscussoin
	*/
	@Override
	public long getPrimaryKey() {
		return _momPointdiscussoin.getPrimaryKey();
	}

	/**
	* Returns the site ID of this mom pointdiscussoin.
	*
	* @return the site ID of this mom pointdiscussoin
	*/
	@Override
	public long getSiteId() {
		return _momPointdiscussoin.getSiteId();
	}

	@Override
	public void persist() {
		_momPointdiscussoin.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_momPointdiscussoin.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this mom pointdiscussoin.
	*
	* @param CreateDate the create date of this mom pointdiscussoin
	*/
	@Override
	public void setCreateDate(Date CreateDate) {
		_momPointdiscussoin.setCreateDate(CreateDate);
	}

	/**
	* Sets the created by of this mom pointdiscussoin.
	*
	* @param CreatedBy the created by of this mom pointdiscussoin
	*/
	@Override
	public void setCreatedBy(java.lang.String CreatedBy) {
		_momPointdiscussoin.setCreatedBy(CreatedBy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_momPointdiscussoin.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_momPointdiscussoin.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_momPointdiscussoin.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the mo mpd ID of this mom pointdiscussoin.
	*
	* @param MOMpdId the mo mpd ID of this mom pointdiscussoin
	*/
	@Override
	public void setMOMpdId(long MOMpdId) {
		_momPointdiscussoin.setMOMpdId(MOMpdId);
	}

	/**
	* Sets the modified by of this mom pointdiscussoin.
	*
	* @param ModifiedBy the modified by of this mom pointdiscussoin
	*/
	@Override
	public void setModifiedBy(java.lang.String ModifiedBy) {
		_momPointdiscussoin.setModifiedBy(ModifiedBy);
	}

	/**
	* Sets the modified date of this mom pointdiscussoin.
	*
	* @param ModifiedDate the modified date of this mom pointdiscussoin
	*/
	@Override
	public void setModifiedDate(Date ModifiedDate) {
		_momPointdiscussoin.setModifiedDate(ModifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_momPointdiscussoin.setNew(n);
	}

	/**
	* Sets the notes of this mom pointdiscussoin.
	*
	* @param Notes the notes of this mom pointdiscussoin
	*/
	@Override
	public void setNotes(java.lang.String Notes) {
		_momPointdiscussoin.setNotes(Notes);
	}

	/**
	* Sets the pd ID of this mom pointdiscussoin.
	*
	* @param PdId the pd ID of this mom pointdiscussoin
	*/
	@Override
	public void setPdId(long PdId) {
		_momPointdiscussoin.setPdId(PdId);
	}

	/**
	* Sets the ponint discussion name of this mom pointdiscussoin.
	*
	* @param PonintDiscussionName the ponint discussion name of this mom pointdiscussoin
	*/
	@Override
	public void setPonintDiscussionName(java.lang.String PonintDiscussionName) {
		_momPointdiscussoin.setPonintDiscussionName(PonintDiscussionName);
	}

	/**
	* Sets the primary key of this mom pointdiscussoin.
	*
	* @param primaryKey the primary key of this mom pointdiscussoin
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_momPointdiscussoin.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_momPointdiscussoin.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the site ID of this mom pointdiscussoin.
	*
	* @param SiteId the site ID of this mom pointdiscussoin
	*/
	@Override
	public void setSiteId(long SiteId) {
		_momPointdiscussoin.setSiteId(SiteId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MOMPointdiscussoinWrapper)) {
			return false;
		}

		MOMPointdiscussoinWrapper momPointdiscussoinWrapper = (MOMPointdiscussoinWrapper)obj;

		if (Objects.equals(_momPointdiscussoin,
					momPointdiscussoinWrapper._momPointdiscussoin)) {
			return true;
		}

		return false;
	}

	@Override
	public MOMPointdiscussoin getWrappedModel() {
		return _momPointdiscussoin;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _momPointdiscussoin.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _momPointdiscussoin.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_momPointdiscussoin.resetOriginalValues();
	}

	private final MOMPointdiscussoin _momPointdiscussoin;
}