package com.easyserver.context;

import com.easyserver.components.Request;
import com.easyserver.components.Response;

/**
 * Created by Administrator on 2018/3/1 0001.
 */
public interface Wrapper {
    public void invoke(Request request, Response response);

    //getter and setter
    public void setName(String name);

    public String getName();

    public void setClassName(String className);

    public String getClassName();
}
