package github.veikkoroc.framework.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/26 15:10
 */
public class GetValue {
    public static void main(String[] args) throws Exception {
        // 重试策略
        ExponentialBackoffRetry retry = new ExponentialBackoffRetry(2000, 3);
        // 创建连接
        CuratorFramework zkClient = CuratorFrameworkFactory.builder()
                .connectString("127.0.0.1:2181")
                .retryPolicy(retry)
                .sessionTimeoutMs(6000)
                .build();
        // 开启连接
        zkClient.start();

        // 获取节点的值
        //byte[] bytes = zkClient.getData().forPath("/");
        byte[] bytes2 = zkClient.getData().forPath("/key");
        //System.out.println(new String(bytes));
        System.out.println(new String(bytes2));

        // 关闭连接
        zkClient.close();
    }
}
