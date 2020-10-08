package github.veikkoroc.javaee.mybatis.a;

import lombok.*;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/25 19:33
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    private int id;
    private String countryname;
    private String countrycode;
}
