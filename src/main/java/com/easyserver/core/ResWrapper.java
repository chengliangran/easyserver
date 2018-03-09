package com.easyserver.core;

import com.easyserver.components.Html;
import com.easyserver.components.Request;
import com.easyserver.components.Response;
import com.easyserver.context.Wrapper;
import com.easyserver.servlet.ResServlet;
import com.easyserver.utils.PathKit;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2018/3/5 0005.
 */
public class ResWrapper implements Wrapper {

    ClassLoader classLoader=Thread.currentThread().getContextClassLoader();


    private String className="com.easyserver.servlet.ResServlet";

    private String name="res";

    public void invoke(Request request, Response response) {
        try {
            Class clazz=classLoader.loadClass(className);
            ResServlet servlet= (ResServlet) clazz.newInstance();
            servlet.invoke(request,response);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    public void setName(String name) {

    }

    public String getName() {
        return null;
    }

    public void setClassName(String className) {

    }

    public String getClassName() {
        return null;
    }
}
