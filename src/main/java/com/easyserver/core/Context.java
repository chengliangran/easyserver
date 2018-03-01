package com.easyserver.core;

import com.easyserver.context.Pipeline;
import com.easyserver.servlet.Servlet;
import com.easyserver.components.Request;
import com.easyserver.components.Response;

/**
 * Created by Administrator on 2018/2/27 0027.
 */
public class Context {

    ClassLoader classLoader=Thread.currentThread().getContextClassLoader();

    Pipeline pipeline=new Pipeline();

    public void invoke(Request request,Response response){
        System.out.println("context 开始运作");
        try {
            pipeline.invoke(request,response);
//            Class clazz =classLoader.loadClass("com.easyserver.servlet.TestServlet");
//            Servlet servlet=(Servlet) clazz.newInstance();
//            servlet.invoke(request,response);
        } catch (Exception e){

        }
    }

}
