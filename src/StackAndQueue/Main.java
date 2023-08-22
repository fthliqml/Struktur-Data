package StackAndQueue;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
//        stack.push(10);
//        stack.display();
//        stack.pop();
//        stack.push(1);
//        stack.push(5);
//        stack.push(6);
//        stack.display();
//        stack.display();



//        System.out.println("-----------------QUEUE-----------------\n");
        Queue queue = new Queue();
        queue.push(5);
        queue.push(3);
        queue.push(7);
        queue.display();
        queue.swap(1,2);
        queue.display();


    }
}
