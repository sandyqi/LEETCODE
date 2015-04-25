/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oldtelephonenumberconbination;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author Meng
 */
public class OldTelephoneNumberConbination {
public static LinkedList<String[]> list;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        list = new LinkedList<>();
        String[] c1 = {"a", "b", "c"};
        String[] c2 = {"d","e", "f"};
        String[] c3 = {"g","h","i"};
        String[] c4 = {"j","k","l"};
        String[] c5=  {"m","n","o"};
        
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);


        
        
        
        Map<Integer, String[]> map = new HashMap<>();
        map.put(2, c1);
        map.put(3, c2);
        map.put(4, c3);
        map.put(5, c4);
        map.put(6, c5);
        int[] i = {2,3,4};
        String[] result = getResult(i, map);
                printAll(result);
    }
    
    public static String[] getResult(int[] num,Map<Integer, String[]> map){
        
        return getConbination(num.length,num,map);
    }
    
    public static String[] getConbination(int n, int[]num,Map<Integer, String[]> map ){
        if(n==0){
            return null;
        }
        if(n == 1){
            String[]currentAdd = map.get(num[0]);
            int newLength = currentAdd.length;
            
            String[] result =new String[newLength];
            for(int i = 0; i<newLength; i++){
                result[i] = currentAdd[i];
            }
            return result;
        }
        
        String[] previousResult = getConbination(n-1, num, map);
        String[] currentAdd = map.get(num[n-1]);
        int pLength = previousResult.length;
        int cLength = currentAdd.length;
        int newLength = pLength*cLength;
        String[] result = new String[newLength];
        LinkedList<String> li = new LinkedList<>(); 
        for(int i = 0; i<cLength;i++){
            for(int j = 0; j<pLength;j++){
                li.add(currentAdd[i]+previousResult[j]);
            }
        }
        result = li.toArray(new String[newLength]);
        return result;
   
    }
    
    public static void printAll(String[] s){
        int length = s.length;
        for(int i = 0; i<length;i++){
            System.out.println("Combination "+i+" is "+s[i]);
        }
    }
    
}
