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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing tradingProfit in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see tradingProfit
 * @generated
 */
@ProviderType
public class tradingProfitCacheModel implements CacheModel<tradingProfit>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof tradingProfitCacheModel)) {
			return false;
		}

		tradingProfitCacheModel tradingProfitCacheModel = (tradingProfitCacheModel)obj;

		if (tradingProfitId == tradingProfitCacheModel.tradingProfitId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tradingProfitId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", tradingProfitId=");
		sb.append(tradingProfitId);
		sb.append(", periodId=");
		sb.append(periodId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", year=");
		sb.append(year);
		sb.append(", npat=");
		sb.append(npat);
		sb.append(", netForex=");
		sb.append(netForex);
		sb.append(", ppeDispos=");
		sb.append(ppeDispos);
		sb.append(", revalutionOnPropertyInvestment=");
		sb.append(revalutionOnPropertyInvestment);
		sb.append(", investment=");
		sb.append(investment);
		sb.append(", taxExpense=");
		sb.append(taxExpense);
		sb.append(", impairmentOnAsset=");
		sb.append(impairmentOnAsset);
		sb.append(", others=");
		sb.append(others);
		sb.append(", TotalSum=");
		sb.append(TotalSum);
		sb.append(", notes_Npat=");
		sb.append(notes_Npat);
		sb.append(", notes_NetForex=");
		sb.append(notes_NetForex);
		sb.append(", notes_ppeDispos=");
		sb.append(notes_ppeDispos);
		sb.append(", notes_RevalutiononPI=");
		sb.append(notes_RevalutiononPI);
		sb.append(", notes_Investment=");
		sb.append(notes_Investment);
		sb.append(", notes_taxExpenses=");
		sb.append(notes_taxExpenses);
		sb.append(", notes_impartmentOnAsset=");
		sb.append(notes_impartmentOnAsset);
		sb.append(", notes_others=");
		sb.append(notes_others);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public tradingProfit toEntityModel() {
		tradingProfitImpl tradingProfitImpl = new tradingProfitImpl();

		if (uuid == null) {
			tradingProfitImpl.setUuid(StringPool.BLANK);
		}
		else {
			tradingProfitImpl.setUuid(uuid);
		}

		tradingProfitImpl.setTradingProfitId(tradingProfitId);
		tradingProfitImpl.setPeriodId(periodId);
		tradingProfitImpl.setCompanyId(companyId);
		tradingProfitImpl.setYear(year);
		tradingProfitImpl.setNpat(npat);
		tradingProfitImpl.setNetForex(netForex);
		tradingProfitImpl.setPpeDispos(ppeDispos);
		tradingProfitImpl.setRevalutionOnPropertyInvestment(revalutionOnPropertyInvestment);
		tradingProfitImpl.setInvestment(investment);
		tradingProfitImpl.setTaxExpense(taxExpense);
		tradingProfitImpl.setImpairmentOnAsset(impairmentOnAsset);
		tradingProfitImpl.setOthers(others);
		tradingProfitImpl.setTotalSum(TotalSum);

		if (notes_Npat == null) {
			tradingProfitImpl.setNotes_Npat(StringPool.BLANK);
		}
		else {
			tradingProfitImpl.setNotes_Npat(notes_Npat);
		}

		if (notes_NetForex == null) {
			tradingProfitImpl.setNotes_NetForex(StringPool.BLANK);
		}
		else {
			tradingProfitImpl.setNotes_NetForex(notes_NetForex);
		}

		if (notes_ppeDispos == null) {
			tradingProfitImpl.setNotes_ppeDispos(StringPool.BLANK);
		}
		else {
			tradingProfitImpl.setNotes_ppeDispos(notes_ppeDispos);
		}

		if (notes_RevalutiononPI == null) {
			tradingProfitImpl.setNotes_RevalutiononPI(StringPool.BLANK);
		}
		else {
			tradingProfitImpl.setNotes_RevalutiononPI(notes_RevalutiononPI);
		}

		if (notes_Investment == null) {
			tradingProfitImpl.setNotes_Investment(StringPool.BLANK);
		}
		else {
			tradingProfitImpl.setNotes_Investment(notes_Investment);
		}

		if (notes_taxExpenses == null) {
			tradingProfitImpl.setNotes_taxExpenses(StringPool.BLANK);
		}
		else {
			tradingProfitImpl.setNotes_taxExpenses(notes_taxExpenses);
		}

		if (notes_impartmentOnAsset == null) {
			tradingProfitImpl.setNotes_impartmentOnAsset(StringPool.BLANK);
		}
		else {
			tradingProfitImpl.setNotes_impartmentOnAsset(notes_impartmentOnAsset);
		}

		if (notes_others == null) {
			tradingProfitImpl.setNotes_others(StringPool.BLANK);
		}
		else {
			tradingProfitImpl.setNotes_others(notes_others);
		}

		tradingProfitImpl.resetOriginalValues();

		return tradingProfitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		tradingProfitId = objectInput.readLong();

		periodId = objectInput.readLong();

		companyId = objectInput.readLong();

		year = objectInput.readLong();

		npat = objectInput.readDouble();

		netForex = objectInput.readDouble();

		ppeDispos = objectInput.readDouble();

		revalutionOnPropertyInvestment = objectInput.readDouble();

		investment = objectInput.readDouble();

		taxExpense = objectInput.readDouble();

		impairmentOnAsset = objectInput.readDouble();

		others = objectInput.readDouble();

		TotalSum = objectInput.readDouble();
		notes_Npat = objectInput.readUTF();
		notes_NetForex = objectInput.readUTF();
		notes_ppeDispos = objectInput.readUTF();
		notes_RevalutiononPI = objectInput.readUTF();
		notes_Investment = objectInput.readUTF();
		notes_taxExpenses = objectInput.readUTF();
		notes_impartmentOnAsset = objectInput.readUTF();
		notes_others = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(tradingProfitId);

		objectOutput.writeLong(periodId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(year);

		objectOutput.writeDouble(npat);

		objectOutput.writeDouble(netForex);

		objectOutput.writeDouble(ppeDispos);

		objectOutput.writeDouble(revalutionOnPropertyInvestment);

		objectOutput.writeDouble(investment);

		objectOutput.writeDouble(taxExpense);

		objectOutput.writeDouble(impairmentOnAsset);

		objectOutput.writeDouble(others);

		objectOutput.writeDouble(TotalSum);

		if (notes_Npat == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes_Npat);
		}

		if (notes_NetForex == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes_NetForex);
		}

		if (notes_ppeDispos == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes_ppeDispos);
		}

		if (notes_RevalutiononPI == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes_RevalutiononPI);
		}

		if (notes_Investment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes_Investment);
		}

		if (notes_taxExpenses == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes_taxExpenses);
		}

		if (notes_impartmentOnAsset == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes_impartmentOnAsset);
		}

		if (notes_others == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes_others);
		}
	}

	public String uuid;
	public long tradingProfitId;
	public long periodId;
	public long companyId;
	public long year;
	public double npat;
	public double netForex;
	public double ppeDispos;
	public double revalutionOnPropertyInvestment;
	public double investment;
	public double taxExpense;
	public double impairmentOnAsset;
	public double others;
	public double TotalSum;
	public String notes_Npat;
	public String notes_NetForex;
	public String notes_ppeDispos;
	public String notes_RevalutiononPI;
	public String notes_Investment;
	public String notes_taxExpenses;
	public String notes_impartmentOnAsset;
	public String notes_others;
}