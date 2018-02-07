package com.cily.uitest.web;

import com.cily.uitest.web.conf.SQLParam;
import com.cily.uitest.web.controller.ApksController;
import com.cily.uitest.web.controller.SysUserController;
import com.cily.uitest.web.controller.UserController;
import com.cily.uitest.web.interceptor.DeviceImeiInterceptor;
import com.cily.uitest.web.interceptor.LogInterceptor;
import com.cily.uitest.web.interceptor.LoginedInterceptor;
import com.cily.uitest.web.model.UserModel;
import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.template.Engine;

/**
 * Created by admin on 2018/1/17.
 */
public class Conf extends JFinalConfig {
    @Override
    public void configConstant(Constants me) {
        PropKit.use("conf.properties");
    }

    @Override
    public void configRoute(Routes me) {
        me.add("apk", ApksController.class);
        me.add("user", UserController.class);
        me.add("sysUser", SysUserController.class);
    }

    @Override
    public void configEngine(Engine me) {

    }

    @Override
    public void configPlugin(Plugins me) {
        C3p0Plugin c3p0 = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("pwd"));
        me.add(c3p0);

        ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0);
        arp.setShowSql(PropKit.getBoolean("showSql"));
        me.add(arp);
        arp.addMapping(SQLParam.T_USER, SQLParam.USER_ID, UserModel.class);
    }

    @Override
    public void configInterceptor(Interceptors me) {
        me.add(new LogInterceptor());
        me.add(new DeviceImeiInterceptor());
//        me.add(new LoginedInterceptor());
    }

    @Override
    public void configHandler(Handlers me) {

    }
}