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
    String failedMsg="HTTP/1.1 200 sb\r\n" +
            "Content-Type:text/html\r\n" +
            "\r\n";
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
            try {
                System.out.println("开始写数据");
                OutputStream outputStream=response.getOutputStream();
                outputStream.write(failedMsg.getBytes());
                new Html(PathKit.WEB_CONTENT+"test.html",outputStream).write();
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
