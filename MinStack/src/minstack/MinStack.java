/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package minstack;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author Meng
 */
public class MinStack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      MinStack3 test = new MinStack3();
      test.push(512);test.push(512);
      test.push(-1024);test.push(-1024);test.push(512);
      System.out.println(test.getMin());
      test.pop();test.pop();test.pop();
      System.out.println(test.getMin());
      //push(512),push(-1024),push(-1024),push(512),pop,getMin,pop,getMin,pop,getMin
    }
    
}


class MyStack{
    MinStack2 s2= null;
    public void push(int x){
        if(s2 == null){
            s2 = new MinStack2();
            s2.push(x);
        }else{
            s2.push(x);
        }
        
    }
    public void pop(){
        s2.pop();
    }
    public int top(){
        return s2.top();
    } 
    public int getMin(){
        return s2.getMin();
    }
}

class MinStack2 {
    int value;
    int minValue;
    MinStack2 next;
    MinStack2 top = null;
    public MinStack2(){
        
    }
    public MinStack2(int value){
        this.value = value;
    }
    
    public void push(int x) {
        MinStack2 pushed = new MinStack2(x);
        if(top == null){
            top = pushed;
            top.minValue = x;
            top.next = null;
        }else{
            int min = Math.min(x, top.minValue);
            pushed.next = top;
            top = pushed;
            top.minValue = min; 
        }
    }

    public void pop() {
        top = top.next;
    }

    public int top() {
        return top.value;
        
    }

    public int getMin() {
        return top.minValue;
    }
}



class MinStack3 {
    Deque<Integer> stack = new LinkedList<>();
    Deque<Integer>  min = new LinkedList<>();
    
    public void push(int x) {
        if(min.isEmpty() || min.peek()>=x)
        min.push(x);
        
        stack.push(x);
    }

    public void pop() {
        if(stack.peek().equals(min.peek()))
            min.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}