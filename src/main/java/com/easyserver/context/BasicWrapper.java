package com.easyserver.context;

import com.easyserver.components.Request;
import com.easyserver.components.Response;
import com.easyserver.servlet.Servlet;

/**
 * Created by Administrator on 2018/3/1 0001.
 */
public class BasicWrapper implements Wrapper {
    String name;

    String className;

    public void invoke(Request request, Response response) {
        ClassLoader classLoader= Thread.currentThread().getContextClassLoader();
        try {
            Class clazz= classLoader.loadClass(getClassName());
            Servlet servlet= (Servlet) clazz.newInstance();
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
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setClassName(String className) {
        this.className=className;
    }

    public String getClassName() {
        return className;
    }

}
