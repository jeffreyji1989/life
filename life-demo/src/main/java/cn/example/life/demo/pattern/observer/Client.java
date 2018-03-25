package cn.example.life.demo.pattern.observer;

import java.util.Observer;

/**
 * Created by 季先生 on 2017/11/8 9:03.
 */
public class Client {
    public static void main(String[] args) {
        print();
    }

    public static void print(){
        Observer lisi = new Lisi();
        HanFeiZi hanfeizi = new HanFeiZi();
        hanfeizi.addObserver(lisi);
        hanfeizi.thing1();
        hanfeizi.thing2();
    }
}
