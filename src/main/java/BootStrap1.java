import com.easyserver.core.Context;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Scope;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Administrator on 2018/3/6 0006.
 */
public class BootStrap1 {
    public static void main(String[] args) {
//        new BootStrap1().test2();
        new BootStrap1().test1();
    }
    public void test1(){
        System.out.println(new File("/").getPath());
        System.out.println();
    }

    public void test2(){
        Context context=new Context();
        try {
            ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            serverSocketChannel.configureBlocking(false);

            Selector selector=Selector.open();

            serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

            while (true){
                try {


                    selector.select();
                    Set<SelectionKey> keys= selector.selectedKeys();
                    Iterator iterator= keys.iterator();
                    while (iterator.hasNext()){
                        SelectionKey key= (SelectionKey) iterator.next();
                        iterator.remove();
                        if (!key.isValid()){
                            continue;
                        }else if (key.isAcceptable()){
                            SocketChannel socketChannel= ((ServerSocketChannel)key.channel()).accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector,SelectionKey.OP_READ);

                        }else if(key.isReadable()){
                            SocketChannel channel=(SocketChannel)key.channel();
                            ByteBuffer buffer=ByteBuffer.allocate(2048);
                            channel.read(buffer);
                            System.out.println(new String(buffer.array(),"utf-8"));
                            key.cancel();
                        }
                    }
                }catch (Exception e){

                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
