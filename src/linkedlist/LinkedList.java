package linkedlist;

import exceptions.InvalidIndexException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinkedList<T> implements ILinkedList<T> {
    private static Logger LOGGER = LogManager.getLogger(LinkedList.class);
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public LinkedList(T firstElement) {
        Node<T> firstNode = new Node<T>(firstElement);
        this.head = firstNode;
        this.tail = firstNode;
    }

    @Override
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.setPrev(null);
        this.head.setPrev(newNode);
        newNode.setNext(this.head);
        this.size++;
        this.head = newNode;
    }

    @Override
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.setNext(null);
        this.tail.setNext(newNode);
        newNode.setPrev(tail);
        this.size++;
        this.tail = newNode;
    }

    @Override
    public void add(int index, T element) throws InvalidIndexException {
        validateIndex(index);

        if (index == 0) {
            addFirst(element);
            return;
        } else if (index == (this.size - 1)) {
            addLast(element);
            return;
        }

        Node<T> newNode = new Node<>(element);
        Node<T> temp = this.head;

        for (int i = 0; i < (index - 1); i++) {
            temp = temp.getNext();
        }

        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        temp.getNext().getNext().setPrev(newNode);
        newNode.setPrev(temp);
        this.size++;
    }

    @Override
    public void removeFirst() {
        Node<T> temp = this.head.getNext();
        temp.setPrev(null);
        this.head = temp;
        this.size--;
    }

    @Override
    public void removeLast() {
        Node<T> temp = this.tail.getPrev();
        temp.setNext(null);
        this.tail = temp;
        this.size--;
    }

    @Override
    public void remove(int index) throws InvalidIndexException {
        if (index == 0) {
            removeFirst();
            return;
        } else if (index == (size - 1)) {
            removeLast();
        }

        validateIndex(index);
        Node<T> temp = this.head;

        for (int i = 0; i < (index - 1); i++) {
            temp = temp.getNext();
        }

        temp.setNext(temp.getNext());
        temp.setPrev(temp.getPrev());
        this.size--;
    }

    @Override
    public T get(int index) {
        Node<T> temp = this.head;

        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }

        return temp.getData();
    }

    @Override
    public T getLast() {
        return this.tail.getData();
    }

    @Override
    public T getFirst() {
        return this.head.getData();
    }

    public void print(String order) {
        Node<T> current;

        if (order.toLowerCase() == "asc") {
            current = this.head;
            while (current != null) {
                System.out.print(current.getData() + " ");
                current = current.getNext();
            }
        } else if (order.toLowerCase() == "desc") {
            current = this.tail;
            while (current != null) {
                System.out.print(current.getData() + " ");
                current = current.getPrev();
            }
        }
    }

    private void validateIndex(int index) throws InvalidIndexException {
        try {
            if (index >= this.size) {
                throw new InvalidIndexException("Index should be less than size of list: " + this.size);
            } else if (index < 0) {
                throw new InvalidIndexException("Index should be more than 0");
            }
        } catch (InvalidIndexException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
