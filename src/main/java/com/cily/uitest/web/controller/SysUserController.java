package com.cily.uitest.web.controller;

import com.cily.uitest.web.conf.Param;
import com.cily.uitest.web.conf.SQLParam;
import com.cily.uitest.web.model.UserModel;
import com.cily.uitest.web.utils.ResUtils;
import com.cily.uitest.web.utils.TokenUtils;
import com.cily.uitest.web.utils.UserUtils;
import com.cily.utils.base.StrUtils;
import com.jfinal.core.Controller;

/**
 * Created by admin on 2018/2/5.
 */
public class SysUserController extends Controller {

    public void addUser(){
        UserUtils.regist(this, getHeader(SQLParam.USER_ID),
                getPara(SQLParam.STATUS, SQLParam.STATUS_ENABLE));
    }

    public void updateUserInfo(){
        UserUtils.updateUserInfo(this, getPara(SQLParam.USER_ID, null),
                getPara(SQLParam.STATUS, null));
    }

    public void getUsers(){
        String token = getHeader(SQLParam.TOKEN);
        String deviceImei = getAttr(Param.DEVICE_IMEI);

        int pageNumber = getParaToInt(Param.PAGE_NUMBER, 1);
        int pageSize = getParaToInt(Param.PAGE_SIZE, 10);



        renderJson(ResUtils.success(TokenUtils.createToken(
                getHeader(SQLParam.USER_ID), deviceImei, token),
                UserModel.getUsersByStatus(getPara(SQLParam.STATUS, null), pageNumber, pageSize)));
    }
}