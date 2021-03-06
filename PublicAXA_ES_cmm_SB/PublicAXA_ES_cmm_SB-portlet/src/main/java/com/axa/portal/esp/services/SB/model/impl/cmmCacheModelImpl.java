package com.axa.portal.esp.services.SB.model.impl;

import com.axa.portal.esp.services.SB.model.cmmCache;
import com.axa.portal.esp.services.SB.model.cmmCacheModel;
import com.axa.portal.esp.services.SB.model.cmmCacheSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the cmmCache service. Represents a row in the &quot;cmm_cmmCache&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.axa.portal.esp.services.SB.model.cmmCacheModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link cmmCacheImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see cmmCacheImpl
 * @see com.axa.portal.esp.services.SB.model.cmmCache
 * @see com.axa.portal.esp.services.SB.model.cmmCacheModel
 * @generated
 */
@JSON(strict = true)
public class cmmCacheModelImpl extends BaseModelImpl<cmmCache>
    implements cmmCacheModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a cmm cache model instance should use the {@link com.axa.portal.esp.services.SB.model.cmmCache} interface instead.
     */
    public static final String TABLE_NAME = "cmm_cmmCache";
    public static final Object[][] TABLE_COLUMNS = {
            { "cmmId", Types.BIGINT },
            { "hashKey", Types.VARCHAR },
            { "hashValue", Types.VARCHAR },
            { "hashDateUpdate", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table cmm_cmmCache (cmmId LONG not null primary key,hashKey VARCHAR(75) null,hashValue VARCHAR(75) null,hashDateUpdate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table cmm_cmmCache";
    public static final String ORDER_BY_JPQL = " ORDER BY cmmCache.hashKey ASC";
    public static final String ORDER_BY_SQL = " ORDER BY cmm_cmmCache.hashKey ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.axa.portal.esp.services.SB.model.cmmCache"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.axa.portal.esp.services.SB.model.cmmCache"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.axa.portal.esp.services.SB.model.cmmCache"),
            true);
    public static long CMMID_COLUMN_BITMASK = 1L;
    public static long HASHKEY_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.axa.portal.esp.services.SB.model.cmmCache"));
    private static ClassLoader _classLoader = cmmCache.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            cmmCache.class
        };
    private long _cmmId;
    private long _originalCmmId;
    private boolean _setOriginalCmmId;
    private String _hashKey;
    private String _originalHashKey;
    private String _hashValue;
    private Date _hashDateUpdate;
    private long _columnBitmask;
    private cmmCache _escapedModel;

    public cmmCacheModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static cmmCache toModel(cmmCacheSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        cmmCache model = new cmmCacheImpl();

        model.setCmmId(soapModel.getCmmId());
        model.setHashKey(soapModel.getHashKey());
        model.setHashValue(soapModel.getHashValue());
        model.setHashDateUpdate(soapModel.getHashDateUpdate());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<cmmCache> toModels(cmmCacheSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<cmmCache> models = new ArrayList<cmmCache>(soapModels.length);

        for (cmmCacheSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _cmmId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setCmmId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _cmmId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return cmmCache.class;
    }

    @Override
    public String getModelClassName() {
        return cmmCache.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("cmmId", getCmmId());
        attributes.put("hashKey", getHashKey());
        attributes.put("hashValue", getHashValue());
        attributes.put("hashDateUpdate", getHashDateUpdate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long cmmId = (Long) attributes.get("cmmId");

        if (cmmId != null) {
            setCmmId(cmmId);
        }

        String hashKey = (String) attributes.get("hashKey");

        if (hashKey != null) {
            setHashKey(hashKey);
        }

        String hashValue = (String) attributes.get("hashValue");

        if (hashValue != null) {
            setHashValue(hashValue);
        }

        Date hashDateUpdate = (Date) attributes.get("hashDateUpdate");

        if (hashDateUpdate != null) {
            setHashDateUpdate(hashDateUpdate);
        }
    }

    @JSON
    @Override
    public long getCmmId() {
        return _cmmId;
    }

    @Override
    public void setCmmId(long cmmId) {
        _columnBitmask |= CMMID_COLUMN_BITMASK;

        if (!_setOriginalCmmId) {
            _setOriginalCmmId = true;

            _originalCmmId = _cmmId;
        }

        _cmmId = cmmId;
    }

    public long getOriginalCmmId() {
        return _originalCmmId;
    }

    @JSON
    @Override
    public String getHashKey() {
        if (_hashKey == null) {
            return StringPool.BLANK;
        } else {
            return _hashKey;
        }
    }

    @Override
    public void setHashKey(String hashKey) {
        _columnBitmask = -1L;

        if (_originalHashKey == null) {
            _originalHashKey = _hashKey;
        }

        _hashKey = hashKey;
    }

    public String getOriginalHashKey() {
        return GetterUtil.getString(_originalHashKey);
    }

    @JSON
    @Override
    public String getHashValue() {
        if (_hashValue == null) {
            return StringPool.BLANK;
        } else {
            return _hashValue;
        }
    }

    @Override
    public void setHashValue(String hashValue) {
        _hashValue = hashValue;
    }

    @JSON
    @Override
    public Date getHashDateUpdate() {
        return _hashDateUpdate;
    }

    @Override
    public void setHashDateUpdate(Date hashDateUpdate) {
        _hashDateUpdate = hashDateUpdate;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            cmmCache.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public cmmCache toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (cmmCache) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        cmmCacheImpl cmmCacheImpl = new cmmCacheImpl();

        cmmCacheImpl.setCmmId(getCmmId());
        cmmCacheImpl.setHashKey(getHashKey());
        cmmCacheImpl.setHashValue(getHashValue());
        cmmCacheImpl.setHashDateUpdate(getHashDateUpdate());

        cmmCacheImpl.resetOriginalValues();

        return cmmCacheImpl;
    }

    @Override
    public int compareTo(cmmCache cmmCache) {
        int value = 0;

        value = getHashKey().compareTo(cmmCache.getHashKey());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof cmmCache)) {
            return false;
        }

        cmmCache cmmCache = (cmmCache) obj;

        long primaryKey = cmmCache.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        cmmCacheModelImpl cmmCacheModelImpl = this;

        cmmCacheModelImpl._originalCmmId = cmmCacheModelImpl._cmmId;

        cmmCacheModelImpl._setOriginalCmmId = false;

        cmmCacheModelImpl._originalHashKey = cmmCacheModelImpl._hashKey;

        cmmCacheModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<cmmCache> toCacheModel() {
        cmmCacheCacheModel cmmCacheCacheModel = new cmmCacheCacheModel();

        cmmCacheCacheModel.cmmId = getCmmId();

        cmmCacheCacheModel.hashKey = getHashKey();

        String hashKey = cmmCacheCacheModel.hashKey;

        if ((hashKey != null) && (hashKey.length() == 0)) {
            cmmCacheCacheModel.hashKey = null;
        }

        cmmCacheCacheModel.hashValue = getHashValue();

        String hashValue = cmmCacheCacheModel.hashValue;

        if ((hashValue != null) && (hashValue.length() == 0)) {
            cmmCacheCacheModel.hashValue = null;
        }

        Date hashDateUpdate = getHashDateUpdate();

        if (hashDateUpdate != null) {
            cmmCacheCacheModel.hashDateUpdate = hashDateUpdate.getTime();
        } else {
            cmmCacheCacheModel.hashDateUpdate = Long.MIN_VALUE;
        }

        return cmmCacheCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{cmmId=");
        sb.append(getCmmId());
        sb.append(", hashKey=");
        sb.append(getHashKey());
        sb.append(", hashValue=");
        sb.append(getHashValue());
        sb.append(", hashDateUpdate=");
        sb.append(getHashDateUpdate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("com.axa.portal.esp.services.SB.model.cmmCache");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>cmmId</column-name><column-value><![CDATA[");
        sb.append(getCmmId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>hashKey</column-name><column-value><![CDATA[");
        sb.append(getHashKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>hashValue</column-name><column-value><![CDATA[");
        sb.append(getHashValue());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>hashDateUpdate</column-name><column-value><![CDATA[");
        sb.append(getHashDateUpdate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
