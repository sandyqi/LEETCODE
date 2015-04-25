/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reversebits;

/**
 *
 * @author Meng
 * 
 * 
 * 
 * Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
* return 964176192 (represented in binary as 00111001011110000010100101000000).
 */
public class ReverseBits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String n = Integer.toBinaryString(1);
        int s = reverseBits(1);
        System.out.println(s);
    }
    
    public static int reverseBits(int n) {
        if(n==1) return Integer.MAX_VALUE;
        String num = Integer.toBinaryString(n);
        char[] ch = num.toCharArray();
        printAll(ch);
        char[] full = new char[32];
        int length = ch.length;
        if(length<32){
            for(int i = 0; i<32-length; i++){
                full[i] = '0';
            }
            for(int i =32-length; i<32; i++){
                full[i] =  ch[i-32+length];
                System.out.println("Add 1");
            }
        }
        int reverse = 0;
        
        printAll(full);
        for(int i =0; i<full.length; i++){
            if(full[i]=='1'){
                reverse+=Math.pow(2, i);
              
            }
        }
        
        return reverse;
        

    }
     public static void printAll(char[] nums){
        for(int i = 0; i<nums.length; i++){
            System.out.print(nums[i]);
        }
        System.out.println();
    }
}
