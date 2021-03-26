package github.veikkoroc.framework.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 *
 *  path：最后一个/后面接的不是节点，而是前面节点的 key，
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/26 14:52
 */
public class CreateNode {
    public static void main(String[] args) throws Exception {
        // 创建重试策略
        ExponentialBackoffRetry retry = new ExponentialBackoffRetry(3000, 3);

        // 创建连接
        CuratorFramework zkClient = CuratorFrameworkFactory.builder()
                .sessionTimeoutMs(3000)
                .retryPolicy(retry)
                .connectString("127.0.0.1:2181")
                .build();

        // 开启连接
        zkClient.start();

        // 创建节点
        // zkClient.create().forPath("/key","value".getBytes());

        // 多级节点
        zkClient.create().creatingParentsIfNeeded().forPath("/pl/plkey2");
        // zkClient.create().creatingParentsIfNeeded().forPath("/pl/pl3");

        // 临时节点
        // zkClient.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/node1/001");
        // zkClient.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/node1/002","hhhh0".getBytes());
        // zkClient.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/node1/002/003","hhhh0".getBytes());

        // 关闭连接
        zkClient.close();

    }
}
