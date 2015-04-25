/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package findminimuminrotatedsortedarray;

/**
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 */
public class FindMinimumInRotatedSortedArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      int[] test = {6,6,4};
      System.out.println(findMin(test));
    }
    public static int findMin(int[] num) {
        int min = num[0]; int length = num.length;
        if(num[length-1]>num[0]) return min;
        
        for(int i = 1; i<length; i++){
            if(min<=num[i]){
                min = num[i];
            }else{
                return num[i];
            }
        }
        
        
        return min;
    }
}
