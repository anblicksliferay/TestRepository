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

import com.astra.anblicks.pdca.exception.NoSuchListMOMException;
import com.astra.anblicks.pdca.model.ListMOM;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the list mom service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.persistence.impl.ListMOMPersistenceImpl
 * @see ListMOMUtil
 * @generated
 */
@ProviderType
public interface ListMOMPersistence extends BasePersistence<ListMOM> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ListMOMUtil} to access the list mom persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the list mom in the entity cache if it is enabled.
	*
	* @param listMOM the list mom
	*/
	public void cacheResult(ListMOM listMOM);

	/**
	* Caches the list moms in the entity cache if it is enabled.
	*
	* @param listMOMs the list moms
	*/
	public void cacheResult(java.util.List<ListMOM> listMOMs);

	/**
	* Creates a new list mom with the primary key. Does not add the list mom to the database.
	*
	* @param MomId the primary key for the new list mom
	* @return the new list mom
	*/
	public ListMOM create(long MomId);

	/**
	* Removes the list mom with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param MomId the primary key of the list mom
	* @return the list mom that was removed
	* @throws NoSuchListMOMException if a list mom with the primary key could not be found
	*/
	public ListMOM remove(long MomId) throws NoSuchListMOMException;

	public ListMOM updateImpl(ListMOM listMOM);

	/**
	* Returns the list mom with the primary key or throws a {@link NoSuchListMOMException} if it could not be found.
	*
	* @param MomId the primary key of the list mom
	* @return the list mom
	* @throws NoSuchListMOMException if a list mom with the primary key could not be found
	*/
	public ListMOM findByPrimaryKey(long MomId) throws NoSuchListMOMException;

	/**
	* Returns the list mom with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param MomId the primary key of the list mom
	* @return the list mom, or <code>null</code> if a list mom with the primary key could not be found
	*/
	public ListMOM fetchByPrimaryKey(long MomId);

	@Override
	public java.util.Map<java.io.Serializable, ListMOM> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the list moms.
	*
	* @return the list moms
	*/
	public java.util.List<ListMOM> findAll();

	/**
	* Returns a range of all the list moms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ListMOMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of list moms
	* @param end the upper bound of the range of list moms (not inclusive)
	* @return the range of list moms
	*/
	public java.util.List<ListMOM> findAll(int start, int end);

	/**
	* Returns an ordered range of all the list moms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ListMOMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of list moms
	* @param end the upper bound of the range of list moms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of list moms
	*/
	public java.util.List<ListMOM> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ListMOM> orderByComparator);

	/**
	* Returns an ordered range of all the list moms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ListMOMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of list moms
	* @param end the upper bound of the range of list moms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of list moms
	*/
	public java.util.List<ListMOM> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ListMOM> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the list moms from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of list moms.
	*
	* @return the number of list moms
	*/
	public int countAll();
}