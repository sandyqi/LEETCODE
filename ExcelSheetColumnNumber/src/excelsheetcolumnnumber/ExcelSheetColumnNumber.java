/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package excelsheetcolumnnumber;

/**
 Excel Sheet Column Number Total Accepted: 23551 Total Submissions: 63975 My Submissions Question Solution 
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28  
 */
public class ExcelSheetColumnNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char c = 'A';
    //    System.out.println((int)c);
        String test = "abc";
        System.out.print(titleToNumber(test));
    }
    public static int titleToNumber(String s) {
        s = s.toUpperCase();
        char[] ch = s.toCharArray();
        int length = ch.length;

        int num = 0;
        for(int i = 0; i<length-1; i++){
            int cur = (int)ch[i]-64;
            num += cur * Math.pow(26, length-1-i);
        }
        num+=(int)ch[length-1] - 64;
        return num;
    }
}
