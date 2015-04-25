/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package triangle;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       List<List<Integer>> result = new LinkedList<>();
         List<Integer> first = new LinkedList<>();
           List<Integer> second = new LinkedList<>();
             List<Integer> third = new LinkedList<>();
               List<Integer> fourth = new LinkedList<>();
               first.add(2);
               second.add(3); second.add(4);
               third.add(5); third.add(6);third.add(60);
               fourth.add(30); fourth.add(40); fourth.add(10); fourth.add(20);
               result.add(first);result.add(second);result.add(third);result.add(fourth);
               int re = minimumTotal(result);
               System.out.println(re);
    }
    
     public static int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> first = new LinkedList<>();
        first.add(triangle.get(0).get(0));
        result.add(first);
        for(int i = 1 ; i<length; i++){ // start with triangle's second list. 
            List<Integer> list = new LinkedList<>();
            for(int j = 0; j<= i ; j++){// literate triangle's current list, and generate min value. 
                if(j == 0)     list.add( triangle.get(i).get(0)+result.get(i-1).get(0));
                else if(j == i)   list.add(triangle.get(i).get(i)+result.get(i-1).get(i-1));
                else{
                    list.add(Math.min(triangle.get(i).get(j)+result.get(i-1).get(j-1),triangle.get(i).get(j)+result.get(i-1).get(j)) );
                }
            }
            result.add(list);
        }
        Integer min = Collections.min(result.get(length-1));
      
         return min;
    }
    
}
