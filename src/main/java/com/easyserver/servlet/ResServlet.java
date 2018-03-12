package com.easyserver.servlet;

import com.easyserver.components.Html;
import com.easyserver.components.Request;
import com.easyserver.components.Response;
import com.easyserver.utils.PathKit;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2018/3/5 0005.
 */
public class ResServlet implements Servlet {
    String failedMsg="HTTP/1.1 200 sb\r\n" +
            "Content-Type:text/html\r\n" +
            "\r\n";

    public void invoke(Request request, Response response) {
        File file=new File(PathKit.WEB_CONTENT+"test.html");

        OutputStream outputStream=response.getOutputStream();
        try {
            outputStream.write(failedMsg.getBytes());
            if(file.exists()){
                new Html(PathKit.WEB_CONTENT+request.getUrl(),outputStream).write();
            }else{
                new Html(PathKit.WEB_CONTENT+"test.html",outputStream).write();
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
