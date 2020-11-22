package github.veikkoroc.framework.mybatis.a;

import lombok.extern.slf4j.Slf4j;
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
 * @date 2020/9/25 19:41
 */
@Slf4j
public class MyTest {



    public static void main(String[] args) throws IOException {
        //通过配置文件获取sqlSessionFactory对象
        String resource = "mybatis/mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        log.info("SqlSessionFactory: [{}]",build);

        //通过sqlSessionFactory获取SqlSession对象
        SqlSession sqlSession = build.openSession();
        log.info("SqlSession:[{}]",sqlSession);

        CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);

        Country country =  mapper.getCountryById(1);
        System.out.println(country);


    }
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

        List<Country> getAllCountry = sqlSession.selectList("getAllCountry");
        sqlSession.close();

        for (Country country : getAllCountry) {
            System.out.println(country);
        }

    }
}
