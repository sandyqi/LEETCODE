/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binarytreerightsideview;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Meng
 * 
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 */
public class BinaryTreeRightSideView {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    // take advantage of the depth. only select one node from the nodes in the same dapth
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursiveSearch(root, list, 0);
        return list;
    }
    
    public static void recursiveSearch(TreeNode root, List<Integer> list, int depth){
        if(root == null) return;
        if(list.size()==depth){
        list.add(root.val);
        }
        recursiveSearch(root.right, list, depth+1);
        recursiveSearch(root.left, list, depth+1);
                
        
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