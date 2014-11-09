/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commonprefix;

/**
 *
 * @author Meng
 */
public class CommonPrefix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if(length ==0){
            return "";
        }
        String pre = strs[0];
        for(int i =0; i<length; i++){
            if(pre == "" || strs[i] == ""){
                return "";
            }
            int len = pre.length() < strs[i].length() ? pre.length() : strs[i].length();
            for(int j = 0; j<len; j++){
                if(pre.charAt(j) != strs[i].charAt(j)){
                    len = j;
                    break;
                }
            }
            pre = pre.substring(0,len);
        }

        
        
        return "";
    }
    
}
