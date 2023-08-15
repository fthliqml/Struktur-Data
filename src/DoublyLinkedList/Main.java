package DoublyLinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        DlinkedList dll = new DlinkedList();

        dll.addLast(0);
        dll.addLast(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addLast(5);
        // dll.insert(99, 4);
        // dll.insert(88, 1);

        // dll.display();
        // dll.remove(5);
        // dll.display();
        // dll.displayReverse();
        // dll.remove(0);
        dll.display();
        dll.displayReverse();
        dll.swap(1, 4);
        System.out.println();
        System.out.println("after swap----------------------------------------");
        dll.display();
        dll.displayReverse();
        // dll.get(4);
    }
}
