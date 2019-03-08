package com.axa.portal.esp.services.SB.model.impl;

import com.axa.portal.esp.services.SB.model.cmmCache;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing cmmCache in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see cmmCache
 * @generated
 */
public class cmmCacheCacheModel implements CacheModel<cmmCache>, Externalizable {
    public long cmmId;
    public String hashKey;
    public String hashValue;
    public long hashDateUpdate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{cmmId=");
        sb.append(cmmId);
        sb.append(", hashKey=");
        sb.append(hashKey);
        sb.append(", hashValue=");
        sb.append(hashValue);
        sb.append(", hashDateUpdate=");
        sb.append(hashDateUpdate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public cmmCache toEntityModel() {
        cmmCacheImpl cmmCacheImpl = new cmmCacheImpl();

        cmmCacheImpl.setCmmId(cmmId);

        if (hashKey == null) {
            cmmCacheImpl.setHashKey(StringPool.BLANK);
        } else {
            cmmCacheImpl.setHashKey(hashKey);
        }

        if (hashValue == null) {
            cmmCacheImpl.setHashValue(StringPool.BLANK);
        } else {
            cmmCacheImpl.setHashValue(hashValue);
        }

        if (hashDateUpdate == Long.MIN_VALUE) {
            cmmCacheImpl.setHashDateUpdate(null);
        } else {
            cmmCacheImpl.setHashDateUpdate(new Date(hashDateUpdate));
        }

        cmmCacheImpl.resetOriginalValues();

        return cmmCacheImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        cmmId = objectInput.readLong();
        hashKey = objectInput.readUTF();
        hashValue = objectInput.readUTF();
        hashDateUpdate = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(cmmId);

        if (hashKey == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(hashKey);
        }

        if (hashValue == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(hashValue);
        }

        objectOutput.writeLong(hashDateUpdate);
    }
}
