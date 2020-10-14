package github.veikkoroc.JavaSE.Z_Other;

import java.util.concurrent.atomic.LongAdder;

/**
 *
 * AtomicLong的原理是依靠底层的cas来保障原子性的更新数据，在要添加或者减少的时候，会使用死循环不断地cas到特定的值，从而达到更新数据的目的。
 * 那么LongAdder又是使用到了什么原理?难道有比cas更加快速的方式？
 *
 *LongAdder在AtomicLong的基础上将单点的更新压力分散到各个节点，在低并发的时候通过对base的直接更新可以很好的保障和AtomicLong的性能基本保持一致，
 * 而在高并发的时候通过分散提高了性能。
 * 缺点是LongAdder在统计的时候如果有并发更新，可能导致统计的数据有误差。
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/14 9:42
 */
public class LongAdderAndAtomicLong {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
    }
}
