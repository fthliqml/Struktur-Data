package Kamus;

public class Node {
    private String key;
    private Node right;
    private  Node left;
    private Node parent;
    private boolean red;
    private String value;
    
    public Node (String key, String value){
        this.key = key.toLowerCase();
        this.value = value.toLowerCase();
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
    public String getKey(){
        return key;
    }
    public void setKey(String key){
        this.key = key;
    }
    public boolean isRed(){
        return red;
    }

    public void setRed(boolean red){
        this.red = red;
    }

    public Node getParent(){
        return parent;
    }
    public void setParent(Node parent){
        this.parent = parent;
    }
    public void setValue(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
    public void gimmick(){
        
    }
}
