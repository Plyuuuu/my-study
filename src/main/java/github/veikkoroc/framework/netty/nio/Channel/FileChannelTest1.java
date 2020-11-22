package github.veikkoroc.framework.netty.nio.Channel;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/2 23:10
 */
public class FileChannelTest1 {


    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Works of IT\\IDEA_IU_Project\\GitHub\\my-study\\src\\main\\java\\github\\veikkoroc\\JavaEE\\netty\\nio\\FileChannelTest.txt");

        // 创建Java的FileInputStream
        FileInputStream fileInputStream = new FileInputStream(file);

        // 获取fileInputStream的通道
        FileChannel channel = fileInputStream.getChannel();

        // 创建ByteBuffer
        //ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());

        // 从通道中读取数据到ByteBuffer
        channel.read(byteBuffer);

        // ByteBuffer读写转换
        //byteBuffer.flip();

        // 把ByteBuffer中的字节一次性转成字符
        byte[] array = byteBuffer.array();

        // 将byteBuffer中的字节转字符串
        System.out.println(new String(array));

        // 关闭资源
        fileInputStream.close();
    }
}
