package github.veikkoroc.codetest;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/24 10:42
 */
public abstract class Test01 {
    public int constInt = 5;
    
    {
        //该式子需要在代码块中
        constInt = constInt + 5;
    }
    public void method(){

    }
}
