/*
FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
 */

package uniquepath2;

import java.util.Stack;

/**
 Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
 */
public class UniquePath2 {
static int[][] path;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     int[][] test = {{0,0,1,0},
                    {0,0,1,0},
                    {0,0,0,0},
                    {1,0,0,0}
                     };
     path =new int[4][4];
    int result = uniquePathsWithObstacles(test);
     int re = getResult(test);
     Practice424 p = new Practice424();
     System.out.println(p.getPath(test));
     System.out.println(result);
    }
    
    

      public static int doRecursive(int m, int n, int[][] all){  // this way is gonna cost too much time.
      
          int x = all.length;
          int y = all[0].length;
          if(m==1){
              int n1 = n;
              while(n>0){
                  if(all[x-1][y-n] != 0){
                      path[x-1][y-n] = -1;
                      return 0;
                  }else{
                      n--;
                  }
              }
              path[x-1][y-n1] = 1;
              return 1;
          }
          if(n == 1){
              int m1 = m;
              while(m>0){
                  if(all[x-m][y-1] != 0){
                      path[x-m][y-1] = -1;
                      return 0;
                  }else{
                      m--;
                  }
              }
              path[x-m1][y-1] = 1;
              return 1;
          }
          
          int partA; int partB;
          if(all[x-m+1][y-n] == 1){
              partA =0;
          }else{
              if(path[x-m+1][y-n]>0){
                  partA = path[x-m+1][y-n];
              }else if(path[x-m+1][y-n] == -1){
                  partA =0;
              }
              else{
                  partA = doRecursive(m-1, n, all);
                  path[x-m+1][y-n] = partA;
              }
          }
          
          if(all[x-m][y-n+1] == 1){
              partB = 0;
          }else{
              if(path[x-m][y-n+1]>0){
                  partB = path[x-m][y-n+1];
              }else if(path[x-m][y-n+1] == -1){
                  partB =0;
              }else{
              partB = doRecursive(m, n-1, all);
              path[x-m][y-n+1] = partB;
              }
          }
              
          return partA+partB;
      }
      
      
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int length = obstacleGrid[0].length;
        int[] depth = new int[length];
        depth[0] = 1;
        
        for (int[] row : obstacleGrid){
           for(int i = 0; i<length; i++){
               if(row[i] == 1){
                   depth[i] = 0;
               }else if (i>0){
                   depth[i] +=depth[i-1];
    
               }
           }
        }
        
        return depth[length-1];
    }
   
   public static int getResult(int[][] grid){
       int length = grid[0].length;
       int[] depth = new int[length];
       depth[0] = 1;
       
       
       for(int[] row : grid){
           for(int i = 0; i<length; i++){
               if(row[i] == 1){
                   depth[i] =0;
               }else if(i>0){
                   depth[i]+=depth[i-1];

               }
           }
       }
       
       
       return depth[length-1];
   }

}

class Practice424{
    public int getPath(int[][] map){
        int[] depth = new int[map[0].length];
        depth[0] = 1;
        
        for (int[] map1 : map) {
            for (int j = 0; j<depth.length; j++) {
                if (map1[j] == 1) {
                    depth[j]=0;
                } else if(j!=0){
                    depth[j]+=depth[j-1];
                   
                }
            }
        }
            
       
        
        
        return depth[depth.length-1];
    }
    
}


