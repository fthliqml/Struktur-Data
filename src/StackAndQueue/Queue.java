package StackAndQueue;

public class Queue {
    private Node first;

    public Queue(){
        this.first = null;
    }

    public void push(int value){
        Node newNode = new Node(value);
        if(first == null){
            first = newNode;
        } else {
            newNode.setNext(first);
            first = newNode;
        }
    }

    public void pop(){
        int popValue;
        Node currentNode = first;
        if (currentNode == null) {
            System.out.print("Pop Method Message : ");
            System.out.println("\u001B[31m" +"Queue Is Already Null!\n" + "\u001B[0m");
        }else if(currentNode.getNext() == null){
            popValue = first.getValue();
            System.out.println("Pop Method Success!(Pop Value : "+popValue+")\n");
            first = null;
        } else{
            while (currentNode != null){
                if(currentNode.getNext().getNext() == null){
                    popValue = currentNode.getNext().getValue();
                    System.out.println("Pop Method Success!(Pop Value : "+popValue+")\n");
                    currentNode.setNext(null);
                }
                currentNode = currentNode.getNext();
            }
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
            System.out.println("\u001B[34m" + "[Queue Is Null]" + "\u001B[0m");
        } else {
            System.out.print("\u001B[34m" + "In : ");
            while (currentNode != null){
                System.out.print("[" + currentNode.getValue() + "] -> ");
                currentNode = currentNode.getNext();
                size++;
            }
            System.out.println("Out" + "\u001B[0m");
        }
        System.out.println("Ukuran Queue : " + size + "\n");
    }

}
