package com.axa.portal.esp.services.SB.service.persistence;

import com.axa.portal.esp.services.SB.NoSuchCacheException;
import com.axa.portal.esp.services.SB.model.cmmCache;
import com.axa.portal.esp.services.SB.model.impl.cmmCacheImpl;
import com.axa.portal.esp.services.SB.model.impl.cmmCacheModelImpl;
import com.axa.portal.esp.services.SB.service.persistence.cmmCachePersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the cmm cache service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see cmmCachePersistence
 * @see cmmCacheUtil
 * @generated
 */
public class cmmCachePersistenceImpl extends BasePersistenceImpl<cmmCache>
    implements cmmCachePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link cmmCacheUtil} to access the cmm cache persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = cmmCacheImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(cmmCacheModelImpl.ENTITY_CACHE_ENABLED,
            cmmCacheModelImpl.FINDER_CACHE_ENABLED, cmmCacheImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(cmmCacheModelImpl.ENTITY_CACHE_ENABLED,
            cmmCacheModelImpl.FINDER_CACHE_ENABLED, cmmCacheImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(cmmCacheModelImpl.ENTITY_CACHE_ENABLED,
            cmmCacheModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_HASHVALUEFROMHASHKEY = new FinderPath(cmmCacheModelImpl.ENTITY_CACHE_ENABLED,
            cmmCacheModelImpl.FINDER_CACHE_ENABLED, cmmCacheImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByhashValuefromHASHkey",
            new String[] { String.class.getName() },
            cmmCacheModelImpl.HASHKEY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_HASHVALUEFROMHASHKEY = new FinderPath(cmmCacheModelImpl.ENTITY_CACHE_ENABLED,
            cmmCacheModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByhashValuefromHASHkey",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_HASHVALUEFROMHASHKEY_HASHKEY_1 = "cmmCache.hashKey IS NULL";
    private static final String _FINDER_COLUMN_HASHVALUEFROMHASHKEY_HASHKEY_2 = "cmmCache.hashKey = ?";
    private static final String _FINDER_COLUMN_HASHVALUEFROMHASHKEY_HASHKEY_3 = "(cmmCache.hashKey IS NULL OR cmmCache.hashKey = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_HASHVALUEFROMID = new FinderPath(cmmCacheModelImpl.ENTITY_CACHE_ENABLED,
            cmmCacheModelImpl.FINDER_CACHE_ENABLED, cmmCacheImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByhashValuefromId",
            new String[] { Long.class.getName() },
            cmmCacheModelImpl.CMMID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_HASHVALUEFROMID = new FinderPath(cmmCacheModelImpl.ENTITY_CACHE_ENABLED,
            cmmCacheModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByhashValuefromId", new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_HASHVALUEFROMID_CMMID_2 = "cmmCache.cmmId = ?";
    private static final String _SQL_SELECT_CMMCACHE = "SELECT cmmCache FROM cmmCache cmmCache";
    private static final String _SQL_SELECT_CMMCACHE_WHERE = "SELECT cmmCache FROM cmmCache cmmCache WHERE ";
    private static final String _SQL_COUNT_CMMCACHE = "SELECT COUNT(cmmCache) FROM cmmCache cmmCache";
    private static final String _SQL_COUNT_CMMCACHE_WHERE = "SELECT COUNT(cmmCache) FROM cmmCache cmmCache WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "cmmCache.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No cmmCache exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No cmmCache exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(cmmCachePersistenceImpl.class);
    private static cmmCache _nullcmmCache = new cmmCacheImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<cmmCache> toCacheModel() {
                return _nullcmmCacheCacheModel;
            }
        };

    private static CacheModel<cmmCache> _nullcmmCacheCacheModel = new CacheModel<cmmCache>() {
            @Override
            public cmmCache toEntityModel() {
                return _nullcmmCache;
            }
        };

    public cmmCachePersistenceImpl() {
        setModelClass(cmmCache.class);
    }

    /**
     * Returns the cmm cache where hashKey = &#63; or throws a {@link com.axa.portal.esp.services.SB.NoSuchCacheException} if it could not be found.
     *
     * @param hashKey the hash key
     * @return the matching cmm cache
     * @throws com.axa.portal.esp.services.SB.NoSuchCacheException if a matching cmm cache could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public cmmCache findByhashValuefromHASHkey(String hashKey)
        throws NoSuchCacheException, SystemException {
        cmmCache cmmCache = fetchByhashValuefromHASHkey(hashKey);

        if (cmmCache == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("hashKey=");
            msg.append(hashKey);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchCacheException(msg.toString());
        }

        return cmmCache;
    }

    /**
     * Returns the cmm cache where hashKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param hashKey the hash key
     * @return the matching cmm cache, or <code>null</code> if a matching cmm cache could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public cmmCache fetchByhashValuefromHASHkey(String hashKey)
        throws SystemException {
        return fetchByhashValuefromHASHkey(hashKey, true);
    }

    /**
     * Returns the cmm cache where hashKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param hashKey the hash key
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching cmm cache, or <code>null</code> if a matching cmm cache could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public cmmCache fetchByhashValuefromHASHkey(String hashKey,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { hashKey };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_HASHVALUEFROMHASHKEY,
                    finderArgs, this);
        }

        if (result instanceof cmmCache) {
            cmmCache cmmCache = (cmmCache) result;

            if (!Validator.equals(hashKey, cmmCache.getHashKey())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_CMMCACHE_WHERE);

            boolean bindHashKey = false;

            if (hashKey == null) {
                query.append(_FINDER_COLUMN_HASHVALUEFROMHASHKEY_HASHKEY_1);
            } else if (hashKey.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_HASHVALUEFROMHASHKEY_HASHKEY_3);
            } else {
                bindHashKey = true;

                query.append(_FINDER_COLUMN_HASHVALUEFROMHASHKEY_HASHKEY_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindHashKey) {
                    qPos.add(hashKey);
                }

                List<cmmCache> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HASHVALUEFROMHASHKEY,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "cmmCachePersistenceImpl.fetchByhashValuefromHASHkey(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    cmmCache cmmCache = list.get(0);

                    result = cmmCache;

                    cacheResult(cmmCache);

                    if ((cmmCache.getHashKey() == null) ||
                            !cmmCache.getHashKey().equals(hashKey)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HASHVALUEFROMHASHKEY,
                            finderArgs, cmmCache);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_HASHVALUEFROMHASHKEY,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (cmmCache) result;
        }
    }

    /**
     * Removes the cmm cache where hashKey = &#63; from the database.
     *
     * @param hashKey the hash key
     * @return the cmm cache that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public cmmCache removeByhashValuefromHASHkey(String hashKey)
        throws NoSuchCacheException, SystemException {
        cmmCache cmmCache = findByhashValuefromHASHkey(hashKey);

        return remove(cmmCache);
    }

    /**
     * Returns the number of cmm caches where hashKey = &#63;.
     *
     * @param hashKey the hash key
     * @return the number of matching cmm caches
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByhashValuefromHASHkey(String hashKey)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_HASHVALUEFROMHASHKEY;

        Object[] finderArgs = new Object[] { hashKey };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CMMCACHE_WHERE);

            boolean bindHashKey = false;

            if (hashKey == null) {
                query.append(_FINDER_COLUMN_HASHVALUEFROMHASHKEY_HASHKEY_1);
            } else if (hashKey.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_HASHVALUEFROMHASHKEY_HASHKEY_3);
            } else {
                bindHashKey = true;

                query.append(_FINDER_COLUMN_HASHVALUEFROMHASHKEY_HASHKEY_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindHashKey) {
                    qPos.add(hashKey);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the cmm cache where cmmId = &#63; or throws a {@link com.axa.portal.esp.services.SB.NoSuchCacheException} if it could not be found.
     *
     * @param cmmId the cmm ID
     * @return the matching cmm cache
     * @throws com.axa.portal.esp.services.SB.NoSuchCacheException if a matching cmm cache could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public cmmCache findByhashValuefromId(long cmmId)
        throws NoSuchCacheException, SystemException {
        cmmCache cmmCache = fetchByhashValuefromId(cmmId);

        if (cmmCache == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("cmmId=");
            msg.append(cmmId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchCacheException(msg.toString());
        }

        return cmmCache;
    }

    /**
     * Returns the cmm cache where cmmId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param cmmId the cmm ID
     * @return the matching cmm cache, or <code>null</code> if a matching cmm cache could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public cmmCache fetchByhashValuefromId(long cmmId)
        throws SystemException {
        return fetchByhashValuefromId(cmmId, true);
    }

    /**
     * Returns the cmm cache where cmmId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param cmmId the cmm ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching cmm cache, or <code>null</code> if a matching cmm cache could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public cmmCache fetchByhashValuefromId(long cmmId, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { cmmId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_HASHVALUEFROMID,
                    finderArgs, this);
        }

        if (result instanceof cmmCache) {
            cmmCache cmmCache = (cmmCache) result;

            if ((cmmId != cmmCache.getCmmId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_CMMCACHE_WHERE);

            query.append(_FINDER_COLUMN_HASHVALUEFROMID_CMMID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(cmmId);

                List<cmmCache> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HASHVALUEFROMID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "cmmCachePersistenceImpl.fetchByhashValuefromId(long, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    cmmCache cmmCache = list.get(0);

                    result = cmmCache;

                    cacheResult(cmmCache);

                    if ((cmmCache.getCmmId() != cmmId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HASHVALUEFROMID,
                            finderArgs, cmmCache);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_HASHVALUEFROMID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (cmmCache) result;
        }
    }

    /**
     * Removes the cmm cache where cmmId = &#63; from the database.
     *
     * @param cmmId the cmm ID
     * @return the cmm cache that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public cmmCache removeByhashValuefromId(long cmmId)
        throws NoSuchCacheException, SystemException {
        cmmCache cmmCache = findByhashValuefromId(cmmId);

        return remove(cmmCache);
    }

    /**
     * Returns the number of cmm caches where cmmId = &#63;.
     *
     * @param cmmId the cmm ID
     * @return the number of matching cmm caches
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByhashValuefromId(long cmmId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_HASHVALUEFROMID;

        Object[] finderArgs = new Object[] { cmmId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CMMCACHE_WHERE);

            query.append(_FINDER_COLUMN_HASHVALUEFROMID_CMMID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(cmmId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the cmm cache in the entity cache if it is enabled.
     *
     * @param cmmCache the cmm cache
     */
    @Override
    public void cacheResult(cmmCache cmmCache) {
        EntityCacheUtil.putResult(cmmCacheModelImpl.ENTITY_CACHE_ENABLED,
            cmmCacheImpl.class, cmmCache.getPrimaryKey(), cmmCache);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HASHVALUEFROMHASHKEY,
            new Object[] { cmmCache.getHashKey() }, cmmCache);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HASHVALUEFROMID,
            new Object[] { cmmCache.getCmmId() }, cmmCache);

        cmmCache.resetOriginalValues();
    }

    /**
     * Caches the cmm caches in the entity cache if it is enabled.
     *
     * @param cmmCaches the cmm caches
     */
    @Override
    public void cacheResult(List<cmmCache> cmmCaches) {
        for (cmmCache cmmCache : cmmCaches) {
            if (EntityCacheUtil.getResult(
                        cmmCacheModelImpl.ENTITY_CACHE_ENABLED,
                        cmmCacheImpl.class, cmmCache.getPrimaryKey()) == null) {
                cacheResult(cmmCache);
            } else {
                cmmCache.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all cmm caches.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(cmmCacheImpl.class.getName());
        }

        EntityCacheUtil.clearCache(cmmCacheImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the cmm cache.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(cmmCache cmmCache) {
        EntityCacheUtil.removeResult(cmmCacheModelImpl.ENTITY_CACHE_ENABLED,
            cmmCacheImpl.class, cmmCache.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(cmmCache);
    }

    @Override
    public void clearCache(List<cmmCache> cmmCaches) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (cmmCache cmmCache : cmmCaches) {
            EntityCacheUtil.removeResult(cmmCacheModelImpl.ENTITY_CACHE_ENABLED,
                cmmCacheImpl.class, cmmCache.getPrimaryKey());

            clearUniqueFindersCache(cmmCache);
        }
    }

    protected void cacheUniqueFindersCache(cmmCache cmmCache) {
        if (cmmCache.isNew()) {
            Object[] args = new Object[] { cmmCache.getHashKey() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_HASHVALUEFROMHASHKEY,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HASHVALUEFROMHASHKEY,
                args, cmmCache);

            args = new Object[] { cmmCache.getCmmId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_HASHVALUEFROMID,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HASHVALUEFROMID,
                args, cmmCache);
        } else {
            cmmCacheModelImpl cmmCacheModelImpl = (cmmCacheModelImpl) cmmCache;

            if ((cmmCacheModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_HASHVALUEFROMHASHKEY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { cmmCache.getHashKey() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_HASHVALUEFROMHASHKEY,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HASHVALUEFROMHASHKEY,
                    args, cmmCache);
            }

            if ((cmmCacheModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_HASHVALUEFROMID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { cmmCache.getCmmId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_HASHVALUEFROMID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HASHVALUEFROMID,
                    args, cmmCache);
            }
        }
    }

    protected void clearUniqueFindersCache(cmmCache cmmCache) {
        cmmCacheModelImpl cmmCacheModelImpl = (cmmCacheModelImpl) cmmCache;

        Object[] args = new Object[] { cmmCache.getHashKey() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HASHVALUEFROMHASHKEY,
            args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_HASHVALUEFROMHASHKEY,
            args);

        if ((cmmCacheModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_HASHVALUEFROMHASHKEY.getColumnBitmask()) != 0) {
            args = new Object[] { cmmCacheModelImpl.getOriginalHashKey() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HASHVALUEFROMHASHKEY,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_HASHVALUEFROMHASHKEY,
                args);
        }

        args = new Object[] { cmmCache.getCmmId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HASHVALUEFROMID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_HASHVALUEFROMID, args);

        if ((cmmCacheModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_HASHVALUEFROMID.getColumnBitmask()) != 0) {
            args = new Object[] { cmmCacheModelImpl.getOriginalCmmId() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HASHVALUEFROMID,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_HASHVALUEFROMID,
                args);
        }
    }

    /**
     * Creates a new cmm cache with the primary key. Does not add the cmm cache to the database.
     *
     * @param cmmId the primary key for the new cmm cache
     * @return the new cmm cache
     */
    @Override
    public cmmCache create(long cmmId) {
        cmmCache cmmCache = new cmmCacheImpl();

        cmmCache.setNew(true);
        cmmCache.setPrimaryKey(cmmId);

        return cmmCache;
    }

    /**
     * Removes the cmm cache with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param cmmId the primary key of the cmm cache
     * @return the cmm cache that was removed
     * @throws com.axa.portal.esp.services.SB.NoSuchCacheException if a cmm cache with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public cmmCache remove(long cmmId)
        throws NoSuchCacheException, SystemException {
        return remove((Serializable) cmmId);
    }

    /**
     * Removes the cmm cache with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the cmm cache
     * @return the cmm cache that was removed
     * @throws com.axa.portal.esp.services.SB.NoSuchCacheException if a cmm cache with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public cmmCache remove(Serializable primaryKey)
        throws NoSuchCacheException, SystemException {
        Session session = null;

        try {
            session = openSession();

            cmmCache cmmCache = (cmmCache) session.get(cmmCacheImpl.class,
                    primaryKey);

            if (cmmCache == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchCacheException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(cmmCache);
        } catch (NoSuchCacheException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected cmmCache removeImpl(cmmCache cmmCache) throws SystemException {
        cmmCache = toUnwrappedModel(cmmCache);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(cmmCache)) {
                cmmCache = (cmmCache) session.get(cmmCacheImpl.class,
                        cmmCache.getPrimaryKeyObj());
            }

            if (cmmCache != null) {
                session.delete(cmmCache);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (cmmCache != null) {
            clearCache(cmmCache);
        }

        return cmmCache;
    }

    @Override
    public cmmCache updateImpl(
        com.axa.portal.esp.services.SB.model.cmmCache cmmCache)
        throws SystemException {
        cmmCache = toUnwrappedModel(cmmCache);

        boolean isNew = cmmCache.isNew();

        Session session = null;

        try {
            session = openSession();

            if (cmmCache.isNew()) {
                session.save(cmmCache);

                cmmCache.setNew(false);
            } else {
                session.merge(cmmCache);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !cmmCacheModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(cmmCacheModelImpl.ENTITY_CACHE_ENABLED,
            cmmCacheImpl.class, cmmCache.getPrimaryKey(), cmmCache);

        clearUniqueFindersCache(cmmCache);
        cacheUniqueFindersCache(cmmCache);

        return cmmCache;
    }

    protected cmmCache toUnwrappedModel(cmmCache cmmCache) {
        if (cmmCache instanceof cmmCacheImpl) {
            return cmmCache;
        }

        cmmCacheImpl cmmCacheImpl = new cmmCacheImpl();

        cmmCacheImpl.setNew(cmmCache.isNew());
        cmmCacheImpl.setPrimaryKey(cmmCache.getPrimaryKey());

        cmmCacheImpl.setCmmId(cmmCache.getCmmId());
        cmmCacheImpl.setHashKey(cmmCache.getHashKey());
        cmmCacheImpl.setHashValue(cmmCache.getHashValue());
        cmmCacheImpl.setHashDateUpdate(cmmCache.getHashDateUpdate());

        return cmmCacheImpl;
    }

    /**
     * Returns the cmm cache with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the cmm cache
     * @return the cmm cache
     * @throws com.axa.portal.esp.services.SB.NoSuchCacheException if a cmm cache with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public cmmCache findByPrimaryKey(Serializable primaryKey)
        throws NoSuchCacheException, SystemException {
        cmmCache cmmCache = fetchByPrimaryKey(primaryKey);

        if (cmmCache == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchCacheException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return cmmCache;
    }

    /**
     * Returns the cmm cache with the primary key or throws a {@link com.axa.portal.esp.services.SB.NoSuchCacheException} if it could not be found.
     *
     * @param cmmId the primary key of the cmm cache
     * @return the cmm cache
     * @throws com.axa.portal.esp.services.SB.NoSuchCacheException if a cmm cache with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public cmmCache findByPrimaryKey(long cmmId)
        throws NoSuchCacheException, SystemException {
        return findByPrimaryKey((Serializable) cmmId);
    }

    /**
     * Returns the cmm cache with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the cmm cache
     * @return the cmm cache, or <code>null</code> if a cmm cache with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public cmmCache fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        cmmCache cmmCache = (cmmCache) EntityCacheUtil.getResult(cmmCacheModelImpl.ENTITY_CACHE_ENABLED,
                cmmCacheImpl.class, primaryKey);

        if (cmmCache == _nullcmmCache) {
            return null;
        }

        if (cmmCache == null) {
            Session session = null;

            try {
                session = openSession();

                cmmCache = (cmmCache) session.get(cmmCacheImpl.class, primaryKey);

                if (cmmCache != null) {
                    cacheResult(cmmCache);
                } else {
                    EntityCacheUtil.putResult(cmmCacheModelImpl.ENTITY_CACHE_ENABLED,
                        cmmCacheImpl.class, primaryKey, _nullcmmCache);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(cmmCacheModelImpl.ENTITY_CACHE_ENABLED,
                    cmmCacheImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return cmmCache;
    }

    /**
     * Returns the cmm cache with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param cmmId the primary key of the cmm cache
     * @return the cmm cache, or <code>null</code> if a cmm cache with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public cmmCache fetchByPrimaryKey(long cmmId) throws SystemException {
        return fetchByPrimaryKey((Serializable) cmmId);
    }

    /**
     * Returns all the cmm caches.
     *
     * @return the cmm caches
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<cmmCache> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the cmm caches.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.axa.portal.esp.services.SB.model.impl.cmmCacheModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of cmm caches
     * @param end the upper bound of the range of cmm caches (not inclusive)
     * @return the range of cmm caches
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<cmmCache> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the cmm caches.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.axa.portal.esp.services.SB.model.impl.cmmCacheModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of cmm caches
     * @param end the upper bound of the range of cmm caches (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of cmm caches
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<cmmCache> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<cmmCache> list = (List<cmmCache>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CMMCACHE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CMMCACHE;

                if (pagination) {
                    sql = sql.concat(cmmCacheModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<cmmCache>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<cmmCache>(list);
                } else {
                    list = (List<cmmCache>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the cmm caches from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (cmmCache cmmCache : findAll()) {
            remove(cmmCache);
        }
    }

    /**
     * Returns the number of cmm caches.
     *
     * @return the number of cmm caches
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_CMMCACHE);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the cmm cache persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.axa.portal.esp.services.SB.model.cmmCache")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<cmmCache>> listenersList = new ArrayList<ModelListener<cmmCache>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<cmmCache>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(cmmCacheImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
