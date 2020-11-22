package github.veikkoroc.framework.netty.nio.Channel;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * 使用 transferFrom / transferTo实现图片拷贝
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/3 11:21
 */
public class FileChannelTest3 {
    public static void main(String[] args) throws IOException {

        // 创建要复制的文件和目标地址
        File fileSrc = new File("D:\\Works of IT\\IDEA_IU_Project\\GitHub\\my-study\\src\\main\\java\\github\\veikkoroc\\JavaEE\\netty\\nio\\1.jpg");
        File fileDesc = new File("D:\\Works of IT\\IDEA_IU_Project\\GitHub\\my-study\\src\\main\\java\\github\\veikkoroc\\JavaEE\\netty\\file\\1.jpg");
        // System.out.println(file.exists());

        // 创建文件字节流
        FileInputStream fileInputStream = new FileInputStream(fileSrc);
        FileOutputStream fileOutputStream = new FileOutputStream(fileDesc);

        // 获取文件字节输入流的Channel
        FileChannel src = fileInputStream.getChannel();
        FileChannel desc = fileOutputStream.getChannel();

        // 通道Channel内数据进行拷贝
        //desc.transferFrom(src,0,fileSrc.length());
        src.transferTo(0,fileSrc.length(),desc);

        // 关闭资源
        fileOutputStream.close();
        fileInputStream.close();
    }
}
