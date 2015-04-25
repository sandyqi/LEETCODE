/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lexicographic.rank.of.a.string;

/**
 *
 * @author Meng
 */
public class LexicographicRankOfAString {

    /**
    Given a string, find its rank among all its permutations sorted lexicographically.
    * For example, rank of “abc” is 1, rank of “acb” is 2, and rank of “cba” is 6.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] test = {8,10,4,2,3,1};
        int[] trans = rebuild(test);
        for(int i = 0; i< trans.length ; i++){
            System.out.print(trans[i]);
        }
        System.out.println();
        System.out.println(getRank(trans));
    }
    public static int recursion(int num){//利用递归计算阶乘
int sum=1;
if(num < 0)
throw new IllegalArgumentException("必须为正整数!");//抛出不合理参数异常
if(num==1){
return 1;//根据条件,跳出循环
}else{
sum=num * recursion(num-1);//运用递归计算
return sum;
}
}
    public static int[] rebuild(int[] num){
      int count = 0; int length = num.length;
      int[] trans = new int[length];
      for(int i = 0; i<length; i++){
          int j = i+1;
          while(j<length){ 
              if(num[i]>num[j]){
                  trans[i]++;
              }
              j++;
          }
      }
        
        return trans;
    }
    public static int getRank(int[] num){
        int length = num.length;
        int rank = 1;
        for(int i = 0; i<length-1; i++){
            rank += num[i] * recursion(length - 1- i);
        }
        return rank;
    }
}
