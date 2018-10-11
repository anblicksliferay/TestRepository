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

import com.astra.anblicks.pdca.model.tradingProfit;
import com.astra.anblicks.pdca.model.tradingProfitModel;
import com.astra.anblicks.pdca.model.tradingProfitSoap;

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
 * The base model implementation for the tradingProfit service. Represents a row in the &quot;pdca_tradingProfit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link tradingProfitModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link tradingProfitImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see tradingProfitImpl
 * @see tradingProfit
 * @see tradingProfitModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class tradingProfitModelImpl extends BaseModelImpl<tradingProfit>
	implements tradingProfitModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a trading profit model instance should use the {@link tradingProfit} interface instead.
	 */
	public static final String TABLE_NAME = "pdca_tradingProfit";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "tradingProfitId", Types.BIGINT },
			{ "periodId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "year", Types.BIGINT },
			{ "npat", Types.DOUBLE },
			{ "netForex", Types.DOUBLE },
			{ "ppeDispos", Types.DOUBLE },
			{ "revalutionOnPropertyInvestment", Types.DOUBLE },
			{ "investment", Types.DOUBLE },
			{ "taxExpense", Types.DOUBLE },
			{ "impairmentOnAsset", Types.DOUBLE },
			{ "others", Types.DOUBLE }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("tradingProfitId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("periodId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("year", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("npat", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("netForex", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("ppeDispos", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("revalutionOnPropertyInvestment", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("investment", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("taxExpense", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("impairmentOnAsset", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("others", Types.DOUBLE);
	}

	public static final String TABLE_SQL_CREATE = "create table pdca_tradingProfit (uuid_ VARCHAR(75) null,tradingProfitId LONG not null primary key,periodId LONG,companyId LONG,year LONG,npat DOUBLE,netForex DOUBLE,ppeDispos DOUBLE,revalutionOnPropertyInvestment DOUBLE,investment DOUBLE,taxExpense DOUBLE,impairmentOnAsset DOUBLE,others DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table pdca_tradingProfit";
	public static final String ORDER_BY_JPQL = " ORDER BY tradingProfit.tradingProfitId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY pdca_tradingProfit.tradingProfitId ASC";
	public static final String DATA_SOURCE = "extDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.astra.anblicks.pdca.model.tradingProfit"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.astra.anblicks.pdca.model.tradingProfit"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.astra.anblicks.pdca.model.tradingProfit"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long UUID_COLUMN_BITMASK = 2L;
	public static final long TRADINGPROFITID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static tradingProfit toModel(tradingProfitSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		tradingProfit model = new tradingProfitImpl();

		model.setUuid(soapModel.getUuid());
		model.setTradingProfitId(soapModel.getTradingProfitId());
		model.setPeriodId(soapModel.getPeriodId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setYear(soapModel.getYear());
		model.setNpat(soapModel.getNpat());
		model.setNetForex(soapModel.getNetForex());
		model.setPpeDispos(soapModel.getPpeDispos());
		model.setRevalutionOnPropertyInvestment(soapModel.getRevalutionOnPropertyInvestment());
		model.setInvestment(soapModel.getInvestment());
		model.setTaxExpense(soapModel.getTaxExpense());
		model.setImpairmentOnAsset(soapModel.getImpairmentOnAsset());
		model.setOthers(soapModel.getOthers());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<tradingProfit> toModels(tradingProfitSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<tradingProfit> models = new ArrayList<tradingProfit>(soapModels.length);

		for (tradingProfitSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"lock.expiration.time.com.astra.anblicks.pdca.model.tradingProfit"));

	public tradingProfitModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _tradingProfitId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTradingProfitId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tradingProfitId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return tradingProfit.class;
	}

	@Override
	public String getModelClassName() {
		return tradingProfit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("tradingProfitId", getTradingProfitId());
		attributes.put("periodId", getPeriodId());
		attributes.put("companyId", getCompanyId());
		attributes.put("year", getYear());
		attributes.put("npat", getNpat());
		attributes.put("netForex", getNetForex());
		attributes.put("ppeDispos", getPpeDispos());
		attributes.put("revalutionOnPropertyInvestment",
			getRevalutionOnPropertyInvestment());
		attributes.put("investment", getInvestment());
		attributes.put("taxExpense", getTaxExpense());
		attributes.put("impairmentOnAsset", getImpairmentOnAsset());
		attributes.put("others", getOthers());

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

		Long tradingProfitId = (Long)attributes.get("tradingProfitId");

		if (tradingProfitId != null) {
			setTradingProfitId(tradingProfitId);
		}

		Long periodId = (Long)attributes.get("periodId");

		if (periodId != null) {
			setPeriodId(periodId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long year = (Long)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		Double npat = (Double)attributes.get("npat");

		if (npat != null) {
			setNpat(npat);
		}

		Double netForex = (Double)attributes.get("netForex");

		if (netForex != null) {
			setNetForex(netForex);
		}

		Double ppeDispos = (Double)attributes.get("ppeDispos");

		if (ppeDispos != null) {
			setPpeDispos(ppeDispos);
		}

		Double revalutionOnPropertyInvestment = (Double)attributes.get(
				"revalutionOnPropertyInvestment");

		if (revalutionOnPropertyInvestment != null) {
			setRevalutionOnPropertyInvestment(revalutionOnPropertyInvestment);
		}

		Double investment = (Double)attributes.get("investment");

		if (investment != null) {
			setInvestment(investment);
		}

		Double taxExpense = (Double)attributes.get("taxExpense");

		if (taxExpense != null) {
			setTaxExpense(taxExpense);
		}

		Double impairmentOnAsset = (Double)attributes.get("impairmentOnAsset");

		if (impairmentOnAsset != null) {
			setImpairmentOnAsset(impairmentOnAsset);
		}

		Double others = (Double)attributes.get("others");

		if (others != null) {
			setOthers(others);
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
	public long getTradingProfitId() {
		return _tradingProfitId;
	}

	@Override
	public void setTradingProfitId(long tradingProfitId) {
		_tradingProfitId = tradingProfitId;
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
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getYear() {
		return _year;
	}

	@Override
	public void setYear(long year) {
		_year = year;
	}

	@JSON
	@Override
	public double getNpat() {
		return _npat;
	}

	@Override
	public void setNpat(double npat) {
		_npat = npat;
	}

	@JSON
	@Override
	public double getNetForex() {
		return _netForex;
	}

	@Override
	public void setNetForex(double netForex) {
		_netForex = netForex;
	}

	@JSON
	@Override
	public double getPpeDispos() {
		return _ppeDispos;
	}

	@Override
	public void setPpeDispos(double ppeDispos) {
		_ppeDispos = ppeDispos;
	}

	@JSON
	@Override
	public double getRevalutionOnPropertyInvestment() {
		return _revalutionOnPropertyInvestment;
	}

	@Override
	public void setRevalutionOnPropertyInvestment(
		double revalutionOnPropertyInvestment) {
		_revalutionOnPropertyInvestment = revalutionOnPropertyInvestment;
	}

	@JSON
	@Override
	public double getInvestment() {
		return _investment;
	}

	@Override
	public void setInvestment(double investment) {
		_investment = investment;
	}

	@JSON
	@Override
	public double getTaxExpense() {
		return _taxExpense;
	}

	@Override
	public void setTaxExpense(double taxExpense) {
		_taxExpense = taxExpense;
	}

	@JSON
	@Override
	public double getImpairmentOnAsset() {
		return _impairmentOnAsset;
	}

	@Override
	public void setImpairmentOnAsset(double impairmentOnAsset) {
		_impairmentOnAsset = impairmentOnAsset;
	}

	@JSON
	@Override
	public double getOthers() {
		return _others;
	}

	@Override
	public void setOthers(double others) {
		_others = others;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			tradingProfit.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public tradingProfit toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (tradingProfit)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		tradingProfitImpl tradingProfitImpl = new tradingProfitImpl();

		tradingProfitImpl.setUuid(getUuid());
		tradingProfitImpl.setTradingProfitId(getTradingProfitId());
		tradingProfitImpl.setPeriodId(getPeriodId());
		tradingProfitImpl.setCompanyId(getCompanyId());
		tradingProfitImpl.setYear(getYear());
		tradingProfitImpl.setNpat(getNpat());
		tradingProfitImpl.setNetForex(getNetForex());
		tradingProfitImpl.setPpeDispos(getPpeDispos());
		tradingProfitImpl.setRevalutionOnPropertyInvestment(getRevalutionOnPropertyInvestment());
		tradingProfitImpl.setInvestment(getInvestment());
		tradingProfitImpl.setTaxExpense(getTaxExpense());
		tradingProfitImpl.setImpairmentOnAsset(getImpairmentOnAsset());
		tradingProfitImpl.setOthers(getOthers());

		tradingProfitImpl.resetOriginalValues();

		return tradingProfitImpl;
	}

	@Override
	public int compareTo(tradingProfit tradingProfit) {
		long primaryKey = tradingProfit.getPrimaryKey();

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

		if (!(obj instanceof tradingProfit)) {
			return false;
		}

		tradingProfit tradingProfit = (tradingProfit)obj;

		long primaryKey = tradingProfit.getPrimaryKey();

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
		tradingProfitModelImpl tradingProfitModelImpl = this;

		tradingProfitModelImpl._originalUuid = tradingProfitModelImpl._uuid;

		tradingProfitModelImpl._originalCompanyId = tradingProfitModelImpl._companyId;

		tradingProfitModelImpl._setOriginalCompanyId = false;

		tradingProfitModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<tradingProfit> toCacheModel() {
		tradingProfitCacheModel tradingProfitCacheModel = new tradingProfitCacheModel();

		tradingProfitCacheModel.uuid = getUuid();

		String uuid = tradingProfitCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			tradingProfitCacheModel.uuid = null;
		}

		tradingProfitCacheModel.tradingProfitId = getTradingProfitId();

		tradingProfitCacheModel.periodId = getPeriodId();

		tradingProfitCacheModel.companyId = getCompanyId();

		tradingProfitCacheModel.year = getYear();

		tradingProfitCacheModel.npat = getNpat();

		tradingProfitCacheModel.netForex = getNetForex();

		tradingProfitCacheModel.ppeDispos = getPpeDispos();

		tradingProfitCacheModel.revalutionOnPropertyInvestment = getRevalutionOnPropertyInvestment();

		tradingProfitCacheModel.investment = getInvestment();

		tradingProfitCacheModel.taxExpense = getTaxExpense();

		tradingProfitCacheModel.impairmentOnAsset = getImpairmentOnAsset();

		tradingProfitCacheModel.others = getOthers();

		return tradingProfitCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", tradingProfitId=");
		sb.append(getTradingProfitId());
		sb.append(", periodId=");
		sb.append(getPeriodId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", year=");
		sb.append(getYear());
		sb.append(", npat=");
		sb.append(getNpat());
		sb.append(", netForex=");
		sb.append(getNetForex());
		sb.append(", ppeDispos=");
		sb.append(getPpeDispos());
		sb.append(", revalutionOnPropertyInvestment=");
		sb.append(getRevalutionOnPropertyInvestment());
		sb.append(", investment=");
		sb.append(getInvestment());
		sb.append(", taxExpense=");
		sb.append(getTaxExpense());
		sb.append(", impairmentOnAsset=");
		sb.append(getImpairmentOnAsset());
		sb.append(", others=");
		sb.append(getOthers());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.astra.anblicks.pdca.model.tradingProfit");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tradingProfitId</column-name><column-value><![CDATA[");
		sb.append(getTradingProfitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodId</column-name><column-value><![CDATA[");
		sb.append(getPeriodId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>npat</column-name><column-value><![CDATA[");
		sb.append(getNpat());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>netForex</column-name><column-value><![CDATA[");
		sb.append(getNetForex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ppeDispos</column-name><column-value><![CDATA[");
		sb.append(getPpeDispos());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>revalutionOnPropertyInvestment</column-name><column-value><![CDATA[");
		sb.append(getRevalutionOnPropertyInvestment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>investment</column-name><column-value><![CDATA[");
		sb.append(getInvestment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taxExpense</column-name><column-value><![CDATA[");
		sb.append(getTaxExpense());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>impairmentOnAsset</column-name><column-value><![CDATA[");
		sb.append(getImpairmentOnAsset());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>others</column-name><column-value><![CDATA[");
		sb.append(getOthers());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = tradingProfit.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			tradingProfit.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _tradingProfitId;
	private long _periodId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _year;
	private double _npat;
	private double _netForex;
	private double _ppeDispos;
	private double _revalutionOnPropertyInvestment;
	private double _investment;
	private double _taxExpense;
	private double _impairmentOnAsset;
	private double _others;
	private long _columnBitmask;
	private tradingProfit _escapedModel;
}