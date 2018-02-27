package com.easyserver.components;

import com.easyserver.utils.StrKit;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2018/2/27 0027.
 */
public class Request {

    boolean parsed=false;

    InputStream inputStream;

    public Request(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    private String requestStr=null;

    private boolean parse(){
        if (!parsed){
            if (inputStream!=null){
                StringBuffer sb=new StringBuffer();
                byte[] buf=new byte[100];
                int length=0;
                try {
                    while ((length=inputStream.read(buf))!=-1){
                        sb.append(new String(buf,0,length));
                        if (sb.toString().contains("\r\n\r\n")){
                            requestStr=sb.toString();
                            return true;
                        }
                    }
                    return false;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return true;
    }

    private String url=null;

    public void parseUrl(){
        try {
            if (parse()&&StrKit.isNotBlank(requestStr)){
                String[] str=requestStr.split("\r\n");
                String reqLine=str[0];
                if (StrKit.isNotBlank(reqLine)){
                    String url= reqLine.split(" ")[1];
                    if (StrKit.isNotBlank(url)){
                        this.url=url;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //getter and setter
    public String getRequestStr() {
        return requestStr;
    }

    public void setRequestStr(String requestStr) {
        this.requestStr = requestStr;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
