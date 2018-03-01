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
        try {
            if ("/".equals(request.getUrl())){
                byte[] buffer=new byte[2048];
                FileInputStream inputStream=new FileInputStream(new File(PathKit.WEB_ROOT+File.separator+"test.txt"));
                int length=inputStream.read(buffer);
                while (length!=-1){
                    response.getOutputStream().write(buffer,0,length);
                    length=inputStream.read(buffer);
                }
            }else{
                response.getOutputStream().write(failedMsg.getBytes());

//      `       response.getOutputStream().write("text and document".getBytes());1测试字符串
//              2测试json
                HashMap<String,String> map=new HashMap<String, String>();
                map.put("1","1");
                map.put("2","2");
                List list=new ArrayList();
                list.add(map);
                list.add("1");

                String jsonString= JSON.toJSONString(list);
                OutputStream outputStream=response.getOutputStream();
                outputStream.write(jsonString.getBytes());
                outputStream.flush();
                outputStream.close();


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
