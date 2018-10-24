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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link tradingProfit}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see tradingProfit
 * @generated
 */
@ProviderType
public class tradingProfitWrapper implements tradingProfit,
	ModelWrapper<tradingProfit> {
	public tradingProfitWrapper(tradingProfit tradingProfit) {
		_tradingProfit = tradingProfit;
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
		attributes.put("TotalSum", getTotalSum());
		attributes.put("notes_Npat", getNotes_Npat());
		attributes.put("notes_NetForex", getNotes_NetForex());
		attributes.put("notes_ppeDispos", getNotes_ppeDispos());
		attributes.put("notes_RevalutiononPI", getNotes_RevalutiononPI());
		attributes.put("notes_Investment", getNotes_Investment());
		attributes.put("notes_taxExpenses", getNotes_taxExpenses());
		attributes.put("notes_impartmentOnAsset", getNotes_impartmentOnAsset());
		attributes.put("notes_others", getNotes_others());

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

		Double TotalSum = (Double)attributes.get("TotalSum");

		if (TotalSum != null) {
			setTotalSum(TotalSum);
		}

		String notes_Npat = (String)attributes.get("notes_Npat");

		if (notes_Npat != null) {
			setNotes_Npat(notes_Npat);
		}

		String notes_NetForex = (String)attributes.get("notes_NetForex");

		if (notes_NetForex != null) {
			setNotes_NetForex(notes_NetForex);
		}

		String notes_ppeDispos = (String)attributes.get("notes_ppeDispos");

		if (notes_ppeDispos != null) {
			setNotes_ppeDispos(notes_ppeDispos);
		}

		String notes_RevalutiononPI = (String)attributes.get(
				"notes_RevalutiononPI");

		if (notes_RevalutiononPI != null) {
			setNotes_RevalutiononPI(notes_RevalutiononPI);
		}

		String notes_Investment = (String)attributes.get("notes_Investment");

		if (notes_Investment != null) {
			setNotes_Investment(notes_Investment);
		}

		String notes_taxExpenses = (String)attributes.get("notes_taxExpenses");

		if (notes_taxExpenses != null) {
			setNotes_taxExpenses(notes_taxExpenses);
		}

		String notes_impartmentOnAsset = (String)attributes.get(
				"notes_impartmentOnAsset");

		if (notes_impartmentOnAsset != null) {
			setNotes_impartmentOnAsset(notes_impartmentOnAsset);
		}

		String notes_others = (String)attributes.get("notes_others");

		if (notes_others != null) {
			setNotes_others(notes_others);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _tradingProfit.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _tradingProfit.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _tradingProfit.isNew();
	}

	@Override
	public com.astra.anblicks.pdca.model.tradingProfit toEscapedModel() {
		return new tradingProfitWrapper(_tradingProfit.toEscapedModel());
	}

	@Override
	public com.astra.anblicks.pdca.model.tradingProfit toUnescapedModel() {
		return new tradingProfitWrapper(_tradingProfit.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _tradingProfit.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.astra.anblicks.pdca.model.tradingProfit> toCacheModel() {
		return _tradingProfit.toCacheModel();
	}

	/**
	* Returns the impairment on asset of this trading profit.
	*
	* @return the impairment on asset of this trading profit
	*/
	@Override
	public double getImpairmentOnAsset() {
		return _tradingProfit.getImpairmentOnAsset();
	}

	/**
	* Returns the investment of this trading profit.
	*
	* @return the investment of this trading profit
	*/
	@Override
	public double getInvestment() {
		return _tradingProfit.getInvestment();
	}

	/**
	* Returns the net forex of this trading profit.
	*
	* @return the net forex of this trading profit
	*/
	@Override
	public double getNetForex() {
		return _tradingProfit.getNetForex();
	}

	/**
	* Returns the npat of this trading profit.
	*
	* @return the npat of this trading profit
	*/
	@Override
	public double getNpat() {
		return _tradingProfit.getNpat();
	}

	/**
	* Returns the others of this trading profit.
	*
	* @return the others of this trading profit
	*/
	@Override
	public double getOthers() {
		return _tradingProfit.getOthers();
	}

	/**
	* Returns the ppe dispos of this trading profit.
	*
	* @return the ppe dispos of this trading profit
	*/
	@Override
	public double getPpeDispos() {
		return _tradingProfit.getPpeDispos();
	}

	/**
	* Returns the revalution on property investment of this trading profit.
	*
	* @return the revalution on property investment of this trading profit
	*/
	@Override
	public double getRevalutionOnPropertyInvestment() {
		return _tradingProfit.getRevalutionOnPropertyInvestment();
	}

	/**
	* Returns the tax expense of this trading profit.
	*
	* @return the tax expense of this trading profit
	*/
	@Override
	public double getTaxExpense() {
		return _tradingProfit.getTaxExpense();
	}

	/**
	* Returns the total sum of this trading profit.
	*
	* @return the total sum of this trading profit
	*/
	@Override
	public double getTotalSum() {
		return _tradingProfit.getTotalSum();
	}

	@Override
	public int compareTo(
		com.astra.anblicks.pdca.model.tradingProfit tradingProfit) {
		return _tradingProfit.compareTo(tradingProfit);
	}

	@Override
	public int hashCode() {
		return _tradingProfit.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tradingProfit.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new tradingProfitWrapper((tradingProfit)_tradingProfit.clone());
	}

	/**
	* Returns the notes_ investment of this trading profit.
	*
	* @return the notes_ investment of this trading profit
	*/
	@Override
	public java.lang.String getNotes_Investment() {
		return _tradingProfit.getNotes_Investment();
	}

	/**
	* Returns the notes_ net forex of this trading profit.
	*
	* @return the notes_ net forex of this trading profit
	*/
	@Override
	public java.lang.String getNotes_NetForex() {
		return _tradingProfit.getNotes_NetForex();
	}

	/**
	* Returns the notes_ npat of this trading profit.
	*
	* @return the notes_ npat of this trading profit
	*/
	@Override
	public java.lang.String getNotes_Npat() {
		return _tradingProfit.getNotes_Npat();
	}

	/**
	* Returns the notes_ revalutionon pi of this trading profit.
	*
	* @return the notes_ revalutionon pi of this trading profit
	*/
	@Override
	public java.lang.String getNotes_RevalutiononPI() {
		return _tradingProfit.getNotes_RevalutiononPI();
	}

	/**
	* Returns the notes_impartment on asset of this trading profit.
	*
	* @return the notes_impartment on asset of this trading profit
	*/
	@Override
	public java.lang.String getNotes_impartmentOnAsset() {
		return _tradingProfit.getNotes_impartmentOnAsset();
	}

	/**
	* Returns the notes_others of this trading profit.
	*
	* @return the notes_others of this trading profit
	*/
	@Override
	public java.lang.String getNotes_others() {
		return _tradingProfit.getNotes_others();
	}

	/**
	* Returns the notes_ppe dispos of this trading profit.
	*
	* @return the notes_ppe dispos of this trading profit
	*/
	@Override
	public java.lang.String getNotes_ppeDispos() {
		return _tradingProfit.getNotes_ppeDispos();
	}

	/**
	* Returns the notes_tax expenses of this trading profit.
	*
	* @return the notes_tax expenses of this trading profit
	*/
	@Override
	public java.lang.String getNotes_taxExpenses() {
		return _tradingProfit.getNotes_taxExpenses();
	}

	/**
	* Returns the uuid of this trading profit.
	*
	* @return the uuid of this trading profit
	*/
	@Override
	public java.lang.String getUuid() {
		return _tradingProfit.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _tradingProfit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tradingProfit.toXmlString();
	}

	/**
	* Returns the company ID of this trading profit.
	*
	* @return the company ID of this trading profit
	*/
	@Override
	public long getCompanyId() {
		return _tradingProfit.getCompanyId();
	}

	/**
	* Returns the period ID of this trading profit.
	*
	* @return the period ID of this trading profit
	*/
	@Override
	public long getPeriodId() {
		return _tradingProfit.getPeriodId();
	}

	/**
	* Returns the primary key of this trading profit.
	*
	* @return the primary key of this trading profit
	*/
	@Override
	public long getPrimaryKey() {
		return _tradingProfit.getPrimaryKey();
	}

	/**
	* Returns the trading profit ID of this trading profit.
	*
	* @return the trading profit ID of this trading profit
	*/
	@Override
	public long getTradingProfitId() {
		return _tradingProfit.getTradingProfitId();
	}

	/**
	* Returns the year of this trading profit.
	*
	* @return the year of this trading profit
	*/
	@Override
	public long getYear() {
		return _tradingProfit.getYear();
	}

	@Override
	public void persist() {
		_tradingProfit.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tradingProfit.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this trading profit.
	*
	* @param companyId the company ID of this trading profit
	*/
	@Override
	public void setCompanyId(long companyId) {
		_tradingProfit.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_tradingProfit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_tradingProfit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_tradingProfit.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the impairment on asset of this trading profit.
	*
	* @param impairmentOnAsset the impairment on asset of this trading profit
	*/
	@Override
	public void setImpairmentOnAsset(double impairmentOnAsset) {
		_tradingProfit.setImpairmentOnAsset(impairmentOnAsset);
	}

	/**
	* Sets the investment of this trading profit.
	*
	* @param investment the investment of this trading profit
	*/
	@Override
	public void setInvestment(double investment) {
		_tradingProfit.setInvestment(investment);
	}

	/**
	* Sets the net forex of this trading profit.
	*
	* @param netForex the net forex of this trading profit
	*/
	@Override
	public void setNetForex(double netForex) {
		_tradingProfit.setNetForex(netForex);
	}

	@Override
	public void setNew(boolean n) {
		_tradingProfit.setNew(n);
	}

	/**
	* Sets the notes_ investment of this trading profit.
	*
	* @param notes_Investment the notes_ investment of this trading profit
	*/
	@Override
	public void setNotes_Investment(java.lang.String notes_Investment) {
		_tradingProfit.setNotes_Investment(notes_Investment);
	}

	/**
	* Sets the notes_ net forex of this trading profit.
	*
	* @param notes_NetForex the notes_ net forex of this trading profit
	*/
	@Override
	public void setNotes_NetForex(java.lang.String notes_NetForex) {
		_tradingProfit.setNotes_NetForex(notes_NetForex);
	}

	/**
	* Sets the notes_ npat of this trading profit.
	*
	* @param notes_Npat the notes_ npat of this trading profit
	*/
	@Override
	public void setNotes_Npat(java.lang.String notes_Npat) {
		_tradingProfit.setNotes_Npat(notes_Npat);
	}

	/**
	* Sets the notes_ revalutionon pi of this trading profit.
	*
	* @param notes_RevalutiononPI the notes_ revalutionon pi of this trading profit
	*/
	@Override
	public void setNotes_RevalutiononPI(java.lang.String notes_RevalutiononPI) {
		_tradingProfit.setNotes_RevalutiononPI(notes_RevalutiononPI);
	}

	/**
	* Sets the notes_impartment on asset of this trading profit.
	*
	* @param notes_impartmentOnAsset the notes_impartment on asset of this trading profit
	*/
	@Override
	public void setNotes_impartmentOnAsset(
		java.lang.String notes_impartmentOnAsset) {
		_tradingProfit.setNotes_impartmentOnAsset(notes_impartmentOnAsset);
	}

	/**
	* Sets the notes_others of this trading profit.
	*
	* @param notes_others the notes_others of this trading profit
	*/
	@Override
	public void setNotes_others(java.lang.String notes_others) {
		_tradingProfit.setNotes_others(notes_others);
	}

	/**
	* Sets the notes_ppe dispos of this trading profit.
	*
	* @param notes_ppeDispos the notes_ppe dispos of this trading profit
	*/
	@Override
	public void setNotes_ppeDispos(java.lang.String notes_ppeDispos) {
		_tradingProfit.setNotes_ppeDispos(notes_ppeDispos);
	}

	/**
	* Sets the notes_tax expenses of this trading profit.
	*
	* @param notes_taxExpenses the notes_tax expenses of this trading profit
	*/
	@Override
	public void setNotes_taxExpenses(java.lang.String notes_taxExpenses) {
		_tradingProfit.setNotes_taxExpenses(notes_taxExpenses);
	}

	/**
	* Sets the npat of this trading profit.
	*
	* @param npat the npat of this trading profit
	*/
	@Override
	public void setNpat(double npat) {
		_tradingProfit.setNpat(npat);
	}

	/**
	* Sets the others of this trading profit.
	*
	* @param others the others of this trading profit
	*/
	@Override
	public void setOthers(double others) {
		_tradingProfit.setOthers(others);
	}

	/**
	* Sets the period ID of this trading profit.
	*
	* @param periodId the period ID of this trading profit
	*/
	@Override
	public void setPeriodId(long periodId) {
		_tradingProfit.setPeriodId(periodId);
	}

	/**
	* Sets the ppe dispos of this trading profit.
	*
	* @param ppeDispos the ppe dispos of this trading profit
	*/
	@Override
	public void setPpeDispos(double ppeDispos) {
		_tradingProfit.setPpeDispos(ppeDispos);
	}

	/**
	* Sets the primary key of this trading profit.
	*
	* @param primaryKey the primary key of this trading profit
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tradingProfit.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_tradingProfit.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the revalution on property investment of this trading profit.
	*
	* @param revalutionOnPropertyInvestment the revalution on property investment of this trading profit
	*/
	@Override
	public void setRevalutionOnPropertyInvestment(
		double revalutionOnPropertyInvestment) {
		_tradingProfit.setRevalutionOnPropertyInvestment(revalutionOnPropertyInvestment);
	}

	/**
	* Sets the tax expense of this trading profit.
	*
	* @param taxExpense the tax expense of this trading profit
	*/
	@Override
	public void setTaxExpense(double taxExpense) {
		_tradingProfit.setTaxExpense(taxExpense);
	}

	/**
	* Sets the total sum of this trading profit.
	*
	* @param TotalSum the total sum of this trading profit
	*/
	@Override
	public void setTotalSum(double TotalSum) {
		_tradingProfit.setTotalSum(TotalSum);
	}

	/**
	* Sets the trading profit ID of this trading profit.
	*
	* @param tradingProfitId the trading profit ID of this trading profit
	*/
	@Override
	public void setTradingProfitId(long tradingProfitId) {
		_tradingProfit.setTradingProfitId(tradingProfitId);
	}

	/**
	* Sets the uuid of this trading profit.
	*
	* @param uuid the uuid of this trading profit
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_tradingProfit.setUuid(uuid);
	}

	/**
	* Sets the year of this trading profit.
	*
	* @param year the year of this trading profit
	*/
	@Override
	public void setYear(long year) {
		_tradingProfit.setYear(year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof tradingProfitWrapper)) {
			return false;
		}

		tradingProfitWrapper tradingProfitWrapper = (tradingProfitWrapper)obj;

		if (Objects.equals(_tradingProfit, tradingProfitWrapper._tradingProfit)) {
			return true;
		}

		return false;
	}

	@Override
	public tradingProfit getWrappedModel() {
		return _tradingProfit;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _tradingProfit.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _tradingProfit.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_tradingProfit.resetOriginalValues();
	}

	private final tradingProfit _tradingProfit;
}