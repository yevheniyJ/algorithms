package org.yevheniy.ua;

import java.util.Comparator;

public final class ShellSort {

    private ShellSort() {
        throw new UnsupportedOperationException();
    }

    public static <T> void sort(T[] a, Comparator<T> comparator) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && SortUtils.less(a[j], a[j - h], comparator); j -= h) {
                    SortUtils.exch(a, j, j - h);
                }
            }

            h = h / 3;
        }
    }
}
