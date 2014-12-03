/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package angrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 *Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
 * @author Meng
 */
public class Angrams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    String s = "jkljdmvaa";
  //  System.out.println(translate(s));
  //  System.out.println(transfer(s));
    
    String[] test = {"dfs"};
    List<String> list = anagrams(test);
    for(int i = 0; i<list.size(); i++){
        System.out.println(list.get(i));
    }
  //  List<String> list = anagrams2(test);
   // for(int i = 0; i<list.size(); i++){
   //     System.out.println(list.get(i));
      // } 
  //  transfer("ppale");
  //  System.out.println(sort("ppaad"));
  //  System.out.println('b' - 'a');

    }
    
    public static List<String> anagrams(String[] strs) {  //this is all about index
        List<String> results= new LinkedList<String>();
             
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        
        for(int i = 0; i<strs.length; i++){
            String key = sort(strs[i]);
            List<Integer> list = map.get(key);
            if(list == null){
                list = new ArrayList<Integer>();
                list.add(i);
                map.put(key, list);
            }else{
                map.get(key).add(i);
            }
        }  // finish the hashmap
        
        for(String key : map.keySet()){
            if(map.get(key).size()>1){
                for(int index : map.get(key)){
                    results.add(strs[index]);
                }
            }
        }
        
        return results;
    }   
    
    public static String sort(String s){
        StringBuffer sb = new StringBuffer();
        int[] character = new int[26];
        for(int i = 0; i<s.length(); i++){
            int count = s.charAt(i)-'a';
            character[count]++;
        }
        
        for(int i = 0; i<26; i++){
            while(character[i]>0){
                sb.append((char)('a'+i));
                character[i]--;
            }
        }
         
        return sb.toString();
    }
    
//     public static ArrayList<String> anagrams2(String[] strs) {  
//        // Start typing your Java solution below  
//        // DO NOT write main() function  
//        Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>(strs.length);  
//        for (int i = 0; i < strs.length; i++) {  
//            String key = transfer(strs[i]);  
//            ArrayList<Integer> value = map.get(key); 
//            if (value != null) {  
//                value.add(i);  
//            }  
//            else {  
//                value = new ArrayList<Integer>();  
//                value.add(i);  
//                map.put(key, value);  
//            }  
//        }  
//          
//        ArrayList<String> result = new ArrayList<String>();  
//        for (String key : map.keySet()) {  
//            if (map.get(key).size() > 1) {  
//                for (int idx : map.get(key)) {  
//                    result.add(strs[idx]);  
//                }  
//            }  
//        }  
//          
//        return result;  
//    }  
//    
//     // the way to sort. 
//     
//    private static String transfer(String s) {  
//        StringBuilder t = new StringBuilder();  
//          
//        int[] count = new int[26];  
//        for (int i = 0; i < s.length(); i++) {  
//            System.out.println(s.charAt(i));
//            System.out.println(s.charAt(i)-'a');
//            count[s.charAt(i) - 'a']++;  
//        }  
//        for (int i = 0; i < count.length; i++) {  
//            for (int j = 0; j < count[i]; j++) {  
//                t.append((char) ('a' + i));  
//            }  
//        }  
//          
//        return t.toString();  
//    }  
    
}
