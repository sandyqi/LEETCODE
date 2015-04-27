/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package candy;

import java.util.Arrays;

/**
 *
 * @author Meng
 * There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
 */
public class Candy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
     public int candy(int[] ratings) {
        // initialize
        int candy[] = new int[ratings.length];
        int sum = 0;
        Arrays.fill(candy,1); // crucial step!

        // forward pass, assign candy for increasing ones
        for(int i = 1;i < ratings.length;i++)
            if(ratings[i] > ratings[i-1])
                candy[i] = candy[i-1]+1;

        // backforward pass, assign candy for decreasing ones
        for(int i = ratings.length-2;i >= 0;i--)
            if(ratings[i] > ratings[i+1]){
                if(i-1 >= 0 && ratings[i-1] <= ratings[i])
                    candy[i] = Math.max(candy[i+1]+1, candy[i]);
                else
                    candy[i] = candy[i+1] + 1;
            }

        // sum up candy
        for(int i = 0;i < candy.length;i++)
            sum += candy[i];
        return sum;
    }
}
