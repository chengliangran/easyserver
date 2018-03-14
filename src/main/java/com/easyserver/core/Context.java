package com.easyserver.core;

import com.easyserver.context.BasicWrapper;
import com.easyserver.context.Pipeline;
import com.easyserver.context.Wrapper;
import com.easyserver.servlet.Servlet;
import com.easyserver.components.Request;
import com.easyserver.components.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/27 0027.
 */
public class Context {

    public Context(){
        Wrapper wrapper=new BasicWrapper();
        wrapper.setClassName("com.easyserver.servlet.TestServlet");
        wrapper.setName("basic");

        Wrapper wrapper1=new ResWrapper();

        wrappers.add(wrapper);

    }

    ClassLoader classLoader=Thread.currentThread().getContextClassLoader();

    Pipeline pipeline=new Pipeline();

    List<Wrapper> wrappers=new ArrayList<Wrapper>();

    Wrapper resWrapper=new ResWrapper();


    public void invoke(Request request, Response response){
        pipeline.setContext(this);
        try {
            pipeline.invoke(request,response);
        } catch (Exception e){

        }
    }

    //getter and setter
    public List<Wrapper> getWrappers() {
        return wrappers;
    }

    public void setWrapper(Wrapper wrapper) {
        wrappers.add(wrapper);
    }

    public Wrapper getResWrapper() {
        return resWrapper;
    }

    public void setResWrapper(Wrapper resWrapper) {
        this.resWrapper = resWrapper;
    }


}
