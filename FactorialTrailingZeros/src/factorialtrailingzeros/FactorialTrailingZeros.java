/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package factorialtrailingzeros;

/**
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // System.out.println(Math.pow(5,3));
       System.out.println(trailingZeroes(2147483647));
    }
    public static int trailingZeroes(int n) {
        int result = 0;
        int all2 = 0; int all5 = 0;
        all5 = n/5;
        int mul = all5;
        while(mul>0){
            mul=mul/5;
            all5+=mul;
        }
        return all5;
     
    }
}
