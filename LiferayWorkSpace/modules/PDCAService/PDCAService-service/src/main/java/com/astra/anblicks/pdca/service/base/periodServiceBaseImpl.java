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

package com.astra.anblicks.pdca.service.base;

import com.astra.anblicks.pdca.model.period;
import com.astra.anblicks.pdca.service.periodService;
import com.astra.anblicks.pdca.service.persistence.AstraPdca_CompanyDataPersistence;
import com.astra.anblicks.pdca.service.persistence.AstraPdca_ModulePersistence;
import com.astra.anblicks.pdca.service.persistence.AstraPdca_YearPersistence;
import com.astra.anblicks.pdca.service.persistence.ControlMOMPersistence;
import com.astra.anblicks.pdca.service.persistence.ListMOMPersistence;
import com.astra.anblicks.pdca.service.persistence.MOMPointdiscussoinPersistence;
import com.astra.anblicks.pdca.service.persistence.achivementFormulaPersistence;
import com.astra.anblicks.pdca.service.persistence.cla_kpiPersistence;
import com.astra.anblicks.pdca.service.persistence.company_userPersistence;
import com.astra.anblicks.pdca.service.persistence.itemDescriptionPersistence;
import com.astra.anblicks.pdca.service.persistence.kpiPersistence;
import com.astra.anblicks.pdca.service.persistence.pdca_AdminSettingsPersistence;
import com.astra.anblicks.pdca.service.persistence.periodPersistence;
import com.astra.anblicks.pdca.service.persistence.tradingProfitPersistence;
import com.astra.anblicks.pdca.service.persistence.typePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the period remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.astra.anblicks.pdca.service.impl.periodServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.impl.periodServiceImpl
 * @see com.astra.anblicks.pdca.service.periodServiceUtil
 * @generated
 */
public abstract class periodServiceBaseImpl extends BaseServiceImpl
	implements periodService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.astra.anblicks.pdca.service.periodServiceUtil} to access the period remote service.
	 */

	/**
	 * Returns the achivement formula local service.
	 *
	 * @return the achivement formula local service
	 */
	public com.astra.anblicks.pdca.service.achivementFormulaLocalService getachivementFormulaLocalService() {
		return achivementFormulaLocalService;
	}

	/**
	 * Sets the achivement formula local service.
	 *
	 * @param achivementFormulaLocalService the achivement formula local service
	 */
	public void setachivementFormulaLocalService(
		com.astra.anblicks.pdca.service.achivementFormulaLocalService achivementFormulaLocalService) {
		this.achivementFormulaLocalService = achivementFormulaLocalService;
	}

	/**
	 * Returns the achivement formula remote service.
	 *
	 * @return the achivement formula remote service
	 */
	public com.astra.anblicks.pdca.service.achivementFormulaService getachivementFormulaService() {
		return achivementFormulaService;
	}

	/**
	 * Sets the achivement formula remote service.
	 *
	 * @param achivementFormulaService the achivement formula remote service
	 */
	public void setachivementFormulaService(
		com.astra.anblicks.pdca.service.achivementFormulaService achivementFormulaService) {
		this.achivementFormulaService = achivementFormulaService;
	}

	/**
	 * Returns the achivement formula persistence.
	 *
	 * @return the achivement formula persistence
	 */
	public achivementFormulaPersistence getachivementFormulaPersistence() {
		return achivementFormulaPersistence;
	}

	/**
	 * Sets the achivement formula persistence.
	 *
	 * @param achivementFormulaPersistence the achivement formula persistence
	 */
	public void setachivementFormulaPersistence(
		achivementFormulaPersistence achivementFormulaPersistence) {
		this.achivementFormulaPersistence = achivementFormulaPersistence;
	}

	/**
	 * Returns the astra pdca_ company data local service.
	 *
	 * @return the astra pdca_ company data local service
	 */
	public com.astra.anblicks.pdca.service.AstraPdca_CompanyDataLocalService getAstraPdca_CompanyDataLocalService() {
		return astraPdca_CompanyDataLocalService;
	}

	/**
	 * Sets the astra pdca_ company data local service.
	 *
	 * @param astraPdca_CompanyDataLocalService the astra pdca_ company data local service
	 */
	public void setAstraPdca_CompanyDataLocalService(
		com.astra.anblicks.pdca.service.AstraPdca_CompanyDataLocalService astraPdca_CompanyDataLocalService) {
		this.astraPdca_CompanyDataLocalService = astraPdca_CompanyDataLocalService;
	}

	/**
	 * Returns the astra pdca_ company data remote service.
	 *
	 * @return the astra pdca_ company data remote service
	 */
	public com.astra.anblicks.pdca.service.AstraPdca_CompanyDataService getAstraPdca_CompanyDataService() {
		return astraPdca_CompanyDataService;
	}

	/**
	 * Sets the astra pdca_ company data remote service.
	 *
	 * @param astraPdca_CompanyDataService the astra pdca_ company data remote service
	 */
	public void setAstraPdca_CompanyDataService(
		com.astra.anblicks.pdca.service.AstraPdca_CompanyDataService astraPdca_CompanyDataService) {
		this.astraPdca_CompanyDataService = astraPdca_CompanyDataService;
	}

	/**
	 * Returns the astra pdca_ company data persistence.
	 *
	 * @return the astra pdca_ company data persistence
	 */
	public AstraPdca_CompanyDataPersistence getAstraPdca_CompanyDataPersistence() {
		return astraPdca_CompanyDataPersistence;
	}

	/**
	 * Sets the astra pdca_ company data persistence.
	 *
	 * @param astraPdca_CompanyDataPersistence the astra pdca_ company data persistence
	 */
	public void setAstraPdca_CompanyDataPersistence(
		AstraPdca_CompanyDataPersistence astraPdca_CompanyDataPersistence) {
		this.astraPdca_CompanyDataPersistence = astraPdca_CompanyDataPersistence;
	}

	/**
	 * Returns the astra pdca_ module local service.
	 *
	 * @return the astra pdca_ module local service
	 */
	public com.astra.anblicks.pdca.service.AstraPdca_ModuleLocalService getAstraPdca_ModuleLocalService() {
		return astraPdca_ModuleLocalService;
	}

	/**
	 * Sets the astra pdca_ module local service.
	 *
	 * @param astraPdca_ModuleLocalService the astra pdca_ module local service
	 */
	public void setAstraPdca_ModuleLocalService(
		com.astra.anblicks.pdca.service.AstraPdca_ModuleLocalService astraPdca_ModuleLocalService) {
		this.astraPdca_ModuleLocalService = astraPdca_ModuleLocalService;
	}

	/**
	 * Returns the astra pdca_ module remote service.
	 *
	 * @return the astra pdca_ module remote service
	 */
	public com.astra.anblicks.pdca.service.AstraPdca_ModuleService getAstraPdca_ModuleService() {
		return astraPdca_ModuleService;
	}

	/**
	 * Sets the astra pdca_ module remote service.
	 *
	 * @param astraPdca_ModuleService the astra pdca_ module remote service
	 */
	public void setAstraPdca_ModuleService(
		com.astra.anblicks.pdca.service.AstraPdca_ModuleService astraPdca_ModuleService) {
		this.astraPdca_ModuleService = astraPdca_ModuleService;
	}

	/**
	 * Returns the astra pdca_ module persistence.
	 *
	 * @return the astra pdca_ module persistence
	 */
	public AstraPdca_ModulePersistence getAstraPdca_ModulePersistence() {
		return astraPdca_ModulePersistence;
	}

	/**
	 * Sets the astra pdca_ module persistence.
	 *
	 * @param astraPdca_ModulePersistence the astra pdca_ module persistence
	 */
	public void setAstraPdca_ModulePersistence(
		AstraPdca_ModulePersistence astraPdca_ModulePersistence) {
		this.astraPdca_ModulePersistence = astraPdca_ModulePersistence;
	}

	/**
	 * Returns the astra pdca_ year local service.
	 *
	 * @return the astra pdca_ year local service
	 */
	public com.astra.anblicks.pdca.service.AstraPdca_YearLocalService getAstraPdca_YearLocalService() {
		return astraPdca_YearLocalService;
	}

	/**
	 * Sets the astra pdca_ year local service.
	 *
	 * @param astraPdca_YearLocalService the astra pdca_ year local service
	 */
	public void setAstraPdca_YearLocalService(
		com.astra.anblicks.pdca.service.AstraPdca_YearLocalService astraPdca_YearLocalService) {
		this.astraPdca_YearLocalService = astraPdca_YearLocalService;
	}

	/**
	 * Returns the astra pdca_ year remote service.
	 *
	 * @return the astra pdca_ year remote service
	 */
	public com.astra.anblicks.pdca.service.AstraPdca_YearService getAstraPdca_YearService() {
		return astraPdca_YearService;
	}

	/**
	 * Sets the astra pdca_ year remote service.
	 *
	 * @param astraPdca_YearService the astra pdca_ year remote service
	 */
	public void setAstraPdca_YearService(
		com.astra.anblicks.pdca.service.AstraPdca_YearService astraPdca_YearService) {
		this.astraPdca_YearService = astraPdca_YearService;
	}

	/**
	 * Returns the astra pdca_ year persistence.
	 *
	 * @return the astra pdca_ year persistence
	 */
	public AstraPdca_YearPersistence getAstraPdca_YearPersistence() {
		return astraPdca_YearPersistence;
	}

	/**
	 * Sets the astra pdca_ year persistence.
	 *
	 * @param astraPdca_YearPersistence the astra pdca_ year persistence
	 */
	public void setAstraPdca_YearPersistence(
		AstraPdca_YearPersistence astraPdca_YearPersistence) {
		this.astraPdca_YearPersistence = astraPdca_YearPersistence;
	}

	/**
	 * Returns the cla_kpi local service.
	 *
	 * @return the cla_kpi local service
	 */
	public com.astra.anblicks.pdca.service.cla_kpiLocalService getcla_kpiLocalService() {
		return cla_kpiLocalService;
	}

	/**
	 * Sets the cla_kpi local service.
	 *
	 * @param cla_kpiLocalService the cla_kpi local service
	 */
	public void setcla_kpiLocalService(
		com.astra.anblicks.pdca.service.cla_kpiLocalService cla_kpiLocalService) {
		this.cla_kpiLocalService = cla_kpiLocalService;
	}

	/**
	 * Returns the cla_kpi remote service.
	 *
	 * @return the cla_kpi remote service
	 */
	public com.astra.anblicks.pdca.service.cla_kpiService getcla_kpiService() {
		return cla_kpiService;
	}

	/**
	 * Sets the cla_kpi remote service.
	 *
	 * @param cla_kpiService the cla_kpi remote service
	 */
	public void setcla_kpiService(
		com.astra.anblicks.pdca.service.cla_kpiService cla_kpiService) {
		this.cla_kpiService = cla_kpiService;
	}

	/**
	 * Returns the cla_kpi persistence.
	 *
	 * @return the cla_kpi persistence
	 */
	public cla_kpiPersistence getcla_kpiPersistence() {
		return cla_kpiPersistence;
	}

	/**
	 * Sets the cla_kpi persistence.
	 *
	 * @param cla_kpiPersistence the cla_kpi persistence
	 */
	public void setcla_kpiPersistence(cla_kpiPersistence cla_kpiPersistence) {
		this.cla_kpiPersistence = cla_kpiPersistence;
	}

	/**
	 * Returns the company_user local service.
	 *
	 * @return the company_user local service
	 */
	public com.astra.anblicks.pdca.service.company_userLocalService getcompany_userLocalService() {
		return company_userLocalService;
	}

	/**
	 * Sets the company_user local service.
	 *
	 * @param company_userLocalService the company_user local service
	 */
	public void setcompany_userLocalService(
		com.astra.anblicks.pdca.service.company_userLocalService company_userLocalService) {
		this.company_userLocalService = company_userLocalService;
	}

	/**
	 * Returns the company_user remote service.
	 *
	 * @return the company_user remote service
	 */
	public com.astra.anblicks.pdca.service.company_userService getcompany_userService() {
		return company_userService;
	}

	/**
	 * Sets the company_user remote service.
	 *
	 * @param company_userService the company_user remote service
	 */
	public void setcompany_userService(
		com.astra.anblicks.pdca.service.company_userService company_userService) {
		this.company_userService = company_userService;
	}

	/**
	 * Returns the company_user persistence.
	 *
	 * @return the company_user persistence
	 */
	public company_userPersistence getcompany_userPersistence() {
		return company_userPersistence;
	}

	/**
	 * Sets the company_user persistence.
	 *
	 * @param company_userPersistence the company_user persistence
	 */
	public void setcompany_userPersistence(
		company_userPersistence company_userPersistence) {
		this.company_userPersistence = company_userPersistence;
	}

	/**
	 * Returns the control mom local service.
	 *
	 * @return the control mom local service
	 */
	public com.astra.anblicks.pdca.service.ControlMOMLocalService getControlMOMLocalService() {
		return controlMOMLocalService;
	}

	/**
	 * Sets the control mom local service.
	 *
	 * @param controlMOMLocalService the control mom local service
	 */
	public void setControlMOMLocalService(
		com.astra.anblicks.pdca.service.ControlMOMLocalService controlMOMLocalService) {
		this.controlMOMLocalService = controlMOMLocalService;
	}

	/**
	 * Returns the control mom remote service.
	 *
	 * @return the control mom remote service
	 */
	public com.astra.anblicks.pdca.service.ControlMOMService getControlMOMService() {
		return controlMOMService;
	}

	/**
	 * Sets the control mom remote service.
	 *
	 * @param controlMOMService the control mom remote service
	 */
	public void setControlMOMService(
		com.astra.anblicks.pdca.service.ControlMOMService controlMOMService) {
		this.controlMOMService = controlMOMService;
	}

	/**
	 * Returns the control mom persistence.
	 *
	 * @return the control mom persistence
	 */
	public ControlMOMPersistence getControlMOMPersistence() {
		return controlMOMPersistence;
	}

	/**
	 * Sets the control mom persistence.
	 *
	 * @param controlMOMPersistence the control mom persistence
	 */
	public void setControlMOMPersistence(
		ControlMOMPersistence controlMOMPersistence) {
		this.controlMOMPersistence = controlMOMPersistence;
	}

	/**
	 * Returns the item description local service.
	 *
	 * @return the item description local service
	 */
	public com.astra.anblicks.pdca.service.itemDescriptionLocalService getitemDescriptionLocalService() {
		return itemDescriptionLocalService;
	}

	/**
	 * Sets the item description local service.
	 *
	 * @param itemDescriptionLocalService the item description local service
	 */
	public void setitemDescriptionLocalService(
		com.astra.anblicks.pdca.service.itemDescriptionLocalService itemDescriptionLocalService) {
		this.itemDescriptionLocalService = itemDescriptionLocalService;
	}

	/**
	 * Returns the item description remote service.
	 *
	 * @return the item description remote service
	 */
	public com.astra.anblicks.pdca.service.itemDescriptionService getitemDescriptionService() {
		return itemDescriptionService;
	}

	/**
	 * Sets the item description remote service.
	 *
	 * @param itemDescriptionService the item description remote service
	 */
	public void setitemDescriptionService(
		com.astra.anblicks.pdca.service.itemDescriptionService itemDescriptionService) {
		this.itemDescriptionService = itemDescriptionService;
	}

	/**
	 * Returns the item description persistence.
	 *
	 * @return the item description persistence
	 */
	public itemDescriptionPersistence getitemDescriptionPersistence() {
		return itemDescriptionPersistence;
	}

	/**
	 * Sets the item description persistence.
	 *
	 * @param itemDescriptionPersistence the item description persistence
	 */
	public void setitemDescriptionPersistence(
		itemDescriptionPersistence itemDescriptionPersistence) {
		this.itemDescriptionPersistence = itemDescriptionPersistence;
	}

	/**
	 * Returns the kpi local service.
	 *
	 * @return the kpi local service
	 */
	public com.astra.anblicks.pdca.service.kpiLocalService getkpiLocalService() {
		return kpiLocalService;
	}

	/**
	 * Sets the kpi local service.
	 *
	 * @param kpiLocalService the kpi local service
	 */
	public void setkpiLocalService(
		com.astra.anblicks.pdca.service.kpiLocalService kpiLocalService) {
		this.kpiLocalService = kpiLocalService;
	}

	/**
	 * Returns the kpi remote service.
	 *
	 * @return the kpi remote service
	 */
	public com.astra.anblicks.pdca.service.kpiService getkpiService() {
		return kpiService;
	}

	/**
	 * Sets the kpi remote service.
	 *
	 * @param kpiService the kpi remote service
	 */
	public void setkpiService(
		com.astra.anblicks.pdca.service.kpiService kpiService) {
		this.kpiService = kpiService;
	}

	/**
	 * Returns the kpi persistence.
	 *
	 * @return the kpi persistence
	 */
	public kpiPersistence getkpiPersistence() {
		return kpiPersistence;
	}

	/**
	 * Sets the kpi persistence.
	 *
	 * @param kpiPersistence the kpi persistence
	 */
	public void setkpiPersistence(kpiPersistence kpiPersistence) {
		this.kpiPersistence = kpiPersistence;
	}

	/**
	 * Returns the list mom local service.
	 *
	 * @return the list mom local service
	 */
	public com.astra.anblicks.pdca.service.ListMOMLocalService getListMOMLocalService() {
		return listMOMLocalService;
	}

	/**
	 * Sets the list mom local service.
	 *
	 * @param listMOMLocalService the list mom local service
	 */
	public void setListMOMLocalService(
		com.astra.anblicks.pdca.service.ListMOMLocalService listMOMLocalService) {
		this.listMOMLocalService = listMOMLocalService;
	}

	/**
	 * Returns the list mom remote service.
	 *
	 * @return the list mom remote service
	 */
	public com.astra.anblicks.pdca.service.ListMOMService getListMOMService() {
		return listMOMService;
	}

	/**
	 * Sets the list mom remote service.
	 *
	 * @param listMOMService the list mom remote service
	 */
	public void setListMOMService(
		com.astra.anblicks.pdca.service.ListMOMService listMOMService) {
		this.listMOMService = listMOMService;
	}

	/**
	 * Returns the list mom persistence.
	 *
	 * @return the list mom persistence
	 */
	public ListMOMPersistence getListMOMPersistence() {
		return listMOMPersistence;
	}

	/**
	 * Sets the list mom persistence.
	 *
	 * @param listMOMPersistence the list mom persistence
	 */
	public void setListMOMPersistence(ListMOMPersistence listMOMPersistence) {
		this.listMOMPersistence = listMOMPersistence;
	}

	/**
	 * Returns the mom pointdiscussoin local service.
	 *
	 * @return the mom pointdiscussoin local service
	 */
	public com.astra.anblicks.pdca.service.MOMPointdiscussoinLocalService getMOMPointdiscussoinLocalService() {
		return momPointdiscussoinLocalService;
	}

	/**
	 * Sets the mom pointdiscussoin local service.
	 *
	 * @param momPointdiscussoinLocalService the mom pointdiscussoin local service
	 */
	public void setMOMPointdiscussoinLocalService(
		com.astra.anblicks.pdca.service.MOMPointdiscussoinLocalService momPointdiscussoinLocalService) {
		this.momPointdiscussoinLocalService = momPointdiscussoinLocalService;
	}

	/**
	 * Returns the mom pointdiscussoin remote service.
	 *
	 * @return the mom pointdiscussoin remote service
	 */
	public com.astra.anblicks.pdca.service.MOMPointdiscussoinService getMOMPointdiscussoinService() {
		return momPointdiscussoinService;
	}

	/**
	 * Sets the mom pointdiscussoin remote service.
	 *
	 * @param momPointdiscussoinService the mom pointdiscussoin remote service
	 */
	public void setMOMPointdiscussoinService(
		com.astra.anblicks.pdca.service.MOMPointdiscussoinService momPointdiscussoinService) {
		this.momPointdiscussoinService = momPointdiscussoinService;
	}

	/**
	 * Returns the mom pointdiscussoin persistence.
	 *
	 * @return the mom pointdiscussoin persistence
	 */
	public MOMPointdiscussoinPersistence getMOMPointdiscussoinPersistence() {
		return momPointdiscussoinPersistence;
	}

	/**
	 * Sets the mom pointdiscussoin persistence.
	 *
	 * @param momPointdiscussoinPersistence the mom pointdiscussoin persistence
	 */
	public void setMOMPointdiscussoinPersistence(
		MOMPointdiscussoinPersistence momPointdiscussoinPersistence) {
		this.momPointdiscussoinPersistence = momPointdiscussoinPersistence;
	}

	/**
	 * Returns the pdca_ admin settings local service.
	 *
	 * @return the pdca_ admin settings local service
	 */
	public com.astra.anblicks.pdca.service.pdca_AdminSettingsLocalService getpdca_AdminSettingsLocalService() {
		return pdca_AdminSettingsLocalService;
	}

	/**
	 * Sets the pdca_ admin settings local service.
	 *
	 * @param pdca_AdminSettingsLocalService the pdca_ admin settings local service
	 */
	public void setpdca_AdminSettingsLocalService(
		com.astra.anblicks.pdca.service.pdca_AdminSettingsLocalService pdca_AdminSettingsLocalService) {
		this.pdca_AdminSettingsLocalService = pdca_AdminSettingsLocalService;
	}

	/**
	 * Returns the pdca_ admin settings remote service.
	 *
	 * @return the pdca_ admin settings remote service
	 */
	public com.astra.anblicks.pdca.service.pdca_AdminSettingsService getpdca_AdminSettingsService() {
		return pdca_AdminSettingsService;
	}

	/**
	 * Sets the pdca_ admin settings remote service.
	 *
	 * @param pdca_AdminSettingsService the pdca_ admin settings remote service
	 */
	public void setpdca_AdminSettingsService(
		com.astra.anblicks.pdca.service.pdca_AdminSettingsService pdca_AdminSettingsService) {
		this.pdca_AdminSettingsService = pdca_AdminSettingsService;
	}

	/**
	 * Returns the pdca_ admin settings persistence.
	 *
	 * @return the pdca_ admin settings persistence
	 */
	public pdca_AdminSettingsPersistence getpdca_AdminSettingsPersistence() {
		return pdca_AdminSettingsPersistence;
	}

	/**
	 * Sets the pdca_ admin settings persistence.
	 *
	 * @param pdca_AdminSettingsPersistence the pdca_ admin settings persistence
	 */
	public void setpdca_AdminSettingsPersistence(
		pdca_AdminSettingsPersistence pdca_AdminSettingsPersistence) {
		this.pdca_AdminSettingsPersistence = pdca_AdminSettingsPersistence;
	}

	/**
	 * Returns the period local service.
	 *
	 * @return the period local service
	 */
	public com.astra.anblicks.pdca.service.periodLocalService getperiodLocalService() {
		return periodLocalService;
	}

	/**
	 * Sets the period local service.
	 *
	 * @param periodLocalService the period local service
	 */
	public void setperiodLocalService(
		com.astra.anblicks.pdca.service.periodLocalService periodLocalService) {
		this.periodLocalService = periodLocalService;
	}

	/**
	 * Returns the period remote service.
	 *
	 * @return the period remote service
	 */
	public periodService getperiodService() {
		return periodService;
	}

	/**
	 * Sets the period remote service.
	 *
	 * @param periodService the period remote service
	 */
	public void setperiodService(periodService periodService) {
		this.periodService = periodService;
	}

	/**
	 * Returns the period persistence.
	 *
	 * @return the period persistence
	 */
	public periodPersistence getperiodPersistence() {
		return periodPersistence;
	}

	/**
	 * Sets the period persistence.
	 *
	 * @param periodPersistence the period persistence
	 */
	public void setperiodPersistence(periodPersistence periodPersistence) {
		this.periodPersistence = periodPersistence;
	}

	/**
	 * Returns the trading profit local service.
	 *
	 * @return the trading profit local service
	 */
	public com.astra.anblicks.pdca.service.tradingProfitLocalService gettradingProfitLocalService() {
		return tradingProfitLocalService;
	}

	/**
	 * Sets the trading profit local service.
	 *
	 * @param tradingProfitLocalService the trading profit local service
	 */
	public void settradingProfitLocalService(
		com.astra.anblicks.pdca.service.tradingProfitLocalService tradingProfitLocalService) {
		this.tradingProfitLocalService = tradingProfitLocalService;
	}

	/**
	 * Returns the trading profit remote service.
	 *
	 * @return the trading profit remote service
	 */
	public com.astra.anblicks.pdca.service.tradingProfitService gettradingProfitService() {
		return tradingProfitService;
	}

	/**
	 * Sets the trading profit remote service.
	 *
	 * @param tradingProfitService the trading profit remote service
	 */
	public void settradingProfitService(
		com.astra.anblicks.pdca.service.tradingProfitService tradingProfitService) {
		this.tradingProfitService = tradingProfitService;
	}

	/**
	 * Returns the trading profit persistence.
	 *
	 * @return the trading profit persistence
	 */
	public tradingProfitPersistence gettradingProfitPersistence() {
		return tradingProfitPersistence;
	}

	/**
	 * Sets the trading profit persistence.
	 *
	 * @param tradingProfitPersistence the trading profit persistence
	 */
	public void settradingProfitPersistence(
		tradingProfitPersistence tradingProfitPersistence) {
		this.tradingProfitPersistence = tradingProfitPersistence;
	}

	/**
	 * Returns the type local service.
	 *
	 * @return the type local service
	 */
	public com.astra.anblicks.pdca.service.typeLocalService gettypeLocalService() {
		return typeLocalService;
	}

	/**
	 * Sets the type local service.
	 *
	 * @param typeLocalService the type local service
	 */
	public void settypeLocalService(
		com.astra.anblicks.pdca.service.typeLocalService typeLocalService) {
		this.typeLocalService = typeLocalService;
	}

	/**
	 * Returns the type remote service.
	 *
	 * @return the type remote service
	 */
	public com.astra.anblicks.pdca.service.typeService gettypeService() {
		return typeService;
	}

	/**
	 * Sets the type remote service.
	 *
	 * @param typeService the type remote service
	 */
	public void settypeService(
		com.astra.anblicks.pdca.service.typeService typeService) {
		this.typeService = typeService;
	}

	/**
	 * Returns the type persistence.
	 *
	 * @return the type persistence
	 */
	public typePersistence gettypePersistence() {
		return typePersistence;
	}

	/**
	 * Sets the type persistence.
	 *
	 * @param typePersistence the type persistence
	 */
	public void settypePersistence(typePersistence typePersistence) {
		this.typePersistence = typePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return periodService.class.getName();
	}

	protected Class<?> getModelClass() {
		return period.class;
	}

	protected String getModelClassName() {
		return period.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = periodPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.astra.anblicks.pdca.service.achivementFormulaLocalService.class)
	protected com.astra.anblicks.pdca.service.achivementFormulaLocalService achivementFormulaLocalService;
	@BeanReference(type = com.astra.anblicks.pdca.service.achivementFormulaService.class)
	protected com.astra.anblicks.pdca.service.achivementFormulaService achivementFormulaService;
	@BeanReference(type = achivementFormulaPersistence.class)
	protected achivementFormulaPersistence achivementFormulaPersistence;
	@BeanReference(type = com.astra.anblicks.pdca.service.AstraPdca_CompanyDataLocalService.class)
	protected com.astra.anblicks.pdca.service.AstraPdca_CompanyDataLocalService astraPdca_CompanyDataLocalService;
	@BeanReference(type = com.astra.anblicks.pdca.service.AstraPdca_CompanyDataService.class)
	protected com.astra.anblicks.pdca.service.AstraPdca_CompanyDataService astraPdca_CompanyDataService;
	@BeanReference(type = AstraPdca_CompanyDataPersistence.class)
	protected AstraPdca_CompanyDataPersistence astraPdca_CompanyDataPersistence;
	@BeanReference(type = com.astra.anblicks.pdca.service.AstraPdca_ModuleLocalService.class)
	protected com.astra.anblicks.pdca.service.AstraPdca_ModuleLocalService astraPdca_ModuleLocalService;
	@BeanReference(type = com.astra.anblicks.pdca.service.AstraPdca_ModuleService.class)
	protected com.astra.anblicks.pdca.service.AstraPdca_ModuleService astraPdca_ModuleService;
	@BeanReference(type = AstraPdca_ModulePersistence.class)
	protected AstraPdca_ModulePersistence astraPdca_ModulePersistence;
	@BeanReference(type = com.astra.anblicks.pdca.service.AstraPdca_YearLocalService.class)
	protected com.astra.anblicks.pdca.service.AstraPdca_YearLocalService astraPdca_YearLocalService;
	@BeanReference(type = com.astra.anblicks.pdca.service.AstraPdca_YearService.class)
	protected com.astra.anblicks.pdca.service.AstraPdca_YearService astraPdca_YearService;
	@BeanReference(type = AstraPdca_YearPersistence.class)
	protected AstraPdca_YearPersistence astraPdca_YearPersistence;
	@BeanReference(type = com.astra.anblicks.pdca.service.cla_kpiLocalService.class)
	protected com.astra.anblicks.pdca.service.cla_kpiLocalService cla_kpiLocalService;
	@BeanReference(type = com.astra.anblicks.pdca.service.cla_kpiService.class)
	protected com.astra.anblicks.pdca.service.cla_kpiService cla_kpiService;
	@BeanReference(type = cla_kpiPersistence.class)
	protected cla_kpiPersistence cla_kpiPersistence;
	@BeanReference(type = com.astra.anblicks.pdca.service.company_userLocalService.class)
	protected com.astra.anblicks.pdca.service.company_userLocalService company_userLocalService;
	@BeanReference(type = com.astra.anblicks.pdca.service.company_userService.class)
	protected com.astra.anblicks.pdca.service.company_userService company_userService;
	@BeanReference(type = company_userPersistence.class)
	protected company_userPersistence company_userPersistence;
	@BeanReference(type = com.astra.anblicks.pdca.service.ControlMOMLocalService.class)
	protected com.astra.anblicks.pdca.service.ControlMOMLocalService controlMOMLocalService;
	@BeanReference(type = com.astra.anblicks.pdca.service.ControlMOMService.class)
	protected com.astra.anblicks.pdca.service.ControlMOMService controlMOMService;
	@BeanReference(type = ControlMOMPersistence.class)
	protected ControlMOMPersistence controlMOMPersistence;
	@BeanReference(type = com.astra.anblicks.pdca.service.itemDescriptionLocalService.class)
	protected com.astra.anblicks.pdca.service.itemDescriptionLocalService itemDescriptionLocalService;
	@BeanReference(type = com.astra.anblicks.pdca.service.itemDescriptionService.class)
	protected com.astra.anblicks.pdca.service.itemDescriptionService itemDescriptionService;
	@BeanReference(type = itemDescriptionPersistence.class)
	protected itemDescriptionPersistence itemDescriptionPersistence;
	@BeanReference(type = com.astra.anblicks.pdca.service.kpiLocalService.class)
	protected com.astra.anblicks.pdca.service.kpiLocalService kpiLocalService;
	@BeanReference(type = com.astra.anblicks.pdca.service.kpiService.class)
	protected com.astra.anblicks.pdca.service.kpiService kpiService;
	@BeanReference(type = kpiPersistence.class)
	protected kpiPersistence kpiPersistence;
	@BeanReference(type = com.astra.anblicks.pdca.service.ListMOMLocalService.class)
	protected com.astra.anblicks.pdca.service.ListMOMLocalService listMOMLocalService;
	@BeanReference(type = com.astra.anblicks.pdca.service.ListMOMService.class)
	protected com.astra.anblicks.pdca.service.ListMOMService listMOMService;
	@BeanReference(type = ListMOMPersistence.class)
	protected ListMOMPersistence listMOMPersistence;
	@BeanReference(type = com.astra.anblicks.pdca.service.MOMPointdiscussoinLocalService.class)
	protected com.astra.anblicks.pdca.service.MOMPointdiscussoinLocalService momPointdiscussoinLocalService;
	@BeanReference(type = com.astra.anblicks.pdca.service.MOMPointdiscussoinService.class)
	protected com.astra.anblicks.pdca.service.MOMPointdiscussoinService momPointdiscussoinService;
	@BeanReference(type = MOMPointdiscussoinPersistence.class)
	protected MOMPointdiscussoinPersistence momPointdiscussoinPersistence;
	@BeanReference(type = com.astra.anblicks.pdca.service.pdca_AdminSettingsLocalService.class)
	protected com.astra.anblicks.pdca.service.pdca_AdminSettingsLocalService pdca_AdminSettingsLocalService;
	@BeanReference(type = com.astra.anblicks.pdca.service.pdca_AdminSettingsService.class)
	protected com.astra.anblicks.pdca.service.pdca_AdminSettingsService pdca_AdminSettingsService;
	@BeanReference(type = pdca_AdminSettingsPersistence.class)
	protected pdca_AdminSettingsPersistence pdca_AdminSettingsPersistence;
	@BeanReference(type = com.astra.anblicks.pdca.service.periodLocalService.class)
	protected com.astra.anblicks.pdca.service.periodLocalService periodLocalService;
	@BeanReference(type = periodService.class)
	protected periodService periodService;
	@BeanReference(type = periodPersistence.class)
	protected periodPersistence periodPersistence;
	@BeanReference(type = com.astra.anblicks.pdca.service.tradingProfitLocalService.class)
	protected com.astra.anblicks.pdca.service.tradingProfitLocalService tradingProfitLocalService;
	@BeanReference(type = com.astra.anblicks.pdca.service.tradingProfitService.class)
	protected com.astra.anblicks.pdca.service.tradingProfitService tradingProfitService;
	@BeanReference(type = tradingProfitPersistence.class)
	protected tradingProfitPersistence tradingProfitPersistence;
	@BeanReference(type = com.astra.anblicks.pdca.service.typeLocalService.class)
	protected com.astra.anblicks.pdca.service.typeLocalService typeLocalService;
	@BeanReference(type = com.astra.anblicks.pdca.service.typeService.class)
	protected com.astra.anblicks.pdca.service.typeService typeService;
	@BeanReference(type = typePersistence.class)
	protected typePersistence typePersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}