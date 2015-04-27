/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wordbreak;

import java.util.Set;

/**
 *
 * @author Meng
 * 
 * Given a string s and a dictionary of words dict, determine 
 * if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
 * 
 */
public class WordBreak {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] f = new boolean[len+1];
        f[0] = true;
        for (int i=1; i<len+1; i++)
            for (int j=0; j<i; j++)
                if (f[j] && wordDict.contains(s.substring(j,i)))
                {
                    f[i] = true;
                    break;
                }
        return f[len];
    }
}
