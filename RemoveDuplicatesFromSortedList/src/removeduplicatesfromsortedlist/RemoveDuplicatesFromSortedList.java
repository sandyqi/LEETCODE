/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package removeduplicatesfromsortedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

/**
 *
 * @author Meng
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesFromSortedList {

    /**
     * @param args the command line arguments
     * 
     * HashMap does not record who comes first, but TreeMap does record the order.
     */
    public static void main(String[] args) {
        // TODO code application logic here
  
        ListNode n1 = new ListNode(-3);
        ListNode n2 = new ListNode(-1);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(0);
        ListNode n5 = new ListNode(0);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;n5.next = n6;n6.next = n7;
        ListNode n = deleteDuplicate(n1);
        n.printAll();
    }
    
    public static ListNode deleteDuplicate(ListNode head){
        ListNode tail = head;
        
        TreeMap map = new TreeMap();
        
        if(head == null)
            return null;
        
        if(head.next == null)
            return head;
        
        while(tail != null){
            if(!map.containsKey(tail.val)){
                map.put(tail.val, 1);
            }else{
                int val = (int)map.get(tail.val);
           //     map.remove(tail.val);
                map.put(tail.val,val+1);
            }
            tail = tail.next;
        }
        
        ListNode parent = new ListNode(0);
        parent.next = head;
        ListNode result = parent;
        tail = head; 
  
        //test
        Collection<Integer> keys = map.keySet();
        Collection<Integer> values = map.values();
        for(int v : values){
            System.out.print(v+", ");
        }
        System.out.println("Keys next");
        for(int k :keys){
            System.out.print(k+", ");
        }
        //test end
        
        int totalskip = 0;
        int oneskip = 0;
        Iterator<Integer> it = values.iterator();
        
        while(it.hasNext()){ //if the first several nodes are duplicated, we track these nodes, totalskip is the number of nodes
            oneskip = it.next();
            if(oneskip >1){
                totalskip += oneskip;
            }else{
                //tail = tail.next;
                //parent = parent.next;
                break;
            }
        }
        
        if(oneskip>1){  //all nodes are duplicated
            return null;
        }

        if(totalskip != 0){   
                while(totalskip>0){ //some nodes are duplicated at start and we skip them until the node is not duplicated
                    tail = tail.next;
                    totalskip--;
                }
                parent.next = tail;  
        }
        
        tail = tail.next;
        parent = parent.next; // do changes with line 72; the iterator pointer has been moved and now we move node pointer
        //at this moment, first node is not duplicated
        
        while(it.hasNext()){
            oneskip = it.next();
            if(oneskip ==1){
                tail = tail.next;
                parent = parent.next;
            }else{
                while(oneskip> 0){
                    tail = tail.next;
                    oneskip--;
                }
                parent.next = tail;
            }
        }
        
        return result.next;
    }
    
}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
      public void printAll(){
          System.out.print(this.val);
          ListNode n = next;
          while(n!=null){
              System.out.print(n.val);
              n = n.next;
          }
      }
  }