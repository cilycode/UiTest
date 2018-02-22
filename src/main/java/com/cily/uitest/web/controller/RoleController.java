package com.cily.uitest.web.controller;

import com.cily.uitest.web.conf.Param;
import com.cily.uitest.web.conf.SQLParam;
import com.cily.uitest.web.utils.ResUtils;
import com.cily.uitest.web.utils.TokenUtils;
import com.cily.utils.base.StrUtils;
import com.jfinal.core.Controller;

/**
 * Created by admin on 2018/2/22.
 */
public class RoleController extends BaseController {

    public void addRole(){
        String roleName = getParam(SQLParam.ROLE_NAME);
        String des = getParam(SQLParam.DES);
        if (StrUtils.isEmpty(roleName)){
            renderJson(ResUtils.res(Param.C_ROLE_NAME_NULL,
                    TokenUtils.createToken(getUserId(),
                            getDeviceImei(), getToken()), null));
            return;
        }
    }
}