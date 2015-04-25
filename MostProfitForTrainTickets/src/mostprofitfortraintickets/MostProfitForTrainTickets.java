/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mostprofitfortraintickets;

import java.util.LinkedList;

/**
 *
 * @author Meng
 */
public class MostProfitForTrainTickets {

    /**
    第一道题有n个火车站，每个火车站有a1, a2, ..., an张火车票可以卖，票的价格是该火车站剩余的火车票数，
    * 问怎样卖票可以让前m张票的总收入最高,并打印总收入。
    * 比如说m = 4, n = 2， a1 = 2, a2 = 5, 则总收入为14 = 5 + 4 + 3 + 2. 
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       LinkedList<Integer> test = new LinkedList<>();
       test.add(2);test.add(5); 
      // getTickets( test);
       System.out.println();
       getRevenue(4, getTickets(test));

    }
    public static LinkedList getTickets(LinkedList<Integer> n){
        LinkedList<Integer> tickets = new LinkedList<>();
        
        int length = n.size();
            
        tickets.add(n.getFirst());
        
        int index = 1;
        while(index<length){
              if(n.get(index)>=tickets.getFirst()){ // the largest is on the left
                    tickets.add(0 ,n.get(index));
                }
              else if(n.get(index)<= tickets.getLast()){
                  tickets.add(n.get(index));
              }
              else{     
            for(int i = 0; i<tickets.size(); i++){
              if(n.get(index)<=tickets.get(i) && n.get(index)>=tickets.get(i+1) ){
                  tickets.add( i+1, n.get(index));
                  break;
              }
            }
            }
              index++;
                      
        }
        
     
        return tickets;
    }
    
    
    public static int getRevenue(int m, LinkedList<Integer> tickets){
        int revenue = 0;
        
        while(m>0){
            m--;
            
            if(tickets.isEmpty()){
                break;
            }
            
            revenue += tickets.get(0);
            int next = tickets.get(0)-1;
      
            
            if(next == 0){
                
                tickets.removeFirst();  // if a station sold out the tickets
            
            }
            else if(tickets.size() == 1){
                
                tickets.set(0, tickets.get(0)-1); // it there is just one station
            
            }else{
                
            tickets.set(0, next);
      
            tickets = getTickets(tickets);    
                
            }
            
        }
        
        System.out.println(revenue);
        return revenue;
    }
}
