package DoublyLinkedList;

public class Node {
    private int val;
    private Node next;
    private Node prev;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next, Node prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    public Node getNext() {
        return this.next;
    }

    public Node getPrev() {
        return this.prev;
    }

    public Integer getVal() {
        return this.val;
    }

    public void setNext(Node Next) {
        this.next = Next;
    }

    public void setPrev(Node Prev) {
        this.prev = Prev;
    }

}