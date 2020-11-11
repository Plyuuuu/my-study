package github.veikkoroc.OS.Test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/10 10:57
 */
public class MyTest {
    public static void main(String[] args) {
        WarehouseTest warehouseTest = new WarehouseTest();
        int[] arr = warehouseTest.getArr();
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 测试随机数 Java.Util.Random类
     */
    @Test
    public void test(){
        /*// 1、无参构造器+无参方法
        Random random = new Random();
        while (true){
            // 随机的整形数据
            // 2100791671
            //-1782882353
            //531120016
            //-52935795
            int i = random.nextInt();
            System.out.println(i);
        }*/


        // 2、无参构造器+有参方法
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            // 生成0~9随机数
            int k = random.nextInt(10);
            System.out.println(k);
        }


    }
    /**
     * 测试 Math.Random 方法
     */
    @Test
    public void test02(){

        for (int i = 0; i < 100; i++) {
            int random =(int) (Math.random()*1000);
            System.out.println(random);
        }

    }
}
