package github.veikkoroc.javaee.mybatis.a;

import java.util.List;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/25 19:28
 */
public interface CountryMapper {
    /**
     * 根据id查询国家
     * @param id
     * @return
     */
    Country getCountryById(int id);

    /**
     * 查询所有Country
     * @return
     */
    List<Country> getAllCountry();
}
