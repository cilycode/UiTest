package com.cily.uitest.web.controller;

import com.alibaba.fastjson.JSON;
import com.jfinal.core.Controller;

import java.io.File;

/**
 * Created by admin on 2018/1/17.
 */
public class ApksController extends Controller {
    private final String FILE_PATH = "E:\\software\\tomcat-file";

    public void index(){
        File f = new File(FILE_PATH);
        if (!f.exists()){
            renderJson(FILE_PATH + "路径不存在");
            return;
        }
        File[] fs = f.listFiles();
        if (fs != null && fs.length > 0){
            for (int i = 0; i < fs.length; i++) {
                if (fs[i].isDirectory()){
                    System.out.println("文件夹:" + fs[i].getName());
                }else {
                    System.out.println("文件:" + fs[i].getName());
                }
            }
        }
        renderJson(FILE_PATH + "路径存在");
    }

    public void testCancelRequest(){
        System.out.println("1111111111111***********");
//        getRequest()

        Res r = new Res();
        r.setErrcode(0);
        r.setErrmsg("成功");
        r.setData("测试成功了");

        renderJson(JSON.toJSONString(r));
    }

    private static class Res{
        private int errcode;
        private String errmsg;
        private String data;

        public int getErrcode() {
            return errcode;
        }

        public void setErrcode(int errcode) {
            this.errcode = errcode;
        }

        public String getErrmsg() {
            return errmsg;
        }

        public void setErrmsg(String errmsg) {
            this.errmsg = errmsg;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}