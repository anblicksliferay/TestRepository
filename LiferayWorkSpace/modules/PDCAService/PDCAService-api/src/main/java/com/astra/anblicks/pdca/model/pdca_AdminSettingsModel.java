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
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the pdca_AdminSettings service. Represents a row in the &quot;pdca_pdca_adminsettings&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.astra.anblicks.pdca.model.impl.pdca_AdminSettingsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.astra.anblicks.pdca.model.impl.pdca_AdminSettingsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see pdca_AdminSettings
 * @see com.astra.anblicks.pdca.model.impl.pdca_AdminSettingsImpl
 * @see com.astra.anblicks.pdca.model.impl.pdca_AdminSettingsModelImpl
 * @generated
 */
@ProviderType
public interface pdca_AdminSettingsModel extends BaseModel<pdca_AdminSettings>,
	ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a pdca_ admin settings model instance should use the {@link pdca_AdminSettings} interface instead.
	 */

	/**
	 * Returns the primary key of this pdca_ admin settings.
	 *
	 * @return the primary key of this pdca_ admin settings
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this pdca_ admin settings.
	 *
	 * @param primaryKey the primary key of this pdca_ admin settings
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the settings_ ID of this pdca_ admin settings.
	 *
	 * @return the settings_ ID of this pdca_ admin settings
	 */
	public long getSettings_Id();

	/**
	 * Sets the settings_ ID of this pdca_ admin settings.
	 *
	 * @param settings_Id the settings_ ID of this pdca_ admin settings
	 */
	public void setSettings_Id(long settings_Id);

	/**
	 * Returns the module ID of this pdca_ admin settings.
	 *
	 * @return the module ID of this pdca_ admin settings
	 */
	public long getModuleId();

	/**
	 * Sets the module ID of this pdca_ admin settings.
	 *
	 * @param moduleId the module ID of this pdca_ admin settings
	 */
	public void setModuleId(long moduleId);

	/**
	 * Returns the year of this pdca_ admin settings.
	 *
	 * @return the year of this pdca_ admin settings
	 */
	public long getYear();

	/**
	 * Sets the year of this pdca_ admin settings.
	 *
	 * @param year the year of this pdca_ admin settings
	 */
	public void setYear(long year);

	/**
	 * Returns the company ID of this pdca_ admin settings.
	 *
	 * @return the company ID of this pdca_ admin settings
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this pdca_ admin settings.
	 *
	 * @param companyId the company ID of this pdca_ admin settings
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the period ID of this pdca_ admin settings.
	 *
	 * @return the period ID of this pdca_ admin settings
	 */
	public long getPeriodId();

	/**
	 * Sets the period ID of this pdca_ admin settings.
	 *
	 * @param periodId the period ID of this pdca_ admin settings
	 */
	public void setPeriodId(long periodId);

	/**
	 * Returns the site ID of this pdca_ admin settings.
	 *
	 * @return the site ID of this pdca_ admin settings
	 */
	public long getSiteId();

	/**
	 * Sets the site ID of this pdca_ admin settings.
	 *
	 * @param SiteId the site ID of this pdca_ admin settings
	 */
	public void setSiteId(long SiteId);

	/**
	 * Returns the create date of this pdca_ admin settings.
	 *
	 * @return the create date of this pdca_ admin settings
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this pdca_ admin settings.
	 *
	 * @param CreateDate the create date of this pdca_ admin settings
	 */
	public void setCreateDate(Date CreateDate);

	/**
	 * Returns the created by of this pdca_ admin settings.
	 *
	 * @return the created by of this pdca_ admin settings
	 */
	@AutoEscape
	public String getCreatedBy();

	/**
	 * Sets the created by of this pdca_ admin settings.
	 *
	 * @param CreatedBy the created by of this pdca_ admin settings
	 */
	public void setCreatedBy(String CreatedBy);

	/**
	 * Returns the modified date of this pdca_ admin settings.
	 *
	 * @return the modified date of this pdca_ admin settings
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this pdca_ admin settings.
	 *
	 * @param ModifiedDate the modified date of this pdca_ admin settings
	 */
	public void setModifiedDate(Date ModifiedDate);

	/**
	 * Returns the modified by of this pdca_ admin settings.
	 *
	 * @return the modified by of this pdca_ admin settings
	 */
	@AutoEscape
	public String getModifiedBy();

	/**
	 * Sets the modified by of this pdca_ admin settings.
	 *
	 * @param ModifiedBy the modified by of this pdca_ admin settings
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
	public int compareTo(
		com.astra.anblicks.pdca.model.pdca_AdminSettings pdca_AdminSettings);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.astra.anblicks.pdca.model.pdca_AdminSettings> toCacheModel();

	@Override
	public com.astra.anblicks.pdca.model.pdca_AdminSettings toEscapedModel();

	@Override
	public com.astra.anblicks.pdca.model.pdca_AdminSettings toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}