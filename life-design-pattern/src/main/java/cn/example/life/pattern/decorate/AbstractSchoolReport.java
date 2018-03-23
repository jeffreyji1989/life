package cn.example.life.pattern.decorate;

/**
 * Created by 季先生 on 2017/11/8 9:08.
 * 具体要做的事情的抽象类
 */
public abstract class AbstractSchoolReport {
    // 成绩报告
    abstract void scoreReport();
    // 家长签字
    abstract void sign(String name);
}
