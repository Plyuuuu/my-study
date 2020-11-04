package github.veikkoroc.JavaEE.netty.nio.Buffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/3 13:35
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws IOException {

        // 获取流,此类的实例支持对随机访问文件的读取和写入
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\Works of IT\\IDEA_IU_Project\\GitHub\\my-study\\src\\main\\java\\github\\veikkoroc\\JavaEE\\netty\\nio\\1.txt","rw");

        // 获取通道
        FileChannel channel = randomAccessFile.getChannel();

        /**
         * 获取MapperByteBuffer
         * 参数1：读写模式
         * 参数2：读的起点指针
         * 参数3：读取的数据大小
         */

        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        // 修改数据
        map.put(0,(byte)'H');

        // 关闭资源
        randomAccessFile.close();

    }
}
