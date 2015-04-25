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
       System.out.println(numDecodings("111561201010"));
            System.out.println(decode("111561201010"));
      
    }
    
    //利用数组叠加和传递进行记录
       public static int numDecodings(String s) {  
        if(s==null || s.length()==0) {  
            return 0;  
        }  
        if(s.charAt(0)=='0') {  
            return 0;  
        }  
          
        int [] number = new int[s.length() + 1];  
        number[0] = 1;  
        number[1] = 1;  
        int tmp;  
        for(int i=2;i<=s.length();i++) {  
            //检查当前字符是不是'0'  
            tmp = Integer.parseInt(s.substring(i-1,i));  
            if(tmp!=0) {              
                number[i] = number[i-1];  
            }  
            //检查当前字符和前一个字符组合在一起是否在1-26之间  
            if(s.charAt(i-2)!='0') {  
                tmp = Integer.parseInt(s.substring(i-2,i));  
                if(tmp>0&&tmp<=26) {  
                    number[i] += number[i-2];  
                }  
            }  
        }  
        return number[s.length()];  
    }  
    
       public static int decode(String s){
           //if s is null
           if(s.length() == 0 || s == null){
                return 0 ;
           }
           //if first digit is 0
           if(s.charAt(0) == '0'){
               return 0 ;
           }
           
           //create an array to keep track of combination for each digit with the previous digit
          int [] num = new int[s.length()+1];
          num[0] = 1;
          //the first digit only has one combination with the prefious digit
          num[1] = 1;
          //the current digit
          int tep;
          //from the second digit to the last digit, these digits all have previous digit, and now we can check the possible combination
          for(int i=2; i<=s.length(); i++){
              //when i=2, this tep is the first digit
              tep = Integer.parseInt(s.substring(i-1,i));
              //0 cannot exist itself. It have to be with the previous digit
              if(tep != 0){
                  num[i] = num[i-1];
              }
              //仍然是f(n) = f(n-1) + f(n-2)的问题。只是加入了限制条件0 以及>26的情况。
              if(s.charAt(i-2) != '0'){
                  tep = Integer.parseInt(s.substring(i-2,i));
                  if(tep >0 && tep<= 26){
                      num[i] += num[i-2];
                  }
              }
          }
          
      
           return num[s.length()];
       }

}
