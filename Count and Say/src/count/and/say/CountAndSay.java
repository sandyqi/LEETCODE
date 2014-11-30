/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package count.and.say;

/**
 *
 * @author Meng
 */
public class CountAndSay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(countAndSay2(1));
       // System.out.println(translate(5));
    }
    
  
    
    public static String countAndSay2(int n){
        String num = "1";
        for(int i = 1; i<n; i++){
            num =translate(num);
            System.out.println(i + ":   "+num);
        }
        return num;
    }
    
    
    // this method generates 0-9 digits number
    public static String translate(String n){
       StringBuilder sb = new StringBuilder();
       char[] chars=null;
       chars = n.toCharArray();
       int length = chars.length;
      
       //When only has one element
       if(length == 1){
           sb.append(1);
           sb.append(chars[0]);
           return sb.toString();
       }
       
       for(int i = 0; i<length;){
           int num = 1;
   
        // Normal situation
           while(i+num != length -1 && chars[i]==chars[i+num]){
               num++;
           }
           
        //Last element. If so, we cannot compare it with last+1 element.
           if(i+num == length -1){
               if(chars[i+num] == chars[i]){
                   num++;
                   sb.append(num);
                   sb.append(chars[i]);
                   return sb.toString();
               }else{
                   sb.append(num);
                   sb.append(chars[i]);
                   sb.append(1);
                   sb.append(chars[i+num]);
                   return sb.toString();
               }
           }
         
           sb.append(num);
           sb.append(chars[i]);
           i+=num;
  
       }
       return sb.toString();
    }
   /* 
    public static String translate2(int num){
        int begin = 1;
        if(num == 1){
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        int length = chars.length;
        
        for(int i = 0; i<length; i++){
            int count = 0;
            
        }
        
    }
    */
    
}
