/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swapnodesinpairs;

/**
 *
 * @author Meng
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ListNode head = new ListNode(3);
       head.next = new ListNode(4);
       head.next.next = new ListNode(5);
      head.next.next.next= new ListNode(6);
      head.next.next.next.next= new ListNode(7);
    //   head.printAll(head);
       ListNode newHead = head.swapPairs(head);
  //     head.printAll(newHead);
  //     System.out.println();
  //     head.printAll(head);
       ListNode test = new ListNode(1);
       System.out.print("Old newHead is"); newHead.printAll(newHead);
       System.out.println();
       test.next = newHead;
       System.out.println("test.next.next is " +test.next.next.val );
       test.next.next = new ListNode(111);
       System.out.println("New test.next.next is "+test.next.next.val);
       System.out.println("New newHead is"); newHead.printAll(newHead);
       
   
    }
}
 
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
      
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        } else {
            ListNode newHead = head.next;
            ListNode next = head.next.next;
            newHead.next = head;
            head.next = swapPairs(next);
            return newHead;
        }
    }
    public void printAll(ListNode head){
        while(head!= null){
            System.out.print(head.val);
            head = head.next;
        }
    }
}