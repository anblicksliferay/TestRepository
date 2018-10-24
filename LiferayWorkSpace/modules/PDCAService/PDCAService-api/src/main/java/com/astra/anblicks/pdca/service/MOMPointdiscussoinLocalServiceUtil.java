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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for MOMPointdiscussoin. This utility wraps
 * {@link com.astra.anblicks.pdca.service.impl.MOMPointdiscussoinLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MOMPointdiscussoinLocalService
 * @see com.astra.anblicks.pdca.service.base.MOMPointdiscussoinLocalServiceBaseImpl
 * @see com.astra.anblicks.pdca.service.impl.MOMPointdiscussoinLocalServiceImpl
 * @generated
 */
@ProviderType
public class MOMPointdiscussoinLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.astra.anblicks.pdca.service.impl.MOMPointdiscussoinLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the mom pointdiscussoin to the database. Also notifies the appropriate model listeners.
	*
	* @param momPointdiscussoin the mom pointdiscussoin
	* @return the mom pointdiscussoin that was added
	*/
	public static com.astra.anblicks.pdca.model.MOMPointdiscussoin addMOMPointdiscussoin(
		com.astra.anblicks.pdca.model.MOMPointdiscussoin momPointdiscussoin) {
		return getService().addMOMPointdiscussoin(momPointdiscussoin);
	}

	/**
	* Creates a new mom pointdiscussoin with the primary key. Does not add the mom pointdiscussoin to the database.
	*
	* @param PdId the primary key for the new mom pointdiscussoin
	* @return the new mom pointdiscussoin
	*/
	public static com.astra.anblicks.pdca.model.MOMPointdiscussoin createMOMPointdiscussoin(
		long PdId) {
		return getService().createMOMPointdiscussoin(PdId);
	}

	/**
	* Deletes the mom pointdiscussoin from the database. Also notifies the appropriate model listeners.
	*
	* @param momPointdiscussoin the mom pointdiscussoin
	* @return the mom pointdiscussoin that was removed
	*/
	public static com.astra.anblicks.pdca.model.MOMPointdiscussoin deleteMOMPointdiscussoin(
		com.astra.anblicks.pdca.model.MOMPointdiscussoin momPointdiscussoin) {
		return getService().deleteMOMPointdiscussoin(momPointdiscussoin);
	}

	/**
	* Deletes the mom pointdiscussoin with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PdId the primary key of the mom pointdiscussoin
	* @return the mom pointdiscussoin that was removed
	* @throws PortalException if a mom pointdiscussoin with the primary key could not be found
	*/
	public static com.astra.anblicks.pdca.model.MOMPointdiscussoin deleteMOMPointdiscussoin(
		long PdId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteMOMPointdiscussoin(PdId);
	}

	public static com.astra.anblicks.pdca.model.MOMPointdiscussoin fetchMOMPointdiscussoin(
		long PdId) {
		return getService().fetchMOMPointdiscussoin(PdId);
	}

	/**
	* Returns the mom pointdiscussoin with the primary key.
	*
	* @param PdId the primary key of the mom pointdiscussoin
	* @return the mom pointdiscussoin
	* @throws PortalException if a mom pointdiscussoin with the primary key could not be found
	*/
	public static com.astra.anblicks.pdca.model.MOMPointdiscussoin getMOMPointdiscussoin(
		long PdId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getMOMPointdiscussoin(PdId);
	}

	/**
	* Updates the mom pointdiscussoin in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param momPointdiscussoin the mom pointdiscussoin
	* @return the mom pointdiscussoin that was updated
	*/
	public static com.astra.anblicks.pdca.model.MOMPointdiscussoin updateMOMPointdiscussoin(
		com.astra.anblicks.pdca.model.MOMPointdiscussoin momPointdiscussoin) {
		return getService().updateMOMPointdiscussoin(momPointdiscussoin);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of mom pointdiscussoins.
	*
	* @return the number of mom pointdiscussoins
	*/
	public static int getMOMPointdiscussoinsCount() {
		return getService().getMOMPointdiscussoinsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
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
	public static java.util.List<com.astra.anblicks.pdca.model.MOMPointdiscussoin> getMOMPointdiscussoins(
		int start, int end) {
		return getService().getMOMPointdiscussoins(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static MOMPointdiscussoinLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MOMPointdiscussoinLocalService, MOMPointdiscussoinLocalService> _serviceTracker =
		ServiceTrackerFactory.open(MOMPointdiscussoinLocalService.class);
}