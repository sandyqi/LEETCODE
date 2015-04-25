/*
LinkedList questions from cracking the code interview
 */

package practice0108;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Meng
 */
public class Practice0108 {

    /**
     *线性回归的应用
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Integer> list = new ArrayList<>();
        list = getNum(5, list);
     //   System.out.println("阶乘："+list.size()+"   Last element: "+list.get(list.size()-1));
     //   System.out.println("Fibonacci: "+ fibonacci(5));
     //   System.out.println("Unefficient Fibonacci: "+ fibonacci2(5));
        moveDisk(4,'A', 'B','C');
        System.out.println();
        List<String> list1 = new ArrayList<>();
        permute("abc");
        String s = "abc";
        

    }
    //阶乘
    public static List<Integer> getNum(int num, List<Integer> list){
        if(list.isEmpty()){
            list.add(num);
        }
        if(num == 1){
            return list;
        }
        list.set(0, list.get(0)*(num-1));
        return getNum(num-1, list);
    }
    //Fibonacci
    public static int fibonacci(int num){
        int f1 = 0; int f2 = 1; int f3=0;
        for(int i = 0; i<num; i++){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
    
    public static int fibonacci2(int num){
        if(num == 0 || num ==1){
            return 1;
        }else{
            return fibonacci2(num-1)+fibonacci2(num-2);
        }
        
    }
    
    //hanoi tower
    public static void moveDisk(int level, char from, char mid, char to){
        if(level == 1){
            System.out.println("Move disk "+level+" from "+from+" to "+to);
        }else{
            moveDisk(level -1, from, to, mid);
            System.out.println("Move disk "+level+" from "+from+" to "+to);
            //n-1个移动过来之后b变开始盘，b通过a移动到c，这边很难理解
            moveDisk(level-1, mid,from, to);
        }
    }
    public static void permute(String str) {  
        char[] strArray = str.toCharArray();  
        permute(strArray, 0, strArray.length - 1); 
    }
     public static void permute(char[] list, int low, int high) {  
        int i;  
        if (low == high) {  
            String cout = "";  
            for (i = 0; i <= high; i++) {  
                cout += list[i];  
            }  
            System.out.println(cout);  
        } else {  
            for (i = low; i <= high; i++) {  
                char temp = list[low];  
                list[low] = list[i];  
                list[i] = temp;  
                permute(list, low + 1, high);  
                temp = list[low];  
                list[low] = list[i];  
                list[i] = temp;  
            }  
        }  
     }
}
