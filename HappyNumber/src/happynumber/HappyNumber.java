/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package happynumber;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Meng
 * 
 * 
 * 
 */
public class HappyNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
     public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        int num = n;
        
        while(true){
            if(num == 1) return true;
            
            if(set.contains(num)) return false;
            
            set.add(num);
            String s = String.valueOf(num);
            num = 0;
            for(int i = 0; i<s.length(); i++ ){
                int p = Integer.valueOf(s.substring(i, i+1));

                num+=p*p;
            }
 
            
        }   
    }
     
     //only 1, 7 is happy number
     
     public static boolean isHappy2(int n){
         int num = n;
         if(num<0) return false;
         while(true){    
             if(num<10){
                 if(num == 1 || num == 7) return true;
                 return false;
             }
             int sum = 0;
             while(num!=0){
                 sum += (num%10)*(num%10);
                 num =num/10;
             } 
             num = sum;
         }

     }
} 
     
    
