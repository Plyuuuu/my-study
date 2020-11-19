package github.veikkoroc.Framework.netty.nio.Buffer;

import java.nio.IntBuffer;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/2 19:24
 */
public class BufferTest {
    public static void main(String[] args) {
        // 创建Buffer
        IntBuffer intBuffer = IntBuffer.allocate(5);

        // 往buffer中存值
        for (int i = 0; i < intBuffer.capacity(); i++) { // java.nio.BufferOverflowException
            intBuffer.put(i);
        }
        // 读写切换,写--->读
        intBuffer.flip();

        // 读取buffer中的值
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }

    }
}
