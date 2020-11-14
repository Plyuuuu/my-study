package github.veikkoroc.JavaEE.netty.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/13 22:24
 */
public class NettyByteBuf2 {
    public static void main(String[] args) {

        // 创建ByteBuf,   编码
        ByteBuf byteBuf = Unpooled.copiedBuffer("Hello word!", Charset.forName("UTF-8"));// CharsetUtil.UTF_8

        // 使用相关方法
        if(byteBuf.hasArray()){
            // 编码后的Byte数组
            byte[] content = byteBuf.array();

            // 将content转成字符串,   解码
            System.out.println(new String(content,0,byteBuf.readableBytes(),CharsetUtil.UTF_8));

            System.out.println(byteBuf.readerIndex()); // 0
            System.out.println(byteBuf.writerIndex()); // 11
            System.out.println(byteBuf.arrayOffset()); // 0
            System.out.println(byteBuf.capacity()); // 33 = (writerIndex * 3)，也就是已有字符个数的三倍
            System.out.println(byteBuf.readableBytes()); // 11 可读取的字符个数

            // byteBuf.getByte 不改变readerIndex的值，byteBuf.readByte 会改变

            // 循环读取
            for (int i = 0; i < byteBuf.readableBytes(); i++) {
                System.out.println(byteBuf.getByte(i));
            }

            // 获取byteBuf某一段                         起始索引，读取个数
            System.out.println(byteBuf.getCharSequence(0,5,CharsetUtil.UTF_8));

        }

    }
}
