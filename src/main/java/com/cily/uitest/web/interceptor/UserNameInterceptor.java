package com.cily.uitest.web.interceptor;

import com.cily.uitest.web.conf.Param;
import com.cily.uitest.web.conf.SQLParam;
import com.cily.uitest.web.utils.ResUtils;
import com.cily.uitest.web.utils.TokenUtils;
import com.cily.utils.base.StrUtils;
import com.jfinal.aop.Invocation;

/**
 * Created by admin on 2018/2/5.
 */
public class UserNameInterceptor extends BaseInterceptor {
    @Override
    public void intercept(Invocation inv) {
        String userName = getParam(inv, SQLParam.USER_NAME, null);
        String deviceImei = getDeviceImeiFromAttr(inv);
        String userId = getParam(inv, SQLParam.USER_ID, null);

        if (StrUtils.isEmpty(deviceImei)){
            //客户端ip

        }
        String token = getToken(inv);

        if (StrUtils.isEmpty(userName)){
            inv.getController().renderJson(ResUtils.res(Param.C_USER_NAME_NULL,
                    TokenUtils.createToken(userId, deviceImei, token),null));
        }else {
            inv.invoke();
        }
    }
}
