import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ValueAtRiskTest {

    List<List<Double>> returnPercentageAll;
    List<Double> weightModified;
    List<Double> demo;

    @Before
    public void createPortfolio(){
        weightModified = new ArrayList<>();
        weightModified.add(1.0);
        weightModified.add(0.0);

        returnPercentageAll = new ArrayList<>();
        demo = new ArrayList<>();
        demo.add(0.01);
        demo.add(-0.02);
        demo.add(0.03);
        List<Double> demo2 = new ArrayList<>();
        demo2.add(0.01);
        demo2.add(-0.02);
        demo2.add(0.03);
        returnPercentageAll.add(demo);
        returnPercentageAll.add(demo2);
    }


    @Test
    public void varPortfolioTest(){

        assertEquals(ValueAtRisk.varSingleTrade(returnPercentageAll.get(0), 95), ValueAtRisk.varPortfolio(returnPercentageAll, weightModified, 95), 0.0001);

    }

    @Test
    public void varSingleTradeTest(){
        assertEquals(Collections.max(demo), ValueAtRisk.varSingleTrade(demo, 100), 0.000001);
    }

}