package com.cily.uitest.web.interceptor;

import com.cily.uitest.web.conf.Param;
import com.cily.uitest.web.conf.SQLParam;
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

        String accessUrl = inv.getActionKey();

        UserRoleModel m = UserRoleModel.getUserRoleRight(userId, accessUrl);
        if (m == null){
            inv.getController().renderJson(ResUtils.res(
                    Param.C_RIGHT_LOW, createTokenByOs(inv), null));
            return;
        }
        if (SQLParam.STATUS_ENABLE.equals(m.get(SQLParam.STATUS))){
            inv.invoke();
        }else {
            inv.getController().renderJson(ResUtils.res(
                    Param.C_RIGHT_REFUSE, createTokenByOs(inv), null));
        }
    }
}
