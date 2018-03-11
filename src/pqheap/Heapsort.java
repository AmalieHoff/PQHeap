/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pqheap;

/**
 *
 * @author amaliehoff
 */

import java.util.Scanner;
     

public class Heapsort { 
    public static void main(String[] args) {

	PQ pq = new PQHeap(1000);

	int n = 0;
	int i;
	Scanner sc = new Scanner(System.in);
	while (sc.hasNextInt()) {
	    i = sc.nextInt();
	    n++;
	    pq.insert(new Element(i,null));
       }
	while (n > 0){
	    System.out.println(pq.extractMin().key);
	    n--;
	}
   }
}
