package org.dast;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        List<Integer> l = new ArrayList<Integer>();
        l.add(3);
        l.add(8);
        l.add(6);
        l.add(2);
        System.out.println("List: " + l.toString());
        System.out.println("l.indexOf(null): " + l.indexOf(null));
    }
}