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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the MOMPointdiscussoin service. Represents a row in the &quot;pdca_mompointdiscussoin&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.astra.anblicks.pdca.model.impl.MOMPointdiscussoinModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.astra.anblicks.pdca.model.impl.MOMPointdiscussoinImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOMPointdiscussoin
 * @see com.astra.anblicks.pdca.model.impl.MOMPointdiscussoinImpl
 * @see com.astra.anblicks.pdca.model.impl.MOMPointdiscussoinModelImpl
 * @generated
 */
@ProviderType
public interface MOMPointdiscussoinModel extends BaseModel<MOMPointdiscussoin> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a mom pointdiscussoin model instance should use the {@link MOMPointdiscussoin} interface instead.
	 */

	/**
	 * Returns the primary key of this mom pointdiscussoin.
	 *
	 * @return the primary key of this mom pointdiscussoin
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this mom pointdiscussoin.
	 *
	 * @param primaryKey the primary key of this mom pointdiscussoin
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the pd ID of this mom pointdiscussoin.
	 *
	 * @return the pd ID of this mom pointdiscussoin
	 */
	public long getPdId();

	/**
	 * Sets the pd ID of this mom pointdiscussoin.
	 *
	 * @param PdId the pd ID of this mom pointdiscussoin
	 */
	public void setPdId(long PdId);

	/**
	 * Returns the mo mpd ID of this mom pointdiscussoin.
	 *
	 * @return the mo mpd ID of this mom pointdiscussoin
	 */
	public long getMOMpdId();

	/**
	 * Sets the mo mpd ID of this mom pointdiscussoin.
	 *
	 * @param MOMpdId the mo mpd ID of this mom pointdiscussoin
	 */
	public void setMOMpdId(long MOMpdId);

	/**
	 * Returns the ponint discussion name of this mom pointdiscussoin.
	 *
	 * @return the ponint discussion name of this mom pointdiscussoin
	 */
	@AutoEscape
	public String getPonintDiscussionName();

	/**
	 * Sets the ponint discussion name of this mom pointdiscussoin.
	 *
	 * @param PonintDiscussionName the ponint discussion name of this mom pointdiscussoin
	 */
	public void setPonintDiscussionName(String PonintDiscussionName);

	/**
	 * Returns the notes of this mom pointdiscussoin.
	 *
	 * @return the notes of this mom pointdiscussoin
	 */
	@AutoEscape
	public String getNotes();

	/**
	 * Sets the notes of this mom pointdiscussoin.
	 *
	 * @param Notes the notes of this mom pointdiscussoin
	 */
	public void setNotes(String Notes);

	/**
	 * Returns the site ID of this mom pointdiscussoin.
	 *
	 * @return the site ID of this mom pointdiscussoin
	 */
	public long getSiteId();

	/**
	 * Sets the site ID of this mom pointdiscussoin.
	 *
	 * @param SiteId the site ID of this mom pointdiscussoin
	 */
	public void setSiteId(long SiteId);

	/**
	 * Returns the create date of this mom pointdiscussoin.
	 *
	 * @return the create date of this mom pointdiscussoin
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this mom pointdiscussoin.
	 *
	 * @param CreateDate the create date of this mom pointdiscussoin
	 */
	public void setCreateDate(Date CreateDate);

	/**
	 * Returns the created by of this mom pointdiscussoin.
	 *
	 * @return the created by of this mom pointdiscussoin
	 */
	@AutoEscape
	public String getCreatedBy();

	/**
	 * Sets the created by of this mom pointdiscussoin.
	 *
	 * @param CreatedBy the created by of this mom pointdiscussoin
	 */
	public void setCreatedBy(String CreatedBy);

	/**
	 * Returns the modified date of this mom pointdiscussoin.
	 *
	 * @return the modified date of this mom pointdiscussoin
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this mom pointdiscussoin.
	 *
	 * @param ModifiedDate the modified date of this mom pointdiscussoin
	 */
	public void setModifiedDate(Date ModifiedDate);

	/**
	 * Returns the modified by of this mom pointdiscussoin.
	 *
	 * @return the modified by of this mom pointdiscussoin
	 */
	@AutoEscape
	public String getModifiedBy();

	/**
	 * Sets the modified by of this mom pointdiscussoin.
	 *
	 * @param ModifiedBy the modified by of this mom pointdiscussoin
	 */
	public void setModifiedBy(String ModifiedBy);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(MOMPointdiscussoin momPointdiscussoin);

	@Override
	public int hashCode();

	@Override
	public CacheModel<MOMPointdiscussoin> toCacheModel();

	@Override
	public MOMPointdiscussoin toEscapedModel();

	@Override
	public MOMPointdiscussoin toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}