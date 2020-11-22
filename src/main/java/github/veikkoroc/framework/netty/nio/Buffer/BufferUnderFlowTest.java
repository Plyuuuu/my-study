package github.veikkoroc.framework.netty.nio.Buffer;

import java.nio.ByteBuffer;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/3 13:17
 */
public class BufferUnderFlowTest {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
        byteBuffer.putInt(1);
        byteBuffer.flip();
        // java.nio.BufferUnderflowException
        byteBuffer.getLong();
    }
}
