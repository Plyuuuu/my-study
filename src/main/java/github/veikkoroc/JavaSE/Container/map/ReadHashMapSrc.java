package github.veikkoroc.JavaSE.Container.map;

import java.util.HashMap;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/29 15:54
 */
public class ReadHashMapSrc {
    public static void main(String[] args) {

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < 13; i++) {
            hashMap.put(i,i);
        }
        hashMap.get(1);
    }
}
