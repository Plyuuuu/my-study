package github.veikkoroc.Framework.netty.nio.Channel;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * 把 FileChannelTest.txt 复制到file，只用一个Buffer
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/3 10:52
 */
public class FileChannelTest2 {
    public static void main(String[] args) throws IOException {

        // 创建文件对应的类
        File file = new File("D:\\Works of IT\\IDEA_IU_Project\\GitHub\\my-study\\src\\main\\java\\github\\veikkoroc\\JavaEE\\netty\\nio\\FileChannelTest.txt");

        // 创建文件输入流对象
        FileInputStream fileInputStream = new FileInputStream(file);

        // 获取输入流的通道
        FileChannel channel = fileInputStream.getChannel();

        // 创建一个Buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());

        // 把输入流数据写入Buffer
        channel.read(byteBuffer);

        // 创建输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Works of IT\\IDEA_IU_Project\\GitHub\\my-study\\src\\main\\java\\github\\veikkoroc\\JavaEE\\netty\\file\\a.txt");

        // 获取输出流的channel
        FileChannel channel1 = fileOutputStream.getChannel();

        // 读写要转换啊！！！！！！！！！！！！！！！！！！！！！！！！！！
        byteBuffer.flip();

        // 把buffer数据写入channel1
        channel1.write(byteBuffer);

        // 关闭资源
        fileOutputStream.close();
        fileInputStream.close();

    }
}
