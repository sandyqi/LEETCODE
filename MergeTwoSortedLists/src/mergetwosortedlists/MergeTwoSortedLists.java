/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mergetwosortedlists;

/**
 *
 * @author Meng
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
    
    public static ListNode mergeTwoLists(ListNode first, ListNode second){
       
        ListNode finalStart = new ListNode(0);
        ListNode finalEnd = finalStart;
        
        while(first!=null || second!=null){
            if(first!=null && second!=null){
                if(first.val<=second.val){
                    finalEnd.next = first;
                    first = first.next;
                }else{
                    finalEnd.next = second;
                    second = second.next;
                }
                finalEnd = finalEnd .next;
            }
            
            else if(first!=null){
                finalEnd.next = first;
                first = first.next;
                finalEnd = finalEnd.next;
            }
            
            else{
                finalEnd.next = second;
                second = second.next;
                finalEnd = finalEnd.next;
            }
        }
        return finalStart.next;
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