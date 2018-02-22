package com.cily.uitest.web.model;

import com.cily.uitest.web.conf.SQLParam;
import com.cily.utils.base.StrUtils;
import com.cily.utils.base.UUIDUtils;
import com.jfinal.plugin.activerecord.Model;

/**
 * Created by admin on 2018/2/22.
 */
public class RoleModel extends Model<RoleModel> {
    private static RoleModel dao = new RoleModel();

    public boolean insert(String roleName, String des){
        if (StrUtils.isEmpty(roleName)){
            return false;
        }
        RoleModel m = new RoleModel();
        m.set(SQLParam.ROLE_ID, UUIDUtils.getUUID());
        m.set(SQLParam.ROLE_NAME, roleName);
        if (!StrUtils.isEmpty(des)){
            m.set(SQLParam.DES, des);
        }
        return m.save();
    }

    public boolean del(String roleId){
        if (StrUtils.isEmpty(roleId)){
            return false;
        }
        return dao.deleteById(roleId);
    }

    public boolean roleNameIsExist(String roleName){
        if (StrUtils.isEmpty(roleName)){
            return true;
        }
        return dao.findFirst(StrUtils.join("select * from ",
                SQLParam.T_ROLE, " where ", SQLParam.ROLE_NAME,
                " = '", roleName, "';")) != null;
    }
}