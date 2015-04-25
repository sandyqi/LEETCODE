/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package containerwithmostwater;

import java.util.ArrayList;
import java.util.List;

/**
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
* n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
* Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
 */
public class ContainerWithMostWater {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);list.add(5);list.add(8);list.add(1);
        
        System.out.println(maxArea(list));
    //    System.out.println(maxArea2(list));
    }
    
    public static int maxArea(List<Integer> height) {
     int left = 0; int right = height.size()-1;
     int maxArea = 0;
     
     while(left<right){
         maxArea = Math.max((right-left)*Math.min(height.get(right), height.get(left)), maxArea);
           
         
         if(height.get(left)<height.get(right)){
             while(height.get(left+1)<height.get(left) && (left+1)<right) left++;
             left++;
         }
         else{
             while(height.get(right-1)<height.get(right) && (right-1)>left) right--;
             right--;
         }
         
     }
     
        
        return maxArea;
    }
    
    
    
}
