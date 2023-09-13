package stackQueue;

public class MainClass {
    public static void main(String[] args) {
        StackList stack = new StackList();

        System.out.println("Is stack empty? " + stack.hasPop());

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Is stack empty? " + stack.hasPop());
        System.out.println("Top element: " + stack.peek());

        stack.pop();
        System.out.println("Top element after pop: " + stack.peek());

        stack.pop();
        stack.pop();

        System.out.println("Is stack empty? " + stack.hasPop());
        System.out.println("Top element: " + stack.peek());

        stack.pop();
    }
}
