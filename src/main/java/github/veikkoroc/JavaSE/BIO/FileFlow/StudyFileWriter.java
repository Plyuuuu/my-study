package github.veikkoroc.JavaSE.BIO.FileFlow;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *  文件字符输出流
 *
 *  说明：
 *      1. 输出操作，对应的File可以不存在的。并不会报异常
 *      2.
 *           File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
 *           File对应的硬盘中的文件如果存在：
 *                  如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原文件的覆盖
 *                  如果流使用的构造器是：FileWriter(file,true):不会对原文件覆盖，而是在原文件基础上追加内容
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/11 14:37
 */
public class StudyFileWriter {
    public static void main(String[] args) {

        // 1.声明字符输出流
        FileWriter fileWriter = null;

        try{
            // 2.创建文件对象
            File file = new File("src/main/resources/io/test.txt");
            // 3.创建字符输出流
            fileWriter = new FileWriter(file);
            // 4.写数据
            fileWriter.write("迪丽热巴巴巴~~~");
            fileWriter.write("古力娜扎渣渣~~~");


        }catch (Exception e){
            e.printStackTrace();
        }finally {

            // 5.关闭资源
            if (fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
