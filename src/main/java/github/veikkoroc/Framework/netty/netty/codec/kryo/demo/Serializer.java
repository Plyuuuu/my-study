package github.veikkoroc.Framework.netty.netty.codec.kryo.demo;

/**
 *
 * 序列化接口
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/17 15:20
 */
public interface Serializer {

    /**
     * 序列化（编码）的方法
     * @param object 要序列化的对象
     * @return 对象序列化后的字节数组
     */
    byte[] encode(Object object);

    /**
     *  反序列化（解码）的方法
     * @param bytes 对象序列化后的字节数组
     * @param clazz 字节数组应该反序列化后的类型Class的对象
     * @param <T>   类的类型。举个例子,  {@code String.class} 的类型是 {@code Class<String>}.
     *                   如果不知道类的类型的话，使用 {@code Class<?>}
     * @return 序列化后的对象
     */
    <T> T decoder(byte[] bytes,Class<T> clazz);
}
