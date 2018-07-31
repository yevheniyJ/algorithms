package org.yevheniy.ua;

import java.util.Comparator;

public class MaxPQ<T> {

    private T[] pq;
    private int n;
    private final Comparator<T> comparator;

    @SuppressWarnings("unchecked")
    //You can avoid capacity by using resizing mechanism
    public MaxPQ(int capacity, Comparator<T> comparator) {
        this.comparator = comparator;
        pq = (T[]) new Object[capacity + 1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(T t) {
        pq[++n] = t;
        swim(n);
    }

    public T delMax() {
        T max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return comparator.compare(pq[i], pq[j]) < 0;
    }

    private void exch(int i, int j) {
        T t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}

