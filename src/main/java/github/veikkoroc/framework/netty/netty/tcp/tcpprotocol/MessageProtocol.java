package github.veikkoroc.framework.netty.netty.tcp.tcpprotocol;

/**
 *
 * TCP 协议包
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/19 10:44
 */
public class MessageProtocol {
    /**
     * 数据包长度
     */
    private int length;
    /**
     * 数据包内容
     */
    private byte[] content;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
