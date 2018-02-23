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
public class SysUserController extends BaseController {

    public void addUser(){
        UserUtils.regist(this, getUserId(),
                getParam(SQLParam.STATUS, SQLParam.STATUS_ENABLE));
    }

    public void updateUserInfo(){
        UserUtils.updateUserInfo(this, getParam(SQLParam.USER_ID),
                getParam(SQLParam.STATUS));
    }

    public void getUsers(){
        String token = getToken();
        String deviceImei = getDeviceImei();

        int pageNumber = getParaToInt(Param.PAGE_NUMBER, 1);
        int pageSize = getParaToInt(Param.PAGE_SIZE, 10);



        renderJson(ResUtils.success(createTokenByOs(),
                UserModel.getUsersByStatus(getParam(SQLParam.STATUS), pageNumber, pageSize)));
    }
}