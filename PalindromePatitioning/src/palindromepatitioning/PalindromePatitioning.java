/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindromepatitioning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Meng
 *
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s = "aab", Return
 *
 * [
 * ["aa","b"], ["a","a","b"] ]
 *
 */
public class PalindromePatitioning {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "abbccd";
        System.out.println(s.substring(0, 1).equals("a"));
     //   String sub = s.substring(0,1);
        //   System.out.println(sub);
        List<List<String>> list = partition(s);
        printAll(list);
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        return doDp(list, s, 0);
    }

    public static List<List<String>> doDp(List<List<String>> list, String s, int index) {
        if (index >= s.length()) {
            return list;
        }

        int length = list.size();
        List<List<String>> temp = list;
        List<List<String>> list2 = new ArrayList<>();
        String curLetter = s.substring(index, index + 1);
        if (length == 0) {
            List<String> first = new ArrayList<>();
            first.add(curLetter);
            list.add(first);
            index++;
        }

        if (index < s.length() && curLetter.substring(curLetter.length() - 1, curLetter.length()).equals(s.substring(index, index + 1))) {
            while (index < s.length() && curLetter.substring(curLetter.length() - 1, curLetter.length()).equals(s.substring(index, index + 1))) {
                list = new ArrayList<>(temp);
                for (int i = 0; i < length; i++) {
                    
                    list.get(i).add(curLetter);
                    list2.add(list.get(i));
                }
                curLetter += curLetter;

                index++;
                System.out.print("index: " + index);
            }
            list = list2;
        }

        return doDp(list, s, index);
    }

    public static void printAll(List<List<String>> list) {
        int length = list.size();
        System.out.println("size: " + length);
        for (int i = 0; i < length; i++) {
            int length2 = list.get(i).size();
            for (int j = 0; j < length2; j++) {
                System.out.print(list.get(i).get(j) + ",");
            }
            System.out.println("end");
        }
    }
}

class Solution {
    List<List<String>> result = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        helper(s, new ArrayList<String>());
        return result;
    }        

    public void helper(String s, List<String> cur){                 //DFS every combinations
        if(s.length() == 0){result.add(cur); return;}        
        for(int i = 1; i <= s.length(); i++){
            String sub = s.substring(0,i);
            if(isPal(sub)){
                List<String> newList = new ArrayList<String>(cur);
                newList.add(sub);
                helper(s.substring(i,s.length()), newList);
            }
            else continue;                                    //not palindrome, ignore it
        }        
    }                

    public boolean isPal(String str){
        int l = 0;
        int r = str.length()-1;
        while(l <= r){
            if(str.charAt(l) != str.charAt(r))  return false;
            l++;r--;
        }
        return true;
    }
} 


class Solution2{
public List<List<String>> partition(String s) {
    List<String> res = new  ArrayList<String>();
    return findP(s,res);
}

public static  List<List<String>> findP ( String s, List<String>prevString)
{
    List<List<String>> res = new  ArrayList<List<String>>();
    for(int i=1; i<=s.length(); i++)
    {
        List<String>set = new  ArrayList<String>();
        if(isPalindrome(s.substring(0,i)))
        {
            set.addAll(prevString);
            set.add(s.substring(0,i));
            if(i==s.length())
                res.add(set);
            else
                res.addAll(findP(s.substring(i),set));
        }
    }
    return res;
}

public static boolean isPalindrome(String s)
{
    if(s.length()==1)
        return true;
    for(int i=0; i<s.length()/2;i++)
    {
        if(s.charAt(s.length()-1-i)!=s.charAt(i))
            return false;
    }
    return true;
}


}