package com.easyserver.core;

import com.easyserver.connector.Connector;
import com.easyserver.context.Context;

/**
 * Created by Administrator on 2018/2/11 0011.
 */
public class EeasyServer {

    Connector connector=null;

    Context context=null;

    public void addConnector(Connector connector) {
        this.connector=connector;
    }

    public void addContext(Context context) {
        this.context=context;
    }
}
