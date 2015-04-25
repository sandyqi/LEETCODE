/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bubblesort;

/**
 *
 * @author Meng
 * 
 * Bubble sort is a simple and well-known sorting algorithm. 
 * It is used in practice once in a blue moon and its main application is to make an introduction to the sorting algorithms. 
 * Bubble sort belongs to O(n2) sorting algorithms, which makes it quite inefficient for sorting large data volumes.
 * Bubble sort is stable and adaptive.

Algorithm

Compare each pair of adjacent elements from the beginning of an array and, if they are in reversed order, swap them.
If at least one swap has been done, repeat step 1.
 */
public class BubbleSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int[] num = {3,4,55,2,89,48,9,77};
       bubbleSort(num);
       for(int i = 0; i<num.length; i++){
           System.out.println("Num "+i+" is "+num[i]);
       }
    }
    
    public static void bubbleSort(int[] num){
        int length = num.length;
        boolean swapped = true;
        int temp = 0;
        int j = 0;
        
        while(swapped){
            swapped = false;
            j++;
            for(int i = 0; i<length-j; i++){
                //ifnum[i] < num[i+1] for all elements, there is no need to search again
                if(num[i]>num[i+1]){
                    temp = num[i];
                    num[i]=num[i+1];
                    num[i+1] = temp;
                    swapped = true;   //when the nodes are swapped, then change swapped to be ture, and then do a next round search
                }
                
            }
            
        }
        
        
        
    }
}
