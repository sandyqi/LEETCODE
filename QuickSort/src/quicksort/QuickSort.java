/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quicksort;

/**
 *
 * @author Meng
 * 
 * 
 * Quicksort

Quicksort is a fast sorting algorithm, which is used not only for educational purposes, 
* but widely applied in practice. On the average, it has O(n log n) complexity, 
* making quicksort suitable for sorting big data volumes. 
* The idea of the algorithm is quite simple and once you realize it, you can write quicksort as fast as bubble sort.

Algorithm

The divide-and-conquer strategy is used in quicksort. Below the recursion step is described:
Choose a pivot value. We take the value of the middle element as pivot value, but it can be any value, 
* which is in range of sorted values, even if it doesn't present in the array.
Partition. Rearrange elements in such a way, 
* that all elements which are lesser than the pivot go to the left part of the array and all elements greater than the pivot,
* go to the right part of the array. Values equal to the pivot can stay in any part of the array. 
* Notice, that array may be divided in non-equal parts.
Sort both parts. Apply quicksort algorithm recursively to the left and the right parts.
Partition algorithm in detail

There are two indices i and j and at the very beginning of the partition algorithm i points to the first element 
* in the array and j points to the last one. Then algorithm moves i forward, 
* until an element with value greater or equal to the pivot is found. Index j is moved backward, 
* until an element with value lesser or equal to the pivot is found. If i ≤ j then they are swapped and i steps to the next position (i + 1), 
* j steps to the previous one (j - 1). Algorithm stops, when i becomes greater than j.

After partition, all values before i-th element are less or equal than the pivot and all values after j-th element are greater or equal to the pivot.
 */
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] num = {3,4,55,2,89,48,9,77};
        Practice p = new Practice();
       p.quickSort(num, 0, 7);
       for(int i = 0; i<num.length; i++){
           System.out.println("Num "+i+" is "+num[i]);
       }
    }
    public static int partition(int arr[], int left, int right)
{
      int i = left, j = right;
      int tmp;
      int pivot = arr[(left + right) / 2];
     
      while (i <= j) {
            while (arr[i] < pivot)
                  i++;
            while (arr[j] > pivot)
                  j--;
            if (i <= j) {
                  tmp = arr[i];
                  arr[i] = arr[j];
                  arr[j] = tmp;
                  i++;
                  j--;
            }
            
      };
      System.out.println(j);
     System.out.println("i="+i);
      return j;
}
 
public  static void quickSort(int arr[], int left, int right) {
      int index = partition(arr, left, right);
      if (left < index )
            quickSort(arr, left, index );
      if (index+1 < right)
            quickSort(arr, index+1 , right);
}
}

class Practice{
    
    public int patition(int[] arr, int left, int right){
        int i, j, pivot, temp;
        i = left; j = right;
        pivot = arr[(left+right)/2];
        
        while(i<=j){
            while(arr[i]<pivot)
                i++;
            while(arr[j]>pivot)
                j--;
            if(i<=j ){
                temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j--;
                i++;
            }
            
        }       
        return j;
    }
    
    public void quickSort(int[] arr, int left, int right){
        int index = patition(arr, left, right);
        
        if(left<index){
            quickSort(arr, left, index);
        }
        if(right>index+1){
            quickSort(arr, index+1, right);
        }
    }
    
}