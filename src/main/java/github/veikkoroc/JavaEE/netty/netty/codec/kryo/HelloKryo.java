package github.veikkoroc.JavaEE.netty.netty.codec.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/17 11:26
 */
public class HelloKryo {
    // 创建一个Kryo
    static Kryo kryo = new Kryo();
    /**
     * 把对象序列化到磁盘
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        // 注册一个学生类
        kryo.register(Student.class);

        // 创建一个学生对象
        Student student = new Student(1,"迪丽热巴");

        // 把学生对象序列化到磁盘student.bin文件中
        // 创建一个Kryo提供的Output流对象
        Output output = new Output(new FileOutputStream("D:\\Works of IT\\IDEA_IU_Project\\GitHub\\my-study\\src\\main\\java\\github\\veikkoroc\\JavaEE\\netty\\netty\\codec\\kryo\\student.bin"));

        // 使用kryo的writeObject方法把学生对象序列化到指定的文件上
        kryo.writeObject(output,student);

        // 关闭流对象
        output.close();

    }

    /**
     * 把磁盘上的对象取出来
     */
    @Test
    public void readBin(){
        // 注册一个学生类
        kryo.register(Student.class);
        kryo.setRegistrationRequired(true);
        try {
            // 创建Kryo提供的输入流
            Input input = new Input(new FileInputStream("D:\\Works of IT\\IDEA_IU_Project\\GitHub\\my-study\\src\\main\\java\\github\\veikkoroc\\JavaEE\\netty\\netty\\codec\\kryo\\student.bin"));

            // 获取流中的对象
            Student student = kryo.readObject(input, Student.class);

            // 关闭资源
            input.close();

            System.out.println(student);




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
