package cn.example.life.demo.pattern.decorate;

/**
 * Created by 季先生 on 2017/11/8 9:21.
 */
public class Decorate extends AbstractSchoolReport {
    private AbstractSchoolReport abstractSchoolReport;

    public Decorate() {
    }

    public Decorate(AbstractSchoolReport abstractSchoolReport) {
        this.abstractSchoolReport = abstractSchoolReport;
    }

    @Override
    void scoreReport() {
        abstractSchoolReport.scoreReport();
    }

    @Override
    void sign(String name) {
        abstractSchoolReport.sign(name);
    }
}
