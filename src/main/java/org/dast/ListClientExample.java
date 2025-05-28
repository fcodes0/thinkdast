package org.dast;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Exercise 1

public class ListClientExample {
    private List<Integer> list;
    public ListClientExample(){
        list = new ArrayList<Integer>();
    }

    public List<Integer> getList(){
        return list;
    }

    public static void main(String[] args){
        ListClientExample lce = new ListClientExample();
        List<Integer> list = lce.getList();
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.println(list);
    }
}
