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

package com.astra.anblicks.pdca.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.astra.anblicks.pdca.exception.NoSuchListMOMException;
import com.astra.anblicks.pdca.model.ListMOM;
import com.astra.anblicks.pdca.model.impl.ListMOMImpl;
import com.astra.anblicks.pdca.model.impl.ListMOMModelImpl;
import com.astra.anblicks.pdca.service.persistence.ListMOMPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the list mom service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ListMOMPersistence
 * @see com.astra.anblicks.pdca.service.persistence.ListMOMUtil
 * @generated
 */
@ProviderType
public class ListMOMPersistenceImpl extends BasePersistenceImpl<ListMOM>
	implements ListMOMPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ListMOMUtil} to access the list mom persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ListMOMImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ListMOMModelImpl.ENTITY_CACHE_ENABLED,
			ListMOMModelImpl.FINDER_CACHE_ENABLED, ListMOMImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ListMOMModelImpl.ENTITY_CACHE_ENABLED,
			ListMOMModelImpl.FINDER_CACHE_ENABLED, ListMOMImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ListMOMModelImpl.ENTITY_CACHE_ENABLED,
			ListMOMModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ListMOMPersistenceImpl() {
		setModelClass(ListMOM.class);
	}

	/**
	 * Caches the list mom in the entity cache if it is enabled.
	 *
	 * @param listMOM the list mom
	 */
	@Override
	public void cacheResult(ListMOM listMOM) {
		entityCache.putResult(ListMOMModelImpl.ENTITY_CACHE_ENABLED,
			ListMOMImpl.class, listMOM.getPrimaryKey(), listMOM);

		listMOM.resetOriginalValues();
	}

	/**
	 * Caches the list moms in the entity cache if it is enabled.
	 *
	 * @param listMOMs the list moms
	 */
	@Override
	public void cacheResult(List<ListMOM> listMOMs) {
		for (ListMOM listMOM : listMOMs) {
			if (entityCache.getResult(ListMOMModelImpl.ENTITY_CACHE_ENABLED,
						ListMOMImpl.class, listMOM.getPrimaryKey()) == null) {
				cacheResult(listMOM);
			}
			else {
				listMOM.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all list moms.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ListMOMImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the list mom.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ListMOM listMOM) {
		entityCache.removeResult(ListMOMModelImpl.ENTITY_CACHE_ENABLED,
			ListMOMImpl.class, listMOM.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ListMOM> listMOMs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ListMOM listMOM : listMOMs) {
			entityCache.removeResult(ListMOMModelImpl.ENTITY_CACHE_ENABLED,
				ListMOMImpl.class, listMOM.getPrimaryKey());
		}
	}

	/**
	 * Creates a new list mom with the primary key. Does not add the list mom to the database.
	 *
	 * @param MomId the primary key for the new list mom
	 * @return the new list mom
	 */
	@Override
	public ListMOM create(long MomId) {
		ListMOM listMOM = new ListMOMImpl();

		listMOM.setNew(true);
		listMOM.setPrimaryKey(MomId);

		listMOM.setCompanyId(companyProvider.getCompanyId());

		return listMOM;
	}

	/**
	 * Removes the list mom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param MomId the primary key of the list mom
	 * @return the list mom that was removed
	 * @throws NoSuchListMOMException if a list mom with the primary key could not be found
	 */
	@Override
	public ListMOM remove(long MomId) throws NoSuchListMOMException {
		return remove((Serializable)MomId);
	}

	/**
	 * Removes the list mom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the list mom
	 * @return the list mom that was removed
	 * @throws NoSuchListMOMException if a list mom with the primary key could not be found
	 */
	@Override
	public ListMOM remove(Serializable primaryKey)
		throws NoSuchListMOMException {
		Session session = null;

		try {
			session = openSession();

			ListMOM listMOM = (ListMOM)session.get(ListMOMImpl.class, primaryKey);

			if (listMOM == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchListMOMException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(listMOM);
		}
		catch (NoSuchListMOMException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ListMOM removeImpl(ListMOM listMOM) {
		listMOM = toUnwrappedModel(listMOM);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(listMOM)) {
				listMOM = (ListMOM)session.get(ListMOMImpl.class,
						listMOM.getPrimaryKeyObj());
			}

			if (listMOM != null) {
				session.delete(listMOM);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (listMOM != null) {
			clearCache(listMOM);
		}

		return listMOM;
	}

	@Override
	public ListMOM updateImpl(ListMOM listMOM) {
		listMOM = toUnwrappedModel(listMOM);

		boolean isNew = listMOM.isNew();

		Session session = null;

		try {
			session = openSession();

			if (listMOM.isNew()) {
				session.save(listMOM);

				listMOM.setNew(false);
			}
			else {
				listMOM = (ListMOM)session.merge(listMOM);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(ListMOMModelImpl.ENTITY_CACHE_ENABLED,
			ListMOMImpl.class, listMOM.getPrimaryKey(), listMOM, false);

		listMOM.resetOriginalValues();

		return listMOM;
	}

	protected ListMOM toUnwrappedModel(ListMOM listMOM) {
		if (listMOM instanceof ListMOMImpl) {
			return listMOM;
		}

		ListMOMImpl listMOMImpl = new ListMOMImpl();

		listMOMImpl.setNew(listMOM.isNew());
		listMOMImpl.setPrimaryKey(listMOM.getPrimaryKey());

		listMOMImpl.setMomId(listMOM.getMomId());
		listMOMImpl.setUserId(listMOM.getUserId());
		listMOMImpl.setCompanyId(listMOM.getCompanyId());
		listMOMImpl.setMeetingDate(listMOM.getMeetingDate());
		listMOMImpl.setFromTime(listMOM.getFromTime());
		listMOMImpl.setAmpm(listMOM.getAmpm());
		listMOMImpl.setMomType(listMOM.getMomType());
		listMOMImpl.setMomTypeId(listMOM.getMomTypeId());
		listMOMImpl.setPerformance(listMOM.getPerformance());
		listMOMImpl.setMOMGroup(listMOM.getMOMGroup());
		listMOMImpl.setMOMparticipants(listMOM.getMOMparticipants());
		listMOMImpl.setMOMcompanyName(listMOM.getMOMcompanyName());
		listMOMImpl.setMOMplace(listMOM.getMOMplace());
		listMOMImpl.setPonitDiscussionId(listMOM.getPonitDiscussionId());
		listMOMImpl.setSiteId(listMOM.getSiteId());
		listMOMImpl.setCreateDate(listMOM.getCreateDate());
		listMOMImpl.setCreatedBy(listMOM.getCreatedBy());
		listMOMImpl.setModifiedDate(listMOM.getModifiedDate());
		listMOMImpl.setModifiedBy(listMOM.getModifiedBy());

		return listMOMImpl;
	}

	/**
	 * Returns the list mom with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the list mom
	 * @return the list mom
	 * @throws NoSuchListMOMException if a list mom with the primary key could not be found
	 */
	@Override
	public ListMOM findByPrimaryKey(Serializable primaryKey)
		throws NoSuchListMOMException {
		ListMOM listMOM = fetchByPrimaryKey(primaryKey);

		if (listMOM == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchListMOMException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return listMOM;
	}

	/**
	 * Returns the list mom with the primary key or throws a {@link NoSuchListMOMException} if it could not be found.
	 *
	 * @param MomId the primary key of the list mom
	 * @return the list mom
	 * @throws NoSuchListMOMException if a list mom with the primary key could not be found
	 */
	@Override
	public ListMOM findByPrimaryKey(long MomId) throws NoSuchListMOMException {
		return findByPrimaryKey((Serializable)MomId);
	}

	/**
	 * Returns the list mom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the list mom
	 * @return the list mom, or <code>null</code> if a list mom with the primary key could not be found
	 */
	@Override
	public ListMOM fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ListMOMModelImpl.ENTITY_CACHE_ENABLED,
				ListMOMImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ListMOM listMOM = (ListMOM)serializable;

		if (listMOM == null) {
			Session session = null;

			try {
				session = openSession();

				listMOM = (ListMOM)session.get(ListMOMImpl.class, primaryKey);

				if (listMOM != null) {
					cacheResult(listMOM);
				}
				else {
					entityCache.putResult(ListMOMModelImpl.ENTITY_CACHE_ENABLED,
						ListMOMImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ListMOMModelImpl.ENTITY_CACHE_ENABLED,
					ListMOMImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return listMOM;
	}

	/**
	 * Returns the list mom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param MomId the primary key of the list mom
	 * @return the list mom, or <code>null</code> if a list mom with the primary key could not be found
	 */
	@Override
	public ListMOM fetchByPrimaryKey(long MomId) {
		return fetchByPrimaryKey((Serializable)MomId);
	}

	@Override
	public Map<Serializable, ListMOM> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ListMOM> map = new HashMap<Serializable, ListMOM>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ListMOM listMOM = fetchByPrimaryKey(primaryKey);

			if (listMOM != null) {
				map.put(primaryKey, listMOM);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ListMOMModelImpl.ENTITY_CACHE_ENABLED,
					ListMOMImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ListMOM)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LISTMOM_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (ListMOM listMOM : (List<ListMOM>)q.list()) {
				map.put(listMOM.getPrimaryKeyObj(), listMOM);

				cacheResult(listMOM);

				uncachedPrimaryKeys.remove(listMOM.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ListMOMModelImpl.ENTITY_CACHE_ENABLED,
					ListMOMImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the list moms.
	 *
	 * @return the list moms
	 */
	@Override
	public List<ListMOM> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ListMOM> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ListMOM> findAll(int start, int end,
		OrderByComparator<ListMOM> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<ListMOM> findAll(int start, int end,
		OrderByComparator<ListMOM> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ListMOM> list = null;

		if (retrieveFromCache) {
			list = (List<ListMOM>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LISTMOM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LISTMOM;

				if (pagination) {
					sql = sql.concat(ListMOMModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ListMOM>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ListMOM>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the list moms from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ListMOM listMOM : findAll()) {
			remove(listMOM);
		}
	}

	/**
	 * Returns the number of list moms.
	 *
	 * @return the number of list moms
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LISTMOM);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ListMOMModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the list mom persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ListMOMImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LISTMOM = "SELECT listMOM FROM ListMOM listMOM";
	private static final String _SQL_SELECT_LISTMOM_WHERE_PKS_IN = "SELECT listMOM FROM ListMOM listMOM WHERE MomId IN (";
	private static final String _SQL_COUNT_LISTMOM = "SELECT COUNT(listMOM) FROM ListMOM listMOM";
	private static final String _ORDER_BY_ENTITY_ALIAS = "listMOM.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ListMOM exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(ListMOMPersistenceImpl.class);
}