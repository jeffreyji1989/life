package cn.example.life.pattern.observer;

import java.util.Observable;

/**
 * Created by 季先生 on 2017/11/8 11:15.
 */
public class HanFeiZi extends Observable implements SubjectService {
    @Override
    public void thing1() {
        System.out.println("韩非子开始做事情1...");
        super.setChanged();
        super.notifyObservers("韩非子开始吃饭了...");
    }

    @Override
    public void thing2() {
        System.out.println("韩非子开始做事情2...");
        super.clearChanged();
        super.notifyObservers("韩非子开始喝酒了...");
    }
}
