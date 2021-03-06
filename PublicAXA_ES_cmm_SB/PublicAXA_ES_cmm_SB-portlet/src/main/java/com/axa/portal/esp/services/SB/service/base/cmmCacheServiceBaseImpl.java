package com.axa.portal.esp.services.SB.service.base;

import com.axa.portal.esp.services.SB.model.cmmCache;
import com.axa.portal.esp.services.SB.service.cmmCacheService;
import com.axa.portal.esp.services.SB.service.persistence.cmmCachePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.asset.service.persistence.AssetTagPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the cmm cache remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.axa.portal.esp.services.SB.service.impl.cmmCacheServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.axa.portal.esp.services.SB.service.impl.cmmCacheServiceImpl
 * @see com.axa.portal.esp.services.SB.service.cmmCacheServiceUtil
 * @generated
 */
public abstract class cmmCacheServiceBaseImpl extends BaseServiceImpl
    implements cmmCacheService, IdentifiableBean {
    @BeanReference(type = com.axa.portal.esp.services.SB.service.cmmCacheLocalService.class)
    protected com.axa.portal.esp.services.SB.service.cmmCacheLocalService cmmCacheLocalService;
    @BeanReference(type = com.axa.portal.esp.services.SB.service.cmmCacheService.class)
    protected com.axa.portal.esp.services.SB.service.cmmCacheService cmmCacheService;
    @BeanReference(type = cmmCachePersistence.class)
    protected cmmCachePersistence cmmCachePersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    @BeanReference(type = com.liferay.portlet.asset.service.AssetEntryLocalService.class)
    protected com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService;
    @BeanReference(type = com.liferay.portlet.asset.service.AssetEntryService.class)
    protected com.liferay.portlet.asset.service.AssetEntryService assetEntryService;
    @BeanReference(type = AssetEntryPersistence.class)
    protected AssetEntryPersistence assetEntryPersistence;
    @BeanReference(type = com.liferay.portlet.asset.service.AssetTagLocalService.class)
    protected com.liferay.portlet.asset.service.AssetTagLocalService assetTagLocalService;
    @BeanReference(type = com.liferay.portlet.asset.service.AssetTagService.class)
    protected com.liferay.portlet.asset.service.AssetTagService assetTagService;
    @BeanReference(type = AssetTagPersistence.class)
    protected AssetTagPersistence assetTagPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private cmmCacheServiceClpInvoker _clpInvoker = new cmmCacheServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.axa.portal.esp.services.SB.service.cmmCacheServiceUtil} to access the cmm cache remote service.
     */

    /**
     * Returns the cmm cache local service.
     *
     * @return the cmm cache local service
     */
    public com.axa.portal.esp.services.SB.service.cmmCacheLocalService getcmmCacheLocalService() {
        return cmmCacheLocalService;
    }

    /**
     * Sets the cmm cache local service.
     *
     * @param cmmCacheLocalService the cmm cache local service
     */
    public void setcmmCacheLocalService(
        com.axa.portal.esp.services.SB.service.cmmCacheLocalService cmmCacheLocalService) {
        this.cmmCacheLocalService = cmmCacheLocalService;
    }

    /**
     * Returns the cmm cache remote service.
     *
     * @return the cmm cache remote service
     */
    public com.axa.portal.esp.services.SB.service.cmmCacheService getcmmCacheService() {
        return cmmCacheService;
    }

    /**
     * Sets the cmm cache remote service.
     *
     * @param cmmCacheService the cmm cache remote service
     */
    public void setcmmCacheService(
        com.axa.portal.esp.services.SB.service.cmmCacheService cmmCacheService) {
        this.cmmCacheService = cmmCacheService;
    }

    /**
     * Returns the cmm cache persistence.
     *
     * @return the cmm cache persistence
     */
    public cmmCachePersistence getcmmCachePersistence() {
        return cmmCachePersistence;
    }

    /**
     * Sets the cmm cache persistence.
     *
     * @param cmmCachePersistence the cmm cache persistence
     */
    public void setcmmCachePersistence(cmmCachePersistence cmmCachePersistence) {
        this.cmmCachePersistence = cmmCachePersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    /**
     * Returns the asset entry local service.
     *
     * @return the asset entry local service
     */
    public com.liferay.portlet.asset.service.AssetEntryLocalService getAssetEntryLocalService() {
        return assetEntryLocalService;
    }

    /**
     * Sets the asset entry local service.
     *
     * @param assetEntryLocalService the asset entry local service
     */
    public void setAssetEntryLocalService(
        com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService) {
        this.assetEntryLocalService = assetEntryLocalService;
    }

    /**
     * Returns the asset entry remote service.
     *
     * @return the asset entry remote service
     */
    public com.liferay.portlet.asset.service.AssetEntryService getAssetEntryService() {
        return assetEntryService;
    }

    /**
     * Sets the asset entry remote service.
     *
     * @param assetEntryService the asset entry remote service
     */
    public void setAssetEntryService(
        com.liferay.portlet.asset.service.AssetEntryService assetEntryService) {
        this.assetEntryService = assetEntryService;
    }

    /**
     * Returns the asset entry persistence.
     *
     * @return the asset entry persistence
     */
    public AssetEntryPersistence getAssetEntryPersistence() {
        return assetEntryPersistence;
    }

    /**
     * Sets the asset entry persistence.
     *
     * @param assetEntryPersistence the asset entry persistence
     */
    public void setAssetEntryPersistence(
        AssetEntryPersistence assetEntryPersistence) {
        this.assetEntryPersistence = assetEntryPersistence;
    }

    /**
     * Returns the asset tag local service.
     *
     * @return the asset tag local service
     */
    public com.liferay.portlet.asset.service.AssetTagLocalService getAssetTagLocalService() {
        return assetTagLocalService;
    }

    /**
     * Sets the asset tag local service.
     *
     * @param assetTagLocalService the asset tag local service
     */
    public void setAssetTagLocalService(
        com.liferay.portlet.asset.service.AssetTagLocalService assetTagLocalService) {
        this.assetTagLocalService = assetTagLocalService;
    }

    /**
     * Returns the asset tag remote service.
     *
     * @return the asset tag remote service
     */
    public com.liferay.portlet.asset.service.AssetTagService getAssetTagService() {
        return assetTagService;
    }

    /**
     * Sets the asset tag remote service.
     *
     * @param assetTagService the asset tag remote service
     */
    public void setAssetTagService(
        com.liferay.portlet.asset.service.AssetTagService assetTagService) {
        this.assetTagService = assetTagService;
    }

    /**
     * Returns the asset tag persistence.
     *
     * @return the asset tag persistence
     */
    public AssetTagPersistence getAssetTagPersistence() {
        return assetTagPersistence;
    }

    /**
     * Sets the asset tag persistence.
     *
     * @param assetTagPersistence the asset tag persistence
     */
    public void setAssetTagPersistence(AssetTagPersistence assetTagPersistence) {
        this.assetTagPersistence = assetTagPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();
    }

    public void destroy() {
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return cmmCache.class;
    }

    protected String getModelClassName() {
        return cmmCache.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = cmmCachePersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
