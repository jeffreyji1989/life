package cn.example.life.pattern.decorate;

/**
 * Created by 季先生 on 2017/11/8 9:29.
 */
public class FirstDecorate extends Decorate {
    public  FirstDecorate(AbstractSchoolReport abstractSchoolReport){
       super(abstractSchoolReport);
    }

    private void maxScoreReport(){
        System.out.println("班级里的最高成绩是:语文:xxx,数学:xxxx,英语:xxxxx!");
    }

    /**
     * 重写scoreReport方法
     */
    @Override
    void scoreReport() {
        maxScoreReport();
        super.scoreReport();
    }
}
