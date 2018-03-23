package cn.example.life.pattern.template;


/**
 * Created by 季先生 on 2018/3/23 10:25.
 */
public abstract class AbstractStep {
    abstract void stepOne();

    protected void  stepTwo(){
        System.out.println("这是第二步");
    };

    abstract void stepTrhree();

    protected void stepFour(){
        System.out.println("这是第四步");
    };

    public final void join() {
        stepOne();
        stepTwo();
        if (ishook()) {
            stepTrhree();
        }
        stepFour();
    }

    protected boolean ishook(){
        return true;
    }

}
