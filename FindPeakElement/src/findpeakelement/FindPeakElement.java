/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package findpeakelement;

/**
 A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
public class FindPeakElement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int[] test ={2,3,4,5,4};
       System.out.println(findPeakElement(test));
    }
    
    
    public static int findPeakElement(int[] num) {
        int index = 0;
        if(num.length ==1)
            return 0;
        if(num[0]>num[1])
            return num[0];
        
        for(int i = 1; i<num.length-1; i++){
            if(num[i]>num[i-1] && num[i]>num[i+1]){
                index = i;return index;
            }
        }
        if(num[num.length-1] >num[num.length-2])
            index = num.length-1;
        
        return index;
    }
    
}
