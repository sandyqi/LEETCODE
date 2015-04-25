/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Meng
 */
public class Solution {
public static Scanner scan;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
       // scan = new Scanner(System.in);
       String s = "  what is this? ";
       System.out.println(s.trim());
        /*
        int tests = Integer.parseInt(scan.nextLine().trim());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<tests; i++){
            int[] prices = readData();
            if(prices == null) list.add(0);
            else{
              list.add(maxProfit(prices));
            }
        }
        for(int i = 0 ; i <tests; i ++){
            System.out.println(list.get(i));
        }
        */
    
    }
      public static int maxProfit(int[] prices) {
        if (prices.length == 1 || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int maxPrice = prices[len - 1];
        int totalProfit = 0;
        int i = len - 2;
        while (i >= 0) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
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
      
        int tests = Integer.parseInt(scan.nextLine().trim());
        if(tests<1 || tests>50000) return null;
        int[] t = new int[tests];
        int index = 0;
        String nums = scan.nextLine();
        nums = nums.replaceAll("[^0-9]+", " ");
        List<String> list= Arrays.asList(nums.trim().split(" "));
        if(list.size()!= tests) return null;
        for(int i = 0; i<tests;i++){
            int num = Integer.parseInt(list.get(i));
            if(num<1 || num>100000)return null;
            t[i]= num;
        }
        return t;
    }
  
}
