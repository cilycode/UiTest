package com.cily.uitest.web.conf;

import com.cily.utils.base.StrUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2018/1/30.
 */
public class Param {
    public final static String DEVICE_IMEI = "deviceImei";

    public final static String PAGE_NUMBER = "pageNumber";
    public final static String PAGE_SIZE = "pageSize";


    //错误码规则：0成功；1~99系统错误；1001~1999用户相关错误
    public final static String C_SUCCESS = "0";

    public final static String C_SERVER_ERROR = "11";

    public final static String C_USER_NOT_LOGIN = "1002";
    public final static String C_USER_NOT_EXIST = "1001";
    public final static String C_USER_OR_PWD_ERROR = "1006";
    public final static String C_USER_NAME_NULL = "1011";


    public final static String C_RESIGT_USER_EXISTS = "1101";
    public final static String C_REGIST_FAILURE = "1106";


    public final static String C_USER_ID_NULL = "1111";
    public final static String C_TOKEN_NULL = "1112";
    public final static String C_TOKEN_ERROR = "1113";

    public final static String C_USER_INFO_UPDATE_FAILURE = "1121";
    public final static String C_USER_INFO_NO_UPDATE = "1122";

    private final static Map<String, String> failureInfo = new HashMap<>();
    static {
        failureInfo.put(C_SUCCESS, "操作成功");
        failureInfo.put(C_SERVER_ERROR, "系统内部异常");
        failureInfo.put(C_USER_NOT_EXIST, "用户不存在");
        failureInfo.put(C_USER_OR_PWD_ERROR, "用户名或密码错误");
        failureInfo.put(C_USER_NAME_NULL, "用户名为空");
        failureInfo.put(C_RESIGT_USER_EXISTS, "该账号已存在");
        failureInfo.put(C_REGIST_FAILURE, "注册失败");
        failureInfo.put(C_USER_ID_NULL, "用户id为空");
        failureInfo.put(C_TOKEN_NULL, "token为空");
        failureInfo.put(C_TOKEN_ERROR, "用户未登录或登录已失效");
        failureInfo.put(C_USER_INFO_UPDATE_FAILURE, "更新用户信息失败");
        failureInfo.put(C_USER_INFO_NO_UPDATE, "用户信息无更新");
        failureInfo.put(C_USER_NOT_LOGIN, "该用户未登录");
//        failureInfo.put(, );
//        failureInfo.put(, );
//        failureInfo.put(, );
//        failureInfo.put(, );
//        failureInfo.put(, );
//        failureInfo.put(, );
//        failureInfo.put(, );
    }
    public final static String getMsg(String code){
        if (StrUtils.isEmpty(code)){
            code = C_SERVER_ERROR;
        }
        return failureInfo.get(code);
    }
}