package com.easyserver.servlet;

import com.easyserver.components.Html;
import com.easyserver.components.Request;
import com.easyserver.components.Response;
import com.easyserver.utils.PathKit;
import sun.nio.ch.FileKey;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2018/3/5 0005.
 */
public class ResServlet implements Servlet {
    String httpProtocal="";
    String html= "HTTP/1.1 200 sb\r\n" +
            "Content-Type:text/html\r\n" ;
    String js="HTTP/1.1 200 sb\r\n" +
            "Content-Type:text/js\r\n";
    String css="HTTP/1.1 200 sb\r\n" +
            "Content-Type:text/css\r\n";
    public void invoke(Request request, Response response) {
        OutputStream outputStream=response.getOutputStream();
        File file= null;
        try {
            file = new File(PathKit.WEB_CONTENT+request.getUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //输出header头
            if (request.getUrl().endsWith("js")){
                httpProtocal=js;
            }else if(request.getUrl().endsWith("css")){
                httpProtocal=css;
            }else {
                httpProtocal=html;
            }
            if (file.exists()&&file.isFile()){
                httpProtocal=httpProtocal.concat("Content-Length:"+file.length()+"\r\n");
            }else{
                httpProtocal=httpProtocal.concat("Content-Length:"+new File(PathKit.WEB_CONTENT+"test.html").length()+"\r\n");
            }
            outputStream.write(httpProtocal.getBytes());
            outputStream.write("\r\n".getBytes());
            //输出内容
            if(file.exists()&&file.isFile()){
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

    public static void main(String[] args) {

     }
}
