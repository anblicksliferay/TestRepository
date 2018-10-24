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
 * Provides a wrapper for {@link ListMOMLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ListMOMLocalService
 * @generated
 */
@ProviderType
public class ListMOMLocalServiceWrapper implements ListMOMLocalService,
	ServiceWrapper<ListMOMLocalService> {
	public ListMOMLocalServiceWrapper(ListMOMLocalService listMOMLocalService) {
		_listMOMLocalService = listMOMLocalService;
	}

	/**
	* Adds the list mom to the database. Also notifies the appropriate model listeners.
	*
	* @param listMOM the list mom
	* @return the list mom that was added
	*/
	@Override
	public com.astra.anblicks.pdca.model.ListMOM addListMOM(
		com.astra.anblicks.pdca.model.ListMOM listMOM) {
		return _listMOMLocalService.addListMOM(listMOM);
	}

	/**
	* Creates a new list mom with the primary key. Does not add the list mom to the database.
	*
	* @param MomId the primary key for the new list mom
	* @return the new list mom
	*/
	@Override
	public com.astra.anblicks.pdca.model.ListMOM createListMOM(long MomId) {
		return _listMOMLocalService.createListMOM(MomId);
	}

	/**
	* Deletes the list mom from the database. Also notifies the appropriate model listeners.
	*
	* @param listMOM the list mom
	* @return the list mom that was removed
	*/
	@Override
	public com.astra.anblicks.pdca.model.ListMOM deleteListMOM(
		com.astra.anblicks.pdca.model.ListMOM listMOM) {
		return _listMOMLocalService.deleteListMOM(listMOM);
	}

	/**
	* Deletes the list mom with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param MomId the primary key of the list mom
	* @return the list mom that was removed
	* @throws PortalException if a list mom with the primary key could not be found
	*/
	@Override
	public com.astra.anblicks.pdca.model.ListMOM deleteListMOM(long MomId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _listMOMLocalService.deleteListMOM(MomId);
	}

	@Override
	public com.astra.anblicks.pdca.model.ListMOM fetchListMOM(long MomId) {
		return _listMOMLocalService.fetchListMOM(MomId);
	}

	/**
	* Returns the list mom with the primary key.
	*
	* @param MomId the primary key of the list mom
	* @return the list mom
	* @throws PortalException if a list mom with the primary key could not be found
	*/
	@Override
	public com.astra.anblicks.pdca.model.ListMOM getListMOM(long MomId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _listMOMLocalService.getListMOM(MomId);
	}

	/**
	* Updates the list mom in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param listMOM the list mom
	* @return the list mom that was updated
	*/
	@Override
	public com.astra.anblicks.pdca.model.ListMOM updateListMOM(
		com.astra.anblicks.pdca.model.ListMOM listMOM) {
		return _listMOMLocalService.updateListMOM(listMOM);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _listMOMLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _listMOMLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _listMOMLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _listMOMLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _listMOMLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of list moms.
	*
	* @return the number of list moms
	*/
	@Override
	public int getListMOMsCount() {
		return _listMOMLocalService.getListMOMsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _listMOMLocalService.getOSGiServiceIdentifier();
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
		return _listMOMLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.ListMOMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _listMOMLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.ListMOMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _listMOMLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the list moms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.ListMOMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of list moms
	* @param end the upper bound of the range of list moms (not inclusive)
	* @return the range of list moms
	*/
	@Override
	public java.util.List<com.astra.anblicks.pdca.model.ListMOM> getListMOMs(
		int start, int end) {
		return _listMOMLocalService.getListMOMs(start, end);
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
		return _listMOMLocalService.dynamicQueryCount(dynamicQuery);
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
		return _listMOMLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public ListMOMLocalService getWrappedService() {
		return _listMOMLocalService;
	}

	@Override
	public void setWrappedService(ListMOMLocalService listMOMLocalService) {
		_listMOMLocalService = listMOMLocalService;
	}

	private ListMOMLocalService _listMOMLocalService;
}