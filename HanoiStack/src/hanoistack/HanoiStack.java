/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hanoistack;

import java.util.Stack;

/**
 *
 * @author Meng
 */
public class HanoiStack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Stack<Integer> stack = new Stack<>();
        //stack.peek();
        Integer a = 10;
       Integer b = 5;
        System.out.print(a.compareTo(b));
    }
    
}

class Tower{
    private Stack<Integer> disks; // 
    private int index;
    
    public Tower(int index){
        disks = new Stack<>();
        this.index = index;
    }
    
    public int index(){
        return this.index;
    }
    
    //public void moveDisk(T)
}