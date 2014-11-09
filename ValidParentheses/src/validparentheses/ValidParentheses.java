/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validparentheses;

import java.util.Stack;

/**
 *
 * @author Meng
 */
public class ValidParentheses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s ="[";
        boolean b = isValid(s);
        System.out.println(b);
    }
    
    public static boolean isValid(String s){
        int length = s.length();
        //check if it is odd
        if(length%2==1){
           // System.out.println("Length is odd");
            return false;
        }
        char[] c = s.toCharArray();
        char compare;
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<length;i++){
            if((c[i]=='[') || c[i] == '{' || c[i]=='(' ){
                //add to stack 
            stack.push(c[i]);
        }else{
                if(c[i] == ']'){
                    compare ='[';
                }else if(c[i] == '}'){
                    compare ='{';
                }else{
                    compare ='(';
                }
                if(stack.empty()){
                    return false;
                }
                if(compare==stack.peek()){
                    stack.pop();
                }else{
                   // System.out.println("c[i] != stack.peek   stack: " + stack.peek() + "   c[i]: "+c[i]);
                    return false;
                }
        }
        }
        if(stack.empty()){
            return true;
        }else{
            //System.out.println("stack is not empty");
            return false;
        }
        }
    
}
