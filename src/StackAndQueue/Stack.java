package StackAndQueue;

public class Stack {
    private Node first;

    public Stack() {
        this.first = null;
    }

    // Push dari kiri ke kanan
    public void push(int value){
        Node newNode = new Node(value);
        if (first == null){
            first = newNode;
        } else {
            newNode.setNext(first);
            first = newNode;
        }
    }

    public int pop(){
        int popValue = first.getValue();
        first = first.getNext();
        return popValue;
    }

    public Boolean hasPop(){
        if (first == null){
            return false;
        } else {
            return true;
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
        System.out.println("||");
        System.out.println("Ukuran Stack : " + size);
    }
}
