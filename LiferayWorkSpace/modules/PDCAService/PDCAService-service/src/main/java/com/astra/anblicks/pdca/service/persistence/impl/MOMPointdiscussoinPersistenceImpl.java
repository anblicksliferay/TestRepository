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

import com.astra.anblicks.pdca.exception.NoSuchMOMPointdiscussoinException;
import com.astra.anblicks.pdca.model.MOMPointdiscussoin;
import com.astra.anblicks.pdca.model.impl.MOMPointdiscussoinImpl;
import com.astra.anblicks.pdca.model.impl.MOMPointdiscussoinModelImpl;
import com.astra.anblicks.pdca.service.persistence.MOMPointdiscussoinPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
 * The persistence implementation for the mom pointdiscussoin service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOMPointdiscussoinPersistence
 * @see com.astra.anblicks.pdca.service.persistence.MOMPointdiscussoinUtil
 * @generated
 */
@ProviderType
public class MOMPointdiscussoinPersistenceImpl extends BasePersistenceImpl<MOMPointdiscussoin>
	implements MOMPointdiscussoinPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MOMPointdiscussoinUtil} to access the mom pointdiscussoin persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MOMPointdiscussoinImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MOMPointdiscussoinModelImpl.ENTITY_CACHE_ENABLED,
			MOMPointdiscussoinModelImpl.FINDER_CACHE_ENABLED,
			MOMPointdiscussoinImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MOMPointdiscussoinModelImpl.ENTITY_CACHE_ENABLED,
			MOMPointdiscussoinModelImpl.FINDER_CACHE_ENABLED,
			MOMPointdiscussoinImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MOMPointdiscussoinModelImpl.ENTITY_CACHE_ENABLED,
			MOMPointdiscussoinModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public MOMPointdiscussoinPersistenceImpl() {
		setModelClass(MOMPointdiscussoin.class);
	}

	/**
	 * Caches the mom pointdiscussoin in the entity cache if it is enabled.
	 *
	 * @param momPointdiscussoin the mom pointdiscussoin
	 */
	@Override
	public void cacheResult(MOMPointdiscussoin momPointdiscussoin) {
		entityCache.putResult(MOMPointdiscussoinModelImpl.ENTITY_CACHE_ENABLED,
			MOMPointdiscussoinImpl.class, momPointdiscussoin.getPrimaryKey(),
			momPointdiscussoin);

		momPointdiscussoin.resetOriginalValues();
	}

	/**
	 * Caches the mom pointdiscussoins in the entity cache if it is enabled.
	 *
	 * @param momPointdiscussoins the mom pointdiscussoins
	 */
	@Override
	public void cacheResult(List<MOMPointdiscussoin> momPointdiscussoins) {
		for (MOMPointdiscussoin momPointdiscussoin : momPointdiscussoins) {
			if (entityCache.getResult(
						MOMPointdiscussoinModelImpl.ENTITY_CACHE_ENABLED,
						MOMPointdiscussoinImpl.class,
						momPointdiscussoin.getPrimaryKey()) == null) {
				cacheResult(momPointdiscussoin);
			}
			else {
				momPointdiscussoin.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all mom pointdiscussoins.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MOMPointdiscussoinImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the mom pointdiscussoin.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MOMPointdiscussoin momPointdiscussoin) {
		entityCache.removeResult(MOMPointdiscussoinModelImpl.ENTITY_CACHE_ENABLED,
			MOMPointdiscussoinImpl.class, momPointdiscussoin.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MOMPointdiscussoin> momPointdiscussoins) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MOMPointdiscussoin momPointdiscussoin : momPointdiscussoins) {
			entityCache.removeResult(MOMPointdiscussoinModelImpl.ENTITY_CACHE_ENABLED,
				MOMPointdiscussoinImpl.class, momPointdiscussoin.getPrimaryKey());
		}
	}

	/**
	 * Creates a new mom pointdiscussoin with the primary key. Does not add the mom pointdiscussoin to the database.
	 *
	 * @param PdId the primary key for the new mom pointdiscussoin
	 * @return the new mom pointdiscussoin
	 */
	@Override
	public MOMPointdiscussoin create(long PdId) {
		MOMPointdiscussoin momPointdiscussoin = new MOMPointdiscussoinImpl();

		momPointdiscussoin.setNew(true);
		momPointdiscussoin.setPrimaryKey(PdId);

		return momPointdiscussoin;
	}

	/**
	 * Removes the mom pointdiscussoin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PdId the primary key of the mom pointdiscussoin
	 * @return the mom pointdiscussoin that was removed
	 * @throws NoSuchMOMPointdiscussoinException if a mom pointdiscussoin with the primary key could not be found
	 */
	@Override
	public MOMPointdiscussoin remove(long PdId)
		throws NoSuchMOMPointdiscussoinException {
		return remove((Serializable)PdId);
	}

	/**
	 * Removes the mom pointdiscussoin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the mom pointdiscussoin
	 * @return the mom pointdiscussoin that was removed
	 * @throws NoSuchMOMPointdiscussoinException if a mom pointdiscussoin with the primary key could not be found
	 */
	@Override
	public MOMPointdiscussoin remove(Serializable primaryKey)
		throws NoSuchMOMPointdiscussoinException {
		Session session = null;

		try {
			session = openSession();

			MOMPointdiscussoin momPointdiscussoin = (MOMPointdiscussoin)session.get(MOMPointdiscussoinImpl.class,
					primaryKey);

			if (momPointdiscussoin == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMOMPointdiscussoinException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(momPointdiscussoin);
		}
		catch (NoSuchMOMPointdiscussoinException nsee) {
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
	protected MOMPointdiscussoin removeImpl(
		MOMPointdiscussoin momPointdiscussoin) {
		momPointdiscussoin = toUnwrappedModel(momPointdiscussoin);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(momPointdiscussoin)) {
				momPointdiscussoin = (MOMPointdiscussoin)session.get(MOMPointdiscussoinImpl.class,
						momPointdiscussoin.getPrimaryKeyObj());
			}

			if (momPointdiscussoin != null) {
				session.delete(momPointdiscussoin);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (momPointdiscussoin != null) {
			clearCache(momPointdiscussoin);
		}

		return momPointdiscussoin;
	}

	@Override
	public MOMPointdiscussoin updateImpl(MOMPointdiscussoin momPointdiscussoin) {
		momPointdiscussoin = toUnwrappedModel(momPointdiscussoin);

		boolean isNew = momPointdiscussoin.isNew();

		Session session = null;

		try {
			session = openSession();

			if (momPointdiscussoin.isNew()) {
				session.save(momPointdiscussoin);

				momPointdiscussoin.setNew(false);
			}
			else {
				momPointdiscussoin = (MOMPointdiscussoin)session.merge(momPointdiscussoin);
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

		entityCache.putResult(MOMPointdiscussoinModelImpl.ENTITY_CACHE_ENABLED,
			MOMPointdiscussoinImpl.class, momPointdiscussoin.getPrimaryKey(),
			momPointdiscussoin, false);

		momPointdiscussoin.resetOriginalValues();

		return momPointdiscussoin;
	}

	protected MOMPointdiscussoin toUnwrappedModel(
		MOMPointdiscussoin momPointdiscussoin) {
		if (momPointdiscussoin instanceof MOMPointdiscussoinImpl) {
			return momPointdiscussoin;
		}

		MOMPointdiscussoinImpl momPointdiscussoinImpl = new MOMPointdiscussoinImpl();

		momPointdiscussoinImpl.setNew(momPointdiscussoin.isNew());
		momPointdiscussoinImpl.setPrimaryKey(momPointdiscussoin.getPrimaryKey());

		momPointdiscussoinImpl.setPdId(momPointdiscussoin.getPdId());
		momPointdiscussoinImpl.setMOMpdId(momPointdiscussoin.getMOMpdId());
		momPointdiscussoinImpl.setPonintDiscussionName(momPointdiscussoin.getPonintDiscussionName());
		momPointdiscussoinImpl.setNotes(momPointdiscussoin.getNotes());
		momPointdiscussoinImpl.setSiteId(momPointdiscussoin.getSiteId());
		momPointdiscussoinImpl.setCreateDate(momPointdiscussoin.getCreateDate());
		momPointdiscussoinImpl.setCreatedBy(momPointdiscussoin.getCreatedBy());
		momPointdiscussoinImpl.setModifiedDate(momPointdiscussoin.getModifiedDate());
		momPointdiscussoinImpl.setModifiedBy(momPointdiscussoin.getModifiedBy());

		return momPointdiscussoinImpl;
	}

	/**
	 * Returns the mom pointdiscussoin with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the mom pointdiscussoin
	 * @return the mom pointdiscussoin
	 * @throws NoSuchMOMPointdiscussoinException if a mom pointdiscussoin with the primary key could not be found
	 */
	@Override
	public MOMPointdiscussoin findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMOMPointdiscussoinException {
		MOMPointdiscussoin momPointdiscussoin = fetchByPrimaryKey(primaryKey);

		if (momPointdiscussoin == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMOMPointdiscussoinException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return momPointdiscussoin;
	}

	/**
	 * Returns the mom pointdiscussoin with the primary key or throws a {@link NoSuchMOMPointdiscussoinException} if it could not be found.
	 *
	 * @param PdId the primary key of the mom pointdiscussoin
	 * @return the mom pointdiscussoin
	 * @throws NoSuchMOMPointdiscussoinException if a mom pointdiscussoin with the primary key could not be found
	 */
	@Override
	public MOMPointdiscussoin findByPrimaryKey(long PdId)
		throws NoSuchMOMPointdiscussoinException {
		return findByPrimaryKey((Serializable)PdId);
	}

	/**
	 * Returns the mom pointdiscussoin with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the mom pointdiscussoin
	 * @return the mom pointdiscussoin, or <code>null</code> if a mom pointdiscussoin with the primary key could not be found
	 */
	@Override
	public MOMPointdiscussoin fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(MOMPointdiscussoinModelImpl.ENTITY_CACHE_ENABLED,
				MOMPointdiscussoinImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		MOMPointdiscussoin momPointdiscussoin = (MOMPointdiscussoin)serializable;

		if (momPointdiscussoin == null) {
			Session session = null;

			try {
				session = openSession();

				momPointdiscussoin = (MOMPointdiscussoin)session.get(MOMPointdiscussoinImpl.class,
						primaryKey);

				if (momPointdiscussoin != null) {
					cacheResult(momPointdiscussoin);
				}
				else {
					entityCache.putResult(MOMPointdiscussoinModelImpl.ENTITY_CACHE_ENABLED,
						MOMPointdiscussoinImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(MOMPointdiscussoinModelImpl.ENTITY_CACHE_ENABLED,
					MOMPointdiscussoinImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return momPointdiscussoin;
	}

	/**
	 * Returns the mom pointdiscussoin with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PdId the primary key of the mom pointdiscussoin
	 * @return the mom pointdiscussoin, or <code>null</code> if a mom pointdiscussoin with the primary key could not be found
	 */
	@Override
	public MOMPointdiscussoin fetchByPrimaryKey(long PdId) {
		return fetchByPrimaryKey((Serializable)PdId);
	}

	@Override
	public Map<Serializable, MOMPointdiscussoin> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, MOMPointdiscussoin> map = new HashMap<Serializable, MOMPointdiscussoin>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			MOMPointdiscussoin momPointdiscussoin = fetchByPrimaryKey(primaryKey);

			if (momPointdiscussoin != null) {
				map.put(primaryKey, momPointdiscussoin);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(MOMPointdiscussoinModelImpl.ENTITY_CACHE_ENABLED,
					MOMPointdiscussoinImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (MOMPointdiscussoin)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_MOMPOINTDISCUSSOIN_WHERE_PKS_IN);

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

			for (MOMPointdiscussoin momPointdiscussoin : (List<MOMPointdiscussoin>)q.list()) {
				map.put(momPointdiscussoin.getPrimaryKeyObj(),
					momPointdiscussoin);

				cacheResult(momPointdiscussoin);

				uncachedPrimaryKeys.remove(momPointdiscussoin.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(MOMPointdiscussoinModelImpl.ENTITY_CACHE_ENABLED,
					MOMPointdiscussoinImpl.class, primaryKey, nullModel);
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
	 * Returns all the mom pointdiscussoins.
	 *
	 * @return the mom pointdiscussoins
	 */
	@Override
	public List<MOMPointdiscussoin> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOMPointdiscussoin> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<MOMPointdiscussoin> findAll(int start, int end,
		OrderByComparator<MOMPointdiscussoin> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<MOMPointdiscussoin> findAll(int start, int end,
		OrderByComparator<MOMPointdiscussoin> orderByComparator,
		boolean retrieveFromCache) {
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

		List<MOMPointdiscussoin> list = null;

		if (retrieveFromCache) {
			list = (List<MOMPointdiscussoin>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MOMPOINTDISCUSSOIN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MOMPOINTDISCUSSOIN;

				if (pagination) {
					sql = sql.concat(MOMPointdiscussoinModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MOMPointdiscussoin>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MOMPointdiscussoin>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the mom pointdiscussoins from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MOMPointdiscussoin momPointdiscussoin : findAll()) {
			remove(momPointdiscussoin);
		}
	}

	/**
	 * Returns the number of mom pointdiscussoins.
	 *
	 * @return the number of mom pointdiscussoins
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MOMPOINTDISCUSSOIN);

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
		return MOMPointdiscussoinModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the mom pointdiscussoin persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(MOMPointdiscussoinImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_MOMPOINTDISCUSSOIN = "SELECT momPointdiscussoin FROM MOMPointdiscussoin momPointdiscussoin";
	private static final String _SQL_SELECT_MOMPOINTDISCUSSOIN_WHERE_PKS_IN = "SELECT momPointdiscussoin FROM MOMPointdiscussoin momPointdiscussoin WHERE PdId IN (";
	private static final String _SQL_COUNT_MOMPOINTDISCUSSOIN = "SELECT COUNT(momPointdiscussoin) FROM MOMPointdiscussoin momPointdiscussoin";
	private static final String _ORDER_BY_ENTITY_ALIAS = "momPointdiscussoin.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MOMPointdiscussoin exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(MOMPointdiscussoinPersistenceImpl.class);
}