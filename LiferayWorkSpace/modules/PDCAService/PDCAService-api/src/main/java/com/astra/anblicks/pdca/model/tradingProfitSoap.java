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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.astra.anblicks.pdca.service.http.tradingProfitServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.http.tradingProfitServiceSoap
 * @generated
 */
@ProviderType
public class tradingProfitSoap implements Serializable {
	public static tradingProfitSoap toSoapModel(tradingProfit model) {
		tradingProfitSoap soapModel = new tradingProfitSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTradingProfitId(model.getTradingProfitId());
		soapModel.setPeriodId(model.getPeriodId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setYear(model.getYear());
		soapModel.setNpat(model.getNpat());
		soapModel.setNetForex(model.getNetForex());
		soapModel.setPpeDispos(model.getPpeDispos());
		soapModel.setRevalutionOnPropertyInvestment(model.getRevalutionOnPropertyInvestment());
		soapModel.setInvestment(model.getInvestment());
		soapModel.setTaxExpense(model.getTaxExpense());
		soapModel.setImpairmentOnAsset(model.getImpairmentOnAsset());
		soapModel.setOthers(model.getOthers());
		soapModel.setTotalSum(model.getTotalSum());
		soapModel.setNotes_Npat(model.getNotes_Npat());
		soapModel.setNotes_NetForex(model.getNotes_NetForex());
		soapModel.setNotes_ppeDispos(model.getNotes_ppeDispos());
		soapModel.setNotes_RevalutiononPI(model.getNotes_RevalutiononPI());
		soapModel.setNotes_Investment(model.getNotes_Investment());
		soapModel.setNotes_taxExpenses(model.getNotes_taxExpenses());
		soapModel.setNotes_impartmentOnAsset(model.getNotes_impartmentOnAsset());
		soapModel.setNotes_others(model.getNotes_others());

		return soapModel;
	}

	public static tradingProfitSoap[] toSoapModels(tradingProfit[] models) {
		tradingProfitSoap[] soapModels = new tradingProfitSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static tradingProfitSoap[][] toSoapModels(tradingProfit[][] models) {
		tradingProfitSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new tradingProfitSoap[models.length][models[0].length];
		}
		else {
			soapModels = new tradingProfitSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static tradingProfitSoap[] toSoapModels(List<tradingProfit> models) {
		List<tradingProfitSoap> soapModels = new ArrayList<tradingProfitSoap>(models.size());

		for (tradingProfit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new tradingProfitSoap[soapModels.size()]);
	}

	public tradingProfitSoap() {
	}

	public long getPrimaryKey() {
		return _tradingProfitId;
	}

	public void setPrimaryKey(long pk) {
		setTradingProfitId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTradingProfitId() {
		return _tradingProfitId;
	}

	public void setTradingProfitId(long tradingProfitId) {
		_tradingProfitId = tradingProfitId;
	}

	public long getPeriodId() {
		return _periodId;
	}

	public void setPeriodId(long periodId) {
		_periodId = periodId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getYear() {
		return _year;
	}

	public void setYear(long year) {
		_year = year;
	}

	public double getNpat() {
		return _npat;
	}

	public void setNpat(double npat) {
		_npat = npat;
	}

	public double getNetForex() {
		return _netForex;
	}

	public void setNetForex(double netForex) {
		_netForex = netForex;
	}

	public double getPpeDispos() {
		return _ppeDispos;
	}

	public void setPpeDispos(double ppeDispos) {
		_ppeDispos = ppeDispos;
	}

	public double getRevalutionOnPropertyInvestment() {
		return _revalutionOnPropertyInvestment;
	}

	public void setRevalutionOnPropertyInvestment(
		double revalutionOnPropertyInvestment) {
		_revalutionOnPropertyInvestment = revalutionOnPropertyInvestment;
	}

	public double getInvestment() {
		return _investment;
	}

	public void setInvestment(double investment) {
		_investment = investment;
	}

	public double getTaxExpense() {
		return _taxExpense;
	}

	public void setTaxExpense(double taxExpense) {
		_taxExpense = taxExpense;
	}

	public double getImpairmentOnAsset() {
		return _impairmentOnAsset;
	}

	public void setImpairmentOnAsset(double impairmentOnAsset) {
		_impairmentOnAsset = impairmentOnAsset;
	}

	public double getOthers() {
		return _others;
	}

	public void setOthers(double others) {
		_others = others;
	}

	public double getTotalSum() {
		return _TotalSum;
	}

	public void setTotalSum(double TotalSum) {
		_TotalSum = TotalSum;
	}

	public String getNotes_Npat() {
		return _notes_Npat;
	}

	public void setNotes_Npat(String notes_Npat) {
		_notes_Npat = notes_Npat;
	}

	public String getNotes_NetForex() {
		return _notes_NetForex;
	}

	public void setNotes_NetForex(String notes_NetForex) {
		_notes_NetForex = notes_NetForex;
	}

	public String getNotes_ppeDispos() {
		return _notes_ppeDispos;
	}

	public void setNotes_ppeDispos(String notes_ppeDispos) {
		_notes_ppeDispos = notes_ppeDispos;
	}

	public String getNotes_RevalutiononPI() {
		return _notes_RevalutiononPI;
	}

	public void setNotes_RevalutiononPI(String notes_RevalutiononPI) {
		_notes_RevalutiononPI = notes_RevalutiononPI;
	}

	public String getNotes_Investment() {
		return _notes_Investment;
	}

	public void setNotes_Investment(String notes_Investment) {
		_notes_Investment = notes_Investment;
	}

	public String getNotes_taxExpenses() {
		return _notes_taxExpenses;
	}

	public void setNotes_taxExpenses(String notes_taxExpenses) {
		_notes_taxExpenses = notes_taxExpenses;
	}

	public String getNotes_impartmentOnAsset() {
		return _notes_impartmentOnAsset;
	}

	public void setNotes_impartmentOnAsset(String notes_impartmentOnAsset) {
		_notes_impartmentOnAsset = notes_impartmentOnAsset;
	}

	public String getNotes_others() {
		return _notes_others;
	}

	public void setNotes_others(String notes_others) {
		_notes_others = notes_others;
	}

	private String _uuid;
	private long _tradingProfitId;
	private long _periodId;
	private long _companyId;
	private long _year;
	private double _npat;
	private double _netForex;
	private double _ppeDispos;
	private double _revalutionOnPropertyInvestment;
	private double _investment;
	private double _taxExpense;
	private double _impairmentOnAsset;
	private double _others;
	private double _TotalSum;
	private String _notes_Npat;
	private String _notes_NetForex;
	private String _notes_ppeDispos;
	private String _notes_RevalutiononPI;
	private String _notes_Investment;
	private String _notes_taxExpenses;
	private String _notes_impartmentOnAsset;
	private String _notes_others;
}