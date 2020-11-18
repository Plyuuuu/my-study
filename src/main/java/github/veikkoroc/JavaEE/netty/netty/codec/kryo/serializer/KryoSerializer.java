package github.veikkoroc.JavaEE.netty.netty.codec.kryo.serializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/17 15:12
 */
public class KryoSerializer extends Serializer {
    @Override
    public void write(Kryo kryo, Output output, Object o) {

    }

    @Override
    public Object read(Kryo kryo, Input input, Class aClass) {
        return null;
    }
}
