import com.easyserver.processor.HttpProcessor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2018/2/26 0026.
 */
public class BootStrap {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket(8080);
            while (true){
                try {
                    Socket socket =serverSocket.accept();
                    InputStream inputStream=socket.getInputStream();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
                    boolean flag=true;
                    StringBuffer sb=new StringBuffer();
                            byte[] buf=new byte[100];
                            int length=0;
                            while ((length=inputStream.read(buf))!=-1){
                                sb.append(new String(buf,0,length));
                                if (sb.toString().contains("\r\n\r\n")){
                                    System.out.println(sb.toString());
                                    break;
                                }
                             }
                    OutputStream outputStream=socket.getOutputStream();
                    outputStream.write("HTTP/1.1 200 SUCCESS\r\n ".getBytes());
                    Thread thread=new Thread(new HttpProcessor());
                    thread.start();

                }catch (Exception e){

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
