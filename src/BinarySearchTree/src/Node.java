public class Node {
    private int key;
    private Node right;
    private  Node left;

    public Node (int key){
        this.key = key;
    }

    public void setRight(Node right){
        this.right = right;
    }
    public void setLeft(Node left){
        this.left = left;
    }

    public Node getRight(){
        return right;
    }
    public Node getLeft(){
        return left;
    }
    public int getKey(){
        return key;
    }
}
