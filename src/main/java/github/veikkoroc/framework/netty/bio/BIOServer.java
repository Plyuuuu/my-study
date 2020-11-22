package github.veikkoroc.framework.netty.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/2 15:36
 */
@Slf4j
public class BIOServer {

    private static final int port = 8888;

    public static void main(String[] args) {

        // 使用线程池机制,如果有客户端连接就创建一个线程与之通信
        ExecutorService threadPool = Executors.newCachedThreadPool();

        try {
            // 创建ServerSocket并且绑定端口8888
            ServerSocket serverSocket = new ServerSocket(port);

            log.info("服务器已经启动，正在监听[{}]端口",port);


            // 不断监听是否有客户端连接带服务端
            while (true){

                System.out.println("线程信息 id="+Thread.currentThread().getId());

                // 监听，等待客户端连接
                log.info("等待客户端连接...");
                Socket accept = serverSocket.accept();
                log.info("连接到一个客户端,accept=[{}]",accept.getLocalSocketAddress().toString());

                // 连接到客户端就创建一个线程与之通信
                threadPool.execute(() -> {
                    // 与客户端通信
                    handler(accept);
                });


            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static void handler(Socket socket){
        System.out.println("线程信息 id="+Thread.currentThread().getId());

        // 存放流管道结果的缓冲区
        byte[] bytes = new byte[1024];

        try {
            // 获取与客户端通信的字节流通道
            InputStream inputStream = socket.getInputStream();

            // 循环读取客户端发送的数据
            while (true){
                // 把字节数组读取到缓冲区
                int read = inputStream.read(bytes);
                if (read != -1){
                    // 输出客户端发送的数据
                    System.out.println(new String(bytes,0,read));
                }else {
                    break;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("关闭和客户端的连接...");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
