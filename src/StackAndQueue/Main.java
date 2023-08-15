package StackAndQueue;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        System.out.println("hasPop : " + stack.hasPop());
        System.out.println();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Pop() : " + stack.pop());

        stack.display();
    }
}
