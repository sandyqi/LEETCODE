/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package majorityelement;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
Given an array of size n, find the majority element. 
* The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] x= {2,3,3,2,3,3,3,3,5};
        System.out.println(majorityElement(x));
    }
    
    public static int majorityElement(int[] num) {
        int result=0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<num.length; i++){
            if(map.containsKey(num[i])){
                map.put(num[i],map.get(num[i])+1);
            }else{
                map.put(num[i], 1);
            }
        }
        for(int i=0; i<map.size(); i++ ){
            System.out.println("key "+(int)map.keySet().toArray()[i] + "   value "+(int)map.values().toArray()[i]);
        }
        Collection re = map.values();
        Integer[] in = (Integer[])re.toArray(new Integer[re.size()]);
        int max = 0;
        int index = 0;
        for(int j = 0; j<in.length;j++){
            if(max<in[j]){
            max = in[j];
            index = j;  
            } 
            System.out.println("Max is " +max);
        }
        return (int)map.keySet().toArray()[index];
    }
}
