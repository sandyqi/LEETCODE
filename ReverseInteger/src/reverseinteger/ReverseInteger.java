/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverseinteger;

/**
 *
 * @author Meng
 */
public class ReverseInteger {

    /**
     * Reverse digits of an integer.
     *
     * Example1: x = 123, return 321 Example2: x = -123, return -321
     */
    public static void main(String[] args) {

        System.out.println(reverse(1534236449));

    }

    public static int reverse(int x) {
        String s = String.valueOf(x);
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        long re = 0;

        if (ch.length == 1) {
            return x;
        }

        for (int i = 1; i < ch.length; i++) {
            sb.append(ch[ch.length - i]);
        }

        if (ch[0] != '-') {
            sb.append(ch[0]);
            re = Long.valueOf(sb.toString());
        } else {
            String sign = "-";
            re = Long.valueOf(sign + sb.toString());
        }

        if (re > Integer.MAX_VALUE || re < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) re;

    }

    public int reverse2(int x) {
        int m = 0;
        int n = 0;
        double result = 0;

        while (x != 0) {
            m = x % 10;
            x = x / 10;
            result = m + result * 10;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) result;

    }

}
