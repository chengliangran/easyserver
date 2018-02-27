package com.easyserver.processor;

import com.easyserver.components.Request;
import com.easyserver.components.Response;
import com.easyserver.core.Context;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Administrator on 2018/2/26 0026.
 */
public class HttpProcessor implements Runnable {
    Request request;
    Response response;
    Context context;

    public HttpProcessor(Request request, Response response, Context context) {
        this.request = request;
        this.response = response;
        this.context = context;
    }

    public void run() {
        process();
    }

    String sucessMsg="HTTP/1.1 400 sb\r\n" +
            "Content-Type:text/html\r\n" +
            "\r\n" +
            "<h1>abc</h1>";

    public void process(){
        request.parseUrl();
        OutputStream outputStream= response.getOutputStream();
        try {
//            outputStream.write(sucessMsg.getBytes());
            if (context!=null){
                context.invoke(request,response);
            }
         } catch (Exception e) {
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
