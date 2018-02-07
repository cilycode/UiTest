package com.cily.uitest.web.controller;

import com.cily.uitest.web.conf.Param;
import com.cily.uitest.web.conf.SQLParam;
import com.cily.uitest.web.interceptor.LoginedInterceptor;
import com.cily.uitest.web.model.UserModel;
import com.cily.uitest.web.utils.UserUtils;
import com.cily.uitest.web.utils.ResUtils;
import com.cily.uitest.web.utils.TokenUtils;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;

/**
 * Created by admin on 2018/1/30.
 */

public class UserController extends Controller {
    @Clear({LoginedInterceptor.class})
    public void login(){
        String userName = getPara(SQLParam.USER_NAME);
        String pwd = getPara(SQLParam.PWD);

        String deviceImei = getAttr(Param.DEVICE_IMEI);

        UserModel um = UserModel.getUserByUserName(userName);
        if (um == null){
            renderJson(ResUtils.res(Param.C_USER_NOT_EXIST, null, null));
            return;
        }
        if (pwd.equals(um.get(SQLParam.PWD))){
            um.remove(SQLParam.PWD);
            String token = TokenUtils.createToken(um.get(SQLParam.USER_ID), deviceImei, null);
            renderJson(ResUtils.success(token, um));
            return;
        }else {
            renderJson(ResUtils.res(Param.C_USER_OR_PWD_ERROR, null, null));
            return;
        }
    }

    @Clear({LoginedInterceptor.class})
    public void regist(){
        UserUtils.regist(this, null, null);
    }

    public void updateUserInfo(){
        UserUtils.updateUserInfo(this, getHeader(SQLParam.USER_ID), null);
    }
}