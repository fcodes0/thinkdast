package org.dast;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

class SelectionSortTest {
    @Test
    void basicSortTest(){
       double tbefore;
       double tafter;
       double elapsedtime;
       SelectionSort sorter = new SelectionSort();
//       int[] array = {5,3,9,10,2,7,1,11,13,12};
       Random rand = new Random();
       int[] array = rand.ints(100).toArray();
       int[] arrCopy = Arrays.copyOf(array,array.length);
       Arrays.sort(arrCopy);
       tbefore = System.currentTimeMillis();
//       System.out.println("Array: " + Arrays.toString(array));
       System.out.println("Time before sort: " + (tbefore)/1000 + " seconds");
       sorter.sort(array);
       tafter = System.currentTimeMillis();
       elapsedtime = (tafter-tbefore)/1000;
       System.out.println("Time after sort : " + (tafter)/1000 + " seconds");
       System.out.println("Total time elapsed : " + (elapsedtime));
//       System.out.println("Array: " + Arrays.toString(array));
       assertArrayEquals(arrCopy,array);
    }
}