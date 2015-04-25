/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package removeduplicate;

import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author Meng
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static ListNode  deleteDuplicates(ListNode head){
        if(head == null) 
            return null;
        
        Collection<Integer> values = new HashSet<>();
        ListNode parent = head;
        ListNode end = head;
        
        values.add(head.val);
        end = end.next;
        
        while(end != null){
        
            if(!values.contains(end.val)){
                values.add(end.val);
                end = end.next;
                parent = parent.next;
            }else{
                parent.next = end.next;
                end = parent.next;
            }
    }
        
        return head;
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