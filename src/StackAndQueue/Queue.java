package StackAndQueue;

public class Queue {
    private Node first;
    private int length = 0;

    public Queue(){
        this.first = null;
    }

    public void push(Object value){
        length++;
        Node newNode = new Node(value);
        if(first == null){
            first = newNode;
        } else {
            newNode.setNext(first);
            first = newNode;
        }
    }

    public Object pop(){
        if(length > 0){
            length--;
        }
        Object popValue = null;
        Node currentNode = first;
        if (currentNode == null) {
            System.out.print("Pop Method Message : ");
            System.out.println("\u001B[31m" + "Queue Is Already Null!\n" + "\u001B[0m");
            return popValue;
        }else if(currentNode.getNext() == null){
            popValue = first.getValue();
            System.out.println("Pop Method Success!(Pop Value : "+popValue+")\n");
            first = null;
            return popValue;
        } else{
            while (currentNode != null){
                if(currentNode.getNext().getNext() == null){
                    popValue = currentNode.getNext().getValue();
                    System.out.println("Pop Method Success!(Pop Value : "+popValue+")\n");
                    currentNode.setNext(null);
                    return popValue;
                }
                currentNode = currentNode.getNext();
            }
        }
        return popValue;
    }

    public Boolean hasPop(){
        if (first == null){
            return false;
        } else {
            return true;
        }
    }

    public void swap(int index1, int index2){
        if (index1 == index2) {
            System.out.println("Swap method meesage : " + "\u001B[31m" +"Index Tidak Boleh Sama!" + "\u001B[0m");
            return;
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
        System.out.println("\u001B[36m" + "-----------Display------------");
        if (currentNode == null) {
            System.out.println("\u001B[34m" + "Queue-list Is Null" + "\u001B[0m");
        } else {
            System.out.print("\u001B[34m" + "In -> ");
            while (currentNode != null){
                System.out.print("[" + currentNode.getValue() + "] -> ");
                currentNode = currentNode.getNext();
            }
            System.out.println("Out" + "\u001B[0m");
        }
        System.out.println("Ukuran Queue : " + length + "\n");
    }

}
