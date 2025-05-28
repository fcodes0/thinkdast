package org.dast;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListClientExampleTest {
    @Test
    public void testListClientExample(){
        ListClientExample lce = new ListClientExample();
        List<Integer> list = lce.getList();
        assertInstanceOf(ArrayList.class,list);

    }
}