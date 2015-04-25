/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repeateddnasequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Meng
 *
 *
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 *
 * For example,
 *
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 *
 * Return: ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class RepeatedDNASequence {

    /**
     * I do not get it
     *
     * this uses hash table, you have to create it.
     */
    public static void main(String[] args) {
       String s = "CAAAAAAAAAC";
   //   s.su
     //  getDNA(s);
       int a = Solution.convert("CAAAAAAAAA");
       int b = Solution.convert("AAAAAAAAAC");
       int c = convert("AAAAAAAAAC");
       System.out.println(a+"  "+b+"   "+c);
   //    Solution.findRepeatedDnaSequences(s);
   //    System.out.println(getDNA(s));
    }
    
    public static List<String> getDNA(String s){
        
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<String> re = new ArrayList<>();

        for(int i = 0; i<=s.length()-10; i++){
            String sub = s.substring(i,i+10 );
         
            int hash = convert(sub);
            
               System.out.println("sub "+sub+"   hash "+hash);
            
            if(set.contains(hash)){
                if(!set2.contains(hash)){
                    set2.add(hash);
                    re.add(sub);
                    System.out.println(sub);
                }
            }else{
                set.add(hash);
            }
        }
        
        
        return re;
    }
    
    public static int convert(String s){
        int re = 0;
        for(int i =0 ; i <s.length(); i++){
            re+= getCode(s.charAt(i));
            re *= 4;
            System.out.println("char = "+s.charAt(i)+"  "+re);
        }
        return re;
    }
    
    public static int getCode(char c){
       
        switch(c){
            case 'A': 
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            default: return 3;
        }
        
    }
    

}

class Solution2 {

    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> hash_set = new HashSet<Integer>();
        List<String> result = new ArrayList<String>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String substr = s.substring(i, i + 10);
            Integer substr_hashcode = getHashCode(substr);
            if (hash_set.contains(substr_hashcode) == true && result.contains(substr) == false) {
                result.add(substr);
            } else {
                hash_set.add(substr_hashcode);
            }
        }

        return result;
    }

    Integer getHashCode(String str) {
        int hash = 0;
        for (int i = 0; i <= str.length() - 1; i++) {
            hash = hash << 2 | getCode(str.charAt(i));
        }

        return hash;
    }

    int getCode(char c) {
        if (c == 'A') {
            return 0;
        } else if (c == 'C') {
            return 1;
        } else if (c == 'G') {
            return 2;
        }
        return 3;
    }
}

/*
 maintain two hashSets, one records the 10-letter substrings when scanning the input string, 
 the other stores the strings that are already in the result.

 need to convert string to integer to reduce memory used. Since there are only four possible characters in string, 
 I can use a 4-based integer to represent each string.

 one tricky thing: do not write comments outside the class, or u will get Memory Limit Exceeded.
 */
class Solution {

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        int len = s.length();
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for (int i = 10; i <= len; ++i) {
            String sub = s.substring(i - 10, i);
            int n = convert(sub);
            if (!res.contains(n)) {
                if (!set.contains(n)) {
                    set.add(n);
                } else {
                    ans.add(sub);
                    res.add(n);
                    System.out.println(sub);
                }
            }
        }
        return ans;
    }

    public static int convert(String sub) {
        int res = 0;
        HashMap<Character, Integer> dict = new HashMap<>();
        dict.put('A', 0);
        dict.put('C', 1);
        dict.put('G', 2);
        dict.put('T', 3);
        for (int i = 0; i < 10; ++i) {
            res += dict.get(sub.charAt(i));
            res *= 4;
        }
        return res;
    }

}
