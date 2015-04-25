/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreenew;

/**
 *
 * @author Meng
 */
public class BinaryTreeNew {

    Node root;

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);
        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;
            while (true) {
                parent = focusNode;
                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        parent.leftChild = newNode;  //cannot assign focusNode = newNode?  because it is null?
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNew bt = new BinaryTreeNew();
        bt.addNode(30, "CFO");
        bt.addNode(10, "Employee 1");
        bt.addNode(20, "Manager");
        bt.addNode(50, "Boss");
        //   bt.addNode(23, "CEO");
        bt.addNode(35, "COO");
        bt.addNode(40, "Vice Pres");
        bt.addNode(15, "Manager Assistant");
        bt.postOrderTraversal(bt.root);

        System.out.println("search for 30 :" + bt.findNode(30));
    }

    //1. Aim for smallest value first. Start at 1st leftChild. 
    //2. When null is reached then move up in value
    public void inOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            inOrderTraversal(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraversal(focusNode.rightChild);
        }
    }

    //1. visit root first, and then go down
    public void preOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preOrderTraversal(focusNode.leftChild);
            preOrderTraversal(focusNode.rightChild);
        }
    }

    //from child to root. level by level
    public void postOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            postOrderTraversal(focusNode.leftChild);
            postOrderTraversal(focusNode.rightChild);
            System.out.println(focusNode.toString());
        }
    }

    public Node findNode(int key) {
        Node focusNode = root;
        while (focusNode.key != key) {
            if (focusNode.key < key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }

    public boolean remove(int key) {
        Node focusNode = root;
        Node parent = root;

        boolean isItLeftChild = true;

        while (focusNode.key != key) {

            parent = focusNode;

            if (key < focusNode.key) {

                isItLeftChild = true;

                focusNode = focusNode.leftChild;

            } else {

                isItLeftChild = false;

                focusNode = focusNode.rightChild;

            }

            if (focusNode == null) {

                return false;

            }
        }
        if (focusNode.leftChild == null && focusNode.rightChild == null) { // if focusNode is leaf

            if (focusNode == root) {

                root = null;

            } else if (isItLeftChild) {

                parent.leftChild = null;

            } else {

                parent.rightChild = null;

            }
            // if it is the leftChild of its parent, then delete its parent's leftChild
        } else if (focusNode.rightChild == null) {  //if focusNode does not have rightChild

            if (focusNode == root) {

                root = focusNode.leftChild;

            } else if (isItLeftChild) {

                parent.leftChild = focusNode.leftChild;

            } else {

                parent.rightChild = focusNode.leftChild;

            }
        } else if (focusNode.leftChild == null) { //if focusNode does not have leftChild

            if (focusNode == root) {

                root = focusNode.rightChild;

            } else if (isItLeftChild) {

                parent.leftChild = focusNode.rightChild;

            } else {

                parent.rightChild = focusNode.rightChild;

            }
        } else { // focusNode has two children

            Node replacement = getReplacementNode(focusNode); //find which node will replace the focusNode

            if (focusNode == root) {

                root = replacement;

            } else if (isItLeftChild) {

                parent.leftChild = replacement;

            } else {

                parent.rightChild = replacement;

            }

            replacement.leftChild = focusNode.leftChild;

        }

        return true;

    }
    
    public Node getReplacementNode(Node replacedNode){
        
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;
        
        Node focusNode = replacedNode.rightChild;
        
        while(focusNode != null){
            
            replacementParent = replacement;
            
            replacement = focusNode;
            
            focusNode = focusNode.leftChild;
            
        }
        
        if(replacement != replacedNode.rightChild){
            
            replacementParent.leftChild = replacement.rightChild;  // make change to the leaf
            
            replacement.rightChild = replacedNode.rightChild; // add rightchild to replacement Node 
            
        }
        
        return replacement;
        
    }

}

class Node {

    int key;
    String name;
    Node leftChild;
    Node rightChild;

    public Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String toString() {
        return name + " has a key " + key;
    }
}
