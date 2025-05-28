package org.dast;

import java.util.Arrays;

public class SelectionSort {
    //Swaps elements
    public void swap(int[] array, int i, int j){
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

    public int lowestIndex(int[] array, int start){
       int lowest = start;
       for(int i = start; i < array.length;i++){
           if (array[i] < array[lowest]){
              lowest = i;
           }
       }
       return lowest;
    }

    public void sort(int[] array){
        int j = -1;
        for(int i = 0;i < array.length;i++){
           j = lowestIndex(array,i);
           if(i == j){
               continue;
           }
           swap(array,i,j);
        }
    }
}
