package com.cily.uitest.web.interceptor;

import com.cily.uitest.web.conf.Param;
import com.cily.utils.base.StrUtils;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * Created by admin on 2018/2/6.
 */
public class DeviceImeiInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation inv) {
        String deviceImei = inv.getController().getHeader(Param.DEVICE_IMEI);
        if (StrUtils.isEmpty(deviceImei)){
//            deviceImei = ip
        }

        inv.getController().setAttr(Param.DEVICE_IMEI, deviceImei);
        inv.invoke();
    }
}