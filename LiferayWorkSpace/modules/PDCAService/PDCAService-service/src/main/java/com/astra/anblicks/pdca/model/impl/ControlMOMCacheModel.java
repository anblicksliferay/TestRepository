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
 * The cache model class for representing ControlMOM in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ControlMOM
 * @generated
 */
@ProviderType
public class ControlMOMCacheModel implements CacheModel<ControlMOM>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ControlMOMCacheModel)) {
			return false;
		}

		ControlMOMCacheModel controlMOMCacheModel = (ControlMOMCacheModel)obj;

		if (ControlMOMId == controlMOMCacheModel.ControlMOMId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ControlMOMId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{ControlMOMId=");
		sb.append(ControlMOMId);
		sb.append(", ListMOMId=");
		sb.append(ListMOMId);
		sb.append(", pdId=");
		sb.append(pdId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", Status=");
		sb.append(Status);
		sb.append(", FollowUp=");
		sb.append(FollowUp);
		sb.append(", FollowUpData=");
		sb.append(FollowUpData);
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
	public ControlMOM toEntityModel() {
		ControlMOMImpl controlMOMImpl = new ControlMOMImpl();

		controlMOMImpl.setControlMOMId(ControlMOMId);
		controlMOMImpl.setListMOMId(ListMOMId);
		controlMOMImpl.setPdId(pdId);
		controlMOMImpl.setUserId(userId);

		if (Status == null) {
			controlMOMImpl.setStatus(StringPool.BLANK);
		}
		else {
			controlMOMImpl.setStatus(Status);
		}

		if (FollowUp == null) {
			controlMOMImpl.setFollowUp(StringPool.BLANK);
		}
		else {
			controlMOMImpl.setFollowUp(FollowUp);
		}

		if (FollowUpData == null) {
			controlMOMImpl.setFollowUpData(StringPool.BLANK);
		}
		else {
			controlMOMImpl.setFollowUpData(FollowUpData);
		}

		controlMOMImpl.setSiteId(SiteId);

		if (CreateDate == Long.MIN_VALUE) {
			controlMOMImpl.setCreateDate(null);
		}
		else {
			controlMOMImpl.setCreateDate(new Date(CreateDate));
		}

		if (CreatedBy == null) {
			controlMOMImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			controlMOMImpl.setCreatedBy(CreatedBy);
		}

		if (ModifiedDate == Long.MIN_VALUE) {
			controlMOMImpl.setModifiedDate(null);
		}
		else {
			controlMOMImpl.setModifiedDate(new Date(ModifiedDate));
		}

		if (ModifiedBy == null) {
			controlMOMImpl.setModifiedBy(StringPool.BLANK);
		}
		else {
			controlMOMImpl.setModifiedBy(ModifiedBy);
		}

		controlMOMImpl.resetOriginalValues();

		return controlMOMImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ControlMOMId = objectInput.readLong();

		ListMOMId = objectInput.readLong();

		pdId = objectInput.readLong();

		userId = objectInput.readLong();
		Status = objectInput.readUTF();
		FollowUp = objectInput.readUTF();
		FollowUpData = objectInput.readUTF();

		SiteId = objectInput.readLong();
		CreateDate = objectInput.readLong();
		CreatedBy = objectInput.readUTF();
		ModifiedDate = objectInput.readLong();
		ModifiedBy = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ControlMOMId);

		objectOutput.writeLong(ListMOMId);

		objectOutput.writeLong(pdId);

		objectOutput.writeLong(userId);

		if (Status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Status);
		}

		if (FollowUp == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(FollowUp);
		}

		if (FollowUpData == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(FollowUpData);
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

	public long ControlMOMId;
	public long ListMOMId;
	public long pdId;
	public long userId;
	public String Status;
	public String FollowUp;
	public String FollowUpData;
	public long SiteId;
	public long CreateDate;
	public String CreatedBy;
	public long ModifiedDate;
	public String ModifiedBy;
}