package org.yevheniy.ua;

public interface Queue<T> extends Iterable<T> {

    void enqueue(T item);

    T dequeue();

    boolean isEmpty();
}
