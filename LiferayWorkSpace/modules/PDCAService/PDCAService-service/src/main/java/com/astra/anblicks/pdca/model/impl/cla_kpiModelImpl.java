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

import com.astra.anblicks.pdca.model.cla_kpi;
import com.astra.anblicks.pdca.model.cla_kpiModel;
import com.astra.anblicks.pdca.model.cla_kpiSoap;

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
 * The base model implementation for the cla_kpi service. Represents a row in the &quot;pdca_cla_kpi&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link cla_kpiModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link cla_kpiImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see cla_kpiImpl
 * @see cla_kpi
 * @see cla_kpiModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class cla_kpiModelImpl extends BaseModelImpl<cla_kpi>
	implements cla_kpiModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cla_kpi model instance should use the {@link cla_kpi} interface instead.
	 */
	public static final String TABLE_NAME = "pdca_cla_kpi";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "claKpiId", Types.BIGINT },
			{ "kpiId", Types.BIGINT },
			{ "periodId", Types.BIGINT },
			{ "ytd", Types.BIGINT },
			{ "ol", Types.DOUBLE },
			{ "claPoint", Types.DOUBLE },
			{ "achivement", Types.DOUBLE },
			{ "peroidInput", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("claKpiId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("kpiId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("periodId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ytd", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ol", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("claPoint", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("achivement", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("peroidInput", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table pdca_cla_kpi (uuid_ VARCHAR(75) null,claKpiId LONG not null primary key,kpiId LONG,periodId LONG,ytd LONG,ol DOUBLE,claPoint DOUBLE,achivement DOUBLE,peroidInput VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table pdca_cla_kpi";
	public static final String ORDER_BY_JPQL = " ORDER BY cla_kpi.claKpiId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY pdca_cla_kpi.claKpiId ASC";
	public static final String DATA_SOURCE = "pdcaSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.astra.anblicks.pdca.model.cla_kpi"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.astra.anblicks.pdca.model.cla_kpi"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.astra.anblicks.pdca.model.cla_kpi"),
			true);
	public static final long UUID_COLUMN_BITMASK = 1L;
	public static final long CLAKPIID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static cla_kpi toModel(cla_kpiSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		cla_kpi model = new cla_kpiImpl();

		model.setUuid(soapModel.getUuid());
		model.setClaKpiId(soapModel.getClaKpiId());
		model.setKpiId(soapModel.getKpiId());
		model.setPeriodId(soapModel.getPeriodId());
		model.setYtd(soapModel.getYtd());
		model.setOl(soapModel.getOl());
		model.setClaPoint(soapModel.getClaPoint());
		model.setAchivement(soapModel.getAchivement());
		model.setPeroidInput(soapModel.getPeroidInput());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<cla_kpi> toModels(cla_kpiSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<cla_kpi> models = new ArrayList<cla_kpi>(soapModels.length);

		for (cla_kpiSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"lock.expiration.time.com.astra.anblicks.pdca.model.cla_kpi"));

	public cla_kpiModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _claKpiId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setClaKpiId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _claKpiId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return cla_kpi.class;
	}

	@Override
	public String getModelClassName() {
		return cla_kpi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("claKpiId", getClaKpiId());
		attributes.put("kpiId", getKpiId());
		attributes.put("periodId", getPeriodId());
		attributes.put("ytd", getYtd());
		attributes.put("ol", getOl());
		attributes.put("claPoint", getClaPoint());
		attributes.put("achivement", getAchivement());
		attributes.put("peroidInput", getPeroidInput());

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

		Long claKpiId = (Long)attributes.get("claKpiId");

		if (claKpiId != null) {
			setClaKpiId(claKpiId);
		}

		Long kpiId = (Long)attributes.get("kpiId");

		if (kpiId != null) {
			setKpiId(kpiId);
		}

		Long periodId = (Long)attributes.get("periodId");

		if (periodId != null) {
			setPeriodId(periodId);
		}

		Long ytd = (Long)attributes.get("ytd");

		if (ytd != null) {
			setYtd(ytd);
		}

		Double ol = (Double)attributes.get("ol");

		if (ol != null) {
			setOl(ol);
		}

		Double claPoint = (Double)attributes.get("claPoint");

		if (claPoint != null) {
			setClaPoint(claPoint);
		}

		Double achivement = (Double)attributes.get("achivement");

		if (achivement != null) {
			setAchivement(achivement);
		}

		String peroidInput = (String)attributes.get("peroidInput");

		if (peroidInput != null) {
			setPeroidInput(peroidInput);
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
	public long getClaKpiId() {
		return _claKpiId;
	}

	@Override
	public void setClaKpiId(long claKpiId) {
		_claKpiId = claKpiId;
	}

	@JSON
	@Override
	public long getKpiId() {
		return _kpiId;
	}

	@Override
	public void setKpiId(long kpiId) {
		_kpiId = kpiId;
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
	public long getYtd() {
		return _ytd;
	}

	@Override
	public void setYtd(long ytd) {
		_ytd = ytd;
	}

	@JSON
	@Override
	public double getOl() {
		return _ol;
	}

	@Override
	public void setOl(double ol) {
		_ol = ol;
	}

	@JSON
	@Override
	public double getClaPoint() {
		return _claPoint;
	}

	@Override
	public void setClaPoint(double claPoint) {
		_claPoint = claPoint;
	}

	@JSON
	@Override
	public double getAchivement() {
		return _achivement;
	}

	@Override
	public void setAchivement(double achivement) {
		_achivement = achivement;
	}

	@JSON
	@Override
	public String getPeroidInput() {
		if (_peroidInput == null) {
			return StringPool.BLANK;
		}
		else {
			return _peroidInput;
		}
	}

	@Override
	public void setPeroidInput(String peroidInput) {
		_peroidInput = peroidInput;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			cla_kpi.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public cla_kpi toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (cla_kpi)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		cla_kpiImpl cla_kpiImpl = new cla_kpiImpl();

		cla_kpiImpl.setUuid(getUuid());
		cla_kpiImpl.setClaKpiId(getClaKpiId());
		cla_kpiImpl.setKpiId(getKpiId());
		cla_kpiImpl.setPeriodId(getPeriodId());
		cla_kpiImpl.setYtd(getYtd());
		cla_kpiImpl.setOl(getOl());
		cla_kpiImpl.setClaPoint(getClaPoint());
		cla_kpiImpl.setAchivement(getAchivement());
		cla_kpiImpl.setPeroidInput(getPeroidInput());

		cla_kpiImpl.resetOriginalValues();

		return cla_kpiImpl;
	}

	@Override
	public int compareTo(cla_kpi cla_kpi) {
		long primaryKey = cla_kpi.getPrimaryKey();

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

		if (!(obj instanceof cla_kpi)) {
			return false;
		}

		cla_kpi cla_kpi = (cla_kpi)obj;

		long primaryKey = cla_kpi.getPrimaryKey();

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
		cla_kpiModelImpl cla_kpiModelImpl = this;

		cla_kpiModelImpl._originalUuid = cla_kpiModelImpl._uuid;

		cla_kpiModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<cla_kpi> toCacheModel() {
		cla_kpiCacheModel cla_kpiCacheModel = new cla_kpiCacheModel();

		cla_kpiCacheModel.uuid = getUuid();

		String uuid = cla_kpiCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			cla_kpiCacheModel.uuid = null;
		}

		cla_kpiCacheModel.claKpiId = getClaKpiId();

		cla_kpiCacheModel.kpiId = getKpiId();

		cla_kpiCacheModel.periodId = getPeriodId();

		cla_kpiCacheModel.ytd = getYtd();

		cla_kpiCacheModel.ol = getOl();

		cla_kpiCacheModel.claPoint = getClaPoint();

		cla_kpiCacheModel.achivement = getAchivement();

		cla_kpiCacheModel.peroidInput = getPeroidInput();

		String peroidInput = cla_kpiCacheModel.peroidInput;

		if ((peroidInput != null) && (peroidInput.length() == 0)) {
			cla_kpiCacheModel.peroidInput = null;
		}

		return cla_kpiCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", claKpiId=");
		sb.append(getClaKpiId());
		sb.append(", kpiId=");
		sb.append(getKpiId());
		sb.append(", periodId=");
		sb.append(getPeriodId());
		sb.append(", ytd=");
		sb.append(getYtd());
		sb.append(", ol=");
		sb.append(getOl());
		sb.append(", claPoint=");
		sb.append(getClaPoint());
		sb.append(", achivement=");
		sb.append(getAchivement());
		sb.append(", peroidInput=");
		sb.append(getPeroidInput());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.astra.anblicks.pdca.model.cla_kpi");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>claKpiId</column-name><column-value><![CDATA[");
		sb.append(getClaKpiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kpiId</column-name><column-value><![CDATA[");
		sb.append(getKpiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodId</column-name><column-value><![CDATA[");
		sb.append(getPeriodId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ytd</column-name><column-value><![CDATA[");
		sb.append(getYtd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ol</column-name><column-value><![CDATA[");
		sb.append(getOl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>claPoint</column-name><column-value><![CDATA[");
		sb.append(getClaPoint());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>achivement</column-name><column-value><![CDATA[");
		sb.append(getAchivement());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>peroidInput</column-name><column-value><![CDATA[");
		sb.append(getPeroidInput());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = cla_kpi.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			cla_kpi.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _claKpiId;
	private long _kpiId;
	private long _periodId;
	private long _ytd;
	private double _ol;
	private double _claPoint;
	private double _achivement;
	private String _peroidInput;
	private long _columnBitmask;
	private cla_kpi _escapedModel;
}