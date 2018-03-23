package cn.example.life.pattern.template;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by 季先生 on 2018/3/23 10:36.
 */
public class SomeOne extends AbstractStep {
    @Override
    void stepOne() {
        System.out.println("some one step one");
    }

    @Override
    void stepTrhree() {
        System.out.println("some one step three");
    }

    @Override
    protected boolean ishook() {
        return false;
    }
}
