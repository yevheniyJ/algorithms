package org.yevheniy.ua;

import java.util.Comparator;

public final class QuickSort {

    private QuickSort() {
        throw new UnsupportedOperationException();
    }

    public static <T> void sort(T[] a, Comparator<T> comparator) {
        sort(a, 0, a.length - 1, comparator);
    }

    private static <T> void sort(T[] a, int lo, int hi, Comparator<T> comparator) {
        if (hi <= lo) {
            return;
        }
        int lt = lo, gt = hi;
        T v = a[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = comparator.compare(a[i], v);
            if (cmp < 0) {
                SortUtils.exch(a, lt++, i++);
            } else if (cmp > 0) {
                SortUtils.exch(a, i, gt--);
            } else {
                i++;
            }
        }
        sort(a, lo, lt - 1, comparator);
        sort(a, gt + 1, hi, comparator);
    }
}
