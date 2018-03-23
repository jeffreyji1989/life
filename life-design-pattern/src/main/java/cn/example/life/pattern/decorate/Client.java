package cn.example.life.pattern.decorate;

/**
 * Created by 季先生 on 2017/11/8 9:03.
 */
public class Client {
    public static void main(String[] args) {
        AbstractSchoolReport abstractSchoolReport = new FourClassReport();
        abstractSchoolReport.scoreReport();
        abstractSchoolReport.sign("老二");
        System.out.println("=====================================================");

        //第一次装饰
        abstractSchoolReport = new FirstDecorate(abstractSchoolReport);
        abstractSchoolReport.scoreReport();
        abstractSchoolReport.sign("老二");
        System.out.println("=====================================================");
        //第二次装饰
        abstractSchoolReport = new SecondDecorate(abstractSchoolReport);
        abstractSchoolReport.scoreReport();
        abstractSchoolReport.sign("老二");
    }
}
