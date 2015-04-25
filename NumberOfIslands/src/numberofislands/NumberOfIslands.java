/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package numberofislands;

import java.util.Stack;

/**
 *
 * @author Meng
 * 
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
 */
public class NumberOfIslands {

    /**
     * I should use recursive searching. So easy DSF
     */
    public static void main(String[] args) {
       char[][] ch ={{'1','1','1','1','1','1','1','1','1'},
                     {'1','0','0','0','0','0','0','0','1'},
                     {'1','0','1','0','1','0','1','0','1'},
                     {'1','0','1','1','1','1','1','0','1'},
                     {'1','0','1','0','1','0','1','0','1'},
                     {'1','0','0','0','0','0','0','0','1'},
                     {'1','1','1','1','1','1','1','1','1'}};
       char[][] ch2 = {{'0','1','0'},
                       {'1','1','1'},
                       {'0','1','0'}};
       
       System.out.println(numIslands(ch));
    }
    
  
     public static int numIslands(char[][] grid) {
         if(grid == null ) return 0;
         
        int island=0;
        
        int xL = grid.length;
        if(xL==0) return 0;
        int yL = grid[0].length;
        if(yL == 0) return 0;
        
        for(int i =0 ; i<xL; i++){
            for(int j = 0; j<yL; j++){
                if(grid[i][j] == '1'){
                    System.out.println("the island start with "+i+"  "+j);
                    island++;   
                    recursiveSearch(i, j, grid);              
                }
            }
        }
        
        return island;
    }
    
    public static void recursiveSearch(int m, int n, char[][] grid){
        if(m>=grid.length || n>=grid[0].length || m<0 || n<0) return ;
        if(grid[m][n]!= '1') return;
        
        grid[m][n] = '2';
        
        recursiveSearch(m-1, n, grid);
        recursiveSearch(m+1, n, grid);
        recursiveSearch(m, n+1, grid);
        recursiveSearch(m, n-1, grid);
        
        
    } 
     
   
}

class Node{
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}