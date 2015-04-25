/*
回溯法是一种不断试探且及时纠正错误的搜索方法，下面的求解过程采用回溯法。
从入口出发，按某一方向向前探索，若能走通（未走过的），即某处可以到达，
则到达一个新点，否则试探下一个方向；若所有的方向均没有通路，则沿原路返回前一点，
换下一个方向继续试探，直到所有可能的通路都搜索到，或找到一条通路，或无路可走又返回到入口点。
这里可以用一个栈来实现，每走一步，将该位置压入栈中，若该点无路可走，则出栈返回上一位置。

（1）表示迷宫的数据结构
　　设迷宫为m行n列，利用数组maze[m][n]来表示一个迷宫，maze[i][j]=0或1，
其中0表示通路，1表示不通。迷宫该数组四边都为1，代表迷宫四周都是墙。这样就可以保证每个点都有8个方向可以试探。
（2）试探方向
　　迷宫中间每个点都有8个方向可以试探。其增量数组可以用一个8*2的二维数组move表述，
表示对当前点而言,它周围8个点的行和列的坐标偏移量.具体值如下：
（4）防止重复到达某点而发生死循环
　　使maze[i][j]置为-1，以便区别为达到的点，同样也可以防止走重复点的作用。
 */

package mazetest;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
class Step{
    int x,y,d;
    public Step(int x,int y,int d) {
        this.x = x;//横坐标
        this.y = y;//纵坐标
        this.d = d;//方向
    }
}

public class MazeTest {

    public static void main(String[] args) {
        // 迷宫定义
        int[][] maze = {{1,1,1,1,1,1,1,1,1,1},
                        {1,0,0,1,1,0,1,1,1,1},
                        {1,1,0,1,0,1,1,1,1,1},
                        {1,0,0,0,0,1,0,0,0,1},
                        {1,0,1,1,0,1,0,1,0,1},
                        {1,1,0,0,0,1,0,0,0,1},
                        {1,0,1,1,0,0,0,1,0,1},
                        {1,1,1,1,1,1,1,1,1,1}};
        int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};
        Stack s = new Stack();

        int a = path(maze, move, s);
      //  while(!s.isEmpty()){
      //      Step step = (Step) s.pop();
       //     System.out.println(step.x+":"+step.y);
      //  }
        
        
        int[][] map = {{1, 1, 1, 0},
                       {1, 0, 0, 1},
                       {1, 1, 1, 0}};
     //   int i = getPath(map);
      //  System.out.println(i);
     
      //  System.out.println(map[1][3]);
      //  getIsland(map);
        int[][] police={{0,0,1},
                        {1,0,2},
                        {0,2,1}};
      //  findPolice(police);
        getIsland(map);

          
        
    }
    // take advantage of the thing that only the final point does not have right point and down point. 
    public static int path(int[][] maze,int[][] move,Stack s){
        Step temp = new Step(1,1,-1); //起点
        s.push(temp);
        while(!s.isEmpty()){
            temp = (Step) s.pop();
            int x = temp.x;
            int y = temp.y;
            int d = temp.d+1;
            while(d<4){
                int i = x + move[d][0];
                int j = y + move[d][1];
                if(maze[i][j] == 0){    //该点可达
                    temp = new Step(i,j,d); //到达新点
                    s.push(temp);
                    x = i;
                    y = j;
                    maze[x][y] = -1;  //到达新点，标志已经到达
                    if(x == 6 && y == 8){
                        return 1;  //到达出口，迷宫有路，返回1
                    }else{
                        d = 0;  //重新初始化方向
                    }
                }else{
                    d++; //改变方向
                }
            }
        }
        return 0;
    }
   
    public static int getPath(int[][] map){
        int path = 0;
        int[][] direction = new int[3][3];
        direction[1][1]= 1;
        direction[1][2]= 0;
        direction[2][1]= 0;
        direction[2][2]= 1;
        int di = 1;
        int length = map.length;
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(0,0));
        
        while(!stack.isEmpty()){
            Node n = stack.pop();
            int x = n.x;
            int y = n.y;
            while(di<=2){
                int i = x + direction[di][1];
                int j = y + direction[di][2];
                System.out.println("i : "+i +"    j :"+j);
                if(i==4 || j==4){
                    di++;
                }
                else if(map[i][j] == 0){  // not visited
                    map[i][j] = -1;
                    stack.push(new Node(i, j));
                    x= i; y = j;
                    if(map[i][j] == map[length-1][length-1]){
                        //return stack.size();
                    }else{
                        di = 1;
                    }
                }else{ //visited
                    di++;
                }
            }
        }
        
        System.out.println("stack size is "+stack.size());
        return -1;
    }
    
// 给定二维数组，表示一片海洋，1代表有岛，0代表没岛。返回相连岛屿的大小。
// Input:. 鍥磋鎴戜滑@1point 3 acres
//[["1", "0", "0", "1"],
// ["1", "0", "0", "1"],
// ["1", "1", "0", "0"]]
// Output:
// [4, 2].鐣欏璁哄潧-涓€浜�-涓夊垎鍦�

// Input:. 鍥磋鎴戜滑@1point 3 acres
//[["1", "1", "1", "0"],. 涓€浜�-涓夊垎-鍦帮紝鐙鍙戝竷
// ["1", "0", "1", "0"],
// ["1", "1", "1", "0"]]
// Output:
// [8]

    public static int[] getIsland(int[][] map){
        int length1 = map.length;
        int length2 = map[0].length;
        int[][] direction = {{1,0},
                             {0,1},
                             {-1,0},
                             {0,-1}};

        for(int i = 0; i<length1; i++){
            for(int j = 0; j<length2; j++){
                if(map[i][j]==1){
                    Stack<Node> stack = new Stack<>();
                    Stack<Node> island = new Stack<>();
                    stack.push(new Node(i, j));
                     while(!stack.isEmpty()){
                        Node n = stack.pop();
                        island.push(n);
                     //   System.out.println("island is added"+n.x+"and "+n.y);
                        int x = n.x;
                        int y = n.y;
                        int d = 0;
                        
                        while(d<4){
                            int t = x+direction[d][0];
                            int p = y +direction[d][1];
                            if(t<0||p<0||t==length1||p==length2){
                                d++;
                            }
                            else if(map[t][p] == 0){
                                map[t][p] = -1;
                                d++;
                            }
                            else if(map[t][p] == 1){ // if it is island
                                map[t][p] = -1;
                                x= t; y= p;
                                stack.push(new Node(t,p));
                            //    System.out.println("NODE: "+t+"    "+p);
                                d = 0;
                           }else{
                                d++;
                            }
                        }
                      //if this node are all visited 
                     }
                     System.out.println("start from: "+i+" "+j+"  "+island.size());
                }
            }
        }        
        return null;            
    }

    
    
    // 给一个n * n的二维数组，例如：. 鍥磋鎴戜滑@1point 3 acres
    // [[0, 1, 0]]-google 1point3acres
    // [[0, 2, 0]]. from: 1point3acres.com/bbs 
    // [[0, 1, 0]]

    // 2是一面墙，表示此路不通。
    // 0表示小孩儿。
    // 1表示警察叔叔。
    // 求小孩儿到离他最近的那个警察叔叔的距离。
    // 如果最终小孩儿碰不到警察叔叔，则距离为-1。. Waral 鍗氬鏈夋洿澶氭枃绔�,
    // 注：墙到警察叔叔的距离无论如何都是-1，警察叔叔到自己的距离是0。

    // Running case 1:
    // [[0, 1, 0]]
    // [[0, 2, 0]]
    // [[0, 1, 0]] 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�. 
    // Result:. 1point3acres.com/bbs
    // [[1, 0, 1]]
    // [[2, -1, 2]]. From 1point 3acres bbs
    // [[1, 0, 1]]

    // Running case 2:
    // [[0, 2, 0]]
    // [[0, 2, 0]]
    // [[0, 2, 1]]. From 1point 3acres bbs
    // Result:. 鐗涗汉浜戦泦,涓€浜╀笁鍒嗗湴
    // [[-1, -1, 2]]
    // [[-1, -1, 1]]
    // [[-1, -1, 0]]

    // Running case 3:
    // [[1, 0, 0]] 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�. 
    // [[0, 0, 0]]
    // [[0, 0, 1]]
    // Result:. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
    // [[0, 1, 2]]. visit 1point3acres.com for more.
    // [[1, 2, 1]]
    // [[2, 1, 0]]
    
    public static void findPolice(int[][] map ){
         //  int[][] police={{0,0,1},
           //                {1,0,2},
             //              {0,2,1}};
        int[][] direction = {{1,0},
                             {0,1},
                            {-1,0},
                            {0,-1}};
        int length = map.length;
        int[][] result = new int[length][length];
        for(int i= 0;i<length; i++ ){
            for(int j=0;j<length; j++){
               
                if(map[i][j] == 1){
                    System.out.println("POLICE: "+i+""+j);
                    int[][] status = new int[length][length];
                    Stack<Node2> stack = new Stack<>();
                    stack.push(new Node2(i,j,0));
                    while(!stack.isEmpty()){
                        Node2 node = stack.pop();
                        int x = node.x;
                        int y = node.y;
                        int step = node.step;
                  
                        int d =0;
                        while(d<4){
                            int x1 = x+direction[d][0];
                            int y1 = y+direction[d][1];
                     //       System.out.println("For d = "+d+" and search"+x1+""+y1 + direction[d][0]+""+direction[d][1]);
                            if(x1==-1||y1==-1 ||x1==length|| y1==length||map[x1][y1]==2||status[x1][y1] ==-1){
                                d++;
                            }else if(map[x1][y1] == 1){ // find a police, continue
                                x=x1;
                                y=y1;
                                d=0;
                                step++;
                                stack.push(new Node2(x,y,step));
                                status[x][y] = -1;
                            }else if(map[x1][y1] == 0){ //get the kid
                            //    status[x1][y1] =-1;
                                x=x1;
                                y=y1;
                                d=0;
                                step++;
                                stack.push(new Node2(x,y,step));
                                status[x][y] = -1;
                                if(result[x][y]>0){
                                result[x][y] = Math.min(result[x][y], step);
                                }
                                else{
                                result[x][y] = step;
                                }
                                System.out.println("for kid "+x+" "+y+ "   step is  "+result[x][y]);
                            }
                        }
                    }
                }
            }
        }
      
        
    }
        
        
    
    
    
}
 class Node{
     public int x;
     public int y;
     public Node(int x, int y){
         this.x = x;
         this.y = y;
     }
     
 }
class Node2{
     public int x;
     public int y;
     public int step;
     public Node2(int x, int y, int step){
         this.x = x;
         this.y = y;
         this.step = step;
     }
     
 }