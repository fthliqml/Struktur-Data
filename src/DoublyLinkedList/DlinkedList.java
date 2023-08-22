package DoublyLinkedList;

import java.util.NoSuchElementException;

public class DlinkedList {

    private Node first;
    private Node last;
    private int lenght;

    public void addFirst(int val) {
        Node node = new Node(val);
        lenght++;
        node.setNext(first);
        if (first == null) {
            first = node;
            last = node;
            return;
        }
        first.setPrev(node);
        first = node;
    }

    public void addLast(int val) {
        Node node = new Node(val);
        lenght++;
        if (last == null) {
            first = node;
            last = node;
            return;
        }
        last.setNext(node);
        node.setPrev(last);
        last = node;
    }

    public void insert(int val, int index) {
        if (index == 0) {
            addFirst(val);
            return;
        }
        if (index == lenght) {
            addLast(val);
            return;
        }
        if (index < 0 || index > lenght) {
            throw new IllegalArgumentException("Index di luar jangkauan");
        }
        Node temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        Node newNode = new Node(val);
        newNode.setNext(temp);
        newNode.setPrev(temp.getPrev());
        temp.getPrev().setNext(newNode);
        temp.setPrev(newNode);
        lenght++;
    }

    public void removeFirst() {
        if (first != null) {
            first = first.getNext();
            if (first != null) {
                first.setPrev(null);
                return;
            } else {
                last = null;
                return;
            }
        }
        throw new NoSuchElementException("Linked list kosong");
    }
    public void remove(int index) {
        if (index == 0) {
            if (first != null) {
                first = first.getNext();
                if (first != null) {
                    first.setPrev(null);
                    lenght--;
                    return;
                } else {
                    last = null;
                    lenght--;
                    return;
                }
            }
            throw new NoSuchElementException("Linked list kosong");
        }
        if (index == lenght - 1) {
            if (first == null) {
                throw new NoSuchElementException("Linked list kosong");
            }
            if (first.getNext() != null) {
                Node temp = first;
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                }
                temp.setNext(null);
                last = temp;
                lenght--;
                return;
            }
            first = null;
            last = null;
            lenght = 0;
        }
        Node temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());
        lenght--;
    }

    public int get(int index) {
        Node node = first;
        if (index < 0 || index > lenght) {
            throw new IllegalArgumentException("Index di luar jangkauan");
        }
        for (int i = 1; i < index; i++) {
            node = node.getNext();
        }

        return node.getVal();
    }

    public Node find(int index) {
        Node node = first;
        if (index < 0 || index > lenght) {
            throw new IllegalArgumentException("Index di luar jangkauan");
        }
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node;
    }

    public void swap(int index1, int index2) {
        if (lenght < index1 || index1 < 0 || lenght < index2 || index2 < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index1 > index2) {
            int var = index2;
            index2 = index1;
            index1 = var;
        }
        if (index1 == index2) {
            return;
        }
        Node pos1 = find(index1);
        Node pos2 = find(index2);
        Node temp1 = null;
        Node temp2 = null;

        if (pos1.getNext() == pos2) {
            //swap node yang bersebelahan
            temp1 = pos2;
            temp2 = pos1;

            if (pos1.getPrev() != null) {
                pos1.getPrev().setNext(temp1);
            } else {
                first = temp1;
            }

            temp1.setPrev(pos1.getPrev());
            temp2.setPrev(temp1);
            temp2.setNext(pos2.getNext());

            if (pos2.getNext() != null) {
                pos2.getNext().setPrev(temp2);
            } else {
                last = temp2;
            }

            temp1.setNext(temp2);
        } else {
            // swap yang berjauhan
            temp1 = pos2.getNext();
            temp2 = pos2.getPrev();
            
            if (pos1.getPrev() != null) {
                pos1.getPrev().setNext(pos2);
            } else {
                first = pos2;
            }

            if (pos1.getNext() != null) {
                pos1.getNext().setPrev(pos2);
            } else {
                last = pos2;
            }

            if (temp1 != null) {
                temp1.setPrev(pos1);
            } else {
                last = pos1;
            }

            if (temp2 != null) {
                temp2.setNext(pos1);
            } else {
                first = pos1;
            }
            pos2.setNext(pos1.getNext());
            pos2.setPrev(pos1.getPrev());
            pos1.setNext(temp1);
            pos1.setPrev(temp2);
        }

    }

    public void display() {

        Node temp = first;
        System.out.println("this is normal streamline");
        while (temp != null) {
            System.out.print(temp.getVal() + " -> ");
            temp = temp.getNext();
        }

        System.out.println("end = " + lenght);

    }

    public void displayReverse() {
        Node temp = last;
        System.out.println("This is reverse :");
        while (temp != null) {
            System.out.print(temp.getVal() + " -> ");
            temp = temp.getPrev();
        }

        System.out.println("start");
    }

}
