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

package com.astra.anblicks.pdca.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.astra.anblicks.pdca.model.ControlMOM;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the control mom service. This utility wraps {@link com.astra.anblicks.pdca.service.persistence.impl.ControlMOMPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ControlMOMPersistence
 * @see com.astra.anblicks.pdca.service.persistence.impl.ControlMOMPersistenceImpl
 * @generated
 */
@ProviderType
public class ControlMOMUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ControlMOM controlMOM) {
		getPersistence().clearCache(controlMOM);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ControlMOM> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ControlMOM> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ControlMOM> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ControlMOM> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ControlMOM update(ControlMOM controlMOM) {
		return getPersistence().update(controlMOM);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ControlMOM update(ControlMOM controlMOM,
		ServiceContext serviceContext) {
		return getPersistence().update(controlMOM, serviceContext);
	}

	/**
	* Caches the control mom in the entity cache if it is enabled.
	*
	* @param controlMOM the control mom
	*/
	public static void cacheResult(ControlMOM controlMOM) {
		getPersistence().cacheResult(controlMOM);
	}

	/**
	* Caches the control moms in the entity cache if it is enabled.
	*
	* @param controlMOMs the control moms
	*/
	public static void cacheResult(List<ControlMOM> controlMOMs) {
		getPersistence().cacheResult(controlMOMs);
	}

	/**
	* Creates a new control mom with the primary key. Does not add the control mom to the database.
	*
	* @param ControlMOMId the primary key for the new control mom
	* @return the new control mom
	*/
	public static ControlMOM create(long ControlMOMId) {
		return getPersistence().create(ControlMOMId);
	}

	/**
	* Removes the control mom with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ControlMOMId the primary key of the control mom
	* @return the control mom that was removed
	* @throws NoSuchControlMOMException if a control mom with the primary key could not be found
	*/
	public static ControlMOM remove(long ControlMOMId)
		throws com.astra.anblicks.pdca.exception.NoSuchControlMOMException {
		return getPersistence().remove(ControlMOMId);
	}

	public static ControlMOM updateImpl(ControlMOM controlMOM) {
		return getPersistence().updateImpl(controlMOM);
	}

	/**
	* Returns the control mom with the primary key or throws a {@link NoSuchControlMOMException} if it could not be found.
	*
	* @param ControlMOMId the primary key of the control mom
	* @return the control mom
	* @throws NoSuchControlMOMException if a control mom with the primary key could not be found
	*/
	public static ControlMOM findByPrimaryKey(long ControlMOMId)
		throws com.astra.anblicks.pdca.exception.NoSuchControlMOMException {
		return getPersistence().findByPrimaryKey(ControlMOMId);
	}

	/**
	* Returns the control mom with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ControlMOMId the primary key of the control mom
	* @return the control mom, or <code>null</code> if a control mom with the primary key could not be found
	*/
	public static ControlMOM fetchByPrimaryKey(long ControlMOMId) {
		return getPersistence().fetchByPrimaryKey(ControlMOMId);
	}

	public static java.util.Map<java.io.Serializable, ControlMOM> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the control moms.
	*
	* @return the control moms
	*/
	public static List<ControlMOM> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the control moms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ControlMOMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of control moms
	* @param end the upper bound of the range of control moms (not inclusive)
	* @return the range of control moms
	*/
	public static List<ControlMOM> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the control moms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ControlMOMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of control moms
	* @param end the upper bound of the range of control moms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of control moms
	*/
	public static List<ControlMOM> findAll(int start, int end,
		OrderByComparator<ControlMOM> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the control moms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ControlMOMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of control moms
	* @param end the upper bound of the range of control moms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of control moms
	*/
	public static List<ControlMOM> findAll(int start, int end,
		OrderByComparator<ControlMOM> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the control moms from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of control moms.
	*
	* @return the number of control moms
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ControlMOMPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ControlMOMPersistence, ControlMOMPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ControlMOMPersistence.class);
}