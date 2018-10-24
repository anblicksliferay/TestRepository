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

package com.astra.anblicks.pdca.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ControlMOMLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ControlMOMLocalService
 * @generated
 */
@ProviderType
public class ControlMOMLocalServiceWrapper implements ControlMOMLocalService,
	ServiceWrapper<ControlMOMLocalService> {
	public ControlMOMLocalServiceWrapper(
		ControlMOMLocalService controlMOMLocalService) {
		_controlMOMLocalService = controlMOMLocalService;
	}

	/**
	* Adds the control mom to the database. Also notifies the appropriate model listeners.
	*
	* @param controlMOM the control mom
	* @return the control mom that was added
	*/
	@Override
	public com.astra.anblicks.pdca.model.ControlMOM addControlMOM(
		com.astra.anblicks.pdca.model.ControlMOM controlMOM) {
		return _controlMOMLocalService.addControlMOM(controlMOM);
	}

	/**
	* Creates a new control mom with the primary key. Does not add the control mom to the database.
	*
	* @param ControlMOMId the primary key for the new control mom
	* @return the new control mom
	*/
	@Override
	public com.astra.anblicks.pdca.model.ControlMOM createControlMOM(
		long ControlMOMId) {
		return _controlMOMLocalService.createControlMOM(ControlMOMId);
	}

	/**
	* Deletes the control mom from the database. Also notifies the appropriate model listeners.
	*
	* @param controlMOM the control mom
	* @return the control mom that was removed
	*/
	@Override
	public com.astra.anblicks.pdca.model.ControlMOM deleteControlMOM(
		com.astra.anblicks.pdca.model.ControlMOM controlMOM) {
		return _controlMOMLocalService.deleteControlMOM(controlMOM);
	}

	/**
	* Deletes the control mom with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ControlMOMId the primary key of the control mom
	* @return the control mom that was removed
	* @throws PortalException if a control mom with the primary key could not be found
	*/
	@Override
	public com.astra.anblicks.pdca.model.ControlMOM deleteControlMOM(
		long ControlMOMId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _controlMOMLocalService.deleteControlMOM(ControlMOMId);
	}

	@Override
	public com.astra.anblicks.pdca.model.ControlMOM fetchControlMOM(
		long ControlMOMId) {
		return _controlMOMLocalService.fetchControlMOM(ControlMOMId);
	}

	/**
	* Returns the control mom with the primary key.
	*
	* @param ControlMOMId the primary key of the control mom
	* @return the control mom
	* @throws PortalException if a control mom with the primary key could not be found
	*/
	@Override
	public com.astra.anblicks.pdca.model.ControlMOM getControlMOM(
		long ControlMOMId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _controlMOMLocalService.getControlMOM(ControlMOMId);
	}

	/**
	* Updates the control mom in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param controlMOM the control mom
	* @return the control mom that was updated
	*/
	@Override
	public com.astra.anblicks.pdca.model.ControlMOM updateControlMOM(
		com.astra.anblicks.pdca.model.ControlMOM controlMOM) {
		return _controlMOMLocalService.updateControlMOM(controlMOM);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _controlMOMLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _controlMOMLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _controlMOMLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _controlMOMLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _controlMOMLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of control moms.
	*
	* @return the number of control moms
	*/
	@Override
	public int getControlMOMsCount() {
		return _controlMOMLocalService.getControlMOMsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _controlMOMLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _controlMOMLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.ControlMOMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _controlMOMLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.ControlMOMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _controlMOMLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the control moms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.ControlMOMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of control moms
	* @param end the upper bound of the range of control moms (not inclusive)
	* @return the range of control moms
	*/
	@Override
	public java.util.List<com.astra.anblicks.pdca.model.ControlMOM> getControlMOMs(
		int start, int end) {
		return _controlMOMLocalService.getControlMOMs(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _controlMOMLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _controlMOMLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public ControlMOMLocalService getWrappedService() {
		return _controlMOMLocalService;
	}

	@Override
	public void setWrappedService(ControlMOMLocalService controlMOMLocalService) {
		_controlMOMLocalService = controlMOMLocalService;
	}

	private ControlMOMLocalService _controlMOMLocalService;
}