package com.easyserver.core;

import com.easyserver.servlet.Servlet;
import com.easyserver.components.Request;
import com.easyserver.components.Response;

/**
 * Created by Administrator on 2018/2/27 0027.
 */
public class Context {
    Request request;
    Response response;
    ClassLoader classLoader=Thread.currentThread().getContextClassLoader();

    public void invoke(Request request,Response response){
        System.out.println("context 开始运作");
        try {
            Class clazz =classLoader.loadClass("com.easyserver.servlet.TestServlet");
            Servlet servlet=(Servlet) clazz.newInstance();
            servlet.invoke(request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //getter and setter
    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
