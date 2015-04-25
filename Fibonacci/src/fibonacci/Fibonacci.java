/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fibonacci;

/**
 *
 * @author Meng
 */
public class Fibonacci {

    /**
     * 题目：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      //  System.out.println("Bad: "+badSolution(45));
        System.out.println("Good: "+goodSolution(3));
    }
    
    public static int badSolution(int num){
        //this solution is not efficient. 
        if(num == 0){
            return 0;
        }
        if( num == 1){
            return 1;
        }
        if( num == 2){
            return 2;
        }
        return badSolution(num-1)+badSolution(num-2);
    }
    
   public static int goodSolution(int num){
       // start from f(0)+f(1) = f(2)
       //running time is o(n)
       if(num == 0){
           return 0;
       }
       if(num == 1){
           return 1;
       }
       if(num == 2){
           return 2;
       }
       int fn1 = 2, fn2 = 3, fnext = 0;
       for(int i = 3; i<=num; i++){
           fnext = fn1+fn2;
           fn1 = fn2;
           fn2 = fnext;
       }
       
       return fnext;
   }
    
}
