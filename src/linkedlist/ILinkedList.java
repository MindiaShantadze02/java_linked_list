package linkedlist;

import exceptions.InvalidIndexException;

public interface ILinkedList<T> {
    public void addFirst(T element);
    public void addLast(T element);
    public void add(int index, T element) throws InvalidIndexException;
    public void removeFirst();
    public void removeLast();
    public void remove(int index) throws InvalidIndexException;
    public T get(int i) throws InvalidIndexException;
    public T getLast();
    public T getFirst();
}
