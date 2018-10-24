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

import com.astra.anblicks.pdca.model.MOMPointdiscussoin;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MOMPointdiscussoin in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see MOMPointdiscussoin
 * @generated
 */
@ProviderType
public class MOMPointdiscussoinCacheModel implements CacheModel<MOMPointdiscussoin>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MOMPointdiscussoinCacheModel)) {
			return false;
		}

		MOMPointdiscussoinCacheModel momPointdiscussoinCacheModel = (MOMPointdiscussoinCacheModel)obj;

		if (PdId == momPointdiscussoinCacheModel.PdId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PdId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{PdId=");
		sb.append(PdId);
		sb.append(", MOMpdId=");
		sb.append(MOMpdId);
		sb.append(", PonintDiscussionName=");
		sb.append(PonintDiscussionName);
		sb.append(", Notes=");
		sb.append(Notes);
		sb.append(", SiteId=");
		sb.append(SiteId);
		sb.append(", CreateDate=");
		sb.append(CreateDate);
		sb.append(", CreatedBy=");
		sb.append(CreatedBy);
		sb.append(", ModifiedDate=");
		sb.append(ModifiedDate);
		sb.append(", ModifiedBy=");
		sb.append(ModifiedBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MOMPointdiscussoin toEntityModel() {
		MOMPointdiscussoinImpl momPointdiscussoinImpl = new MOMPointdiscussoinImpl();

		momPointdiscussoinImpl.setPdId(PdId);
		momPointdiscussoinImpl.setMOMpdId(MOMpdId);

		if (PonintDiscussionName == null) {
			momPointdiscussoinImpl.setPonintDiscussionName(StringPool.BLANK);
		}
		else {
			momPointdiscussoinImpl.setPonintDiscussionName(PonintDiscussionName);
		}

		if (Notes == null) {
			momPointdiscussoinImpl.setNotes(StringPool.BLANK);
		}
		else {
			momPointdiscussoinImpl.setNotes(Notes);
		}

		momPointdiscussoinImpl.setSiteId(SiteId);

		if (CreateDate == Long.MIN_VALUE) {
			momPointdiscussoinImpl.setCreateDate(null);
		}
		else {
			momPointdiscussoinImpl.setCreateDate(new Date(CreateDate));
		}

		if (CreatedBy == null) {
			momPointdiscussoinImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			momPointdiscussoinImpl.setCreatedBy(CreatedBy);
		}

		if (ModifiedDate == Long.MIN_VALUE) {
			momPointdiscussoinImpl.setModifiedDate(null);
		}
		else {
			momPointdiscussoinImpl.setModifiedDate(new Date(ModifiedDate));
		}

		if (ModifiedBy == null) {
			momPointdiscussoinImpl.setModifiedBy(StringPool.BLANK);
		}
		else {
			momPointdiscussoinImpl.setModifiedBy(ModifiedBy);
		}

		momPointdiscussoinImpl.resetOriginalValues();

		return momPointdiscussoinImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PdId = objectInput.readLong();

		MOMpdId = objectInput.readLong();
		PonintDiscussionName = objectInput.readUTF();
		Notes = objectInput.readUTF();

		SiteId = objectInput.readLong();
		CreateDate = objectInput.readLong();
		CreatedBy = objectInput.readUTF();
		ModifiedDate = objectInput.readLong();
		ModifiedBy = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PdId);

		objectOutput.writeLong(MOMpdId);

		if (PonintDiscussionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(PonintDiscussionName);
		}

		if (Notes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Notes);
		}

		objectOutput.writeLong(SiteId);
		objectOutput.writeLong(CreateDate);

		if (CreatedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CreatedBy);
		}

		objectOutput.writeLong(ModifiedDate);

		if (ModifiedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ModifiedBy);
		}
	}

	public long PdId;
	public long MOMpdId;
	public String PonintDiscussionName;
	public String Notes;
	public long SiteId;
	public long CreateDate;
	public String CreatedBy;
	public long ModifiedDate;
	public String ModifiedBy;
}