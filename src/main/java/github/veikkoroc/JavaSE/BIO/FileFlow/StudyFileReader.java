package github.veikkoroc.JavaSE.BIO.FileFlow;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *  字符输入流：读取一个一个字符，中文不乱码
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/11 14:10
 */
public class StudyFileReader {
    /**
     * 挨个读取字符
     *
     * @param args
     */
    public static void main(String[] args) {
        FileReader fileReader =null;

        try {

            // 1.获取文件对象
            File file = new File("src/main/resources/io/test4.txt");

            // 2.创建文件输入流
            fileReader = new FileReader(file);

            // 3.从流中获取数据
            int data;
            while ((data = fileReader.read())!=-1){
                System.out.print((char)data);
            }

        }catch (Exception e){
            e.printStackTrace();
        }  finally {

            // 4.关闭资源

            if (fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    /**
     * 添加缓冲区
     */
    @Test
    public void test(){

        FileReader fileReader = null;

        try {
            // 1.创建File对象
            File file = new File("src/main/resources/io/test4.txt");
            // 2.创建文件输入流
            fileReader = new FileReader(file);

            // 3.创建缓存区
            char[] chars = new char[5];
            // 4.实际读取长度
            int length;

            // 5.读取数据
            while ((length = fileReader.read(chars))!=-1){
                System.out.println(new String(chars));
                System.out.println("实际读取长度:"+length);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {

            // 6.关闭资源
            if (fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
