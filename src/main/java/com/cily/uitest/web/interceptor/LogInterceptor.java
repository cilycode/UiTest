package com.cily.uitest.web.interceptor;

import com.cily.utils.base.log.Logs;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

import java.util.Enumeration;
import java.util.logging.Logger;

/**
 * Created by admin on 2018/2/6.
 */
public class LogInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        Enumeration<String> names = inv.getController().getParaNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            Logger.getLogger(this.getClass().getSimpleName()).info(
                    "<--->name = " + name + "<--->value = "
                            + inv.getController().getPara(name));
        }
        Logger.getLogger(this.getClass().getSimpleName()).info(
                "requestUrl = " + inv.getController().getRequest().getRequestURI());

        inv.invoke();
    }
}
