package org.yevheniy.ua;

import java.util.Comparator;

public final class MergeSort {

    private MergeSort() {
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("unchecked")
    public static <T> void sort(T[] a, Comparator<T> comparator) {
        T[] aux = (T[]) new Object[a.length];
        sort(a, aux, 0, a.length - 1, comparator);
    }

    private static <T> void sort(T[] a, T[] aux, int lo, int hi, Comparator<T> comparator) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid, comparator);
        sort(a, aux, mid + 1, hi, comparator);
        if (!SortUtils.less(a[mid + 1], a[mid], comparator)) {
            return;
        }
        merge(a, aux, lo, mid, hi, comparator);
    }

    private static <T> void merge(T[] a, T[] aux, int lo, int mid, int hi, Comparator<T> comparator) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (SortUtils.less(aux[j], aux[i], comparator)) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}