/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package numbersof1bits;

/**
 *
 * @author Meng
 * 
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class Numbersof1Bits {

    /**
     *take advantage of &.
     * move the digit of bit 
     */
    public static void main(String[] args) {
        int t =11;
        System.out.println(hammingWeight(t));
        System.out.println(8&7);
    }
    
    
    public static int hammingWeight(int n) {
        int result = 0;
        
        while(n!=0){
            n=n&(n-1);
            result++;
        }
        return result;
    }
    
    public static int hammingWeight2(int n){
    int count = 0;
    while(n!=0)
    {
        n = n&(n-1);
        count++;
    }
    return count;
    }
}
