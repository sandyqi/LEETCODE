/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reversewordsinastring;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Meng
 * 
 * Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
 * 
 */
public class ReverseWordsInAString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    public String reverseWords(String s) {
    String[] words = s.trim().split(" +");
    Collections.reverse(Arrays.asList(words));
    return String.join(" ", words);
}
    public String reverseWords2(String s) {
        s = s.trim();
        String[] words = s.split(" +");
        StringBuilder str = new StringBuilder();

        if (words.length != 0) {
            for (int i = words.length - 1; i > 0; i--) {
                str.append(words[i] + " ");
            }
            str.append(words[0]);
        }

        return str.toString();

    }
}
