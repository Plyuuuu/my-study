package github.veikkoroc.OS.ProducerAndConsumer;

/**
 * 仓库（有限货架）：
 *      1、提供 put 方法放产品
 *      2、提供 get 方法获取产品
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/10 10:45
 */
public class Warehouse {

    // 仓库的货架
    private static final int[] wareRack = new int[10];

    // 建立辅助双指针
    private static int putIndex = 0;

    private static int getIndex = 0;

    // 往仓库放物品
    public static void put(int n){

        // P(位置),有位置才放入
        // P(仓库),获取仓库这个临界资源
        try {
            Sem.P_MUTEX.acquire();
            Sem.SITE.acquire();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // 产品放入仓库
        wareRack[putIndex] = n;
        System.out.println("仓库货架:"+putIndex+" 放入产品:"+n);
        putIndex = (putIndex+1)%wareRack.length;


        // V(产品数),放入产品后产品数+1
        Sem.PRODUCT_COUNT.release();
        // V(仓库),放完了吧仓库释放
        Sem.P_MUTEX.release();


    }
    //  从仓库取物品
    public static int get(){


        // P(产品数),产品数>0才能取出
        // P(仓库),获取仓库这个临界资源才能取出(消费者互斥)
        try {
            Sem.C_MUTEX.acquire();
            Sem.PRODUCT_COUNT.acquire();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 产品从仓库取出
        int res = wareRack[getIndex];
        System.err.println("仓库货架:"+getIndex+" 取出产品:"+res);
        getIndex = (getIndex+1)%wareRack.length;


        // V(位置数),取出产品位置+1
        Sem.C_MUTEX.release();
        Sem.SITE.release();


        return res;
    }

}
