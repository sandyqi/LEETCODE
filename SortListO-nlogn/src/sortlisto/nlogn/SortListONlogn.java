/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sortlisto.nlogn;

/**
 *
 * @author Meng
 */
public class SortListONlogn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    
       private static ListNode insertbefore(ListNode l1, ListNode l2, ListNode pr) {
        if (l1 == null || l2 == null || pr == null) {
            return null;
        }
        //remove l2
        pr.next = l2.next;
        //insertion
        l2.next = l1.next;
        l1.next = l2;
        //swap values
        int tmp = l2.val;
        l2.val = l1.val;
        l1.val = tmp;
        if (pr == l1) {
            return l2;
        } else {
            return pr;
        }
    }

    private static ListNode next(ListNode cur, int steps) {
        if (steps == 0 ) {
            return cur;
        }
        if (cur.next == null) {
            return null;
        }
        for(; steps > 0 && cur != null; steps--) {
            cur = cur.next;
        }
        return cur;
    }

    private static ListNode mergeLists(ListNode l1, ListNode l2, int size) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode pr = next(l1, size - 1);
        ListNode res = next(l2, size);
        //res = res !=null ? res.next : null;
        int n1 = size;
        int n2 = size;
        while (n1 > 0 && n2 > 0 && c2 != null) {
            if (c1.val < c2.val) {
                c1 = c1.next;
                n1--;
            } else {
                ListNode c2next = c2.next;
                pr = insertbefore(c1, c2, pr); 
                c1 = c2;
                c2 = c2next;
                n2--;
            }
        }
        return res;
    }

    public static ListNode sortList(ListNode head) {
        ListNode cur = head;
        Integer n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        for(int i = 1; i < n; i *= 2) {
            cur = head;
            while (cur != null) {
                ListNode l1 = cur;
                ListNode l2 = next(cur, i);
                if (l2 != null) {
                    cur = mergeLists(l1, l2, i);
                } else {
                    cur = null;
                }
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