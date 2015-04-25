/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fractiontorecurringdecimal;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Meng
 * 
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class FractionToRecurringDecimal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String test = fractionToDecimal(2,3);
        System.out.println(test);
        
    }
    
    
    public static String fractionToDecimal(int numerator, int denominator) {
        
        if(numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        
        String sign = ((numerator>0)^(denominator>0))? "-" :"";
        sb.append(sign);
        
        long num = Math.abs((long)numerator);
        long dem = Math.abs((long)denominator);

        sb.append(num/dem);
        long reminder = num % dem;
        
        
        if(reminder == 0) return sb.toString();
        
        sb.append(".");
        
        Map<Long, Integer> map = new HashMap<>();
        map.put(reminder, sb.length());
        
        while(reminder != 0){
            reminder*= 10;
            sb.append(reminder/dem);
            reminder %= dem;
            if(map.containsKey(reminder)){
                int index = map.get(reminder);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }else{
                map.put(reminder, sb.length());
            }
        }
        
   
        return sb.toString();
        
    }
}
class Solution {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
}