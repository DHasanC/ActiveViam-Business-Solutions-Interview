import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValueAtRisk {

    public static double varSingleTrade(List<Double> returnPercentage, int confidenceInterval){

        //sorting the %p&L values in ascending order
        Collections.sort(returnPercentage);

        //calculating the index to look for in the sorted %p&L values
        int index = returnPercentage.size() * confidenceInterval / 100;

        return returnPercentage.get(index - 1);

    }

    public static double varPortfolio(List<List<Double>> returnPercentageAll, List<Double> weights, int confidenceInterval){

        //portfolio to be outputted
        double portfolioVar = 0;

        //looping through the List to calculate varSingleTrade and then applying appropriate weight
        for(int i = 0; i < returnPercentageAll.size(); i++){

            portfolioVar += varSingleTrade(returnPercentageAll.get(i), confidenceInterval) * weights.get(i);
        }

        return portfolioVar;

    }

    public static void main(String[] args) {

        //Netflix historical %p&L values to be inserted in the sampleHistoricalData arrayList
        List<Double> sampleHistoricalData = new ArrayList<>();

        //looping through the txt file and adding the double values to the sampleHistoricalData arrayList
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

        //Creating another arrayList for Apple %p&L values
        List<Double> sampleHistoricalData2 = new ArrayList<>();

        //Repeating the same process for Apple
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

        //creating arrayList for portfolio historical values
        List<List<Double>> portfolioHistoricalData = new ArrayList<>();
        portfolioHistoricalData.add(sampleHistoricalData);
        portfolioHistoricalData.add(sampleHistoricalData2);

        //adding weights
        List<Double> weights = new ArrayList<>();
        weights.add(0.1);
        weights.add(0.9);

        //printing out varSingleTrade for Netflix and Apple at 95% confidence interval
        System.out.println(varSingleTrade(sampleHistoricalData, 95));
        System.out.println(varSingleTrade(sampleHistoricalData2, 95));

        //printing out portfolio var
        System.out.println(varPortfolio(portfolioHistoricalData, weights, 95));

    }

}
