package github.veikkoroc.framework.netty.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/13 21:45
 */
public class NettyByteBuf {
    public static void main(String[] args) {

        // 先创建一个ByteBuf,
        // 1、是一个 byte[10]
        // 2、和NIO的ByteBuffer不同，不需要flip进行反转；底层维护类readIndex和writeIndex
        // 3、通过readIndex 和 writeIndex 和 capacity 将byteBuf分成三个区域
        //    0-readIndex:已经读取的区域
        //    readIndex-writeIndex:可读的区域
        //    writeIndex-capacity:可写的区域
        ByteBuf byteBuf = Unpooled.buffer(10);

        for (int i = 0; i < 10; i++) {
            byteBuf.writeByte(i);
        }

        System.out.println("byteBuf Capacity:"+byteBuf.capacity());

        // 输出
//        for (int i = 0; i < byteBuf.capacity(); i++) {
//            System.out.println(byteBuf.getByte(i));
//        }

        // 此方法会改变 readIndex 的值
        for (int i = 0; i < byteBuf.capacity(); i++) {
            System.out.println(byteBuf.readByte());
        }


    }
}
