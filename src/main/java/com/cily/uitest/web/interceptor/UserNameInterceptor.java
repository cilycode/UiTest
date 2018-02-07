package com.cily.uitest.web.interceptor;

import com.cily.uitest.web.conf.Param;
import com.cily.uitest.web.conf.SQLParam;
import com.cily.uitest.web.utils.ResUtils;
import com.cily.uitest.web.utils.TokenUtils;
import com.cily.utils.base.StrUtils;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * Created by admin on 2018/2/5.
 */
public class UserNameInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        String userName = inv.getController().getPara(SQLParam.USER_NAME, null);
        String deviceImei = inv.getController().getHeader(Param.DEVICE_IMEI);
        String userId = inv.getController().getPara(SQLParam.USER_ID, null);

        if (StrUtils.isEmpty(deviceImei)){
            //客户端ip

        }
        String token = inv.getController().getHeader(Param.TOKEN);

        if (StrUtils.isEmpty(userName)){
            inv.getController().renderJson(ResUtils.res(Param.C_USER_NAME_NULL,
                    TokenUtils.createToken(userId, deviceImei, token),null));
        }else {
            inv.invoke();
        }
    }
}
