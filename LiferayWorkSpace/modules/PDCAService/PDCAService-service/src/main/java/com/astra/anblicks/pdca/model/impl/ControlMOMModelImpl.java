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

package com.astra.anblicks.pdca.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.astra.anblicks.pdca.model.ControlMOM;
import com.astra.anblicks.pdca.model.ControlMOMModel;
import com.astra.anblicks.pdca.model.ControlMOMSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ControlMOM service. Represents a row in the &quot;pdca_controlmom&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ControlMOMModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ControlMOMImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ControlMOMImpl
 * @see ControlMOM
 * @see ControlMOMModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class ControlMOMModelImpl extends BaseModelImpl<ControlMOM>
	implements ControlMOMModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a control mom model instance should use the {@link ControlMOM} interface instead.
	 */
	public static final String TABLE_NAME = "pdca_controlmom";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ControlMOMId", Types.BIGINT },
			{ "ListMOMId", Types.BIGINT },
			{ "pdId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "Status", Types.VARCHAR },
			{ "FollowUp", Types.VARCHAR },
			{ "FollowUpData", Types.VARCHAR },
			{ "SiteId", Types.BIGINT },
			{ "CreateDate", Types.TIMESTAMP },
			{ "CreatedBy", Types.VARCHAR },
			{ "ModifiedDate", Types.TIMESTAMP },
			{ "ModifiedBy", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("ControlMOMId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ListMOMId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("pdId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("Status", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("FollowUp", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("FollowUpData", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("SiteId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("CreateDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("CreatedBy", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ModifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("ModifiedBy", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table pdca_controlmom (ControlMOMId LONG not null primary key,ListMOMId LONG,pdId LONG,userId LONG,Status VARCHAR(75) null,FollowUp VARCHAR(75) null,FollowUpData VARCHAR(75) null,SiteId LONG,CreateDate DATE null,CreatedBy VARCHAR(75) null,ModifiedDate DATE null,ModifiedBy VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table pdca_controlmom";
	public static final String ORDER_BY_JPQL = " ORDER BY controlMOM.ControlMOMId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY pdca_controlmom.ControlMOMId ASC";
	public static final String DATA_SOURCE = "pdcaSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.astra.anblicks.pdca.model.ControlMOM"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.astra.anblicks.pdca.model.ControlMOM"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ControlMOM toModel(ControlMOMSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ControlMOM model = new ControlMOMImpl();

		model.setControlMOMId(soapModel.getControlMOMId());
		model.setListMOMId(soapModel.getListMOMId());
		model.setPdId(soapModel.getPdId());
		model.setUserId(soapModel.getUserId());
		model.setStatus(soapModel.getStatus());
		model.setFollowUp(soapModel.getFollowUp());
		model.setFollowUpData(soapModel.getFollowUpData());
		model.setSiteId(soapModel.getSiteId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setCreatedBy(soapModel.getCreatedBy());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setModifiedBy(soapModel.getModifiedBy());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ControlMOM> toModels(ControlMOMSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ControlMOM> models = new ArrayList<ControlMOM>(soapModels.length);

		for (ControlMOMSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"lock.expiration.time.com.astra.anblicks.pdca.model.ControlMOM"));

	public ControlMOMModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ControlMOMId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setControlMOMId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ControlMOMId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	@JSON
	@Override
	public long getControlMOMId() {
		return _ControlMOMId;
	}

	@Override
	public void setControlMOMId(long ControlMOMId) {
		_ControlMOMId = ControlMOMId;
	}

	@JSON
	@Override
	public long getListMOMId() {
		return _ListMOMId;
	}

	@Override
	public void setListMOMId(long ListMOMId) {
		_ListMOMId = ListMOMId;
	}

	@JSON
	@Override
	public long getPdId() {
		return _pdId;
	}

	@Override
	public void setPdId(long pdId) {
		_pdId = pdId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getStatus() {
		if (_Status == null) {
			return StringPool.BLANK;
		}
		else {
			return _Status;
		}
	}

	@Override
	public void setStatus(String Status) {
		_Status = Status;
	}

	@JSON
	@Override
	public String getFollowUp() {
		if (_FollowUp == null) {
			return StringPool.BLANK;
		}
		else {
			return _FollowUp;
		}
	}

	@Override
	public void setFollowUp(String FollowUp) {
		_FollowUp = FollowUp;
	}

	@JSON
	@Override
	public String getFollowUpData() {
		if (_FollowUpData == null) {
			return StringPool.BLANK;
		}
		else {
			return _FollowUpData;
		}
	}

	@Override
	public void setFollowUpData(String FollowUpData) {
		_FollowUpData = FollowUpData;
	}

	@JSON
	@Override
	public long getSiteId() {
		return _SiteId;
	}

	@Override
	public void setSiteId(long SiteId) {
		_SiteId = SiteId;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _CreateDate;
	}

	@Override
	public void setCreateDate(Date CreateDate) {
		_CreateDate = CreateDate;
	}

	@JSON
	@Override
	public String getCreatedBy() {
		if (_CreatedBy == null) {
			return StringPool.BLANK;
		}
		else {
			return _CreatedBy;
		}
	}

	@Override
	public void setCreatedBy(String CreatedBy) {
		_CreatedBy = CreatedBy;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _ModifiedDate;
	}

	@Override
	public void setModifiedDate(Date ModifiedDate) {
		_ModifiedDate = ModifiedDate;
	}

	@JSON
	@Override
	public String getModifiedBy() {
		if (_ModifiedBy == null) {
			return StringPool.BLANK;
		}
		else {
			return _ModifiedBy;
		}
	}

	@Override
	public void setModifiedBy(String ModifiedBy) {
		_ModifiedBy = ModifiedBy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ControlMOM.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ControlMOM toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ControlMOM)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ControlMOMImpl controlMOMImpl = new ControlMOMImpl();

		controlMOMImpl.setControlMOMId(getControlMOMId());
		controlMOMImpl.setListMOMId(getListMOMId());
		controlMOMImpl.setPdId(getPdId());
		controlMOMImpl.setUserId(getUserId());
		controlMOMImpl.setStatus(getStatus());
		controlMOMImpl.setFollowUp(getFollowUp());
		controlMOMImpl.setFollowUpData(getFollowUpData());
		controlMOMImpl.setSiteId(getSiteId());
		controlMOMImpl.setCreateDate(getCreateDate());
		controlMOMImpl.setCreatedBy(getCreatedBy());
		controlMOMImpl.setModifiedDate(getModifiedDate());
		controlMOMImpl.setModifiedBy(getModifiedBy());

		controlMOMImpl.resetOriginalValues();

		return controlMOMImpl;
	}

	@Override
	public int compareTo(ControlMOM controlMOM) {
		long primaryKey = controlMOM.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ControlMOM)) {
			return false;
		}

		ControlMOM controlMOM = (ControlMOM)obj;

		long primaryKey = controlMOM.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<ControlMOM> toCacheModel() {
		ControlMOMCacheModel controlMOMCacheModel = new ControlMOMCacheModel();

		controlMOMCacheModel.ControlMOMId = getControlMOMId();

		controlMOMCacheModel.ListMOMId = getListMOMId();

		controlMOMCacheModel.pdId = getPdId();

		controlMOMCacheModel.userId = getUserId();

		controlMOMCacheModel.Status = getStatus();

		String Status = controlMOMCacheModel.Status;

		if ((Status != null) && (Status.length() == 0)) {
			controlMOMCacheModel.Status = null;
		}

		controlMOMCacheModel.FollowUp = getFollowUp();

		String FollowUp = controlMOMCacheModel.FollowUp;

		if ((FollowUp != null) && (FollowUp.length() == 0)) {
			controlMOMCacheModel.FollowUp = null;
		}

		controlMOMCacheModel.FollowUpData = getFollowUpData();

		String FollowUpData = controlMOMCacheModel.FollowUpData;

		if ((FollowUpData != null) && (FollowUpData.length() == 0)) {
			controlMOMCacheModel.FollowUpData = null;
		}

		controlMOMCacheModel.SiteId = getSiteId();

		Date CreateDate = getCreateDate();

		if (CreateDate != null) {
			controlMOMCacheModel.CreateDate = CreateDate.getTime();
		}
		else {
			controlMOMCacheModel.CreateDate = Long.MIN_VALUE;
		}

		controlMOMCacheModel.CreatedBy = getCreatedBy();

		String CreatedBy = controlMOMCacheModel.CreatedBy;

		if ((CreatedBy != null) && (CreatedBy.length() == 0)) {
			controlMOMCacheModel.CreatedBy = null;
		}

		Date ModifiedDate = getModifiedDate();

		if (ModifiedDate != null) {
			controlMOMCacheModel.ModifiedDate = ModifiedDate.getTime();
		}
		else {
			controlMOMCacheModel.ModifiedDate = Long.MIN_VALUE;
		}

		controlMOMCacheModel.ModifiedBy = getModifiedBy();

		String ModifiedBy = controlMOMCacheModel.ModifiedBy;

		if ((ModifiedBy != null) && (ModifiedBy.length() == 0)) {
			controlMOMCacheModel.ModifiedBy = null;
		}

		return controlMOMCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{ControlMOMId=");
		sb.append(getControlMOMId());
		sb.append(", ListMOMId=");
		sb.append(getListMOMId());
		sb.append(", pdId=");
		sb.append(getPdId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", Status=");
		sb.append(getStatus());
		sb.append(", FollowUp=");
		sb.append(getFollowUp());
		sb.append(", FollowUpData=");
		sb.append(getFollowUpData());
		sb.append(", SiteId=");
		sb.append(getSiteId());
		sb.append(", CreateDate=");
		sb.append(getCreateDate());
		sb.append(", CreatedBy=");
		sb.append(getCreatedBy());
		sb.append(", ModifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", ModifiedBy=");
		sb.append(getModifiedBy());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.astra.anblicks.pdca.model.ControlMOM");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ControlMOMId</column-name><column-value><![CDATA[");
		sb.append(getControlMOMId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ListMOMId</column-name><column-value><![CDATA[");
		sb.append(getListMOMId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pdId</column-name><column-value><![CDATA[");
		sb.append(getPdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>FollowUp</column-name><column-value><![CDATA[");
		sb.append(getFollowUp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>FollowUpData</column-name><column-value><![CDATA[");
		sb.append(getFollowUpData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SiteId</column-name><column-value><![CDATA[");
		sb.append(getSiteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CreateDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CreatedBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ModifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ModifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ControlMOM.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ControlMOM.class
		};
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
	private ControlMOM _escapedModel;
}