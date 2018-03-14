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

    private String queryString=null;

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
            if (url==null) {
                if (parse()&&StrKit.isNotBlank(requestStr)){
                    String[] str=requestStr.split("\r\n");
                    String reqLine=str[0];
                    if (StrKit.isNotBlank(reqLine)){

                        String url= "";
                        if (reqLine.split(" ")[1].length()>1){
                            url=reqLine.split(" ")[1].substring(1,reqLine.split(" ")[1].length());
                            System.out.println("请示的url:"+url);
                        }
                        if (StrKit.isNotBlank(url)){
                            int question=url.indexOf('?');
                            if (question>=0){
                                queryString=new String(url.toCharArray(),question+1,url.length()-question-1);
                                this.url=new String(url.toCharArray(),0,question);
                            }else{
                                this.url=url;
                            }
                        }else{
                            this.url=url;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     //getter and setter
    private String getRequestStr() {
        return requestStr;
    }

    public void setRequestStr(String requestStr) {
        this.requestStr = requestStr;
    }

    public String getUrl() {
        if (url==null){
            parseUrl();
        }
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public static void main(String[] args) {
    }
}
