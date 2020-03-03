package com.my.demo5.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayTest {

    public static void main(String[] args) {
        String [] str = {"1","2","3","4"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(str));
        System.out.println(list);
        list.add(4,"5");
        System.out.println("newList:"+list);
    }
}
