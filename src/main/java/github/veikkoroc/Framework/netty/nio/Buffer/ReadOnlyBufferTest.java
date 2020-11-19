package github.veikkoroc.Framework.netty.nio.Buffer;

import java.nio.ByteBuffer;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/3 13:00
 */
public class ReadOnlyBufferTest {
    public static void main(String[] args) {

        // 创建ByteBuffer且存入数据
        ByteBuffer byteBuffer = ByteBuffer.allocate(65);
        for (int i = 0; i < 64; i++) {
            byteBuffer.put((byte)i);
        }

        // 读写切换
        byteBuffer.flip();

       /* while (byteBuffer.hasRemaining()){
            System.out.println(byteBuffer.get());
        }*/

        // 设置为只读
        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();

        // 读取数据
        while (readOnlyBuffer.hasRemaining()){
            System.out.println(readOnlyBuffer.get());
        }

        // 插入数据 java.nio.ReadOnlyBufferException
        readOnlyBuffer.put((byte) 111);

    }
}
