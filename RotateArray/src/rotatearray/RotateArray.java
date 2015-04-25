/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rotatearray;

/**
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */
public class RotateArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] test = {1,2,3,4,5,6,7};
        rotate(test,2);
        printAll(test);
    }
    
    
    public static void rotate(int[] nums, int k) {
        if(nums == null ) {return;}
        if(nums.length<k) k -=nums.length;
        
        int length = nums.length;
        int[] rightPart = new int[length-k];
        //copy from index 0 to index length-k-1 to rightPart[]
        for(int i = 0; i<length-k;i++) rightPart[i]=nums[i];
        //set nums[0] to nums[k-1] to be nums[length-k-1] to nums[length-1]
        for(int i = 0; i<k; i++) nums[i] = nums[i+length-k];
        //set nums[k] to nums[length-1] to be rightPart[0] to rightPart[lenth-k-1]
        for(int i =k; i<length; i++) nums[i]=rightPart[i-k];
      
    }
    
    public static void printAll(int[] nums){
        for(int i = 0; i<nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
