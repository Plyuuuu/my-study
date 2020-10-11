package github.veikkoroc.JDBC.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/25 18:20
 */
public class DruidTest {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        Properties properties = new Properties();
        InputStream is = DruidTest.class.getClassLoader().getResourceAsStream("jdbc/jdbc.properties");
        properties.load(is);
        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
