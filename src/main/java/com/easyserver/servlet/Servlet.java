package com.easyserver.servlet;

import com.easyserver.components.Request;
import com.easyserver.components.Response;

/**
 * Created by Administrator on 2018/2/27 0027.
 */
public interface Servlet {
    public void invoke(Request request, Response response);

}
