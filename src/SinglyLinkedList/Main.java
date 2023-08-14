package SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SLinkedList ll = new SLinkedList();

        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);

        ll.swap(1,3);
        ll.insert(0, 1);
        ll.remove(6);
        ll.display();
        System.out.println();
        ll.get(3);
    }
}
