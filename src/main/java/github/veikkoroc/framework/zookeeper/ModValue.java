package github.veikkoroc.framework.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/26 15:34
 */
public class ModValue {



    public static void main(String[] args) throws Exception {
        // 重试策略
        ExponentialBackoffRetry retry = new ExponentialBackoffRetry(3000, 2);

        // 创建连接
        CuratorFramework zkClient = CuratorFrameworkFactory.builder()
                .sessionTimeoutMs(6000)
                .retryPolicy(retry)
                .connectString("127.0.0.1:2181").build();

        // 启动连接
        zkClient.start();

        // 修改值
        // zkClient.setData().forPath("/key","哈哈哈".getBytes());

        // 删除值
        // zkClient.delete().forPath("/key");

        // 删除节点
        zkClient.delete().deletingChildrenIfNeeded().forPath("/pl");


        // 关闭连接
        zkClient.close();
    }
}
