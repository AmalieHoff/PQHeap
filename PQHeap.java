/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pqheap;

import java.lang.reflect.Array;


/**
 *
 * @author amaliehoff & Matias Marek
 */
public class PQHeap implements PQ {
    
    private Element[] heapArray;
    private int heapsize; 
    

    /**
     * @param args the command line arguments
     */

    
    /**
     * This is the constructor
     * @param maxElements is the max elements in the heap.
     */
    public PQHeap(int maxElements) {
        this.heapArray = new Element[maxElements +1];
        this.heapsize = 1;  // We say the heap is never empty
    }
    /**
    * 
    * @return
    *
    */
    @Override
    public Element extractMin() {
      Element minimum; 
      minimum = this.heapArray[1];
      this.heapArray[1] = this.heapArray[this.heapArray.length];
      this.heapsize--; 
      this.minHeapify(1);
      return minimum; 
      
      
      
      
      
        
    }
    
    public void minHeapify(int index){
        int left = left(index); 
        int right = right(index); 
        int smallest; 
        
        if(left >= this.heapsize && this.heapArray[left].key < this.heapArray[index].key) {
            smallest = left; 
        }
        else smallest = index;
        if (right >= this.heapsize && this.heapArray[right].key < this.heapArray[smallest].key) {
            smallest = right;
        if(smallest != index){
            Element exchangeArray = this.heapArray[index];
            this.heapArray[index] = this.heapArray[smallest];
            this.heapArray[smallest] = exchangeArray;
            
            //recursive 
            this.minHeapify(smallest);
        }
        
        }
        
        
    }
    /**
    *
    * @param the index in the array
    * @return the parent to the index.
    */
    public int parent(int index){
        return index/2; 
    }
    
    
    /**
    *
    * @param the index in the array
    * @return the left to the index.
    */
    public int left(int index){
        return 2 *  index; 
    }
    
    
    /**
    *
    * @param the index in the array
    * @return the right to the index.
    */
    public int right(int index){
        return 2*index + 1; 
    }
   
    @Override
    public void insert(Element e) {
        this.heapsize++;
        int index = heapsize; 
        this.heapArray[index].key = e.key;
        while( (index > 1) && (this.heapArray[parent(index)].key < this.heapArray[index].key) ){
            Element exchangeArray = this.heapArray[parent(index)];
            index = parent(index);
        }
    }
}
