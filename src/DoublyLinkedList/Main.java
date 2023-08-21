package DoublyLinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        DlinkedList dll = new DlinkedList();
        dll.addFirst(10);
        dll.addLast(20);
        dll.addLast(30);
        dll.addLast(40);
        dll.display();
        System.out.println(" ========================================================== ");
        dll.displayReverse();
    }
}
