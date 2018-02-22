package com.cily.uitest.web.model;

import com.cily.uitest.web.conf.SQLParam;
import com.cily.utils.base.StrUtils;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;

/**
 * Created by admin on 2018/2/22.
 */
public class UserRoleModel extends Model<UserRoleModel> {
    private static UserRoleModel dao = new UserRoleModel();

    public static boolean insertUserRole(String userId, String roleId){
        if (StrUtils.isEmpty(userId) || StrUtils.isEmpty(roleId)){
            return false;
        }
        UserRoleModel m = new UserRoleModel();
        m.set(SQLParam.USER_ID, userId);
        m.set(SQLParam.ROLE_ID, roleId);
        return m.save();
    }

    public static boolean delByUserId(String userId){
        if (StrUtils.isEmpty(userId)){
            return false;
        }
        return Db.delete(StrUtils.join("delete from ",
                SQLParam.T_USER_ROLE, " where ",
                SQLParam.USER_ID, " = '", userId, "';")) > 0;

    }

    public static boolean delByRoleId(String roleId){
        if (StrUtils.isEmpty(roleId)){
            return false;
        }
        return Db.delete(StrUtils.join("delete from ",
                SQLParam.T_USER_ROLE, " where ",
                SQLParam.ROLE_ID, " = '", roleId, "';")) > 0;

    }

    public static boolean delByUserIdAndRoleId(String userId,
                                               String roleId){
        if (StrUtils.isEmpty(userId) || StrUtils.isEmpty(roleId)){
            return false;
        }
        return Db.delete(StrUtils.join("delete from ",
                SQLParam.T_USER_ROLE, " where ",
                SQLParam.ROLE_ID, " = '", roleId, "' and ",
                SQLParam.USER_ID, "= '", userId, "';")) > 0;

    }
}