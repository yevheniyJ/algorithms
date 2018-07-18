package org.yevheniy.ua;

import java.util.Iterator;

public class FixedArrayStack<T> implements Stack<T> {

    private T[] array;
    private int n = 0;

    @SuppressWarnings("unchecked")
    public FixedArrayStack(int capacity) {
        array = (T[]) new Object[capacity];
    }

    @Override
    public void push(T item) {
        array[n++] = item;
    }

    @Override
    public T pop() {
        T item = array[--n];
        array[n] = null;
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
