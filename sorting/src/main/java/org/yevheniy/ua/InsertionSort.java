package org.yevheniy.ua;

import java.util.Comparator;

public final class InsertionSort {

    private InsertionSort() {
        throw new UnsupportedOperationException();
    }

    public static <T> void sort(T[] a, Comparator<T> comparator) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (SortUtils.less(a[j], a[j - 1], comparator)) {
                    SortUtils.exch(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
