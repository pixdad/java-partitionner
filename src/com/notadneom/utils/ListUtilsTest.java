package com.notadneom.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;
import static  com.notadneom.utils.ListUtils.*;

public class ListUtilsTest {


    @org.junit.Test
    public void partitionWithEmptyList() {
        ArrayList<Integer> arraylist = new ArrayList<>();
        LinkedList<Integer> linkedlist = new LinkedList<>();

        assertEquals(partition(arraylist, 2), new ArrayList<>());
        assertEquals(partition(linkedlist, 3), new LinkedList<>());
    }

    @org.junit.Test
    public void partitionWithStrings() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("un", "deux", "trois", "quatre", "cinq"));

        assertEquals(
                partition(list, 2),
                new ArrayList<>(Arrays.asList(Arrays.asList("un", "deux"), Arrays.asList("trois", "quatre"), Arrays.asList("cinq")))
        );
        assertEquals(
                partition(list, 6),
                new ArrayList<>(Arrays.asList(Arrays.asList("un", "deux", "trois", "quatre", "cinq")))
        );
        assertEquals(
                partition(list, 1),
                new ArrayList<>(Arrays.asList(Arrays.asList("un"), Arrays.asList("deux"), Arrays.asList("trois"), Arrays.asList("quatre"), Arrays.asList("cinq")))
        );

    }

    @org.junit.Test
    public void partitionWithInts() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        assertEquals(
                partition(list, 2),
                new ArrayList<>(Arrays.asList(Arrays.asList(1,2), Arrays.asList(3,4), Arrays.asList(5)))
        );
        assertEquals(
                partition(list, 3),
                new ArrayList<>(Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(4,5)))
        );
        assertEquals(
                partition(list, 1),
                new ArrayList<>(Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList(4), Arrays.asList(5)))
        );

    }

    @org.junit.Test(expected = NullPointerException.class)
    public void partitionRaisingNullPointerException() {
        ArrayList<Integer> nullList = null;
        partition(nullList, 3);

    }
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void partitionRaisingIllegalArgumentException() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        partition(list, 0);
    }
}