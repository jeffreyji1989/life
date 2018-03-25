package cn.example.life.demo.pattern.template;

/**
 * Created by 季先生 on 2018/3/23 10:55.
 */
public class Client {
    public static void main(String[] args) {
        AbstractStep someOne = new SomeOne();
        someOne.join();
    }
}
