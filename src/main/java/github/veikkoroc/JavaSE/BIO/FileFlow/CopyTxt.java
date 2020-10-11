package github.veikkoroc.JavaSE.BIO.FileFlow;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/11 17:47
 */
public class CopyTxt {
    public static void main(String[] args) {
        // 声明输入输出流
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            // 创建源文件对象和目标文件对象
            File srcFile = new File("src/main/resources/io/test.txt");
            File decFile = new File("src/main/resources/io/decTest.txt");

            // 创建流
            fileReader = new FileReader(srcFile);
            fileWriter = new FileWriter(decFile,true);

            // 把srcFile内容读取到decFile
            char[] chars = new char[5];
            int length ;
            while ((length = fileReader.read(chars))!=-1){
                fileWriter.write(new String(chars,0,length));
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 关闭资源
            if (fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
