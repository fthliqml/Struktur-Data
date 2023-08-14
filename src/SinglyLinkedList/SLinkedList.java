package SinglyLinkedList;

public class SLinkedList {
    private Node first;

    public SLinkedList(){
        this.first = null;
    }

    public void add(int value){
        Node node = new Node(value);
        if (first == null) {
            first = node;
        }
        else {
            Node temp = first;
            while (temp != null){
                if (temp.getNext() == null){
                    temp.setNext(node);
                    return;
                }
                temp = temp.getNext();
            }
        }
    }

    public void insert(int value, int index){
        int length = 0;
        Node var = first;
        while (var != null){
            length++;
            var = var.getNext();
        }

        if (index <= length){
            Node node = new Node(value);
            if (index == 1) {
                node.setNext(first);
                first = node;
            } else if (index == length) {
                add(value);
            } else {
                Node temp = first;
                int i = 1;
                while (temp != null){
                    if(i == (index-1)){
                        node.setNext(temp.getNext());
                        temp.setNext(node);
                        return;
                    }
                    i++;
                    temp = temp.getNext();
                }
            }
        }
        else {
            System.out.println("index out of bounds!");
        }
    }

    public void remove(int index) {
        int length = 0;
        Node var = first;
        while (var != null){
            length++;
            var = var.getNext();
        }

        if (index <= length){
            if (index == 1){
                first = first.getNext();
            } else {
                Node temp = first;
                int i = 1;
                while (temp != null){
                    if (i == (index-1)){
                        temp.setNext(temp.getNext().getNext());
                    }
                    i++;
                    temp = temp.getNext();
                }
            }
        } else {
            System.out.println("Index out of bounds!");
        }
    }

    public void swap(int index1, int index2){
        if (index1 > index2) {
            int var = index2;
            index2 = index1;
            index1 = var;
        }

        Node node1 = null;
        Node node1Prev = null;
        Node node2 = null;
        Node node2Prev = null;
        Node currentNode = first;
        int i = 1;

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
            if (index1 == 1){
                first = node2;
            }
            else {
                node1Prev.setNext(node2);
            }
       } else {
           if (index1 == 1){
               first = node2;
           } else {
               node1Prev.setNext(node2);
           }
           node2.setNext(node1Next);
           node2Prev.setNext(node1);
       }
    }

    public void get(int index){
        Node temp = first;
        int i = 1;
        while (temp != null){
            if (i == index){
                System.out.println("get : " + temp.getValue());
                return;
            }
            i++;
            temp = temp.getNext();
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
