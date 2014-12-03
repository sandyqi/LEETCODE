/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decode_ways;

import java.util.List;

/**
 *A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 * @author Meng
 */
public class Decode_Ways {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // System.out.println(numDecodings("21215"));
       System.out.println(numDecodings("29432943"));
      
    }
    
    
  public static int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

        return memo[0];
    }
  

    
    public static int decoding(String s){
        return 0;
    }
    public static List<String> transfer(String s){
        
        
        
        return null;
    }
}
