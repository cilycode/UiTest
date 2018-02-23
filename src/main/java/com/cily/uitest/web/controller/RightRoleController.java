package com.cily.uitest.web.controller;

import com.cily.uitest.web.conf.Param;
import com.cily.uitest.web.conf.SQLParam;
import com.cily.uitest.web.interceptor.RightIdInterceptor;
import com.cily.uitest.web.interceptor.RoleIdInterceptor;
import com.cily.uitest.web.model.RightRoleModel;
import com.cily.uitest.web.utils.ResUtils;
import com.jfinal.aop.Before;

/**
 * Created by admin on 2018/2/23.
 */
@Before({RoleIdInterceptor.class})
public class RightRoleController extends BaseController {

    /**
     * 获取角色的权限
     */
    public void getRoleRights(){
        String roleId = getParam(SQLParam.ROLE_ID);
        renderJson(ResUtils.success(createTokenByOs(),
                RightRoleModel.getRoleRightByRoleId(roleId,
                        getParaToInt(Param.PAGE_NUMBER, 1),
                        getParaToInt(Param.PAGE_SIZE, 10))));
    }

    /**
     * 添加角色权限
     */
    @Before({RightIdInterceptor.class})
    public void addRoleRight(){
        String roleId = getParam(SQLParam.ROLE_ID);
        String rightId = getParam(SQLParam.RIGHT_ID);
        if (RightRoleModel.insert(rightId, roleId)){
            renderJson(ResUtils.success(createTokenByOs(), null));
        }else {
            renderJson(ResUtils.res(Param.C_RIGHT_ROLE_ADD_FAILED,
                    createTokenByOs(), null));
        }
    }

    /**
     * 删除角色权限
     */
    @Before({RightIdInterceptor.class})
    public void delRoleRight(){
        String roleId = getParam(SQLParam.ROLE_ID);
        String rightId = getParam(SQLParam.RIGHT_ID);
        if (RightRoleModel.delByRightIdAndRoleId(rightId, roleId)){
            renderJson(ResUtils.success(createTokenByOs(), null));
        }else {
            renderJson(ResUtils.res(Param.C_RIGHT_ROLE_DEL_FAILED,
                    createTokenByOs(), null));
        }
    }
}