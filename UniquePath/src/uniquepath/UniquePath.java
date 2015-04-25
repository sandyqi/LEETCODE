/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uniquepath;

import java.util.Map;

/**
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. 
* The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
 */
public class UniquePath {
static int[][] map;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    //  int num =   getPath2(19,13);
      int num2 = getPath(19, 13);
    //  System.out.println(num);
     //   System.out.println(num2);
    }
    //cost too much time
    public static int getPath(int m , int n){
        if(m == 1 || n == 1 ){
            return 1;
        }
        return uniquePaths(m,n);
        
        
    }
     public static int uniquePaths(int m, int n) {
        int path;
        if(m == 1) {
            return 1;
        }
        
        if(n == 1){
            return 1;
        }
       
      return  uniquePaths(m-1, n) + uniquePaths(m , n-1); 
        

    }
     
     
    
    public static int getPath2(int m, int n) {
        map = new int[m][n];
        return unique(m - 1, n - 1);
    }
    private static int unique(int m, int n) {
        if (m == 0 || n == 0) return 1;
        if (map[m][n] != 0) return map[m][n];

        int s = unique(m, n - 1) + unique(m-1, n);
        map[m][n] = s;
        return s;
    }
}
