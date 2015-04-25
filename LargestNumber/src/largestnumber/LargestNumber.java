/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package largestnumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Meng
 * 
 * Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        
        List<Integer> list = new ArrayList<>();
        list.add(0);list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);list.add(7);list.add(8);list.add(9);
        
        String re = largestNumber(list);
        System.out.println(re);
    }
    
    public static String largestNumber(List<Integer> num) {
        if(num == null || num.size() == 0) return null;
        
        int size = num.size();
        
        String[] numbers = new String[size];
        
        for(int i = 0; i<size; i++){
            numbers[i] = num.get(i)+"";
        }
        
        Comparator<String> c = new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s2.compareTo(s1);
            }
            
        };
        Arrays.sort(numbers, c);
        
        for(int i =0; i<size; i++){System.out.println("Num "+ i+" is "+numbers[i]);}
        
        if(numbers[0].equals("0")){ System.out.println("this is 0"); return "0"; }
        
      
        
        StringBuilder sb = new StringBuilder();
        
        for(String s : numbers){
            sb.append(s);
        }
        
        
        return sb.toString();
    }
    
  
}
