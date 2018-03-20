package cn.example.life.demo.annotation;

/**
 * 耗时注解使用测试示例
 * Created by blinkfox on 2017-01-04.
 */
public class CostTimeTest {

    /** A类的全局实例. */
    private static A a;

    static {
        CostTimeProxy aproxy = new CostTimeProxy();
        a = (A) aproxy.getProxy(A.class);
    }

    /**
     * main 方法.
     *
     * @param args 数组参数
     */
    public static void main(String[] args) {
        a.doSomeThing();
        a.doSomeThing2();
    }

}
