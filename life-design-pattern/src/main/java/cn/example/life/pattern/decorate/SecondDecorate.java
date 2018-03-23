package cn.example.life.pattern.decorate;

/**
 * Created by 季先生 on 2017/11/8 9:58.
 */
public class SecondDecorate extends Decorate {
    public SecondDecorate(AbstractSchoolReport abstractSchoolReport){
        super(abstractSchoolReport);
    }

    private void locationSort(){
        System.out.println("整体排名18");
    }

    @Override
    void scoreReport() {
        super.scoreReport();
        locationSort();
    }
}
