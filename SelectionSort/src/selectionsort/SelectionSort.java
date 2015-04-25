/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package selectionsort;

/**
 *
 * @author Meng
 * The idea of algorithm is quite simple. 
 * Array is imaginary divided into two parts - sorted one and unsorted one. 
 * At the beginning, sorted part is empty, while unsorted one contains whole array. 
 * At every step, algorithm finds minimal element in the unsorted part and adds it to the end of the sorted one. 
 * When unsorted part becomes empty, algorithm stops.
 * 
 */
public class SelectionSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] num = {3,4,55,2,89,48,9,77};
       selectionSort(num);
       for(int i = 0; i<num.length; i++){
           System.out.println("Num "+i+" is "+num[i]);
       
    }
    }
    
    public static void selectionSort(int[] arr){
        int i, j, minIndex, temp;
        
        for(i = 0; i<arr.length-1; i++){
            minIndex = i;
            for(j = i+1; j<arr.length; j++ ){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            if(minIndex!= i){
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
            
        }
    }
    
    
    
}
