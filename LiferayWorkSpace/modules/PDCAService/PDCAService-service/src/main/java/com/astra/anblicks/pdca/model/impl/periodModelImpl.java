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

import com.astra.anblicks.pdca.model.period;
import com.astra.anblicks.pdca.model.periodModel;
import com.astra.anblicks.pdca.model.periodSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the period service. Represents a row in the &quot;pdca_period&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link periodModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link periodImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see periodImpl
 * @see period
 * @see periodModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class periodModelImpl extends BaseModelImpl<period>
	implements periodModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a period model instance should use the {@link period} interface instead.
	 */
	public static final String TABLE_NAME = "pdca_period";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "periodId", Types.BIGINT },
			{ "periodName", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("periodId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("periodName", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table pdca_period (uuid_ VARCHAR(75) null,periodId LONG not null primary key,periodName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table pdca_period";
	public static final String ORDER_BY_JPQL = " ORDER BY period.periodId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY pdca_period.periodId ASC";
	public static final String DATA_SOURCE = "pdcaSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.astra.anblicks.pdca.model.period"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.astra.anblicks.pdca.model.period"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.astra.anblicks.pdca.model.period"),
			true);
	public static final long UUID_COLUMN_BITMASK = 1L;
	public static final long PERIODID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static period toModel(periodSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		period model = new periodImpl();

		model.setUuid(soapModel.getUuid());
		model.setPeriodId(soapModel.getPeriodId());
		model.setPeriodName(soapModel.getPeriodName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<period> toModels(periodSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<period> models = new ArrayList<period>(soapModels.length);

		for (periodSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"lock.expiration.time.com.astra.anblicks.pdca.model.period"));

	public periodModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _periodId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPeriodId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _periodId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return period.class;
	}

	@Override
	public String getModelClassName() {
		return period.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("periodId", getPeriodId());
		attributes.put("periodName", getPeriodName());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long periodId = (Long)attributes.get("periodId");

		if (periodId != null) {
			setPeriodId(periodId);
		}

		String periodName = (String)attributes.get("periodName");

		if (periodName != null) {
			setPeriodName(periodName);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getPeriodId() {
		return _periodId;
	}

	@Override
	public void setPeriodId(long periodId) {
		_periodId = periodId;
	}

	@JSON
	@Override
	public String getPeriodName() {
		if (_periodName == null) {
			return StringPool.BLANK;
		}
		else {
			return _periodName;
		}
	}

	@Override
	public void setPeriodName(String periodName) {
		_periodName = periodName;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			period.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public period toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (period)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		periodImpl periodImpl = new periodImpl();

		periodImpl.setUuid(getUuid());
		periodImpl.setPeriodId(getPeriodId());
		periodImpl.setPeriodName(getPeriodName());

		periodImpl.resetOriginalValues();

		return periodImpl;
	}

	@Override
	public int compareTo(period period) {
		long primaryKey = period.getPrimaryKey();

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

		if (!(obj instanceof period)) {
			return false;
		}

		period period = (period)obj;

		long primaryKey = period.getPrimaryKey();

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
		periodModelImpl periodModelImpl = this;

		periodModelImpl._originalUuid = periodModelImpl._uuid;

		periodModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<period> toCacheModel() {
		periodCacheModel periodCacheModel = new periodCacheModel();

		periodCacheModel.uuid = getUuid();

		String uuid = periodCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			periodCacheModel.uuid = null;
		}

		periodCacheModel.periodId = getPeriodId();

		periodCacheModel.periodName = getPeriodName();

		String periodName = periodCacheModel.periodName;

		if ((periodName != null) && (periodName.length() == 0)) {
			periodCacheModel.periodName = null;
		}

		return periodCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", periodId=");
		sb.append(getPeriodId());
		sb.append(", periodName=");
		sb.append(getPeriodName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.astra.anblicks.pdca.model.period");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodId</column-name><column-value><![CDATA[");
		sb.append(getPeriodId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodName</column-name><column-value><![CDATA[");
		sb.append(getPeriodName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = period.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			period.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _periodId;
	private String _periodName;
	private long _columnBitmask;
	private period _escapedModel;
}