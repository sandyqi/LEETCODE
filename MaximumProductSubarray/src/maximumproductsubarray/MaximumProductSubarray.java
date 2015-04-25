/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maximumproductsubarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Meng
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 * 
 */
public class MaximumProductSubarray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] nums = {-5, 5,1,0,-1,2, 0,-2,-2};
        int[] nums2 = Arrays.copyOfRange(nums, 0, 3);
     
      //  printAll(nums2);
        int re = maxProduct(nums);
        System.out.println(re);
        
    }
    
    
    public static int maxProduct(int[] nums) {
        int max=0;
        List<Integer> zero = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==0) zero.add(i);
          
        }
       
        if(zero.isEmpty()) return findMax(nums);
        
      
        int[] cut = Arrays.copyOfRange(nums, 0, zero.get(0));
      
        if(findMax(cut)>max) max = findMax(cut);
        cut = Arrays.copyOfRange(nums, zero.get(0)+1, nums.length);

        if(findMax(cut)>max) max = findMax(cut);

        
        
        for(int i = 1; i<zero.size()-1; i++){
            cut = Arrays.copyOfRange(nums, zero.get(i)+1, zero.get(i+1));              
                if(findMax(cut)>max) max = findMax(cut);
        }
        
        return max;
    }
    
    public static int findMax(int[] nums){
        if(nums.length==0) return 0;
        List<Integer> neg = new ArrayList<>();
        int product = 1;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]<0){
                neg.add(i);
            }
        }

        if(neg.isEmpty()||neg.size()%2 == 0){
            for(int in : nums){
                product*= in;
            }
            return product;
        }
        
        int p1= 1; int p2 = 1;
        
        if(neg.size()==1){
            for(int i = 0; i<neg.get(0);i++){
                p1*=nums[i];
            }
            for(int i = neg.get(0)+1; i<nums.length; i++){
                p2*=nums[i];
            }
            return Math.max(p1, p2);
        }
        
        int firstNeg = neg.get(0);
        int lastNeg = neg.get(neg.size()-1);
        for(int i = 0; i<lastNeg; i++){
            p1*=nums[i];
        }
        for(int i = firstNeg+1; i<nums.length; i++){

            p2*=nums[i];
        }
        return Math.max(p1,p2);
    }
    
    public static void printAll(int[] nums){
        System.out.println("Next is");
        for(int i = 0; i<nums.length; i++){
            
            System.out.println(nums[i]);
        }
    }
}

class  Solution{

    public int maxProduct(int[] nums){
        if(nums == null || nums.length==0) return 0;
        
        int min, max, result;
        min = nums[0]; max = min; result= min;
        
        // when it is 0, it leads to min=0;max=0; result =previousMax
        for(int i = 1; i<nums.length; i++){
            int temp = min;
            min = Math.min(nums[i], Math.min(max*nums[i],min*nums[i]));
            max = Math.max(nums[i], Math.max(max*nums[i], temp*nums[i]));
            if(max>result) result = max;
        }
        
        return result;
    }

}
