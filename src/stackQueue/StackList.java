package StukturData.stackQueue;

public class StackList {
    private NodeClass first;

    public StackList() {
        this.first = null; 
    }

    public boolean hasPop() {
        return first == null; 
    }

    public void push(int value) {
        NodeClass newNode = new NodeClass(value);
        newNode.setNext(first); 
        first = newNode; 
    }

    public void pop() {
        if (hasPop()) {
            System.out.println("Stack is empty, cannot pop.");
            return;
        }
        first = first.getNext(); 
    }

    public int peek() {
        if (hasPop()) {
            System.out.println("Stack is empty, cannot peek.");
            return -1; 
        }
        return first.getValue(); 
    }
}
