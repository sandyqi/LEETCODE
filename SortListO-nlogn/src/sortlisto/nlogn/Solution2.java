/*
 * Sort a linked list in O(n log n) time using constant space complexity. 
 */

package sortlisto.nlogn;
/*
The basic idea of the solution is to use in-place merge by redirecting the pointers.
In each round of the merge sort, the program determines the unit of the merger
( i.e., the size of the merged list) and go from the beginning until the end.
Then in the next round, the unit will be doubled. 
This process goes on until the unit has been bigger than the whole list.
*/


public class Solution2 {
    public ListNode sortList(ListNode head) {
        ListNode[] nominal_head=new ListNode[2];
        nominal_head[0] =new ListNode(0);
        nominal_head[1] =new ListNode(0);

        nominal_head[0].next=head;
        ListNode cur=head;
        int count=0;
        while(cur!=null){
            cur=cur.next;
            count++;  //find the size of list
        }

        boolean odd=true;
        int unit=1;
        while(unit<count){ //at least two element in the list
            if(odd){
                nominal_head[1].next=merge(nominal_head[0],unit,count);
            }
            else{
                nominal_head[0].next=merge(nominal_head[1],unit,count);
            }

            unit=unit*2;
            odd=!odd;
        }

        return odd?nominal_head[0].next:nominal_head[1].next;
    }

    private ListNode merge(ListNode nominalhead, int unit, int count){
        ListNode result_head=new ListNode(0);
        ListNode result_end=result_head;

        ListNode head1=new ListNode(0);
        ListNode p_end=head1;
        int finished=0;

        while(finished<count){
            //create newlist;
            p_end=head1;
            for(int i=0; i<unit && nominalhead.next!=null; i++){
                p_end.next=nominalhead.next;
                nominalhead.next=nominalhead.next.next;
                p_end=p_end.next;
                finished++;
            }
            p_end.next=null;

            //merge
            for(int i=0; i<unit && nominalhead.next!=null; i++){
                while(head1.next!=null && head1.next.val<=nominalhead.next.val){
                    result_end.next=head1.next;
                    head1.next=head1.next.next;
                    result_end=result_end.next;
                    result_end.next=null;
                }

                if(head1.next==null || head1.next.val>nominalhead.next.val){
                    result_end.next=nominalhead.next;
                    nominalhead.next=nominalhead.next.next;
                    result_end=result_end.next;
                    result_end.next=null;

                    finished++;
                }
            }

            while(head1.next!=null){
                result_end.next=head1.next;
                head1.next=head1.next.next;
                result_end=result_end.next;
                result_end.next=null;
            }  

        }

        return result_head.next;
    }
}