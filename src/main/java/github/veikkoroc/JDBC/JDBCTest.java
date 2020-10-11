package github.veikkoroc.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/25 18:08
 */
public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取数据库连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest01?serverTimezone=Asia/Shanghai","root","root");
        //定义SQL
        String sql = "update person set age = 166 where name ='迪丽热巴'";
        //获取sql语句对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //执行sql
        int res = preparedStatement.executeUpdate();
        System.out.println(res);

    }
}
