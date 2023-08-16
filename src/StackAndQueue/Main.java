package StackAndQueue;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.display();
        stack.pop();
        stack.display();
        stack.pop();

        System.out.println("-----------------QUEUE-----------------\n");
        Queue queue = new Queue();
        queue.push(5);
        queue.push(3);
        queue.display();


    }
}
