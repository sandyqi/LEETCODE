/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stacksandqueues;

import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Meng
 */
public class StacksAndQueues {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Stack3 s = new Stack3(2);
        s.push(1, 1);
        s.push(1, 2);
        s.push(1,3);
     
        try {
            s.pop(1);
            s.pop(1);
        } catch (Exception ex) {
            Logger.getLogger(StacksAndQueues.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        s.push(2, 50);
        s.push(2, 100);
        s.push(3, 88);
        s.push(3, 888);
    }
    
    
}

class Stack3{
    
    int stackSize;
    int[] buffer;
    int[] pointer = {-1,-1,-1};
    
    public Stack3(int size){
    stackSize = size;
    buffer = new int[size*3];
    }
    
    public void push(int stackNum, int value){ //stackNum = 1, 2, 3
        if(pointer[stackNum-1]<stackSize-1){
           int index = getTop(stackNum)+1;
           buffer[index] = value;
           pointer[stackNum-1]++;
           System.out.println("Add "+value +" to Stack "+stackNum +" Successfully"+" Pointer: "+pointer[stackNum-1]);
        }else{
            System.out.println("Error Message: Stack "+stackNum+" is full");
        }
    }
    
    public int pop(int stackNum) throws Exception { //stackNum = 1, 2, 3
        System.out.println("Pointer: "+pointer[stackNum -1]);
        if(pointer[stackNum -1]== -1){
            System.out.println("Error Message: Stack "+stackNum+" is empty");
            throw new Exception();
        }
        int index = getTop(stackNum);
        int popped = buffer[index];
        buffer[index] = 0;
        pointer[stackNum-1]--;
        System.out.println("Stack "+stackNum+ " is popped with value "+popped);
        return popped;
    }
    
    public int peek(int stackNum) throws Exception{
        if(pointer[stackNum -1]==-1){
           System.out.println("Error Message: Stack "+stackNum+" is empty");
           throw new Exception();
        }
        int peeked = buffer[getTop(stackNum)];
        System.out.println("Stack "+stackNum +"'s last element is "+peeked);
        return peeked;
    }
    
    public int getTop(int stackNum){ //get the current top element for some stack
        return (stackNum -1)*stackSize+pointer[stackNum-1];
    }
}

class SetOfStacks{
    ArrayList<Stack> stacks;
    int stackSize;
    
    public SetOfStacks(int stackSize){
        stacks = new ArrayList<>();
        this.stackSize = stackSize;
    }
    
    public void push(int value){
        if(stacks.isEmpty()){
            Stack<Integer> s = new Stack<>();
            s.push(value);
            stacks.set(0, s);
        }else{
             
        }
    }
    
}