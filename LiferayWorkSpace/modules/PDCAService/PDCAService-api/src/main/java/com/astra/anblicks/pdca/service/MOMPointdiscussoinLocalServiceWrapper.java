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
 * Provides a wrapper for {@link MOMPointdiscussoinLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MOMPointdiscussoinLocalService
 * @generated
 */
@ProviderType
public class MOMPointdiscussoinLocalServiceWrapper
	implements MOMPointdiscussoinLocalService,
		ServiceWrapper<MOMPointdiscussoinLocalService> {
	public MOMPointdiscussoinLocalServiceWrapper(
		MOMPointdiscussoinLocalService momPointdiscussoinLocalService) {
		_momPointdiscussoinLocalService = momPointdiscussoinLocalService;
	}

	/**
	* Adds the mom pointdiscussoin to the database. Also notifies the appropriate model listeners.
	*
	* @param momPointdiscussoin the mom pointdiscussoin
	* @return the mom pointdiscussoin that was added
	*/
	@Override
	public com.astra.anblicks.pdca.model.MOMPointdiscussoin addMOMPointdiscussoin(
		com.astra.anblicks.pdca.model.MOMPointdiscussoin momPointdiscussoin) {
		return _momPointdiscussoinLocalService.addMOMPointdiscussoin(momPointdiscussoin);
	}

	/**
	* Creates a new mom pointdiscussoin with the primary key. Does not add the mom pointdiscussoin to the database.
	*
	* @param PdId the primary key for the new mom pointdiscussoin
	* @return the new mom pointdiscussoin
	*/
	@Override
	public com.astra.anblicks.pdca.model.MOMPointdiscussoin createMOMPointdiscussoin(
		long PdId) {
		return _momPointdiscussoinLocalService.createMOMPointdiscussoin(PdId);
	}

	/**
	* Deletes the mom pointdiscussoin from the database. Also notifies the appropriate model listeners.
	*
	* @param momPointdiscussoin the mom pointdiscussoin
	* @return the mom pointdiscussoin that was removed
	*/
	@Override
	public com.astra.anblicks.pdca.model.MOMPointdiscussoin deleteMOMPointdiscussoin(
		com.astra.anblicks.pdca.model.MOMPointdiscussoin momPointdiscussoin) {
		return _momPointdiscussoinLocalService.deleteMOMPointdiscussoin(momPointdiscussoin);
	}

	/**
	* Deletes the mom pointdiscussoin with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PdId the primary key of the mom pointdiscussoin
	* @return the mom pointdiscussoin that was removed
	* @throws PortalException if a mom pointdiscussoin with the primary key could not be found
	*/
	@Override
	public com.astra.anblicks.pdca.model.MOMPointdiscussoin deleteMOMPointdiscussoin(
		long PdId) throws com.liferay.portal.kernel.exception.PortalException {
		return _momPointdiscussoinLocalService.deleteMOMPointdiscussoin(PdId);
	}

	@Override
	public com.astra.anblicks.pdca.model.MOMPointdiscussoin fetchMOMPointdiscussoin(
		long PdId) {
		return _momPointdiscussoinLocalService.fetchMOMPointdiscussoin(PdId);
	}

	/**
	* Returns the mom pointdiscussoin with the primary key.
	*
	* @param PdId the primary key of the mom pointdiscussoin
	* @return the mom pointdiscussoin
	* @throws PortalException if a mom pointdiscussoin with the primary key could not be found
	*/
	@Override
	public com.astra.anblicks.pdca.model.MOMPointdiscussoin getMOMPointdiscussoin(
		long PdId) throws com.liferay.portal.kernel.exception.PortalException {
		return _momPointdiscussoinLocalService.getMOMPointdiscussoin(PdId);
	}

	/**
	* Updates the mom pointdiscussoin in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param momPointdiscussoin the mom pointdiscussoin
	* @return the mom pointdiscussoin that was updated
	*/
	@Override
	public com.astra.anblicks.pdca.model.MOMPointdiscussoin updateMOMPointdiscussoin(
		com.astra.anblicks.pdca.model.MOMPointdiscussoin momPointdiscussoin) {
		return _momPointdiscussoinLocalService.updateMOMPointdiscussoin(momPointdiscussoin);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _momPointdiscussoinLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _momPointdiscussoinLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _momPointdiscussoinLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _momPointdiscussoinLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _momPointdiscussoinLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of mom pointdiscussoins.
	*
	* @return the number of mom pointdiscussoins
	*/
	@Override
	public int getMOMPointdiscussoinsCount() {
		return _momPointdiscussoinLocalService.getMOMPointdiscussoinsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _momPointdiscussoinLocalService.getOSGiServiceIdentifier();
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
		return _momPointdiscussoinLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.MOMPointdiscussoinModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _momPointdiscussoinLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.MOMPointdiscussoinModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _momPointdiscussoinLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the mom pointdiscussoins.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.MOMPointdiscussoinModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of mom pointdiscussoins
	* @param end the upper bound of the range of mom pointdiscussoins (not inclusive)
	* @return the range of mom pointdiscussoins
	*/
	@Override
	public java.util.List<com.astra.anblicks.pdca.model.MOMPointdiscussoin> getMOMPointdiscussoins(
		int start, int end) {
		return _momPointdiscussoinLocalService.getMOMPointdiscussoins(start, end);
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
		return _momPointdiscussoinLocalService.dynamicQueryCount(dynamicQuery);
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
		return _momPointdiscussoinLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public MOMPointdiscussoinLocalService getWrappedService() {
		return _momPointdiscussoinLocalService;
	}

	@Override
	public void setWrappedService(
		MOMPointdiscussoinLocalService momPointdiscussoinLocalService) {
		_momPointdiscussoinLocalService = momPointdiscussoinLocalService;
	}

	private MOMPointdiscussoinLocalService _momPointdiscussoinLocalService;
}