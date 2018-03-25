package cn.example.life.demo.pattern.decorate;

/**
 * Created by 季先生 on 2017/11/8 9:12.
 * 具体事情的实现
 */
public class FourClassReport extends AbstractSchoolReport {
    @Override
    void scoreReport() {
       System.out.println("尊敬的XXXX你好,您孩子本期末的考试成绩如下:\n     xxxxxxxxxxxxxxxxxxxx \n");
    }

    @Override
    void sign(String name) {
        System.out.println("家长签字:" + name);
    }
}
