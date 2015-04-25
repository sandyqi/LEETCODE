/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insertionsort;

/**
 *
 * @author Meng
 * Insertion Sort

Insertion sort belongs to the O(n2) sorting algorithms. 
* Unlike many sorting algorithms with quadratic complexity, 
* it is actually applied in practice for sorting small arrays of data. 
* For instance, it is used to improve quicksort routine. Some sources notice, 
* that people use same algorithm ordering items, for example, hand of cards.

Algorithm

Insertion sort algorithm somewhat resembles selection sort. 
* Array is imaginary divided into two parts - sorted one and unsorted one.
* At the beginning, sorted part contains first element of the array and unsorted one contains the rest. 
* At every step, algorithm takes first element in the unsorted part and inserts it to the right place of the sorted one. 
* When unsorted part becomes empty, algorithm stops. Sketchy, insertion sort algorithm step looks like this:
 */
public class InsertionSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] num = {3,4,55,2,89,48,9,77};
       insertionSort(num);
       for(int i = 0; i<num.length; i++){
           System.out.println("Num "+i+" is "+num[i]);
       }
    
    }
    
    public static void insertionSort(int[] arr){
        int i, j, newValue;
        
        for(i=1; i<arr.length; i++){
            j = i;
            newValue=arr[i];
            while(j>0 && arr[j-1]>newValue ){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = newValue;
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

class Solution {
    public ListNode insertionSortList(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        ListNode preNode= head;
        ListNode insertNode= head.next;
        ListNode nextInsertNode = head;
        
        while(insertNode != null){
            //1. insert it at the head
            nextInsertNode = insertNode.next;
            if(insertNode.val<= head.val){
                preNode.next = nextInsertNode;
                insertNode.next = head;
                head = insertNode;
            }
            //2. insert it at the tail
            else if(insertNode.val>=preNode.val){
                preNode = preNode.next;
            }
            //3. between head and tail
            else{
                ListNode compared = head;
                
                while(insertNode.val>compared.next.val){
                    compared = compared.next;
                }
                preNode.next = nextInsertNode;
                insertNode.next = compared.next;
                compared.next = insertNode;
            }
            insertNode = nextInsertNode;
        }
        
        return head;
    }
}