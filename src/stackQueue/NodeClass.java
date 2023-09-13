package stackQueue;

public class NodeClass {
    private int value;
    private NodeClass next;

    public NodeClass(int value) {
        this.value = value;
    }

    public void setNext(NodeClass next) {
        this.next = next;
    }

    public NodeClass getNext() {
        return this.next;
    }

    public int getValue() {
        return this.value;
    }
}
