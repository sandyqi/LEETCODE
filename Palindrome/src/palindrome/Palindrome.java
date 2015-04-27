/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package palindrome;

import java.util.Stack;

/**
 *
 * @author Meng
 */
public class Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = ",; W;:GlG:;l ;,";
        String s2="#4f3.4.3f4#";
        boolean b = isPalindrome(s);
        boolean c = isPalindrome("ca4ac");
        Practice426 p = new Practice426();
        boolean pp = p.isPalindrome(s2);
        System.out.println(pp);
    }
    
    public static boolean isPalindrome(String s) {
        s=s.toLowerCase();
        char[] cArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        // text with no Character
        if("".equals(s)){
            return true;
        }
        //a string only contains symbol and space
        boolean onlySpaceSign=true;
        for(char c : cArray){
            if(Character.isLetter(c) || Character.isDigit(c)){ 
                onlySpaceSign = false;
            }
        }
        if(onlySpaceSign){
            return true;
        }
        for(char c : cArray){
            if(Character.isLetter(c)|| Character.isDigit(c)){
                stack.add(c);
            }
        }
        int length = stack.size();
        for(int i=0;i<length/2;i++){
            if(stack.get(i)==stack.peek()){
                stack.pop();
            }else{
               //  System.out.println("(stack.get(0)!=stack.peek()"+"   "+stack.get(0)+"!="+stack.peek());
                return false;
            }
        }
       
        return true;
    }
    
    
    public static boolean isPalindrome2(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i))
                    != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
      
        }
        return true;
    }
    public static boolean isPalindrome3(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;  //find the comparable i
            }
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))){
                j--; //find the comparable j
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false; //compare one pair
            }
        }
        return true;
    }
}

class Practice426{
    public static boolean isPalindrome(String s){
        char[] ch = s.toCharArray();
        int i = 0; int j = ch.length-1;
        while(i<j){
            if(ch[i]!=ch[j]){ System.out.println("i is "+ch[i]+"   j is "+ch[j]);return false;}
            
            i++; j--;
        }
        
        
        return true;
    }
}