package org.yevheniy.ua;

import java.util.Comparator;

public final class SelectionSort {

    private SelectionSort() {
        throw new UnsupportedOperationException();
    }

    public static <T> void sort(T[] a, Comparator<T> comparator) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (SortUtils.less(a[j], a[min], comparator)) {
                    min = j;
                }
                SortUtils.exch(a, i, min);
            }
        }
    }
}
