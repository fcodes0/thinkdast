package org.dast;

import org.junit.jupiter.api.Test;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

class MyArrayListTest {
    private final List<Integer> list = new MyArrayList<Integer>();

    @Test
    void sizeTest() {
//        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.clear();
        System.out.println("Testing size()");
        System.out.println("\tCheck size of new array: Size: " + list.size());
        System.out.println("\tAdd elements: 1, 2, 3");
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        System.out.println("\tCheck size of array: Size: " + list.size());
        System.out.println("\tPrint list: " + list.toString());
        list.remove(0);
        list.remove(0);
        list.remove(0);
        assertEquals(0, list.size());
        System.out.println("\tCheck size of array: Size: " + list.size());
        System.out.println("\tPrint list: " + list.toString());
        list.add(10);
        list.add(11);
        list.add(12);
        assertEquals(3, list.size());
        System.out.println("\tCheck size of array: Size: " + list.size());
        System.out.println("\tPrint list: " + list.toString());
        list.clear();
        assertEquals(0, list.size());
        System.out.println("\tCheck size of array: Size: " + list.size());
        System.out.println("\tPrint list: " + list.toString());
        System.out.println("Testing complete...\n");
    }

    @Test
    void isEmptyTest() {
//        MyArrayListTest<Integer> list = new MyArrayList<Integer>();
        System.out.println("Testing isEmpty()");
        System.out.println("\tCalling list.clear()");
        list.clear();
        assertTrue(list.isEmpty());
        System.out.println("\tIs the list empty: " + list.isEmpty());
        System.out.println("\tAdding elements 8, 5, 3 to list");
        list.add(8);
        list.add(5);
        list.add(3);
        assertFalse(list.isEmpty());
        System.out.println("\tIs the list empty: " + list.isEmpty());
        System.out.println("\tCalling list.clear()");
        list.clear();
        assertTrue(list.isEmpty());
        System.out.println("\tIs the list empty: " + list.isEmpty());
        System.out.println("Testing complete...\n");
    }

    @Test
    void addTest() {
//        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.clear();
        System.out.println("Testing add(obj)");
        System.out.println("\tPrint clear list: " + list.toString());
        list.add(10);
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        System.out.println("\tPrint after adding elements list: " + list.toString());
        System.out.println("Testing complete...\n");
        list.clear();
    }

    @Test
    void getTest() {
//        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.clear();
        System.out.println("Testing get(idx)");
        System.out.println("\tAdding elements 2, 10, 9, 8, 7, 6 to list");
        list.add(2);
        list.add(10);
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        System.out.println("\tPrint after adding elements list: " + list.toString());
        System.out.println("\tCall get(0).. \n\tget(0): " + list.get(0));
        System.out.println("\tCall get(1).. \n\tget(1): " + list.get(1));
        System.out.println("\tCall get(2).. \n\tget(2): " + list.get(2));
        System.out.println("\tCall get(5).. \n\tget(5): " + list.get(5));
        System.out.println("Testing complete...\n");
        list.clear();

    }

    @Test
    void setTest(){
        list.clear();
//        MyArrayList<Integer> list = new MyArrayList<Integer>();
        System.out.println("Testing set(idx,element)");
        System.out.println("\tAdding elements 2, 10, 9, 8");
        list.add(2);
        list.add(10);
        list.add(9);
        list.add(8);
        System.out.println("\tPrinting list... " + list.toString());
        System.out.println("\tCalling set(0,10): " + list.set(0,10));
        System.out.println("\tCalling set(1,9): " + list.set(1,9));
        System.out.println("\tCalling set(2,2): " + list.set(2,2));
        System.out.println("\tCalling set(3,4): " + list.set(3,4));
        System.out.println("\tPrinting list... " + list.toString());
        System.out.println("Testing complete...\n");
        list.clear();
    }

    @Test
    void removeObjTest(){
//        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.clear();
        System.out.println("Testing remove(Object o)");
        System.out.println("\tAdding elements 2, 10, 9, 8 to list");
        list.add(2);
        list.add(10);
        list.add(9);
        list.add(8);
        System.out.println("\tPrinting list... " + list.toString());
        System.out.println("\tCalling remove(2): " + list.remove((Object)2));
        System.out.println("\tCalling remove(10): " + list.remove((Object)10));
        System.out.println("\tCalling remove(9): " + list.remove((Object)9));
        System.out.println("\tCalling remove(8): " + list.remove((Object)8));
        System.out.println("\tPrinting list... " + list.toString());
        System.out.println("Testing complete...\n");
        list.clear();
    }

    @Test
    void removeTest(){
        list.clear();
//        MyArrayList<Integer> list = new MyArrayList<Integer>();
        System.out.println("Testing remove(idx)");
        System.out.println("\tAdding elements 2, 10, 9, 8 to list");
        list.add(2);
        list.add(10);
        list.add(9);
        list.add(8);
        System.out.println("\tPrinting list... " + list.toString());
        System.out.println("\tCalling remove(0): " + list.remove(0));
        System.out.println("\tCalling remove(1): " + list.remove(0));
        System.out.println("\tCalling remove(2): " + list.remove(0));
        System.out.println("\tCalling remove(3): " + list.remove(0));
        System.out.println("\tPrinting list... " + list.toString());
        System.out.println("Testing complete...\n");
        list.clear();
    }

    @Test
    void removeAllTest(){
        System.out.println("Testing removeAll()");
        System.out.println("\tAdding elements 3, 5, 6, 7, 8, 9, 10 to list");
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println("\tPrinting list... " + list.toString());
        System.out.println("\tCalling removeAll(): " + list.removeAll(list));
        System.out.println("\tPrinting list... " + list.toString());
        System.out.println("Testing complete...\n");
    }

    @Test
    void containsAllTest(){
        System.out.println("Testing containsAll()");
        list.clear();
        System.out.println("\tAdding elements 3, 1, 9, 10, 8 to list");
        list.add(3);
        list.add(1);
        list.add(9);
        list.add(10);
        list.add(8);
        List<Integer> templist = new MyArrayList<Integer>();
        System.out.println("\tAdding elements 3, 1, 9, 10, 8 to templist");
        templist.add(3);
        templist.add(1);
        templist.add(9);
        templist.add(10);
        templist.add(8);
        System.out.println("\tCalling containsAll(templist): " + list.containsAll(templist));
        assertTrue(list.containsAll(templist));
        System.out.println("\tAdding 7 to templist");
        templist.add(7);
        System.out.println("\tCalling containsAll(templist): " + list.containsAll(templist));
        assertFalse(list.containsAll(templist));
        System.out.println("\tPrinting list... " + list.toString());
        System.out.println("\tPrinting templist... " + templist.toString());
        System.out.println("Testing complete...\n");
    }

    @Test
    void listIterTest(){
        Random random = new Random();
        System.out.println("Testing listIterator()");
        list.clear();
        for(int i = 0;i<10;i++){
            list.add(random.nextInt(0,100));
        }
        System.out.println("\tPrinting list... " + list.toString());
        System.out.println("\tGet list iterator and loop through list printing values");
        ListIterator<Integer> listIt = list.listIterator();
        while(listIt.hasNext()){
            System.out.println("\t" + listIt.next());
        }
        System.out.println("Testing complete...\n");
    }

    @Test
    void listIterIndexTest(){
        Random random = new Random();
        System.out.println("Testing listIterator(index)");
        list.clear();
        for(int i = 0;i<10;i++){
            list.add(random.nextInt(0,100));
        }
        System.out.println("\tGet list iterator and loop through list printing values");
        ListIterator<Integer> listIt = list.listIterator();
        while(listIt.hasNext()){
            System.out.println("\t" + listIt.next());
        }

        System.out.println("\tPrinting list from 5 index... " + list.toString());
        ListIterator<Integer> listIt2 = list.listIterator(5);
        while(listIt2.hasNext()){
            System.out.println("\t" + listIt2.next());
        }
        System.out.println("Testing complete...\n");
    }

    @Test
    void addAllTest(){
        Random random = new Random();
        System.out.println("Testing addAll(Collection<?> c)");
        MyArrayList<Integer> templist = new MyArrayList<Integer>();

        System.out.println("\tFill list with random ints");
        for(int i = 0;i<10;i++){
            list.add(random.nextInt(0,100));
        }
        System.out.println("\tPrinting list... " + list.toString());

        System.out.println("\tCreating temp collection and filling with ints");
        for(int i = 0;i<10;i++){
            templist.add(random.nextInt(0,100));
        }
        System.out.println("\tPrinting templist... " + templist.toString());
        System.out.println("\tAdding templist to list using addAll(templist)");
        list.addAll(templist);
        assertTrue(list.containsAll(templist));
        System.out.println("\tPrinting list... " + list.toString());
        System.out.println("Testing complete");
    }

    @Test
    void addAllIndexTest(){
        Random random = new Random();
        System.out.println("Testing addAll(index,Collection<?> c)");
        MyArrayList<Integer> templist = new MyArrayList<Integer>();

        System.out.println("\tFill list with random ints");
        for(int i = 0;i<10;i++){
            list.add(random.nextInt(0,100));
        }
        System.out.println("\tPrinting list... " + list.toString());

        System.out.println("\tCreating temp collection and filling with ints");
        for(int i = 0;i<10;i++){
            templist.add(random.nextInt(0,100));
        }
        System.out.println("\tPrinting templist... " + templist.toString());
        System.out.println("\tAdding templist to list using addAll(templist)");
        list.addAll(5,templist);
//        assertTrue(list.containsAll(templist));
        System.out.println("\tPrinting list... " + list.toString());
        System.out.println("Testing complete");
    }
}