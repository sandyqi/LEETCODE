/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package intersectionoftwolists;

/**
 *
 * @author Meng
 * Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionOfTwoLists {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        
        int countA = 0; int countB = 0;
        ListNode endA = headA; ListNode endB = headB;
        
        while(endA!= null){
            countA++;
            endA = endA.next;
        }
        
        while(endB != null){
            countB++;
            endB = endB.next;
        }
        endA = headA;
        endB = headB;
        
        if(countA< countB){
            int secStart = countB - countA;
            while(secStart > 0){
                endB = endB.next;
                secStart--;
            }
            while(countA>0){
            if(endB == endA){
                return endB;
            }else{
                endB = endB.next;
                endA = endA.next;
            }
            countA--;
            }
            
           return null;
        }else{
            int secStart = countA - countB;
            while(secStart >0){
                endA = endA.next;
                secStart--;
            }
            while(countB>0){
                if(endB == endA){
                    return endA;
                }else{
                    endB = endB.next;
                    endA = endA.next;
                }
                countB--;
            }
            return null;
        }

    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }