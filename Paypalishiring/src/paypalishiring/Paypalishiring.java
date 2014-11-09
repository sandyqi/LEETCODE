/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paypalishiring;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Meng
 */
public class Paypalishiring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String text = "ABCD";
        String text2 = "ABCD";
       System.out.println( convert2(text, 4));
       System.out.println(convertQM(text2,4));
    }
    public static String convert(String text, int rows){
        int length = text.length();
        char[] charOld = text.toCharArray();
        for(int i=0;i<length;i++){
            System.out.println(charOld[i]);
        }
        char[] charNew = new char[length];
        
        //special condition 1: rows == 1
        if(rows == 1){
            return text;
        }
        //special condition 2: only one colomn
        else if(rows>=length){
            return text;
        }
        //special condition 3: rows == 2
        else if(rows == 2){
            if(length%2 == 1){
                int length1 = length/2 +1;
                int length2 = length/2;
                for(int i=0;i<length1;i++){
                    charNew[i]= charOld[i*2];
                    if(i<length2){
                    charNew[length1+i] = charOld[i*2+1];
                    }
                }
            }else{
                int length1 = length/2;int length2 = length/2;
                for(int i=0;i<length1;i++){
                    charNew[i] = charOld[i*2];
                    charNew[length1+i]= charOld[i*2+1];
                }
            }
        }
        else{
            List<Integer> intList = new ArrayList<>();
            for(int i =1;i<rows;i++){
                
            }
        }
        
        
        
        //check the answer
         for(int i=0;i<length;i++){
            System.out.println(charNew[i]);
        }
        String textNew = String.valueOf(charNew);
        return textNew;
    }
    
     public static String convert2(String s, int nRows) {
        if (nRows == 1)
            return s;

        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int inc = (nRows - 1) << 1; // = (nRows - 1) * 2
        // First row
        for (int i  = 0; i < length; i += inc)
            sb.append(s.charAt(i));
        // Middle rows (if any)
        for (int row = 1, maxRow = nRows - 1; row < maxRow; ++row)
            for (int i = row, j = inc - row; i < length; i += inc, j += inc) {
                sb.append(s.charAt(i));
                if (j < length)
                    sb.append(s.charAt(j));
            }
        // Last row
        for (int i = nRows - 1; i < length; i += inc)
            sb.append(s.charAt(i));

        return sb.toString();
    }
     
     public static String convertQM(String s, int rows){
         int length = s.length();
         StringBuilder sb = new StringBuilder(); 
         if (rows <= 1){
             return s;
         }
         int count = rows*2 - 2;
         //first row
         for(int i = 0; i<length; i+=count){
             sb.append(s.charAt(i));
         }
         //middle row
         for(int i=1;i<rows-1;i++){
             for(int j=i;j<length;j+=2*i){
                 sb.append(s.charAt(j));
                 if((j+count-2*i)<length){
                     j=j+count-2*i;
                     sb.append(s.charAt(j));
                 }else{
                     break;
                 }
             }
         }
         //last row
         for(int i =rows-1;i<length;i+=count){
             sb.append(s.charAt(i));
         }
         return sb.toString();
     }
     
     
     public String convert3(String s, int nRows) {
        if (nRows == 0)
            return s;

        List<List<String>> zigZag2D = new ArrayList<>(nRows);
        for (int i = 0; i < nRows; i++) {
            zigZag2D.add(new ArrayList<String>());
        }

        char[] input = s.toCharArray();
        int[] pattern = getIndexPattern(nRows);

        for (int i = 0; i < input.length; i++) {
            int row = pattern[i % pattern.length];

            zigZag2D.get(row).add(String.valueOf(input[i]));
        }

        String result = "";
        for (int i = 0; i < zigZag2D.size(); i++) {
            result += concatStringsWSep(zigZag2D.get(i), "");
        }

        return result;
    }

    /**
     * 1 -> 0
     * 2 -> 0 1
     * 3 -> 0 1 2 1
     * 4 -> 0 1 2 3 2 1
     * 5 -> 0 1 2 3 4 3 2 1
     */
    private int[] getIndexPattern(int nRows)
    {
        if (nRows == 1)
            return new int[] { 0 };

        int size = (nRows - 1) * 2;
        int[] pattern = new int[size];

        for (int i = 0; i < size; i++) {
            if (i < nRows) {
                pattern[i] = i;
            } else {
                pattern[i] = (nRows-1) - (i - (nRows-1));
            }
        }

        return pattern;
    }

    /**
     * {"A", "P", "P", "L", "E"} -> "APPLE"
     */
    private String concatStringsWSep(List<String> strings, String separator)
    {
        StringBuilder sb = new StringBuilder();
        String sep = "";
        for(String s: strings) {
            sb.append(sep).append(s);
            sep = separator;
        }

        return sb.toString();
    }
}
