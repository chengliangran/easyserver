package com.easyserver.context;

import com.easyserver.components.Request;
import com.easyserver.components.Response;
import com.easyserver.core.Context;

/**
 * Created by Administrator on 2018/3/1 0001.
 */
public interface Valve {

    public void invoke(Request request, Response response);

    public void setContext(Context contexta);

    public Context getContext();
}
