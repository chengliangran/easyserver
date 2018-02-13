package com.easyserver.core;

import com.easyserver.connector.Connector;
import com.easyserver.connector.FastConnector;
import com.easyserver.context.WebAppContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.Properties;

/**
 * Created by Administrator on 2018/2/11 0011.
 */
public class Bootstrap {


    public static void main(String[] args) {

        Properties prop=new Properties();
        try {
            prop.load(new FileInputStream(new File("src/main/resources/configuration/config.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int port =Integer.parseInt(prop.getProperty("port")) ;

        System.out.println(port);

        if (available(port)){
            //组装服务器
            EeasyServer server=new EeasyServer();

            Connector connector =new FastConnector();

            WebAppContext context=new WebAppContext();
            context.addPath("/");

            server.addConnector(connector);
            server.addContext(context);

        }

    }
    private static boolean available(int port){
        ServerSocket serverSocket=null;
        DatagramSocket socket=null;
        try {
            serverSocket=new ServerSocket(port);
            socket=new DatagramSocket(port);
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!=null){
                socket.close();
            }
        }
        return false;
    }
}
