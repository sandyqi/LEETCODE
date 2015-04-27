/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package countprime;

import java.util.BitSet;

/**
 *
 * @author Meng
 * 
 * Description:

Count the number of prime numbers less than a non-negative number, n
 */
public class CountPrime {

    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
    }
    public int countPrimes(int n) {
    BitSet bs = new BitSet(n);
    bs.set(0); bs.set(1);
    int ind = 0, count = 0;
    while(ind < n){
        ind = bs.nextClearBit(ind + 1);
        if(ind >= n)
            return count;
        count++;
        for(int i = 2 * ind; i < n; i += ind)
            bs.set(i);
    }
    return count;
}
}
