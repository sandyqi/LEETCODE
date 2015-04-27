/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package singlenumber2;

/**
 *
 * @author Meng
 * 
 * Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
     public int singleNumber(int[] A) {
        /*
        element in A is 32bit,
        sum corresponding bits from all elements and mod each by 3 then should left the single number
        */
        int[] sum=new int[32];
        int res=0;
        for(int i=0;i<32;i++)
        {
            for(int j=0;j<A.length;j++)
            {
                sum[i]+=((A[j]>>>i)&1);//sum every bit of all numbers
            }
            sum[i]%=3;
            res+=((sum[i]&1)<<i);// recover the single number
        }
        return res;
    }
}
