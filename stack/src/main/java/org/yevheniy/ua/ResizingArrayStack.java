package org.yevheniy.ua;

import java.util.Iterator;

public class ResizingArrayStack<T> implements Stack<T> {

    private T[] array;
    private int n = 0;

    @SuppressWarnings("unchecked")
    public ResizingArrayStack() {
        array = (T[]) new Object[10];
    }

    @Override
    public void push(T item) {
        if (n == array.length) {
            resize(2 * array.length);
        }
        array[n++] = item;
    }

    @Override
    public T pop() {
        T item = array[--n];
        array[n] = null;
        if (n > 0 && n == array.length / 4) {
            resize(array.length / 2);
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = array[i];
        }
        array = copy;
    }

    private class ReverseArrayIterator implements Iterator<T> {

        private int i = n;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return array[--i];
        }
    }

}
