package github.veikkoroc.JavaSE.BIO.File;

import java.io.File;
import java.io.IOException;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/11 13:17
 */
public class StudyFileMethod {
    public static void main(String[] args) throws IOException {

        // 1.创建文件对应的 File 对象
        File file = new File("src/main/resources/io/test4.txt");

        // 2.返回 File 对象对应的文件名或路径名   ==>    test4.txt
        System.out.println(file.getName());

        // 3.返回 File 对应的路径名     ==>     src\main\resources\io\test4.txt
        System.out.println(file.getPath());

        // 4. void deleteOnExit() 注册一个删除钩子，JVM 退出时删除File对应的目录
        File file1 = new File("src/main/resources/io/temp.text");
        file1.deleteOnExit();

        // 5. 创建文件 文件名:前缀+系统随机数+后缀
        File.createTempFile("temp",".txt",new File("src/main/resources/io"));

    }
}
