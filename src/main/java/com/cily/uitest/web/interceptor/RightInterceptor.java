package com.cily.uitest.web.interceptor;

import com.cily.uitest.web.conf.Param;
import com.cily.uitest.web.model.UserRoleModel;
import com.cily.uitest.web.utils.ResUtils;
import com.cily.uitest.web.utils.TokenUtils;
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

        String accessUrl = inv.getActionKey();

        if (UserRoleModel.isAccessToUrl(userId, accessUrl)) {
            inv.invoke();
        }else {
            ResUtils.res(Param.C_RIGHT_LOW,
                    createTokenByOs(inv), null);
            return;
        }
    }
}
