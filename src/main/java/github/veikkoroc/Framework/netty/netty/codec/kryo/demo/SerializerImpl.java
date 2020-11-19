package github.veikkoroc.Framework.netty.netty.codec.kryo.demo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/17 15:28
 */
public class SerializerImpl implements Serializer{

    // 创建kryo
    Kryo kryo ;

    /**
     * 构造器
     * @param clazz 需要注册的类型
     */
    public SerializerImpl(Class clazz){
        this.kryo = new Kryo();
        kryo.register(clazz);
    }

    @Override
    public byte[] encode(Object object) {

        // 放在try的括号里自动释放资源
        try(// 流对象，output把序列化后的字节数组放入byteArrayOutputStream
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Output output = new Output(byteArrayOutputStream);){
            // 序列化操作
            kryo.writeObject(output,object);

            return output.toBytes();
        }catch (Exception e){
            throw new RuntimeException("序列化出错~"+e.getMessage());
        }

    }

    @Override
    public <T> T decoder(byte[] bytes, Class<T> clazz) {
        try(ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            Input input = new Input(byteArrayInputStream);){

            T t = kryo.readObject(input, clazz);
            return t;
        }catch (Exception e){
            throw new RuntimeException("反序列化出错~"+e.getMessage());
        }

    }
}
