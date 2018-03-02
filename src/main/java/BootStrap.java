import com.easyserver.components.Request;
import com.easyserver.components.Response;
import com.easyserver.core.Context;
import com.easyserver.processor.HttpProcessor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2018/2/26 0026.
 */
public class BootStrap {
    private static int count=0;
    public static void main(String[] args) {
        try {
            Context context=new Context();
            ServerSocket serverSocket=new ServerSocket(8080);
            while (true){
                try {
                    Socket socket =serverSocket.accept();

                    Request request=new Request(socket.getInputStream());
                    Response response=new Response(socket.getOutputStream(),request);
                    Thread thread=new Thread(new HttpProcessor(request,response,context));
                    thread.start();
                    count++;
                }catch (Exception e){

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
