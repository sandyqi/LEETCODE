/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sumroottoleafnumber;

import java.util.Stack;

/**
 *
 * @author Meng
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 */
public class SumRootToLeafNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    
    public static int getNumber(TreeNode root){
        
        return recursiveSearch(root, 0);
    }
    
    //visit current, visit current.left, visit curent.right
    public static int recursiveSearch(TreeNode root, int sum){
        if(root == null) return 0;
        
        sum = sum*10 +sum;
        
        if(root.left == null && root.right == null) return sum;
            
        return recursiveSearch(root.left, sum)+recursiveSearch(root.right, sum);
    }
    
    
    //use non-recursive method to add all value for each path
    public static int getAllPath(TreeNode root){
        if(root == null) return 0;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
       
            if(current.left!= null){
                current.left.val +=current.val;
                stack.push(current.left);
            }
            if(current.right!=null){
                current.right.val +=current.val;
                stack.push(current.right);
            }
            if(current.left==null && current.right==null){
                sum+=current.val;
            }       
        }
       return sum;
    }
    
}
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}