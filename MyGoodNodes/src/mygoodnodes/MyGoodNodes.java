/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mygoodnodes;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Meng
 */
public class MyGoodNodes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
      
       
      String s = "";
      int l = s.length();
      System.out.println(l);  //   0
      //  int[] list = readData();
      //  for(int i=0; i<list.length; i++){
      //      System.out.println("result: "+list[i]);
      //  }
    }
    
    
    public static int[]  readData() throws Exception{
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[]result = new int[num];
        int index = 0;
        while(index<num){
            result[index] = scan.nextInt();
            index++;
        }
        return result;
    }
    
    public int getChanges(int[] nodes){
        int changes = 0;
        
        
        return changes;
    }
}
