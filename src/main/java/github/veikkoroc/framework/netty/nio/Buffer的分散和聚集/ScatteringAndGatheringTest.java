package github.veikkoroc.framework.netty.nio.Buffer的分散和聚集;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 *
 * 太多不懂的东西了.....2020/11/03
 *
 * Scattering:写入数据到buffer时，可以采用buffer数组,依次写入[分散]
 * Gathering:从buffer读取数据时，可以采用buffer数组，依次读[聚集]
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/3 14:50
 */
public class ScatteringAndGatheringTest {
    public static void main(String[] args) throws IOException {

        // 使用ServerSocketChannel 和 SocketChannel 网络
        ServerSocketChannel open = ServerSocketChannel.open();

        // 绑定端口并且启动
        open.bind(new InetSocketAddress(8888));

        // 创建Buffer数组
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        // 等待客户端连接
        SocketChannel accept = open.accept();

        int messageLength = 8;// 假定从客户端接收8个字节数据

        // 循环读取
        while (true){

            int byteRead = 0;

            while (byteRead < messageLength){
                long read = accept.read(byteBuffers);

                byteRead+=1;// 累计读取的字节数
                System.out.println("byteRead = "+byteRead);

                // 使用流打印，看看buffer的position和limit
               // Arrays.asList(byteBuffers).stream().map(buffer -> "position = "+)
            }


        }

    }
}
