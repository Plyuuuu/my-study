package github.veikkoroc.JavaEE.mybatis.b;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/25 23:00
 */
public class MyTest {
    private static SqlSessionFactory sqlSessionFactory;
    @BeforeClass
    public static void init(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testSelectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<Department> getAllCountry = sqlSession.selectList("getAllDepartment");
        sqlSession.close();

        for (Department department : getAllCountry) {
            System.out.println(department);

        }

    }
}
