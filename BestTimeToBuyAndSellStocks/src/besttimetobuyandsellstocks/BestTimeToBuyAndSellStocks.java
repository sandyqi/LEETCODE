/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package besttimetobuyandsellstocks;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Meng
 */
public class BestTimeToBuyAndSellStocks {

    /**
     * Say you have an array for which the ith element is the price of a given
     * stock on day i.
     *
     * If you were only permitted to complete at most one transaction (ie, buy
     * one and sell one share of the stock), design an algorithm to find the
     * maximum profit.
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
      //  int[] test = {1,2,100};
      //  int num = maxProfit2(test);
      //  System.out.println(num);
        getResult();
    }

    public static int maxProfit(int[] prices) {

        int length = prices.length;

        if (length == 0 || length == 1) {
            return 0;
        }

        int maxPrice = prices[length - 1];
        int maxProfit = 0;
        int index = length - 2;
        while (index >= 0) {
            if (prices[index] > maxPrice) {
                maxPrice = prices[index];
            }
            int profit = maxProfit - prices[index];
            if (profit > maxPrice) {
                maxProfit = profit;
            }
            index--;
        }
        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        if (prices.length == 1 || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int maxPrice = prices[len - 1];
        int totalProfit = 0;

        int i = len - 2;
        while (i >= 0) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i]; // when stock goes down, we do not care about it.
            }
            int profit = maxPrice - prices[i];
            if (profit > 0) {
                totalProfit += profit;
            }
            i--;
        }

        return totalProfit;
    }
    public static int[] readData() throws Exception{
        Scanner scan = new Scanner(System.in);
        int tests = scan.nextInt();
        if(tests<=0) return null;
        int[] t = new int[tests];
        int index = 0;
        while(index<tests){
            t[index]=scan.nextInt();
            index++;
        }
        
        return t;
    }
    public static int[] getResult() throws Exception{
        Scanner scan = new Scanner(System.in);
        int tests = scan.nextInt();
        int[] result = new int[tests];
        for(int i = 0; i<tests; i++){
            int[] prices = readData();
            if(prices == null){
                return null;
            }
            result[i] = maxProfit2(prices);
        }
        
        return result;
    }
    
    public static int maxProfitMultipleTransaction(int[] prices) {
        int profit = 0;
        int length = prices.length;

        if (length == 0 || length == 1) {
            return profit;
        }

        int maxPrice = prices[length - 1];
        int minPrice = maxPrice;
        int index = length - 2;

        while (index >= 0) {
            while (index >= 0 && prices[index] >= maxPrice) {
                maxPrice = prices[index];
                index--;
            }
            minPrice = maxPrice;
            while (index >= 0 && prices[index] <= minPrice) {
                minPrice = prices[index];
                index--;
            }
            profit += maxPrice - minPrice;
            maxPrice = minPrice;
        }

        return profit;
    }

    public int maxProfitMultipleTransaction2(int[] prices) {
        int profit = 0, i = 0;
        while (i < prices.length) {
            // find next local minimum
            while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                i++;
            }
            int min = prices[i++]; // need increment to avoid infinite loop for "[1]"
            // find next local maximum
            while (i < prices.length - 1 && prices[i + 1] >= prices[i]) {
                i++;
            }
            profit += i < prices.length ? prices[i++] - min : 0;
        }
        return profit;
    }

    public int maxProfitTwoTransaction(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for (int i : prices) {                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2 + i);     // The maximum if we've just sold 2nd stock so far.
            hold2 = Math.max(hold2, release1 - i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1 + i);     // The maximum if we've just sold 1nd stock so far.
            hold1 = Math.max(hold1, -i);          // The maximum if we've just buy  1st stock so far. 
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }

    
       public int maxProfitTwoTransaction2(int[] prices) {
       // traverses. one from left to right. one from right to left. 
       //left means, max profit for the left point
       //right means, max profit for the right point
       //to sum them up, getting the maximum
           
           int profit = 0; int length = prices.length;
           
           if(length== 0  || length ==1){
               return profit;
           }
           
           
           int[] leftPoints = new int[length];
           int minPrice = prices[0];
           int maxProfit = 0;
           int index = 0;
           int currentMax=0;
           // find all left points largest profit, and add them into leftPoints.
           while(index <length){
               if(prices[index]<minPrice){
                   minPrice = prices[index];
               }
               currentMax = prices[index] - minPrice;
               if(currentMax > maxProfit){
                   maxProfit = currentMax;
               }
               leftPoints[index] = maxProfit;
               index++;
           }
           
           // do traverse from right to left.
           int maxPrice = prices[length-1];
           maxProfit = 0;  index = length -1; currentMax = 0;
           
           while(index>=0){
               if(maxPrice< prices[index]){
                   maxPrice = prices[index];
               }
               currentMax = maxPrice - prices[index];
               if(currentMax > maxProfit){
                   maxProfit = currentMax;
               }
               if(index>0 && profit<maxProfit+leftPoints[index]){
                   profit= maxProfit+leftPoints[index];
               }
               index--;
           }
           
           
           
           return profit;
       }
    
    
}


class Practice426{
    
    public int maxProfit(int[] prices){
        if(prices==null ||prices.length == 1) return 0;
        
        int maxProfit = 0; int currentProfit = 0;
        int maxPrice = prices[prices.length-1];
        
        int index = prices.length -2;
        
        while(index>=0){
            if(prices[index]>maxPrice) maxPrice = prices[index];
            
            currentProfit = maxPrice - prices[index];
            
            if(currentProfit>maxProfit) maxProfit = currentProfit;
            
            index--;
        }
        
        
        
        
        return maxProfit;
        
        
    }
    
    
    
}


//Say you have an array for which the ith element is the price of a given stock on day i.

//Design an algorithm to find the maximum profit. You may complete at most k transactions.

class BestTime4{
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);

        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }


    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
    
    
}