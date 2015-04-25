/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package excellsheetcolumntittle;

/**
 *
 * @author Meng
 * 
 * 
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */
public class ExcellSheetColumnTittle {

    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int t = 65;
        char ch = (char)t;
      //  System.out.println(ch);
        Character c = new Character((char) t);
        int in =26;
        System.out.println(convertToTitle(in));
    }
    
    
    public static String convertToTitle(int n) {
        if(n<=0) return null;
        StringBuilder sb = new StringBuilder();
        while(n!=0){
            int left = n%26;
            if(left == 0){
                sb.insert(0, 'Z');
                n--;
            }else{
            sb.insert(0, (char)(left+64));    
            }
            n = n/26;
        }
        
        return sb.toString();
    }
}
