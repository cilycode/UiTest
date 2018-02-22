package com.cily.uitest.web.controller;

import com.cily.uitest.web.conf.Param;
import com.cily.uitest.web.conf.SQLParam;
import com.jfinal.core.Controller;

/**
 * Created by admin on 2018/2/22.
 */
public class BaseController extends Controller {

    protected String getDeviceImei(){
        return getAttr(Param.DEVICE_IMEI);
    }

    protected String getParam(String paramKey, String defValue){
        return getPara(paramKey, defValue);
    }
    protected String getParam(String paramKey){
        return getParam(paramKey, null);
    }

    protected String getToken(){
        return getHeader(SQLParam.TOKEN);
    }

    protected String getUserId(){
        return getHeader(SQLParam.USER_ID);
    }

}
