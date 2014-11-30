/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strstr;

/**
 *
 * @author Implement strStr().
 *
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 */
public class StrStr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String haystack = "";
        String needle = "";
        System.out.println(strStrStandard(haystack, needle));
    }
    //my function has exceed limit time error
    public static int strStr(String haystack, String needle) {
        if (needle == "") {
            return 0;
        }
        if (haystack == "" || needle.length() > haystack.length()) {
            return -1;
        }
        int end = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                for (int j = 0; j < needle.length() && (i + j) < haystack.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    } else {
                        end++;
                    }
                }
            }
            if (end == needle.length()) {
                return i;
            } else {
                end = 0;
            }
        }
        return -1;
    }

    public static int strStrStandard(String haystack, String needle) {
        for (int i = 0;; i++) {
            for (int j = 0;; j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
    }

    public static int strStrSubmitted(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }
        if (needle == "") {
            return 0;
        }
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len1 < len2) {
            return -1;
        }
        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j == len2) {
                return i - j;
            }
        }
        return -1;
    }

    public String strStr2(String haystack, String needle) {
        //KMP algorithms
        if (needle.equals("")) {
            return haystack;
        }
        if (haystack.equals("")) {
            return null;
        }
        char[] arr = needle.toCharArray();
        int[] next = makeNext(arr);

        for (int i = 0, j = 0, end = haystack.length(); i < end;) {
            if (j == -1 || haystack.charAt(i) == arr[j]) {
                j++;
                i++;
                if (j == arr.length) {
                    return haystack.substring(i - arr.length);
                }
            }
            if (i < end && haystack.charAt(i) != arr[j]) {
                j = next[j];
            }
        }
        return null;
    }

    private int[] makeNext(char[] arr) {
        int len = arr.length;
        int[] next = new int[len];

        next[0] = -1;
        for (int i = 0, j = -1; i + 1 < len;) {
            if (j == -1 || arr[i] == arr[j]) {
                next[i + 1] = j + 1;
                if (arr[i + 1] == arr[j + 1]) {
                    next[i + 1] = next[j + 1];
                }
                i++;
                j++;
            }
            if (arr[i] != arr[j]) {
                j = next[j];
            }
        }

        return next;
    }
}
