package StackAndQueue;

public class Stack {
    private Node first;

    public Stack() {
        this.first = null;
    }

    public void push(int value){
        Node newNode = new Node(value);
        if (first == null){
            first = newNode;
        } else {
            newNode.setNext(first);
            first = newNode;
        }
    }

    public void pop(){
        int popValue;
        if(first == null){
            System.out.print("Pop Method Message : ");
            System.out.println("\u001B[31m" +"Queue Is Already Null!\n" + "\u001B[0m");
        } else {
            popValue = first.getValue();
            System.out.println("Pop Method Success!(Pop Value : "+popValue+")\n");
            first = first.getNext();
        }
    }

    public Boolean hasPop(){
        if (first == null){
            return false;
        } else {
            return true;
        }
    }

    public void  display(){
        Node currentNode = first;
        int size = 0;
        System.out.println("\u001B[36m" + "-----------Display------------");
        if (currentNode == null) {
            System.out.println("\u001B[34m" + "[Stack-List Is Null]" + "\u001B[0m");
        } else {
            System.out.print("\u001B[34m" + "In/Out : ");
            while (currentNode != null){
                System.out.print("[" + currentNode.getValue() + "] -> ");
                currentNode = currentNode.getNext();
                size++;
            }
            System.out.println("||" + "\u001B[0m");
        }
        System.out.println("Ukuran Stack-List : " + size + "\n");
    }
}
