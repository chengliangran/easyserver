package com.easyserver.components;

import java.io.OutputStream;

/**
 * Created by Administrator on 2018/2/27 0027.
 */
public class Response {
    private OutputStream outputStream;
    private Request request;

    public Response(OutputStream outputStream, Request request) {
        this.outputStream = outputStream;
        this.request = request;
    }


    //getter and setter

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
