package org.yevheniy.ua;

import java.util.Iterator;

public class LinkedStack<T> implements Stack<T> {

    private Node first = null;

    @Override
    public void push(T item) {
        Node oldFirst = this.first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    @Override
    public T pop() {
        T item = first.item;
        first = first.next;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator();
    }

    private class Node {
        T item;
        Node next;
    }

    private class LinkedIterator implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
