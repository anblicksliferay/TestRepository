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
 * The base model interface for the AstraPdca_Year service. Represents a row in the &quot;pdca_astrapdca_year&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.astra.anblicks.pdca.model.impl.AstraPdca_YearModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.astra.anblicks.pdca.model.impl.AstraPdca_YearImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AstraPdca_Year
 * @see com.astra.anblicks.pdca.model.impl.AstraPdca_YearImpl
 * @see com.astra.anblicks.pdca.model.impl.AstraPdca_YearModelImpl
 * @generated
 */
@ProviderType
public interface AstraPdca_YearModel extends BaseModel<AstraPdca_Year> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a astra pdca_ year model instance should use the {@link AstraPdca_Year} interface instead.
	 */

	/**
	 * Returns the primary key of this astra pdca_ year.
	 *
	 * @return the primary key of this astra pdca_ year
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this astra pdca_ year.
	 *
	 * @param primaryKey the primary key of this astra pdca_ year
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the year ID of this astra pdca_ year.
	 *
	 * @return the year ID of this astra pdca_ year
	 */
	public long getYearId();

	/**
	 * Sets the year ID of this astra pdca_ year.
	 *
	 * @param YearId the year ID of this astra pdca_ year
	 */
	public void setYearId(long YearId);

	/**
	 * Returns the year id_ company of this astra pdca_ year.
	 *
	 * @return the year id_ company of this astra pdca_ year
	 */
	public long getYearId_Company();

	/**
	 * Sets the year id_ company of this astra pdca_ year.
	 *
	 * @param YearId_Company the year id_ company of this astra pdca_ year
	 */
	public void setYearId_Company(long YearId_Company);

	/**
	 * Returns the year of this astra pdca_ year.
	 *
	 * @return the year of this astra pdca_ year
	 */
	public long getYear();

	/**
	 * Sets the year of this astra pdca_ year.
	 *
	 * @param Year the year of this astra pdca_ year
	 */
	public void setYear(long Year);

	/**
	 * Returns the site ID of this astra pdca_ year.
	 *
	 * @return the site ID of this astra pdca_ year
	 */
	public long getSiteId();

	/**
	 * Sets the site ID of this astra pdca_ year.
	 *
	 * @param SiteId the site ID of this astra pdca_ year
	 */
	public void setSiteId(long SiteId);

	/**
	 * Returns the create date of this astra pdca_ year.
	 *
	 * @return the create date of this astra pdca_ year
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this astra pdca_ year.
	 *
	 * @param CreateDate the create date of this astra pdca_ year
	 */
	public void setCreateDate(Date CreateDate);

	/**
	 * Returns the created by of this astra pdca_ year.
	 *
	 * @return the created by of this astra pdca_ year
	 */
	@AutoEscape
	public String getCreatedBy();

	/**
	 * Sets the created by of this astra pdca_ year.
	 *
	 * @param CreatedBy the created by of this astra pdca_ year
	 */
	public void setCreatedBy(String CreatedBy);

	/**
	 * Returns the modified date of this astra pdca_ year.
	 *
	 * @return the modified date of this astra pdca_ year
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this astra pdca_ year.
	 *
	 * @param ModifiedDate the modified date of this astra pdca_ year
	 */
	public void setModifiedDate(Date ModifiedDate);

	/**
	 * Returns the modified by of this astra pdca_ year.
	 *
	 * @return the modified by of this astra pdca_ year
	 */
	@AutoEscape
	public String getModifiedBy();

	/**
	 * Sets the modified by of this astra pdca_ year.
	 *
	 * @param ModifiedBy the modified by of this astra pdca_ year
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
	public int compareTo(AstraPdca_Year astraPdca_Year);

	@Override
	public int hashCode();

	@Override
	public CacheModel<AstraPdca_Year> toCacheModel();

	@Override
	public AstraPdca_Year toEscapedModel();

	@Override
	public AstraPdca_Year toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}