package com.easyserver.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPObject;
import com.easyserver.components.Request;
import com.easyserver.components.Response;
import com.easyserver.utils.PathKit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/2/27 0027.
 */
public class TestServlet implements Servlet {
    String failedMsg="HTTP/1.1 404 sb\r\n" +
            "Content-Type:text/html\r\n" +
            "\r\n" ;
//            "<h1>abc</h1>";
    public void invoke(Request request, Response response) {
        System.out.println("返回处理结果");
        FileInputStream inputStream=null;
        try {
                byte[] buffer=new byte[2048];
                inputStream=new FileInputStream(new File(PathKit.WEB_ROOT+File.separator+"test.txt"));
                int length=inputStream.read(buffer);
                while (length!=-1){
                    response.getOutputStream().write(buffer,0,length);
                    buffer=new byte[2048];
                    length=inputStream.read(buffer);
                }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStream!=null){
                try {
                    System.out.println("关闭连接");
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
