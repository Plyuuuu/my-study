package github.veikkoroc.framework.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 *
 * 连接 zk
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/26 14:35
 */

public class ConnectZK {

    /**
     * 重试策略 : 重试之间的等待时间 2 s,最大重试次数为 3 次
     */
    private static final int BASE_SLEEP_TIME = 2000;
    private static final int MAX_RETRIES = 3;


    public static void main(String[] args) {
        // 重试策略
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(BASE_SLEEP_TIME, MAX_RETRIES);
        // 创建连接
        CuratorFramework zkClient = CuratorFrameworkFactory.builder()
                .retryPolicy(retryPolicy)
                .connectString("127.0.0.1:2181")
                .sessionTimeoutMs(6000)
                .build();
        // 开启连接
        zkClient.start();
        System.out.println("===> 获得的 zkClient:"+zkClient);

    }
}

