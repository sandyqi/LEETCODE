/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package addbinary;

/**
 *
 * @author Meng
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */
public class AddBinary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String b = "1";
        String a = "1";
        System.out.println(addBinary(a,b));
    }
    
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int lena = a.length();
        int lenb = b.length();
        int add = 0;
        int re = 0;
        if(lena >=lenb){
        return reform(a, b);
        }else{
            return reform(b,a);
        }
    }
    
    public static String reform(String a, String b){
        StringBuilder sb = new StringBuilder();
        int lena = a.length();
        int lenb = b.length();
        int add = 0;
        int re = 0;
          StringBuilder sb2 = new StringBuilder();
            for(int i =lenb;i<lena;i++){
                sb2.append(0);
            }
            b = sb2.append(b).toString();
            for(int i = lena-1; i>=0; i--){
                re = add+Character.getNumericValue(a.charAt(i))+ Character.getNumericValue(b.charAt(i));
                if(re == 0){
                    sb.append(0);
                    add=0;
                }
                else if (re == 1){
                    sb.append(1);
                    add = 0;
                }
                else if(re ==2){
                    sb.append(0);
                    add = 1;
                }
                else if(re == 3){
                    sb.append(1);
                    add = 1;
                }
            }
            if(add==1){
                sb.append(1);
            }
    return sb.reverse().toString();
    }
}
