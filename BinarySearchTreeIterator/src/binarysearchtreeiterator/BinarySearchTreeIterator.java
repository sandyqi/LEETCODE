/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtreeiterator;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Meng
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * 
 */
public class BinarySearchTreeIterator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(25);
        root.left= n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;
        
      Practice425 p = new Practice425(root);
      while(p.hasNext()){
      System.out.println(p.next());
      }
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

class BSTIterator2 {

    private TreeNode mCurrent;
    private Stack<TreeNode> mAncestors;

    public BSTIterator2(TreeNode root) {
        this.mCurrent = root;
        this.mAncestors = new Stack<TreeNode>();
        while (mCurrent != null) {
            mAncestors.push(mCurrent);
            mCurrent = mCurrent.left;
        }
    }

    public boolean hasNext() {
        return (mCurrent != null && mCurrent.right != null)
                || !mAncestors.isEmpty();
    }

    public int next() {
        if (mCurrent == null) {
            mCurrent = mAncestors.pop();
        } else if (mCurrent.right != null) {
            mCurrent = mCurrent.right;
            while (mCurrent.left != null) {
                mAncestors.push(mCurrent);
                mCurrent = mCurrent.left;
            }
        } else {
            mCurrent = mAncestors.pop();
        }
        return mCurrent.val;
    }
}

class BSTIterator3{
    TreeNode currNode;   // refer to the node currently having the smallest value
  TreeNode preNode;    // auxiliary TreeNode variable

  public BSTIterator3(TreeNode root) {
    preNode = root;
    currNode = root;

    // initialize the currNode to the node with the smallest value (basically the "leftmost" node)
    if (currNode != null) {         
        while (currNode.left != null) {
            preNode = currNode.left;   // go to the left subtree

            while (preNode.right != null) {
                preNode = preNode.right;    // find the "rightmost" node
            }

            preNode.right = currNode;   // modify the BST structure 
            currNode = currNode.left;   // and continue with the left subtree
        }           
     }      
 }

 public boolean hasNext() { 
    return currNode != null;    // if currNode is null, we reach the end of the BST
 }

 public int next() { 
    int currVal = currNode.val; // store the current smallest value to return later

    // move currNode to refer to the next smallest value    
    currNode = currNode.right;  // start from the right child node of current node

    while (currNode != null) {  
        if (currNode.left == null) {  // if the left child node is null, then we're done
            break;
        }

        preNode = currNode.left;      // else we need to find the "rightmost" node of the left subtree

        while (preNode.right != null && preNode.right != currNode) {
            preNode = preNode.right;
        }

        if (preNode.right == null) {  
            preNode.right = currNode;  // we found the "rightmost" node, modify the BST structure
            currNode = currNode.left;   // and continue with the left subtree

        } else {                     
            preNode.right = null;  // we are done with the left subtree, so restore the BST structure
            break;
        }
     }      

     return currVal;    // return the smallest value saved earlier
 }   
}


class BSTIterator4{
TreeNode root;
ArrayList<Integer> ls = new ArrayList<Integer>();
int point = 0;
int n  = 0;

public BSTIterator4(TreeNode root) {
    this.root = root;
    inorder(root);
    n = ls.size();
}

private void inorder(TreeNode root) {
    if(root == null) return;
    if(root.left != null) inorder(root.left);
    ls.add(root.val);
    if(root.right != null) inorder(root.right);
}

/** @return whether we have a next smallest number */
public boolean hasNext() {
    if(point < n) return true;
    else return false;
}

/** @return the next smallest number */
public int next() {
    return ls.get(point++);
}
    
}


class Practice425{
    private Stack<TreeNode> stack;
    private TreeNode current;  //current refers to the smalled node
    
    public Practice425(TreeNode root){
        stack = new Stack<>();
        current = root;
        while(current!=null){
            stack.push(current);
            current = current.left;
        }
        current = stack.pop();
    }
    public boolean hasNext(){
        return current != null || !stack.isEmpty();
    }
    
    public int next(){
        int value = current.val;
        //current
        if(current.right != null){ 
            TreeNode root2 = current.right;
            while(root2!= null){
                stack.push(root2);
                root2 = root2.left;
            }
        }
        //current changed into next smallest node
        if(stack.isEmpty()) current = null;
        else current = stack.pop();
        
        return value;
    }
    
}