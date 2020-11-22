package github.veikkoroc.framework.netty.nio.NIODemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/3 16:56
 */
public class Client {
    public static void main(String[] args) throws IOException {

        // ===============得到一个网络通道================
        SocketChannel socketChannel = SocketChannel.open();

        // 设置为非阻塞
        socketChannel.configureBlocking(false);

        // 提供服务器端的IP和端口(套接字)
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",8888);

        // 连接服务器
        if (!socketChannel.connect(inetSocketAddress)){

            while (!socketChannel.finishConnect()){
                System.out.println("耐心等待连接...");
            }

        }

        // 连接成功，发送数据
        String message = "加油!VeikkoRoc!!!";

        // Wraps the message
        ByteBuffer byteBuffer = ByteBuffer.wrap(message.getBytes());

        // 发送数据，把buffer数据写入channel
        socketChannel.write(byteBuffer);

        // 使代码停在这
        System.in.read();

    }
}
