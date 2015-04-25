/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dungeongame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Meng
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. 
 * he dungeon consists of M x N rooms laid out in a 2D grid. 
 * Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; 
* other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)	-3	3
-5	-10	1
10	30	-5 (P)

 */
public class DungeonGame {
static List<Integer> path;
static int neg;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       path = new ArrayList<>();
       neg = 0;
       int[][] test = {
                    {-2,0,0,0},
                    {1,-3,0,-5}
                     };
       Solution3 s = new Solution3();
      int i = s.maxProduct(test);
      System.out.println(i);
    }
    
    public static int calculateMinimumHP(int[][] dungeon) {
   
        recursive(dungeon, 0, 0, 0);
        Collections.sort(path);
        return path.get(path.size()-1);
    }
    
    public static void recursive(int[][] arr, int m, int n, int sum){
       sum += arr[m][n];
       if(sum<neg){
           neg = sum;
       }
  
        if(m<arr.length-1){       
            recursive(arr, m+1, n, sum);
        }
  
        if(n<arr[0].length-1){
            recursive(arr, m, n+1, sum);
        }
        
        if(m == arr.length-1 && n == arr[0].length-1){
            path.add(neg);
            neg=0;
    }
}
}




class Solution2 {
    public int calculateMinimumHP(int[][] dungeon) {
        int w = dungeon[0].length;
        int[] dp = new int[w + 1];
        for(int x = 0; x<dp.length; x++)
            if(x != w-1)
                dp[x] = Integer.MAX_VALUE;

        for(int y=dungeon.length-1; y>=0; y--)
            for(int x=w-1; x>=0; x--)
                dp[x] = Math.max(0, Math.min(dp[x+1], dp[x]) - dungeon[y][x]);

        return dp[0] + 1;
    }
}

class Solution3{
    public int maxProduct(int[][] dungeon){
        int row = dungeon.length;
        int column = dungeon[0].length;
        
        int[] depth = new int[column];
        depth[column-1]= Math.max(0, -dungeon[row-1][column-1]);
        
        // fill in last row's depth
        for(int i = column-2; i>=0; i--){
          depth[i] =  Math.max(0, depth[i+1] - dungeon[row-1][i]);
        }
        
        
        for(int i = row-2; i>=0; i--){
            for(int j = column-1; j>=0; j--){
                if(j == column -1) depth[j] = Math.max(0, depth[j]-dungeon[i][j]);
                else{depth[j] = Math.min(Math.max(0, depth[j+1]-dungeon[i][j]), Math.max(0, depth[j]-dungeon[i][j]));}
            }
        }
        
        return depth[0]+1;

    }
    
}