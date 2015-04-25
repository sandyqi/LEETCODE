/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package partitionlist;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Meng
 */
public class PartitionList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static ListNode partition(ListNode head, int x){
        if(head == null)
            return null;
        
        ListNode focused = head;
        List<ListNode> list = new ArrayList<>();
        
        while(focused.val>= x){    
            ListNode node = new ListNode(focused.val);
            list.add(node);
            focused = focused.next;
            
            if(focused == null)
                return head; //all node.vals >= x    
        }
        
        ListNode focusedStart = focused;
        ListNode parent = new ListNode(0); 
        parent.next = focused;
        
        while(focused != null){ // first node.val < x, start the comparison normaly.          
            if(focused.val < x){
            focused = focused.next;
            parent = parent.next;
            }
            else{
                ListNode node = new ListNode(focused.val);
                list.add(node);
                focused = focused.next;
                parent.next = focused;
            }
        }
        // seperate the val>= x and leave the val<x in focusedStart
        
        for(ListNode node : list){
            parent.next = node;
            parent = parent.next;
        }
                
        return focusedStart.next;
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