package com.cily.uitest.web.model;

import com.cily.uitest.web.conf.Param;
import com.cily.uitest.web.conf.SQLParam;
import com.cily.utils.base.StrUtils;
import com.jfinal.plugin.activerecord.Model;

/**
 * Created by admin on 2018/2/11.
 */
public class TokenModel extends Model<TokenModel> {
    private static TokenModel dao = new TokenModel();

    public static boolean insert(String userId, String token){
        TokenModel m = new TokenModel();
        m.set(SQLParam.USER_ID, userId);
        m.set(SQLParam.TOKEN, token);
        m.set(SQLParam.UPDATE_TIME, System.currentTimeMillis());
        return m.save();
    }

    public static boolean updateByUserId(String userId, String token){
        TokenModel m = dao.findById(SQLParam.USER_ID);
        if (m == null){
            m = new TokenModel();
            m.set(SQLParam.USER_ID, userId);
            m.set(SQLParam.TOKEN, token);
            m.set(SQLParam.UPDATE_TIME, System.currentTimeMillis());
            return m.save();
        }else {
            m.set(SQLParam.TOKEN, token);
            m.set(SQLParam.UPDATE_TIME, System.currentTimeMillis());
            return m.update();
        }
    }

//    public static String getTokenByUserId(String userId, String deviceImei){
//        TokenModel m = dao.findById(SQLParam.USER_ID);
//
//        if (m == null){
//            return Param.C_USER_NOT_LOGIN;
//        }else {
//            String token = m.get(SQLParam.TOKEN, null);
//            if (StrUtils.isEmpty(token)){
//                return Param.C_USER_NOT_LOGIN;
//            }else {
//                long updateTime = m.get(SQLParam.UPDATE_TIME, 0);
//
//            }
//        }
//    }

}
