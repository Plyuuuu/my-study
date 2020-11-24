package github.veikkoroc.middleware.redis;

import redis.clients.jedis.Jedis;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/24 16:09
 */
public class PingTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("47.99.93.144",6379);
        System.out.println(jedis);
        String set = jedis.set("jedis", "jedis");
        System.out.println(set);
        System.out.println(jedis.ping());
    }
}
