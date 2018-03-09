package com.easyserver.context;

import com.alibaba.fastjson.JSON;
import com.easyserver.components.Html;
import com.easyserver.components.Request;
import com.easyserver.components.Response;
import com.easyserver.core.Context;
import com.easyserver.utils.PathKit;
import com.easyserver.utils.StrKit;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/3/1 0001.
 */
public class BasicValve implements Valve {


    Context context;

    public void invoke(Request request, Response response) {
        boolean flag=false;
        List<Wrapper> wrappers= getContext().getWrappers();
        if (StrKit.isNotBlank(request.getUrl())){
            int index=request.getUrl().lastIndexOf("/");
            String wrapperPath= null;
            try {
                wrapperPath = new String(request.getUrl().toCharArray(),index,request.getUrl().length()-index).replace("/","");
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (Wrapper wrapper : wrappers) {
                if (wrapper.getName().equals(wrapperPath)){
                    wrapper.invoke(request,response);
                    flag=true;
                    break;
                }
            }
        }
        if (!flag){
           getContext().getResWrapper().invoke(request,response);
        }
    }

    //getter and setter
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
