package cn.example.life.demo.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by 季先生 on 2017/11/8 11:17.
 */
public class Lisi implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        report(arg);
    }

    private void report(Object arg){
        System.out.println("报告秦老板，韩非子有活动:" + arg);
    }
}
