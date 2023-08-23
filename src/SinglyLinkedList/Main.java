package SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SLinkedList ll = new SLinkedList();

        ll.add(0);
        ll.add(1);
        // ll.add(2);
        // ll.add(3);
        // ll.add(4);


        System.out.println();
        ll.swap(2, 3);
        ll.display();

    }
}
