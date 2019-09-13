package com.notadneom.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *  A class providing util methods to interact with {@link List}.
 *
 * @author David Oudart
 */
public class ListUtils {

    /**
     * Returns the partition of a list subdivided by a given size (the last one may be smaller).
     * <p>
     * For exemple, a partition of {@code [a,b,c,d,e]} with a size of 2 returns {@code [[a,b],[c,d],[e]]}.
     * </p>
     *
     * @param list  the input list to partition, not null
     * @param size  the size of each subdivision (last one may be smaller), greater than or equal to 1
     * @param <T>  the type of the input list's items
     * @return the list of sublists
     * @throws NullPointerException if 'list' argument is null
     * @throws IllegalArgumentException if 'size' argument is strictly lesser than 1
     */
    static public <T> List<List<T>> partition(List<T> list, int size) throws NullPointerException, IllegalArgumentException  {
        if (list == null) throw new NullPointerException("Argument 'list' must not be null");
        if (size < 1) throw new IllegalArgumentException("'size' = "+size+" must be greater than 1");

        int listSize = list.size();
        List<List<T>> result = new ArrayList<>();

        for (int i = 0; i < listSize; i=i+size) {
            if (i + size < listSize) {
                result.add(list.subList(i, i+size));
            }
            else {
                result.add(list.subList(i, listSize));
            }
        }

        return result;
    }

}
