package com.cily.uitest.web.interceptor;

import com.jfinal.aop.Invocation;

/**
 * Created by admin on 2018/2/22.
 */
public class RightInterceptor extends BaseInterceptor {

    @Override
    public void intercept(Invocation inv) {
        String userId = getUserId(inv);
        String token = getToken(inv);
        String deviceImei = getDeviceImeiFromAttr(inv);



    }
}
