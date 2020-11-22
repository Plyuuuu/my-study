package github.veikkoroc.framework.netty.nio.NIODemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/3 16:56
 */
public class Server {
    public static void main(String[] args) throws IOException {

        // =============================ServerSocketChannel=====================

        // ServerSocketChannel -> ServerSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 设置服务器的套接字，让通道绑定
        SocketAddress socketAddress = new InetSocketAddress(8888);
        serverSocketChannel.bind(socketAddress);

        // 把通道设置为非阻塞的
        serverSocketChannel.configureBlocking(false);


        // =============================Selector=======================

        // 获取选择器Selector
        Selector selector = Selector.open();


        // ===========================ServerSocketChannel -> Selector================
        // 把服务器的通道ServerSocketChannel注册到selector上,selector 关心事件为 OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


        // =========================与客户端通信====================
        // 循环等待客户端连接
        while (true){

            // 等待一秒，无连接就提示
            if (selector.select(1000) == 0){
                System.out.println("我等了1S，怎么没客户端连接我呀？~~~");
                continue;
            }

            // 如果selector.select>0,说明selector上发送了事件
            // 事件对应的selectionKey会被保存到 Set 集合中
            Set<SelectionKey> selectionKeys = selector.selectedKeys();// selectedKeys()表示发生事件的方法,keys(),是注册的所有的channel

            // 遍历selectionKey，使用迭代器遍历
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()){
                // 获取到selectionKey
                SelectionKey selectionKey = iterator.next();

                // 根据selectionKey对应的时间做相应的处理
                // 如果事件时可Acceptable，说明是连接事件
                if (selectionKey.isAcceptable()){
                    // 给该连接事件分配Channel
                    SocketChannel accept = serverSocketChannel.accept();
                    System.out.println(accept.hashCode()+"客户端连接成功！");

                    // 设置分配的Channel为非阻塞
                    accept.configureBlocking(false);

                    // 把该通道注册到Selector上，关注事件的OP_READ,同时给socketChannel关联一个Buffer
                    accept.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(64));


                }

                // 如果selector发生readAble事件
                if (selectionKey.isReadable()){
                    // 通过SelectionKey获取对应的Channel
                    SelectableChannel channel = selectionKey.channel();
                    SocketChannel socketChannel = (SocketChannel)channel;

                    // 获取socketChannel关联的Buffer,通过selectionKey获取
                    ByteBuffer byteBuffer =  (ByteBuffer)selectionKey.attachment();

                    // 把通道内数据读取到Buffer
                    socketChannel.read(byteBuffer);

                    // 把Buffer数据输出
                    System.out.println("From 客户端:"+new String(byteBuffer.array()));

                }


            }

            // 手动从集合中移除当前selectionKey，防止重复操作
            iterator.remove();




        }



    }
}
