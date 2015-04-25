/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package houserobber;

import java.util.ArrayList;
import java.util.List;

/**
 You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is that 
 * adjacent houses have security system connected and it will automatically contact the police 
 * if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
* determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {

    /**
     *the idea is to track max value of i-2, and i-3  when current is i. 
     * because i-4 should be less than i-2  
     */
    public static void main(String[] args) {
        
        int[] test = {8,1,1,8,2,6};
        System.out.println(rob(test));
        
    }
    
    public static int rob(int[] num) {
        if(num == null || num.length ==0) return 0;
        
        int length = num.length;
        
        if(length ==1) return num[0];
        
        if(length == 2) return Math.max(num[0], num[1]);
        
        if(length ==3) return Math.max(num[0]+num[2], num[1]);
        
        // length>=4
        
        int[] max = new int[num.length];
        max[0]=num[0]; max[1]=num[1]; max[2]= num[0]+num[2]; 
        
        for(int i = 3;i<length;i++){
            max[i]= num[i]+Math.max(max[i-2], max[i-3]);
        }
        
        return Math.max(max[length-1],max[length-2] );
    }
}
