package org.yevheniy.ua;

import java.util.Comparator;

public final class SortUtils {

    private SortUtils() {
        throw new UnsupportedOperationException();
    }

    public static <T> boolean less(T e1, T e2, Comparator<T> comparator) {
        return comparator.compare(e1, e2) < 0;
    }

    public static <T> void exch(T[] a, int i, int j) {
        T swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static <T> boolean isSorted(T[] a, Comparator<T> comparator) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1], comparator)) {
                return false;
            }
        }
        return true;
    }
}
