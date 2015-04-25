/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generateparentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateParentheses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static List<String> getResult(int n){
     List<String> result = new ArrayList<>();
     Stack<String> stack = new Stack<>();
     Stack<int[]> status = new Stack<>();
     status.push(new int[]{n,0});
     stack.push("");
     
     while(!stack.isEmpty()){
         String s = stack.pop();
         int start = status.peek()[0];
         int end = status.pop()[1];
         if(start==0 && end ==0){
             result.add(s);
         }
         if(start>0){
             stack.push(s+"(");
             status.push(new int[]{start-1,end+1});
         }
         if(end>0){
             stack.push(s+")");
             status.push(new int[]{start, end-1});
         }
     }
        
        return result;
    } 
    
}
