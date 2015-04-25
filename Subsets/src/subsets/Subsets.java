/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 *
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If S = [1,2,3], a solution
 * is:
 *
 * [
 * [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 */
public class Subsets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        /*
         List<List<Integer>> test =subsets4(array);
        
         for(int i = 0; i<test.size(); i++){
         for(int j = 0; j<test.get(i).size(); j++){
         System.out.print(test.get(i).get(j));
         }
         System.out.println();
         }
         */

        List<List<Integer>> list = getSubset(array);
        printAll(list);

    }

    public List<List<Integer>> subsets3(int[] S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        Arrays.sort(S);
        for (int i = S.length - 1; i >= 0; i--) {
            int size = res.size() - 1;
            for (int j = size; j >= 0; j--) {
                List<Integer> newList1 = new ArrayList<>();
                newList1.add(S[i]);
                newList1.addAll(res.get(j));
                res.add(newList1);
            }
        }
        return res;
    }

    public static List<List<Integer>> subsets4(int[] S) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        Arrays.sort(S);
        for (int i : S) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List<Integer> sub : res) {
                List<Integer> a = new ArrayList<>(sub);
                a.add(i);
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        return res;
    }

    public static List<List<Integer>> getSubset(int[] S) {
        // initialize the list and add first two element, first is the first number, second is [];
        Arrays.sort(S);
        List<List<Integer>> list = new LinkedList<>();
        list.add(new LinkedList<Integer>());
        list.add(new LinkedList<Integer>());
        list.get(0).add(S[0]);

        for (int j = 1; j < S.length; j++) {
            int length = list.size();
            for (int i = 0; i < length; i++) {
                LinkedList<Integer> l = (LinkedList) ((LinkedList) list.get(i)).clone();
                l.add(S[j]);
                list.add(l);

            }
        }

        return list;
    }

    public static void printAll(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            for (Integer in : list) {
                System.out.print(in + " ");
            }
            System.out.println();
        }
    }
}
