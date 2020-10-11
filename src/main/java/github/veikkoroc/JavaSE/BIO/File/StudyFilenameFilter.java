package github.veikkoroc.JavaSE.BIO.File;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/11 13:56
 */
public class StudyFilenameFilter {
    public static void main(String[] args) {
        File file = new File("src/main/resources/io");
        String[] list = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });
        for (String s : list) {
            System.out.println(s);
        }
        /*
            Lambda 表达式
         */
        String[] list2 = file.list((dir, name) -> name.endsWith(".txt"));
        for (String s : list2) {
            System.out.println(s);
        }
    }
}
