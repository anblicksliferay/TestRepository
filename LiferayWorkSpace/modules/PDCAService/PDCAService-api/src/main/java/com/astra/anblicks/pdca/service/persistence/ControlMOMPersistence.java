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

import com.astra.anblicks.pdca.exception.NoSuchControlMOMException;
import com.astra.anblicks.pdca.model.ControlMOM;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the control mom service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.persistence.impl.ControlMOMPersistenceImpl
 * @see ControlMOMUtil
 * @generated
 */
@ProviderType
public interface ControlMOMPersistence extends BasePersistence<ControlMOM> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ControlMOMUtil} to access the control mom persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the control mom in the entity cache if it is enabled.
	*
	* @param controlMOM the control mom
	*/
	public void cacheResult(ControlMOM controlMOM);

	/**
	* Caches the control moms in the entity cache if it is enabled.
	*
	* @param controlMOMs the control moms
	*/
	public void cacheResult(java.util.List<ControlMOM> controlMOMs);

	/**
	* Creates a new control mom with the primary key. Does not add the control mom to the database.
	*
	* @param ControlMOMId the primary key for the new control mom
	* @return the new control mom
	*/
	public ControlMOM create(long ControlMOMId);

	/**
	* Removes the control mom with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ControlMOMId the primary key of the control mom
	* @return the control mom that was removed
	* @throws NoSuchControlMOMException if a control mom with the primary key could not be found
	*/
	public ControlMOM remove(long ControlMOMId)
		throws NoSuchControlMOMException;

	public ControlMOM updateImpl(ControlMOM controlMOM);

	/**
	* Returns the control mom with the primary key or throws a {@link NoSuchControlMOMException} if it could not be found.
	*
	* @param ControlMOMId the primary key of the control mom
	* @return the control mom
	* @throws NoSuchControlMOMException if a control mom with the primary key could not be found
	*/
	public ControlMOM findByPrimaryKey(long ControlMOMId)
		throws NoSuchControlMOMException;

	/**
	* Returns the control mom with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ControlMOMId the primary key of the control mom
	* @return the control mom, or <code>null</code> if a control mom with the primary key could not be found
	*/
	public ControlMOM fetchByPrimaryKey(long ControlMOMId);

	@Override
	public java.util.Map<java.io.Serializable, ControlMOM> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the control moms.
	*
	* @return the control moms
	*/
	public java.util.List<ControlMOM> findAll();

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
	public java.util.List<ControlMOM> findAll(int start, int end);

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
	public java.util.List<ControlMOM> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ControlMOM> orderByComparator);

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
	public java.util.List<ControlMOM> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ControlMOM> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the control moms from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of control moms.
	*
	* @return the number of control moms
	*/
	public int countAll();
}