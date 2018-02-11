package com.easyserver.core;

import com.easyserver.connector.FastConnector;
import com.easyserver.context.WebAppContext;

/**
 * Created by Administrator on 2018/2/11 0011.
 */
public class Bootstrap {
    public static void main(String[] args) {
        EeasyServer server=new EeasyServer();
        FastConnector fastConnector =new FastConnector();
        WebAppContext context=new WebAppContext();
        server.addConnector();
        context.addPath("/");

    }
}
