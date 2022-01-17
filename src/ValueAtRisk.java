import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValueAtRisk {

    public static double varSingleTrade(List<Double> returnPercentage, int confidenceInterval){

        Collections.sort(returnPercentage);

        int index = returnPercentage.size() * confidenceInterval / 100;

        return returnPercentage.get(index - 1);

    }

    public static double varPortfolio(List<List<Double>> returnPercentageAll, List<Double> weights, int confidenceInterval){

        double portfolioVar = 0;

        for(int i = 0; i < returnPercentageAll.size(); i++){

            portfolioVar += varSingleTrade(returnPercentageAll.get(i), confidenceInterval) * weights.get(i);
        }

        return portfolioVar;

    }

    public static void main(String[] args) {

        //System.out.println(varSingleTrade(new int[]{-3, -1, 0, 1, 1, 4, 9}, 95));

        List<Double> sampleHistoricalData = new ArrayList<>();

        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("C:\\Users\\dhrub\\IdeaProjects\\Independent Practice\\src\\NFLX_historical_percentage_return.txt"));
            String line = reader.readLine();
            while(line != null){
                sampleHistoricalData.add(Double.parseDouble(line));
                line = reader.readLine();
            }
            reader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        List<Double> sampleHistoricalData2 = new ArrayList<>();

        BufferedReader reader2;
        try{
            reader2 = new BufferedReader(new FileReader("C:\\Users\\dhrub\\IdeaProjects\\Independent Practice\\src\\AAPL_historical_percentage_return.txt"));
            String line = reader2.readLine();
            while(line != null){
                sampleHistoricalData2.add(Double.parseDouble(line));
                line = reader2.readLine();
            }
            reader2.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        List<List<Double>> portfolioHistoricalData = new ArrayList<>();
        portfolioHistoricalData.add(sampleHistoricalData);
        portfolioHistoricalData.add(sampleHistoricalData2);

        List<Double> weights = new ArrayList<>();
        weights.add(0.1);
        weights.add(0.9);

        System.out.println(varSingleTrade(sampleHistoricalData, 95));
        System.out.println(varSingleTrade(sampleHistoricalData2, 95));

        System.out.println(varPortfolio(portfolioHistoricalData, weights, 95));

    }

}
