/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodnodes;

/**
 *
 * @author Meng
 *
 * <p>
 * We have a list of N nodes with each node pointing to one of the N nodes.
 * <br>It could even be pointing to itself. We call a node ‘good’,
 * <br>if it satisfies one of the following properties:
 * <br>
 * <br>* It is the tail node (marked as node 1)
 * <br>* It is pointing to the tail node (node 1)
 * <br>* It is pointing to a good node
 * <br>
 * <br>You can change the pointers of some nodes in order to make them all
 * ‘good’.
 * <br>You are given the description of the nodes.
 * <br>You have to find out what is minimum number of nodes that you have to
 * change in order
 * <br>to make all the nodes good.
 * <br>
 * <br>Input:
 * <br>The first line of input contains an integer number N which is the number
 * of nodes.
 * <br>The next N lines contains N numbers,
 * <br>all between 1 and N.
 * <br>The first number, is the number of the node pointed to by Node 1;
 * <br>the second number is the number of the node pointed to by Node 2;
 * <br>the third number is the number of the node pointed to by Node 3 and so
 * on.
 * <br>
 * <br>N is no larger than 1000.
 * <br>
 * <br>Output:
 * <br>Print a single integer which is the answer to the problem
 * <br>
 * <br>Sample Input 1:
 * <br>5
 * <br>1
 * <br>2
 * <br>3
 * <br>4
 * <br>5
 * <br>
 * <br>Sample output 1:
 * <br>4
 * <br>
 * <br>Explanation:
 * <br>We have to change pointers for four nodes (node #2 to node #5) to point
 * to node #1.
 * <br>Thus 4 changes are required
 * <br>
 * <br>Sample input 2:
 * <br>5
 * <br>5
 * <br>5
 * <br>5
 * <br>5
 * <br>5
 * <br>
 * <br>Sample output 2:
 * <br>1
 * <br>
 * <br>Explanation:
 * <br>We have to just change node #5 to point to node #1 (tail node) which will
 * make node #5 good.
 * <br>Since all the other nodes point to a good node (node #5), every node
 * becomes a good node.</p>
 *
 *
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GoodNodes {

    public static void main(String[] argv) throws Exception {
      //  int[] nodes = readNodes(new BufferedReader(new InputStreamReader(System.in)));
     //   int changeCnt = getNum(nodes);
     //   System.out.println("Result is " + changeCnt);
        int[] nodes = {1, 2, 3, 4, 5};
        Solution s = new Solution();
        int in = s.getGoodNodes(nodes);
        System.out.println(in);
        
    }
    /*
     Most answers here over-complicate the problem to graph algorithms.
     An O(n) time solution with O(n) space complexity is given below. 
     The solution associates timestamps with (threads of) nodes and 
     uses these timestamps to determine whether the encountered node is undiscovered,
     good or bad. No actual nodes are created all the data is maintained in two arrays of size n. 
     */

    public static int getNum(int[] nodes) {
        int length = nodes.length;
        if (length < 1) {
            return 0;
        }
        int compare = 1;
        int total = 0;
        int[] last = new int[length];
        last[0] = compare;
        for (int i = 1; i < length; i++) {
            if (last[i] <= 0) {
                int j = i;
                compare++;
                while (last[j] <= 0) {  // if visited twice, timestaps[c] >0, so this is not gonna run
                   // System.out.println("last[j] "+last[j]);
                    last[j] = compare;
                    j = nodes[j];
                   // System.out.println("j: "+ j);
                }
                if (last[j] == compare) {  // if the last one in itself or a cycle, and the cycle doesn't include Node1
                    total++;
                }
            }

        }
        return total;
    }

    private static int[] readNodes(BufferedReader ps) throws Exception {
        int n = Integer.parseInt(ps.readLine().trim());
        int[] total = new int[n];
        for (int i = 0; i < n; i++) {
            total[i] = Integer.parseInt(ps.readLine().trim()) - 1;

        }
        return total;
    }

}

class Solution {

    public int getGoodNodes(int[] nodes) { // only there is a cycle, +1
        // take advantage of : if it is visited, do not need to check the rest points it points to.
        int result = 0; int length = nodes.length;
        int[] visited = new int[length];
        //we do not care what node Node1 points to.
        //set node1 = 1. node1 is visited.
        visited[0] = 1;
        int current = 1;
        //start at node2, which is nodes[1]
        for(int i = 1; i<length; i++){
            //current starts at 2, which means node2, refers to nodes[1]
            current++;
            int j = i;
            if(visited[j] == 0){
            //if the current node is not visited, folow the pointer of the current node, till a cycle or 1;
            while(visited[j] == 0){
                visited[j] = current;
                int pointTo = nodes[j];
                j = pointTo-1;
            }
            if(visited[j] == current){
                result++;
            }
            }
            
        }
        return result;
    }

    
    public int[] getInput(BufferedReader br) throws Exception{
        int n = Integer.parseInt(br.readLine().trim());
        int[] total = new int[n];
        for(int i = 0; i<n; i++){
            total[i] = Integer.parseInt(br.readLine().trim());
        }
        
        return total;
    }
}
