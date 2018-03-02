package com.easyserver.components;

import java.io.*;

/**
 * Created by Administrator on 2018/3/2 0002.
 */
public class Html {
    String htmlPath;

    OutputStream outputStream;

    public Html(String htmlPath,OutputStream outputStream) {
        this.htmlPath = htmlPath;
        this.outputStream=outputStream;
    }

    public void write(){
        File file=new File(htmlPath);
        boolean flag=false;
        if (file.exists()&&outputStream!=null){
            try {
                FileInputStream inputStream=new FileInputStream(file);
                byte[] buf=new byte[2048];
                int length=0;
                while ((length=inputStream.read(buf))>-1){
                    outputStream.write(buf,0,buf.length);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            flag=true;
        }
        if (flag){
            try {
                outputStream.write("404".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
