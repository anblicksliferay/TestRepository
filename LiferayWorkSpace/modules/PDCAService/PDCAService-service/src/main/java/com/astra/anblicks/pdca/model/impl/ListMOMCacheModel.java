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

import com.astra.anblicks.pdca.model.ListMOM;

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
 * The cache model class for representing ListMOM in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ListMOM
 * @generated
 */
@ProviderType
public class ListMOMCacheModel implements CacheModel<ListMOM>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ListMOMCacheModel)) {
			return false;
		}

		ListMOMCacheModel listMOMCacheModel = (ListMOMCacheModel)obj;

		if (MomId == listMOMCacheModel.MomId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, MomId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{MomId=");
		sb.append(MomId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", meetingDate=");
		sb.append(meetingDate);
		sb.append(", fromTime=");
		sb.append(fromTime);
		sb.append(", ampm=");
		sb.append(ampm);
		sb.append(", MomType=");
		sb.append(MomType);
		sb.append(", MomTypeId=");
		sb.append(MomTypeId);
		sb.append(", performance=");
		sb.append(performance);
		sb.append(", MOMGroup=");
		sb.append(MOMGroup);
		sb.append(", MOMparticipants=");
		sb.append(MOMparticipants);
		sb.append(", MOMcompanyName=");
		sb.append(MOMcompanyName);
		sb.append(", MOMplace=");
		sb.append(MOMplace);
		sb.append(", ponitDiscussionId=");
		sb.append(ponitDiscussionId);
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
	public ListMOM toEntityModel() {
		ListMOMImpl listMOMImpl = new ListMOMImpl();

		listMOMImpl.setMomId(MomId);
		listMOMImpl.setUserId(userId);
		listMOMImpl.setCompanyId(companyId);

		if (meetingDate == null) {
			listMOMImpl.setMeetingDate(StringPool.BLANK);
		}
		else {
			listMOMImpl.setMeetingDate(meetingDate);
		}

		if (fromTime == null) {
			listMOMImpl.setFromTime(StringPool.BLANK);
		}
		else {
			listMOMImpl.setFromTime(fromTime);
		}

		if (ampm == null) {
			listMOMImpl.setAmpm(StringPool.BLANK);
		}
		else {
			listMOMImpl.setAmpm(ampm);
		}

		if (MomType == null) {
			listMOMImpl.setMomType(StringPool.BLANK);
		}
		else {
			listMOMImpl.setMomType(MomType);
		}

		if (MomTypeId == null) {
			listMOMImpl.setMomTypeId(StringPool.BLANK);
		}
		else {
			listMOMImpl.setMomTypeId(MomTypeId);
		}

		if (performance == null) {
			listMOMImpl.setPerformance(StringPool.BLANK);
		}
		else {
			listMOMImpl.setPerformance(performance);
		}

		if (MOMGroup == null) {
			listMOMImpl.setMOMGroup(StringPool.BLANK);
		}
		else {
			listMOMImpl.setMOMGroup(MOMGroup);
		}

		if (MOMparticipants == null) {
			listMOMImpl.setMOMparticipants(StringPool.BLANK);
		}
		else {
			listMOMImpl.setMOMparticipants(MOMparticipants);
		}

		if (MOMcompanyName == null) {
			listMOMImpl.setMOMcompanyName(StringPool.BLANK);
		}
		else {
			listMOMImpl.setMOMcompanyName(MOMcompanyName);
		}

		if (MOMplace == null) {
			listMOMImpl.setMOMplace(StringPool.BLANK);
		}
		else {
			listMOMImpl.setMOMplace(MOMplace);
		}

		listMOMImpl.setPonitDiscussionId(ponitDiscussionId);
		listMOMImpl.setSiteId(SiteId);

		if (CreateDate == Long.MIN_VALUE) {
			listMOMImpl.setCreateDate(null);
		}
		else {
			listMOMImpl.setCreateDate(new Date(CreateDate));
		}

		if (CreatedBy == null) {
			listMOMImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			listMOMImpl.setCreatedBy(CreatedBy);
		}

		if (ModifiedDate == Long.MIN_VALUE) {
			listMOMImpl.setModifiedDate(null);
		}
		else {
			listMOMImpl.setModifiedDate(new Date(ModifiedDate));
		}

		if (ModifiedBy == null) {
			listMOMImpl.setModifiedBy(StringPool.BLANK);
		}
		else {
			listMOMImpl.setModifiedBy(ModifiedBy);
		}

		listMOMImpl.resetOriginalValues();

		return listMOMImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		MomId = objectInput.readLong();

		userId = objectInput.readLong();

		companyId = objectInput.readLong();
		meetingDate = objectInput.readUTF();
		fromTime = objectInput.readUTF();
		ampm = objectInput.readUTF();
		MomType = objectInput.readUTF();
		MomTypeId = objectInput.readUTF();
		performance = objectInput.readUTF();
		MOMGroup = objectInput.readUTF();
		MOMparticipants = objectInput.readUTF();
		MOMcompanyName = objectInput.readUTF();
		MOMplace = objectInput.readUTF();

		ponitDiscussionId = objectInput.readLong();

		SiteId = objectInput.readLong();
		CreateDate = objectInput.readLong();
		CreatedBy = objectInput.readUTF();
		ModifiedDate = objectInput.readLong();
		ModifiedBy = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(MomId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(companyId);

		if (meetingDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(meetingDate);
		}

		if (fromTime == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fromTime);
		}

		if (ampm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ampm);
		}

		if (MomType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(MomType);
		}

		if (MomTypeId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(MomTypeId);
		}

		if (performance == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(performance);
		}

		if (MOMGroup == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(MOMGroup);
		}

		if (MOMparticipants == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(MOMparticipants);
		}

		if (MOMcompanyName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(MOMcompanyName);
		}

		if (MOMplace == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(MOMplace);
		}

		objectOutput.writeLong(ponitDiscussionId);

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

	public long MomId;
	public long userId;
	public long companyId;
	public String meetingDate;
	public String fromTime;
	public String ampm;
	public String MomType;
	public String MomTypeId;
	public String performance;
	public String MOMGroup;
	public String MOMparticipants;
	public String MOMcompanyName;
	public String MOMplace;
	public long ponitDiscussionId;
	public long SiteId;
	public long CreateDate;
	public String CreatedBy;
	public long ModifiedDate;
	public String ModifiedBy;
}