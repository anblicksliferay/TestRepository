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

import com.astra.anblicks.pdca.model.MOMPointdiscussoin;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the mom pointdiscussoin service. This utility wraps {@link com.astra.anblicks.pdca.service.persistence.impl.MOMPointdiscussoinPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOMPointdiscussoinPersistence
 * @see com.astra.anblicks.pdca.service.persistence.impl.MOMPointdiscussoinPersistenceImpl
 * @generated
 */
@ProviderType
public class MOMPointdiscussoinUtil {
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
	public static void clearCache(MOMPointdiscussoin momPointdiscussoin) {
		getPersistence().clearCache(momPointdiscussoin);
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
	public static List<MOMPointdiscussoin> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MOMPointdiscussoin> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MOMPointdiscussoin> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MOMPointdiscussoin> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MOMPointdiscussoin update(
		MOMPointdiscussoin momPointdiscussoin) {
		return getPersistence().update(momPointdiscussoin);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MOMPointdiscussoin update(
		MOMPointdiscussoin momPointdiscussoin, ServiceContext serviceContext) {
		return getPersistence().update(momPointdiscussoin, serviceContext);
	}

	/**
	* Caches the mom pointdiscussoin in the entity cache if it is enabled.
	*
	* @param momPointdiscussoin the mom pointdiscussoin
	*/
	public static void cacheResult(MOMPointdiscussoin momPointdiscussoin) {
		getPersistence().cacheResult(momPointdiscussoin);
	}

	/**
	* Caches the mom pointdiscussoins in the entity cache if it is enabled.
	*
	* @param momPointdiscussoins the mom pointdiscussoins
	*/
	public static void cacheResult(List<MOMPointdiscussoin> momPointdiscussoins) {
		getPersistence().cacheResult(momPointdiscussoins);
	}

	/**
	* Creates a new mom pointdiscussoin with the primary key. Does not add the mom pointdiscussoin to the database.
	*
	* @param PdId the primary key for the new mom pointdiscussoin
	* @return the new mom pointdiscussoin
	*/
	public static MOMPointdiscussoin create(long PdId) {
		return getPersistence().create(PdId);
	}

	/**
	* Removes the mom pointdiscussoin with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PdId the primary key of the mom pointdiscussoin
	* @return the mom pointdiscussoin that was removed
	* @throws NoSuchMOMPointdiscussoinException if a mom pointdiscussoin with the primary key could not be found
	*/
	public static MOMPointdiscussoin remove(long PdId)
		throws com.astra.anblicks.pdca.exception.NoSuchMOMPointdiscussoinException {
		return getPersistence().remove(PdId);
	}

	public static MOMPointdiscussoin updateImpl(
		MOMPointdiscussoin momPointdiscussoin) {
		return getPersistence().updateImpl(momPointdiscussoin);
	}

	/**
	* Returns the mom pointdiscussoin with the primary key or throws a {@link NoSuchMOMPointdiscussoinException} if it could not be found.
	*
	* @param PdId the primary key of the mom pointdiscussoin
	* @return the mom pointdiscussoin
	* @throws NoSuchMOMPointdiscussoinException if a mom pointdiscussoin with the primary key could not be found
	*/
	public static MOMPointdiscussoin findByPrimaryKey(long PdId)
		throws com.astra.anblicks.pdca.exception.NoSuchMOMPointdiscussoinException {
		return getPersistence().findByPrimaryKey(PdId);
	}

	/**
	* Returns the mom pointdiscussoin with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PdId the primary key of the mom pointdiscussoin
	* @return the mom pointdiscussoin, or <code>null</code> if a mom pointdiscussoin with the primary key could not be found
	*/
	public static MOMPointdiscussoin fetchByPrimaryKey(long PdId) {
		return getPersistence().fetchByPrimaryKey(PdId);
	}

	public static java.util.Map<java.io.Serializable, MOMPointdiscussoin> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the mom pointdiscussoins.
	*
	* @return the mom pointdiscussoins
	*/
	public static List<MOMPointdiscussoin> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the mom pointdiscussoins.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MOMPointdiscussoinModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of mom pointdiscussoins
	* @param end the upper bound of the range of mom pointdiscussoins (not inclusive)
	* @return the range of mom pointdiscussoins
	*/
	public static List<MOMPointdiscussoin> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the mom pointdiscussoins.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MOMPointdiscussoinModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of mom pointdiscussoins
	* @param end the upper bound of the range of mom pointdiscussoins (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of mom pointdiscussoins
	*/
	public static List<MOMPointdiscussoin> findAll(int start, int end,
		OrderByComparator<MOMPointdiscussoin> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the mom pointdiscussoins.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MOMPointdiscussoinModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of mom pointdiscussoins
	* @param end the upper bound of the range of mom pointdiscussoins (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of mom pointdiscussoins
	*/
	public static List<MOMPointdiscussoin> findAll(int start, int end,
		OrderByComparator<MOMPointdiscussoin> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the mom pointdiscussoins from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of mom pointdiscussoins.
	*
	* @return the number of mom pointdiscussoins
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MOMPointdiscussoinPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MOMPointdiscussoinPersistence, MOMPointdiscussoinPersistence> _serviceTracker =
		ServiceTrackerFactory.open(MOMPointdiscussoinPersistence.class);
}