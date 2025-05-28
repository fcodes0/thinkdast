package org.dast;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    @Test
    void sizeTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        System.out.println("Testing size()");
        System.out.println("\tCheck size of new array: Size: " + list.size());
        System.out.println("\tAdd elements: 1, 2, 3");
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("\tCheck size of array: Size: " + list.size());
        System.out.println("\tPrint list: " + list.toString());
        System.out.println("Testing complete...\n");
    }

    @Test
    void isEmptyTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        System.out.println("Testing isEmpty()");
        System.out.println("\tIs the list empty: " + list.isEmpty());
        System.out.println("Testing complete...\n");
    }

    @Test
    void addTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        System.out.println("Testing add(obj)");
        System.out.println("\tPrint new list: " + list.toString());
        list.add(10);
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        System.out.println("\tPrint after adding elements list: " + list.toString());
        System.out.println("Testing complete...\n");
    }

    @Test
    void getTest() {

    }
}