package StackAndQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        Stack stack = new Stack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        System.out.println("TAMPILAN STACK AWAL");
        stack.display();
        stack.swap(1, 3);
        System.out.println("TAMPILAN STACK SETELAH SWAP INDEX 1 DAN 3");
        stack.display();

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println();

        Queue queue = new Queue();
        queue.push(1);
        queue.push("B");
        queue.push(3);
        queue.push("D");
        System.out.println("TAMPILAN QUEUE AWAL");
        queue.display();
        queue.swap(0, 1);
        System.out.println("TAMPILAN QUEUE SETELAH SWAP INDEX 0 DAN 1");
        queue.display();


    }
}
