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
            System.out.println("\u001B[31m" +"Stack Is Already Null!\n" + "\u001B[0m");
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

    public void swap(int index1, int index2){
        int length = 0;
        Node var = first;
        while (var != null){
            length++;
            var = var.getNext();
        }

        if (index1 >= length || index1 < 0 || index2 >= length || index2 < 0 ) {
            System.out.println("\u001B[31m" +"Index Out Of Bounds!" + "\u001B[0m");
        } else {
            if (index1 > index2) {
                int temp = index2;
                index2 = index1;
                index1 = temp;
            }

            Node node1 = null;
            Node node1Prev = null;
            Node node2 = null;
            Node node2Prev = null;
            Node currentNode = first;
            int i = 0;

            while (currentNode != null){
                if (i == index1){
                    node1 = currentNode;
                } else if (i == (index1-1)) {
                    node1Prev = currentNode;
                } else if (i == index2) {
                    node2 = currentNode;
                } else if (i == (index2-1)) {
                    node2Prev = currentNode;
                }
                i++;
                currentNode = currentNode.getNext();
            }

            Node node2Next = node2.getNext();
            Node node1Next = node1.getNext();
            node1.setNext(node2Next);

            if (index2-index1 == 1) {
                node2.setNext(node1);
                if (index1 == 0){
                    first = node2;
                }
                else {
                    node1Prev.setNext(node2);
                }
            } else {
                if (index1 == 0){
                    first = node2;
                } else {
                    node1Prev.setNext(node2);
                }
                node2.setNext(node1Next);
                node2Prev.setNext(node1);
            }
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
