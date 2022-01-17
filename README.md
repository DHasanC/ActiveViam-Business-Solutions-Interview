# ActiveViam-Business-Solutions-Interview

## Value At Risk Calculation using Historical Data
Given an array of all the historical %return of a stock(i.e. last 252 days for stock prices) and another integer as the confidence level(95/97/?) we follow the following method to calculate value at risk from historical values:

First we multiply 252 with the confidence level and then divide by 100(if it’s 95, then we get 252 * 95 / 100 = 240). Now, the value at risk will be the 240th value of all the historical %return in the ascending order.

Extending this calculation for a portfolio:

Let’s assume there are n number of stocks in a portfolio. In that case, we will calculate VAR for all of them individually using corresponding historical %return. After that, we will need the weight of each stock to calculate the portfolio VAR.

PortFolio VAR = VAR of stock1 * weight of stock1 in that portfolio + VAR of stock2 * weight of stock2 in that portfolio +.... 

## Writing Unit tests
One unit test has been provided here for each methods:
1. One edge case would be when there is only one stock in a portfolio, then portofolio VAR should equal singleTradeVAR
2. Another edge case would be when the confidence interval is 100, then singleTradeVAR should be the maximum %return in the historical dataset

## Running this application
The easiest way to run this appication would be to clone this repository and open with a java IDE like IntelliJ. To run the test cases, adding the JUnit 4 library to the IDE would be necessary

## Dateset 
To run and validate the application using real-world data, I have provided Apple and Netflix historical dataset (neither the actual stock price nor the dates, only %return in seperate lines in a txt file) for the past 252 days. This values were found from yahoo finance website and then converted to percentage return by simple manipulation using MS excel.

## References
1. https://www.youtube.com/watch?v=WJWlHJuEUss&t=4s
2. https://finance.yahoo.com/quote/AAPL/history?p=AAPL
3. https://www.investopedia.com/terms/v/var.asp
