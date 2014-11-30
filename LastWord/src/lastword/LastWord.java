/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lastword;

/**
 *
 * @author Meng
 */
public class LastWord {

    /**
   Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "";
        int j = s.length();
      //  int i = lengthOfLastWord(s);
        System.out.println(j);
        
    }
     public static int lengthOfLastWord(String s) {
          if (s.length() == 0){
             return 0;
         }
         int last = s.length()-1;
         while(!Character.isLetter(s.charAt(last))){
             last --;
             if(last == -1){
                 return 0;
             }
         }
         int first = last;
         //check >=0 first
         while(first >=0 && Character.isLetter(s.charAt(first))){
             first --;
         }
     
         
        return last - first;
    }
}
