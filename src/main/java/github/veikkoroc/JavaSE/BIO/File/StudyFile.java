package github.veikkoroc.JavaSE.BIO.File;

import java.io.File;

/**
 * File 类的理解
 *      1. File类的一个对象，代表一个 文件 或一个  文件目录(俗称：文件夹)
 *      2. File类声明在java.io包下
 *      3. File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，
 *         并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成。
 *      4. 后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的"终点".
 *
 *File 类对象的创建（内存层面）
 *
 *      常用构造器
 *          File(String filePath)
 *          File(String parentPath,String childPath)
 *          File(File parentFile,String childPath)
 *
 *          1.File file1 = new File("D:\test1.txt");
 *          2.File file2 = new File("D:","test2.txt");
 *          3.File file3 = new File("new File("D:")",test3.txt);
 *
 * 路径的分类
 *      相对路径：相较于某个路径下，指明的路径。
 *      绝对路径：包含盘符在内的文件或文件目录的路径
 *  说明：
 *
 * 	    * IDEA中：
 *          如果大家开发使用JUnit中的单元测试方法测试，相对路径即为当前Module下。
 *          如果大家使用main()测试，相对路径即为当前的Project下。
 * 	    * Eclipse中：
 *          不管使用单元测试方法还是使用main()测试，相对路径都是当前的Project下。
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/11 12:18
 */
public class StudyFile {
    public static void main(String[] args) {
        File file = new File("D:\\test1.txt");
        File file2 = new File("D:","test2.txt");
        File file3 = new File(new File("D:"),"test3.txt");


        // 1.检测File对象对应的文件是否存在
        System.out.println(file.exists());

        // model相对路径
        File file4 = new File("src/main/resources/io/test4.txt");
        // true
        System.out.println(file4.exists());

        // 资源目录
        File file5 = new File("io/test4.txt");
        // false
        System.out.println(file5.exists());
    }
}
