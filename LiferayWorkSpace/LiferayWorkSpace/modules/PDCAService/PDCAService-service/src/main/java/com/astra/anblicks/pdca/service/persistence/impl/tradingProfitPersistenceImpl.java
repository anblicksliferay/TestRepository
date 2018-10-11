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

import com.astra.anblicks.pdca.exception.NoSuchtradingProfitException;
import com.astra.anblicks.pdca.model.impl.tradingProfitImpl;
import com.astra.anblicks.pdca.model.impl.tradingProfitModelImpl;
import com.astra.anblicks.pdca.model.tradingProfit;
import com.astra.anblicks.pdca.service.persistence.tradingProfitPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the trading profit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see tradingProfitPersistence
 * @see com.astra.anblicks.pdca.service.persistence.tradingProfitUtil
 * @generated
 */
@ProviderType
public class tradingProfitPersistenceImpl extends BasePersistenceImpl<tradingProfit>
	implements tradingProfitPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link tradingProfitUtil} to access the trading profit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = tradingProfitImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(tradingProfitModelImpl.ENTITY_CACHE_ENABLED,
			tradingProfitModelImpl.FINDER_CACHE_ENABLED,
			tradingProfitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(tradingProfitModelImpl.ENTITY_CACHE_ENABLED,
			tradingProfitModelImpl.FINDER_CACHE_ENABLED,
			tradingProfitImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(tradingProfitModelImpl.ENTITY_CACHE_ENABLED,
			tradingProfitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(tradingProfitModelImpl.ENTITY_CACHE_ENABLED,
			tradingProfitModelImpl.FINDER_CACHE_ENABLED,
			tradingProfitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(tradingProfitModelImpl.ENTITY_CACHE_ENABLED,
			tradingProfitModelImpl.FINDER_CACHE_ENABLED,
			tradingProfitImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] { String.class.getName() },
			tradingProfitModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(tradingProfitModelImpl.ENTITY_CACHE_ENABLED,
			tradingProfitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the trading profits where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trading profits
	 */
	@Override
	public List<tradingProfit> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trading profits where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tradingProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trading profits
	 * @param end the upper bound of the range of trading profits (not inclusive)
	 * @return the range of matching trading profits
	 */
	@Override
	public List<tradingProfit> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trading profits where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tradingProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trading profits
	 * @param end the upper bound of the range of trading profits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trading profits
	 */
	@Override
	public List<tradingProfit> findByUuid(String uuid, int start, int end,
		OrderByComparator<tradingProfit> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trading profits where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tradingProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trading profits
	 * @param end the upper bound of the range of trading profits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching trading profits
	 */
	@Override
	public List<tradingProfit> findByUuid(String uuid, int start, int end,
		OrderByComparator<tradingProfit> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<tradingProfit> list = null;

		if (retrieveFromCache) {
			list = (List<tradingProfit>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (tradingProfit tradingProfit : list) {
					if (!Objects.equals(uuid, tradingProfit.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TRADINGPROFIT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(tradingProfitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<tradingProfit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<tradingProfit>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first trading profit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trading profit
	 * @throws NoSuchtradingProfitException if a matching trading profit could not be found
	 */
	@Override
	public tradingProfit findByUuid_First(String uuid,
		OrderByComparator<tradingProfit> orderByComparator)
		throws NoSuchtradingProfitException {
		tradingProfit tradingProfit = fetchByUuid_First(uuid, orderByComparator);

		if (tradingProfit != null) {
			return tradingProfit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchtradingProfitException(msg.toString());
	}

	/**
	 * Returns the first trading profit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trading profit, or <code>null</code> if a matching trading profit could not be found
	 */
	@Override
	public tradingProfit fetchByUuid_First(String uuid,
		OrderByComparator<tradingProfit> orderByComparator) {
		List<tradingProfit> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trading profit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trading profit
	 * @throws NoSuchtradingProfitException if a matching trading profit could not be found
	 */
	@Override
	public tradingProfit findByUuid_Last(String uuid,
		OrderByComparator<tradingProfit> orderByComparator)
		throws NoSuchtradingProfitException {
		tradingProfit tradingProfit = fetchByUuid_Last(uuid, orderByComparator);

		if (tradingProfit != null) {
			return tradingProfit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchtradingProfitException(msg.toString());
	}

	/**
	 * Returns the last trading profit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trading profit, or <code>null</code> if a matching trading profit could not be found
	 */
	@Override
	public tradingProfit fetchByUuid_Last(String uuid,
		OrderByComparator<tradingProfit> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<tradingProfit> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trading profits before and after the current trading profit in the ordered set where uuid = &#63;.
	 *
	 * @param tradingProfitId the primary key of the current trading profit
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trading profit
	 * @throws NoSuchtradingProfitException if a trading profit with the primary key could not be found
	 */
	@Override
	public tradingProfit[] findByUuid_PrevAndNext(long tradingProfitId,
		String uuid, OrderByComparator<tradingProfit> orderByComparator)
		throws NoSuchtradingProfitException {
		tradingProfit tradingProfit = findByPrimaryKey(tradingProfitId);

		Session session = null;

		try {
			session = openSession();

			tradingProfit[] array = new tradingProfitImpl[3];

			array[0] = getByUuid_PrevAndNext(session, tradingProfit, uuid,
					orderByComparator, true);

			array[1] = tradingProfit;

			array[2] = getByUuid_PrevAndNext(session, tradingProfit, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected tradingProfit getByUuid_PrevAndNext(Session session,
		tradingProfit tradingProfit, String uuid,
		OrderByComparator<tradingProfit> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRADINGPROFIT_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(tradingProfitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tradingProfit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<tradingProfit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trading profits where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (tradingProfit tradingProfit : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(tradingProfit);
		}
	}

	/**
	 * Returns the number of trading profits where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trading profits
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRADINGPROFIT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "tradingProfit.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "tradingProfit.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(tradingProfit.uuid IS NULL OR tradingProfit.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(tradingProfitModelImpl.ENTITY_CACHE_ENABLED,
			tradingProfitModelImpl.FINDER_CACHE_ENABLED,
			tradingProfitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(tradingProfitModelImpl.ENTITY_CACHE_ENABLED,
			tradingProfitModelImpl.FINDER_CACHE_ENABLED,
			tradingProfitImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			tradingProfitModelImpl.UUID_COLUMN_BITMASK |
			tradingProfitModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(tradingProfitModelImpl.ENTITY_CACHE_ENABLED,
			tradingProfitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the trading profits where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trading profits
	 */
	@Override
	public List<tradingProfit> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trading profits where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tradingProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trading profits
	 * @param end the upper bound of the range of trading profits (not inclusive)
	 * @return the range of matching trading profits
	 */
	@Override
	public List<tradingProfit> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trading profits where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tradingProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trading profits
	 * @param end the upper bound of the range of trading profits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trading profits
	 */
	@Override
	public List<tradingProfit> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<tradingProfit> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trading profits where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tradingProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trading profits
	 * @param end the upper bound of the range of trading profits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching trading profits
	 */
	@Override
	public List<tradingProfit> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<tradingProfit> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<tradingProfit> list = null;

		if (retrieveFromCache) {
			list = (List<tradingProfit>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (tradingProfit tradingProfit : list) {
					if (!Objects.equals(uuid, tradingProfit.getUuid()) ||
							(companyId != tradingProfit.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TRADINGPROFIT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(tradingProfitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<tradingProfit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<tradingProfit>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first trading profit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trading profit
	 * @throws NoSuchtradingProfitException if a matching trading profit could not be found
	 */
	@Override
	public tradingProfit findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<tradingProfit> orderByComparator)
		throws NoSuchtradingProfitException {
		tradingProfit tradingProfit = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (tradingProfit != null) {
			return tradingProfit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchtradingProfitException(msg.toString());
	}

	/**
	 * Returns the first trading profit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trading profit, or <code>null</code> if a matching trading profit could not be found
	 */
	@Override
	public tradingProfit fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<tradingProfit> orderByComparator) {
		List<tradingProfit> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trading profit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trading profit
	 * @throws NoSuchtradingProfitException if a matching trading profit could not be found
	 */
	@Override
	public tradingProfit findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<tradingProfit> orderByComparator)
		throws NoSuchtradingProfitException {
		tradingProfit tradingProfit = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (tradingProfit != null) {
			return tradingProfit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchtradingProfitException(msg.toString());
	}

	/**
	 * Returns the last trading profit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trading profit, or <code>null</code> if a matching trading profit could not be found
	 */
	@Override
	public tradingProfit fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<tradingProfit> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<tradingProfit> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trading profits before and after the current trading profit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param tradingProfitId the primary key of the current trading profit
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trading profit
	 * @throws NoSuchtradingProfitException if a trading profit with the primary key could not be found
	 */
	@Override
	public tradingProfit[] findByUuid_C_PrevAndNext(long tradingProfitId,
		String uuid, long companyId,
		OrderByComparator<tradingProfit> orderByComparator)
		throws NoSuchtradingProfitException {
		tradingProfit tradingProfit = findByPrimaryKey(tradingProfitId);

		Session session = null;

		try {
			session = openSession();

			tradingProfit[] array = new tradingProfitImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, tradingProfit, uuid,
					companyId, orderByComparator, true);

			array[1] = tradingProfit;

			array[2] = getByUuid_C_PrevAndNext(session, tradingProfit, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected tradingProfit getByUuid_C_PrevAndNext(Session session,
		tradingProfit tradingProfit, String uuid, long companyId,
		OrderByComparator<tradingProfit> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TRADINGPROFIT_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(tradingProfitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tradingProfit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<tradingProfit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trading profits where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (tradingProfit tradingProfit : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tradingProfit);
		}
	}

	/**
	 * Returns the number of trading profits where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trading profits
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TRADINGPROFIT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "tradingProfit.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "tradingProfit.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(tradingProfit.uuid IS NULL OR tradingProfit.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "tradingProfit.companyId = ?";

	public tradingProfitPersistenceImpl() {
		setModelClass(tradingProfit.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the trading profit in the entity cache if it is enabled.
	 *
	 * @param tradingProfit the trading profit
	 */
	@Override
	public void cacheResult(tradingProfit tradingProfit) {
		entityCache.putResult(tradingProfitModelImpl.ENTITY_CACHE_ENABLED,
			tradingProfitImpl.class, tradingProfit.getPrimaryKey(),
			tradingProfit);

		tradingProfit.resetOriginalValues();
	}

	/**
	 * Caches the trading profits in the entity cache if it is enabled.
	 *
	 * @param tradingProfits the trading profits
	 */
	@Override
	public void cacheResult(List<tradingProfit> tradingProfits) {
		for (tradingProfit tradingProfit : tradingProfits) {
			if (entityCache.getResult(
						tradingProfitModelImpl.ENTITY_CACHE_ENABLED,
						tradingProfitImpl.class, tradingProfit.getPrimaryKey()) == null) {
				cacheResult(tradingProfit);
			}
			else {
				tradingProfit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all trading profits.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(tradingProfitImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the trading profit.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(tradingProfit tradingProfit) {
		entityCache.removeResult(tradingProfitModelImpl.ENTITY_CACHE_ENABLED,
			tradingProfitImpl.class, tradingProfit.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<tradingProfit> tradingProfits) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (tradingProfit tradingProfit : tradingProfits) {
			entityCache.removeResult(tradingProfitModelImpl.ENTITY_CACHE_ENABLED,
				tradingProfitImpl.class, tradingProfit.getPrimaryKey());
		}
	}

	/**
	 * Creates a new trading profit with the primary key. Does not add the trading profit to the database.
	 *
	 * @param tradingProfitId the primary key for the new trading profit
	 * @return the new trading profit
	 */
	@Override
	public tradingProfit create(long tradingProfitId) {
		tradingProfit tradingProfit = new tradingProfitImpl();

		tradingProfit.setNew(true);
		tradingProfit.setPrimaryKey(tradingProfitId);

		String uuid = PortalUUIDUtil.generate();

		tradingProfit.setUuid(uuid);

		tradingProfit.setCompanyId(companyProvider.getCompanyId());

		return tradingProfit;
	}

	/**
	 * Removes the trading profit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tradingProfitId the primary key of the trading profit
	 * @return the trading profit that was removed
	 * @throws NoSuchtradingProfitException if a trading profit with the primary key could not be found
	 */
	@Override
	public tradingProfit remove(long tradingProfitId)
		throws NoSuchtradingProfitException {
		return remove((Serializable)tradingProfitId);
	}

	/**
	 * Removes the trading profit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the trading profit
	 * @return the trading profit that was removed
	 * @throws NoSuchtradingProfitException if a trading profit with the primary key could not be found
	 */
	@Override
	public tradingProfit remove(Serializable primaryKey)
		throws NoSuchtradingProfitException {
		Session session = null;

		try {
			session = openSession();

			tradingProfit tradingProfit = (tradingProfit)session.get(tradingProfitImpl.class,
					primaryKey);

			if (tradingProfit == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchtradingProfitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tradingProfit);
		}
		catch (NoSuchtradingProfitException nsee) {
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
	protected tradingProfit removeImpl(tradingProfit tradingProfit) {
		tradingProfit = toUnwrappedModel(tradingProfit);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tradingProfit)) {
				tradingProfit = (tradingProfit)session.get(tradingProfitImpl.class,
						tradingProfit.getPrimaryKeyObj());
			}

			if (tradingProfit != null) {
				session.delete(tradingProfit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tradingProfit != null) {
			clearCache(tradingProfit);
		}

		return tradingProfit;
	}

	@Override
	public tradingProfit updateImpl(tradingProfit tradingProfit) {
		tradingProfit = toUnwrappedModel(tradingProfit);

		boolean isNew = tradingProfit.isNew();

		tradingProfitModelImpl tradingProfitModelImpl = (tradingProfitModelImpl)tradingProfit;

		if (Validator.isNull(tradingProfit.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			tradingProfit.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (tradingProfit.isNew()) {
				session.save(tradingProfit);

				tradingProfit.setNew(false);
			}
			else {
				tradingProfit = (tradingProfit)session.merge(tradingProfit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!tradingProfitModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { tradingProfitModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					tradingProfitModelImpl.getUuid(),
					tradingProfitModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((tradingProfitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tradingProfitModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { tradingProfitModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((tradingProfitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tradingProfitModelImpl.getOriginalUuid(),
						tradingProfitModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						tradingProfitModelImpl.getUuid(),
						tradingProfitModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		entityCache.putResult(tradingProfitModelImpl.ENTITY_CACHE_ENABLED,
			tradingProfitImpl.class, tradingProfit.getPrimaryKey(),
			tradingProfit, false);

		tradingProfit.resetOriginalValues();

		return tradingProfit;
	}

	protected tradingProfit toUnwrappedModel(tradingProfit tradingProfit) {
		if (tradingProfit instanceof tradingProfitImpl) {
			return tradingProfit;
		}

		tradingProfitImpl tradingProfitImpl = new tradingProfitImpl();

		tradingProfitImpl.setNew(tradingProfit.isNew());
		tradingProfitImpl.setPrimaryKey(tradingProfit.getPrimaryKey());

		tradingProfitImpl.setUuid(tradingProfit.getUuid());
		tradingProfitImpl.setTradingProfitId(tradingProfit.getTradingProfitId());
		tradingProfitImpl.setPeriodId(tradingProfit.getPeriodId());
		tradingProfitImpl.setCompanyId(tradingProfit.getCompanyId());
		tradingProfitImpl.setYear(tradingProfit.getYear());
		tradingProfitImpl.setNpat(tradingProfit.getNpat());
		tradingProfitImpl.setNetForex(tradingProfit.getNetForex());
		tradingProfitImpl.setPpeDispos(tradingProfit.getPpeDispos());
		tradingProfitImpl.setRevalutionOnPropertyInvestment(tradingProfit.getRevalutionOnPropertyInvestment());
		tradingProfitImpl.setInvestment(tradingProfit.getInvestment());
		tradingProfitImpl.setTaxExpense(tradingProfit.getTaxExpense());
		tradingProfitImpl.setImpairmentOnAsset(tradingProfit.getImpairmentOnAsset());
		tradingProfitImpl.setOthers(tradingProfit.getOthers());

		return tradingProfitImpl;
	}

	/**
	 * Returns the trading profit with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the trading profit
	 * @return the trading profit
	 * @throws NoSuchtradingProfitException if a trading profit with the primary key could not be found
	 */
	@Override
	public tradingProfit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchtradingProfitException {
		tradingProfit tradingProfit = fetchByPrimaryKey(primaryKey);

		if (tradingProfit == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchtradingProfitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tradingProfit;
	}

	/**
	 * Returns the trading profit with the primary key or throws a {@link NoSuchtradingProfitException} if it could not be found.
	 *
	 * @param tradingProfitId the primary key of the trading profit
	 * @return the trading profit
	 * @throws NoSuchtradingProfitException if a trading profit with the primary key could not be found
	 */
	@Override
	public tradingProfit findByPrimaryKey(long tradingProfitId)
		throws NoSuchtradingProfitException {
		return findByPrimaryKey((Serializable)tradingProfitId);
	}

	/**
	 * Returns the trading profit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trading profit
	 * @return the trading profit, or <code>null</code> if a trading profit with the primary key could not be found
	 */
	@Override
	public tradingProfit fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(tradingProfitModelImpl.ENTITY_CACHE_ENABLED,
				tradingProfitImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		tradingProfit tradingProfit = (tradingProfit)serializable;

		if (tradingProfit == null) {
			Session session = null;

			try {
				session = openSession();

				tradingProfit = (tradingProfit)session.get(tradingProfitImpl.class,
						primaryKey);

				if (tradingProfit != null) {
					cacheResult(tradingProfit);
				}
				else {
					entityCache.putResult(tradingProfitModelImpl.ENTITY_CACHE_ENABLED,
						tradingProfitImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(tradingProfitModelImpl.ENTITY_CACHE_ENABLED,
					tradingProfitImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tradingProfit;
	}

	/**
	 * Returns the trading profit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tradingProfitId the primary key of the trading profit
	 * @return the trading profit, or <code>null</code> if a trading profit with the primary key could not be found
	 */
	@Override
	public tradingProfit fetchByPrimaryKey(long tradingProfitId) {
		return fetchByPrimaryKey((Serializable)tradingProfitId);
	}

	@Override
	public Map<Serializable, tradingProfit> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, tradingProfit> map = new HashMap<Serializable, tradingProfit>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			tradingProfit tradingProfit = fetchByPrimaryKey(primaryKey);

			if (tradingProfit != null) {
				map.put(primaryKey, tradingProfit);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(tradingProfitModelImpl.ENTITY_CACHE_ENABLED,
					tradingProfitImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (tradingProfit)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TRADINGPROFIT_WHERE_PKS_IN);

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

			for (tradingProfit tradingProfit : (List<tradingProfit>)q.list()) {
				map.put(tradingProfit.getPrimaryKeyObj(), tradingProfit);

				cacheResult(tradingProfit);

				uncachedPrimaryKeys.remove(tradingProfit.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(tradingProfitModelImpl.ENTITY_CACHE_ENABLED,
					tradingProfitImpl.class, primaryKey, nullModel);
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
	 * Returns all the trading profits.
	 *
	 * @return the trading profits
	 */
	@Override
	public List<tradingProfit> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trading profits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tradingProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of trading profits
	 * @param end the upper bound of the range of trading profits (not inclusive)
	 * @return the range of trading profits
	 */
	@Override
	public List<tradingProfit> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the trading profits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tradingProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of trading profits
	 * @param end the upper bound of the range of trading profits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trading profits
	 */
	@Override
	public List<tradingProfit> findAll(int start, int end,
		OrderByComparator<tradingProfit> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trading profits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tradingProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of trading profits
	 * @param end the upper bound of the range of trading profits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of trading profits
	 */
	@Override
	public List<tradingProfit> findAll(int start, int end,
		OrderByComparator<tradingProfit> orderByComparator,
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

		List<tradingProfit> list = null;

		if (retrieveFromCache) {
			list = (List<tradingProfit>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TRADINGPROFIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRADINGPROFIT;

				if (pagination) {
					sql = sql.concat(tradingProfitModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<tradingProfit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<tradingProfit>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the trading profits from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (tradingProfit tradingProfit : findAll()) {
			remove(tradingProfit);
		}
	}

	/**
	 * Returns the number of trading profits.
	 *
	 * @return the number of trading profits
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TRADINGPROFIT);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return tradingProfitModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the trading profit persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(tradingProfitImpl.class.getName());
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
	private static final String _SQL_SELECT_TRADINGPROFIT = "SELECT tradingProfit FROM tradingProfit tradingProfit";
	private static final String _SQL_SELECT_TRADINGPROFIT_WHERE_PKS_IN = "SELECT tradingProfit FROM tradingProfit tradingProfit WHERE tradingProfitId IN (";
	private static final String _SQL_SELECT_TRADINGPROFIT_WHERE = "SELECT tradingProfit FROM tradingProfit tradingProfit WHERE ";
	private static final String _SQL_COUNT_TRADINGPROFIT = "SELECT COUNT(tradingProfit) FROM tradingProfit tradingProfit";
	private static final String _SQL_COUNT_TRADINGPROFIT_WHERE = "SELECT COUNT(tradingProfit) FROM tradingProfit tradingProfit WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tradingProfit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No tradingProfit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No tradingProfit exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(tradingProfitPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}