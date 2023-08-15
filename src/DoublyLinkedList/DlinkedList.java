package DoublyLinkedList;

public class DlinkedList {
    private Node first;
    private Node last;

    public DlinkedList() {
        this.first = null;
        this.last = null;
    }

    public void add(int value){
        Node node = new Node(value);
        if (first == null){
            first = node;
            last = first;
        } else if (first == last){
            first.setNext(node);
            last = node;
        } else {
            last.setNext(node);
            last = node;
        }
    }

    public void  display(){
        Node temp = first;
        int size = 0;
        while (temp != null){
            System.out.print(temp.getValue() + " -> ");
            temp = temp.getNext();
            size++;
        }
        System.out.println("NULL");
        System.out.println("Ukuran Linked-list : " + size);
    }
}
