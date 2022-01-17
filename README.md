# ActiveViam-Business-Solutions-Interview

Given an array of all the historical %return of a stock(i.e. last 252 days for stock prices) and another integer as the confidence level(95/97/?) we follow the following method to calculate value at risk from historical values:

First we multiply 252 with the confidence level and then divide by 100(if it’s 95, then we get 252 * 95 / 100 = 240). Now, the value at risk will be the 240th value of all the historical %return in the ascending order.

Extending this calculation for a portfolio:

Let’s assume there are n number of stocks in a portfolio. In that case, we will calculate VAR for all of them individually using corresponding historical %return. After that, we will need the weight of each stock to calculate the portfolio VAR.

PortFolio VAR = VAR of stock1 * weight of stock1 in that portfolio + VAR of stock2 * weight of stock2 in that portfolio +.... 
