package SinglyLinkedList;

public class SLinkedList {
    private Node first;

    public SLinkedList(){
        this.first = null;
    }

    public void add(int value){
        Node newNode = new Node(value);
        if (first == null) {
            first = newNode;
        }
        else {
            Node CurrentNode = first;
            while (CurrentNode != null){
                if (CurrentNode.getNext() == null){
                    CurrentNode.setNext(newNode);
                    return;
                }
                CurrentNode = CurrentNode.getNext();
            }
        }

    }

    public void insert(int value, int index){
        int length = 0;
        Node temp = first;
        while (temp != null){
            length++;
            temp = temp.getNext();
        }

        if (index < length && index >= 0){
            Node newNode = new Node(value);
            if (index == 0) {
                newNode.setNext(first);
                first = newNode;
            } else if (index == (length-1)) {
                add(value);
            } else {
                Node CurrentNode = first;
                int i = 0;
                while (CurrentNode != null){
                    if(i == (index-1)){
                        newNode.setNext(CurrentNode.getNext());
                        CurrentNode.setNext(newNode);
                        return;
                    }
                    i++;
                    CurrentNode = CurrentNode.getNext();
                }
            }
        }
        else {
            System.out.println("\u001B[31m" +"Index Out Of Bounds!" + "\u001B[0m");
        }
    }

    public void remove(int index) {
        int length = 0;
        Node temp = first;
        while (temp != null){
            length++;
            temp = temp.getNext();
        }

        if (index < length && index >= 0){
            if (index == 0){
                first = first.getNext();
            } else {
                Node CurrentNode = first;
                int i = 0;
                while (CurrentNode != null){
                    if (i == (index-1)){
                        CurrentNode.setNext(CurrentNode.getNext().getNext());
                    }
                    i++;
                    CurrentNode = CurrentNode.getNext();
                }
            }
        } else {
            System.out.println("\u001B[31m" +"Index Out Of Bounds!" + "\u001B[0m");
        }
    }

    public void swap(int index1, int index2){
        int length = 0;
        Node var = first;
        while (var != null){
            length++;
            var = var.getNext();
        }

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

    public int get(int index){
        int length = 0;
        int last = 0;
        Node var = first;
        while (var != null){
            if (var.getNext() == null){
                last = var.getValue();
            }
            length++;
            var = var.getNext();

        }

        if (index < length && index >= 0){
            Node CurrentNode = first;
            int i = 0;
            while (CurrentNode != null){
                if (i == index){
                    return CurrentNode.getValue();
                }
                i++;
                CurrentNode = CurrentNode.getNext();
            }
        } else {
            System.out.println("\u001B[31m" +"Index Out Of Bounds!" + "\u001B[0m");
            if (index < 0){
                return first.getValue();
            }
        }
        return last;
    }

    public void  display(){
        Node currentNode = first;
        int size = 0;
        if (currentNode == null) {
            System.out.println("\u001B[34m" + "Singly Linked List Is Null" + "\u001B[0m");
        } else {
            while (currentNode != null){
                System.out.print(currentNode.getValue() + " -> ");
                currentNode = currentNode.getNext();
                size++;
            }
            System.out.println("Null");
            System.out.println("Ukuran Linked-list : " + size);
        }

    }



}
