package StackAndQueue;

public class Main {
    public static void main(String[] args) {

       Queue queue = new Queue();
       queue.push("A");
       queue.push("B");
       queue.push("C");
       queue.push("D");
       queue.push("E");

       queue.display();

        Stack stack = new Stack();
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.display();


    }
}
