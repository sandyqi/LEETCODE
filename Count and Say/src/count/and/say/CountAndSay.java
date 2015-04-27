/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package count.and.say;

/**
 *
 * @author Meng
 * 
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(countAndSay2(1));
       // System.out.println(translate(5));
    }
    
  
    
    public static String countAndSay2(int n){
        String num = "1";
        for(int i = 1; i<n; i++){
            num =translate(num);
            System.out.println(i + ":   "+num);
        }
        return num;
    }
    
    
    // this method generates 0-9 digits number
    public static String translate(String n){
       StringBuilder sb = new StringBuilder();
       char[] chars=null;
       chars = n.toCharArray();
       int length = chars.length;
      
       //When only has one element
       if(length == 1){
           sb.append(1);
           sb.append(chars[0]);
           return sb.toString();
       }
       
       for(int i = 0; i<length;){
           int num = 1;
   
        // Normal situation
           while(i+num != length -1 && chars[i]==chars[i+num]){
               num++;
           }
           
        //Last element. If so, we cannot compare it with last+1 element.
           if(i+num == length -1){
               if(chars[i+num] == chars[i]){
                   num++;
                   sb.append(num);
                   sb.append(chars[i]);
                   return sb.toString();
               }else{
                   sb.append(num);
                   sb.append(chars[i]);
                   sb.append(1);
                   sb.append(chars[i+num]);
                   return sb.toString();
               }
           }
         
           sb.append(num);
           sb.append(chars[i]);
           i+=num;
  
       }
       return sb.toString();
    }
 
    
}


class Solution427{
    
    public String countAndSay(int n) {
    if (n == 1) {
        return "1";
    }
    String str = "1", result = "";
    int counter = 0, current = 0, prev = 0;
    char[] chars;
    for (int i = 2; i <= n; i++) {
        chars = str.toCharArray();
        result = "";
        counter = 0;
        current = 0; 
        prev = 0;
        for (int j = 0; j < chars.length; j++){
            current = (int)(chars[j] - '0');
            if (current == prev) {
                counter++;
            } else if (current != prev && counter != 0) {
                result += counter + "" + prev;
                prev = current;
                counter = 1;
            } else {
                prev = current;
                counter++;
            }
        }
        result += counter + "" + current;
        str = result;
    }

    return str;
}
    
    
}