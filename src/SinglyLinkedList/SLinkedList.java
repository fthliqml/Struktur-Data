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


    public void  display(){
        Node temp = first;
        while (temp != null){
            System.out.print(temp.getValue() + " -> ");
            temp = temp.getNext();
        }
        System.out.println("NULL");
    }



}
