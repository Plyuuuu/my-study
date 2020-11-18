package github.veikkoroc.JavaEE.netty.netty.codec.kryo.demo;

import github.veikkoroc.JavaEE.netty.netty.codec.kryo.Student;

import java.util.Arrays;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/17 16:19
 */
public class Test {
    public static void main(String[] args) {
        Student student = new Student(1, "古力娜扎");
        // 序列化
        SerializerImpl serializerImpl = new SerializerImpl(Student.class);
        byte[] encode = serializerImpl.encode(student);
        System.out.println(Arrays.toString(encode));

        // 反序列化
        Student decoder = serializerImpl.decoder(encode, Student.class);
        System.out.println(decoder);

    }
}
