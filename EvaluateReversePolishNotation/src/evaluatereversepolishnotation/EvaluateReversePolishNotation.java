/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evaluatereversepolishnotation;

import java.util.Stack;

/**
 *
 * @author Meng
 */
public class EvaluateReversePolishNotation {

    /**
     * @param args the command line arguments
     * 
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     */
    public static void main(String[] args) {
       String[] s ={"0","3","/"};
      System.out.println(evalRPN(s));
    }
    
    
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        stack.add(Integer.valueOf(tokens[0]));
   
        for(int i = 1; i<tokens.length; i++){
            if(!Character.isDigit(tokens[i].charAt(tokens[i].length()-1))){
                int m = stack.pop();
                int n = stack.pop();
                if(tokens[i].equals("+")) stack.push(m+n);
                if(tokens[i].equals("-")) stack.push(n-m);
                if(tokens[i].equals("*")) stack.push(n*m);
                if(tokens[i].equals("/")) stack.push(n/m); 
            }
            else{
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        
        return stack.pop();
    }
}
