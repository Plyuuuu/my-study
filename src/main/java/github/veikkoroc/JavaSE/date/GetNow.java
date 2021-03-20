package github.veikkoroc.JavaSE.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/15 13:51
 */
public class GetNow {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        System.out.println(getSysTimeYMD());
    }

    public static String getSysTimeYMD() {
        return (new SimpleDateFormat("yyyy-MM-dd")).format(new Date(System.currentTimeMillis()));
    }
}
