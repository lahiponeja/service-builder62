package com.axa.portal.esp.services.SB.service.base;

import com.axa.portal.esp.services.SB.service.cmmCacheServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class cmmCacheServiceClpInvoker {
    private String _methodName30;
    private String[] _methodParameterTypes30;
    private String _methodName31;
    private String[] _methodParameterTypes31;

    public cmmCacheServiceClpInvoker() {
        _methodName30 = "getBeanIdentifier";

        _methodParameterTypes30 = new String[] {  };

        _methodName31 = "setBeanIdentifier";

        _methodParameterTypes31 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName30.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
            return cmmCacheServiceUtil.getBeanIdentifier();
        }

        if (_methodName31.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
            cmmCacheServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
