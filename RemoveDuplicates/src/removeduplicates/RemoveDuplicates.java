/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removeduplicates;

import java.util.HashSet;

/**
 *
 * @author Meng
 */
public class RemoveDuplicates {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DLNode node = new DLNode('a');
        node.appendToTail('p');
        node.appendToTail('p');
        node.appendToTail('l');
        node.appendToTail('e');
        node.appendToTail('c');
        node.appendToTail('a');
        node.appendToTail('t');

        node.printAll();
        removeDup(node);
        System.out.println();
        node.printAll();
        System.out.println();
        System.out.println();

        SLNode sNode = new SLNode('w');
        sNode.appendToTail('h');
        sNode.appendToTail('a');
        sNode.appendToTail('t');
        sNode.appendToTail('t');
        sNode.appendToTail('h');
        sNode.appendToTail('e');
        sNode.appendToTail('f');
        sNode.appendToTail('u');
        sNode.appendToTail('c');
        sNode.appendToTail('k');
        sNode.printAll();
        deleteToLast(sNode, 22);
        sNode.printAll();
       // SLNode s2 = findToLast(sNode, 7);
        //s2.printAll();
        //  int t = nthToLast(sNode, 4);
        //  System.out.println();  
        //  System.out.println(t);
        //test partitionList
        sNode.printAll();
      //  SLNode node2 = partitionList(sNode, 'f');
       //   node2.printAll();
        SLNode node3 = partitionList2(sNode, 'f');
        node3.printAll();
    }

    //write code to remove duplicates from an unsorted linked list. How would you solve this problem if a temporary buffer is not allowed
    public static void removeDup(DLNode node) {
        HashSet<Character> set = new HashSet<>();
        while (node != null) {
            if (set.contains(node.data)) {
                node.previous.next = node.next;
            } else {
                set.add(node.data);
            }
            node = node.next;
        }
        //      node.printAll();
    }

    public static void deleteToLast(SLNode node, int index) {
        SLNode from = node;
        for (int i = 1; i < index; i++) {
            if (from.next != null) {
                from = from.next;
            }
        }
        from.next = null;
    }

    public static SLNode findToLast(SLNode node, int index) {
        SLNode from = node;
        for (int i = 1; i < index; i++) {
            if (from.next != null) {
                from = from.next;
            }
        }
        SLNode result = new SLNode(from.next.data);
        SLNode last = from.next;
        while (last.next != null) {
            result.appendToTail(last.next.data);
            last = last.next;
        }
        return result;
    }

    //implement an algorithm to find the kth to last element of a singly linked list.
    public static int nthToLast(SLNode head, int k) {
        //head == null means it is the last element, i = 1
        if (head == null) {
            return 0;
        }
        //find the connection between f(n) and f(n+1)
        int i = nthToLast(head.next, k) + 1;
        //after k times, when can find the node
        if (i == k) {
            System.out.print(head.data);
        }
        return i;
    }

    //2.3 implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node 
    public static boolean delemteMiddle(SLNode node) {
        if (node == null || node.next == null) {
            return false;
        }
        node.data = node.next.data;
        node.next = node.next.next;
        return true;
    }

    public static SLNode partitionList(SLNode node, char value) {

       // node0 = node;
        //  node0.next = null;
        SLNode node1start = null;
        SLNode node2start = null;
        SLNode node1end = null;
        SLNode node2end = null;

        while (node != null) {
            //make node to be a node with one element
            SLNode next = node.next;
           // if I do not add the follow line, it is ok but it will take more space
            node.next = null;
            if (node.data < value) {
                //if I want to keep one node which is head stable, I need to assign head.next to another node, and then change the second node.
                if (node1start == null) {
                    node1start = node;  //they point to the same nodelist. when nodelend do some change to the list, nodestart will be changed too.
                    node1end = node;
                } else {
                    node1end.next = node;
                    node1end = node1end.next;
                }
            }else{
                if(node2start == null){
                    node2start = node;
                    node2end = node;
                }else{
                    node2end.next = node;
                    node2end = node2end.next;
                }
                
            }
            node = next;
        }
        node1start.printAll();
        node2start.printAll();
        node1end.next = node2start;
        return node1start;
    }
    
    public static SLNode partitionList2(SLNode node, char x){
        SLNode head = node;
        SLNode tail = node;
        while(node != null){
            SLNode next = node.next;
            if(node.data < x){
                node.next = head;
            head = node;
            }else{
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }
}

class DLNode {

    public DLNode previous = null, next = null;
    char data;

    public DLNode(char data) {
        this.data = data;
    }

    public void appendToTail(char c) {
        DLNode tail = new DLNode(c);
        DLNode n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = tail;
        tail.previous = n;

    }

    public void printAll() {
        System.out.print(this.data);
        DLNode theNext = next;
        while (theNext != null) {
            System.out.print(theNext.data);
            theNext = theNext.next;
        }
    }
}

class SLNode {

    SLNode next = null;
    char data;

    public SLNode(char data) {
        this.data = data;
    }

    public void appendToTail(char data) {
        SLNode tail = new SLNode(data);
        SLNode node = this;
        while (node.next != null) {
            node = node.next;
        }
        node.next = tail;
    }

    public void printAll() {
        StringBuilder sb = new StringBuilder();
        SLNode node = this;
        sb.append(this.data);
        while (node.next != null) {
            node = node.next;
            sb.append(node.data);
        }
        System.out.println(sb);
    }
}
