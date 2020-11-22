package github.veikkoroc.framework.netty.nio.Channel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/2 22:10
 */
public class FileChannelTest {
    public static void main(String[] args) throws IOException {

        // 创建文件输出流，内容输出到指定文件
        FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\Works of IT\\IDEA_IU_Project\\GitHub\\my-study\\src\\main\\java\\github\\veikkoroc\\JavaEE\\netty\\nio\\FileChannelTest.txt"));

        // 获取输出流的Channel
        FileChannel channel = fileOutputStream.getChannel();

        // 创建需要写入Buffer的str
        String s = "加油！VeikkoRoc!!!";

        // 创建ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 把str转字节数组加入ByteBuffer
        byteBuffer.put(s.getBytes());

        // 将byteBuffer读写转换
        byteBuffer.flip();

        // 读取byteBuffer,写进管道
        channel.write(byteBuffer);

        // 关闭资源
        fileOutputStream.close();
    }
}
