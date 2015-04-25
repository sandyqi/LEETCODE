/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package palindromenumber;

/**
 *
 * @author Meng
 */
public class PalindromeNumber {

    /**
   Determine whether an integer is a palindrome. Do this without extra space.
   Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer",
* you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
   * 
     */
    public static void main(String[] args) {
        int num = 543245;
        System.out.println(isPalindrome(num));
        
    }
    
    
    
    public static boolean isPalindrome(int x) {
        char[] ch = String.valueOf(x).toCharArray();
        int i = 0; int j = ch.length-1;
        
        while(i<j){
            if(ch[i] != ch[j]){
                return false;
            }
            i++;j--;
        }

        return true;
    }
}
