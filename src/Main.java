import exceptions.InvalidIndexException;
import linkedlist.LinkedList;

public class Main {
    public static void main(String[] args) throws InvalidIndexException {
        LinkedList<Integer> ll = new LinkedList<>(5);

        ll.addFirst(10);
        ll.addLast(50);
        ll.add(2, 11);
        ll.print("desc");
        System.out.println();
        ll.print("asc");
    }
}