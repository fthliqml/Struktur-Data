package RedBlackTree;

public class Tree {
    private Node root;

    public void root(Node root) {
        this.root = root;
    }

    public boolean search(int key) {
        boolean found = search(root, key);
        System.out.println(found);
        return found;
    }

    public boolean isRed(int key) {
        Node node = isExist(root, key);

        boolean red = node.isRed();

        if (!red) {
            System.out.println("Node is Black " + key);
        } else {
            System.out.println("Node is Red " + key);
        }
        return red;
    }

    private Node isExist(Node parent, int key) {
        if (parent == null) {
            return parent;
        } else {
            if (parent.getKey() == key) {
                return parent;
            }
            if (parent.getKey() > key) {

                return isExist(parent.getLeft(), key);
            } else {
                return isExist(parent.getRight(), key);
            }
        }
    }

    private boolean search(Node parent, int key) {
        if (parent == null) {
            return false;
        } else {
            if (parent.getKey() == key) {
                System.out.println("Node found = " + key);
                return true;
            }
            if (parent.getKey() > key) {
                return search(parent.getLeft(), key);
            } else {
                return search(parent.getRight(), key);
            }
        }
    }

    public boolean add(int key) {
        Node node = new Node(key);
        boolean isThere = search(root, key);

        if (isThere) {
            System.out.println(key + " Didalam node? " + isThere);
            return false;
        }
        if (root == null) {
            root = node;
            return true;
        }
        insert(root, node);
        BalancingTree(node);
        return true;
    }

    private Node insert(Node parent, Node node) {
        if (parent == null) {
            node.setRed(true);
            return node;
        }

        if (node.getKey() < parent.getKey()) {
            parent.setLeft(insert(parent.getLeft(), node));
            parent.getLeft().setParent(parent);
        } else if (node.getKey() > parent.getKey()) {
            parent.setRight(insert(parent.getRight(), node));
            parent.getRight().setParent(parent);
        }
        
        return parent;
    }

    public boolean remove(int key) {
        if (root == null) {
            System.out.println("Tree still Empty");
            return false;
        }
        if (!search(root, key)) {
            System.out.println("Couldnt found " + key + " Node in Tree");
            return false;
        }
        root = remove(root, key);
        System.out.println("Succeded Deleted " + key + " node");

        return true;
    }

    public Node remove(Node node, int key) {
        if (node == null) {
            return node;
        }
        if (key < node.getKey()) {
            node.setLeft(remove(node.getLeft(), key));
        } else if (key > node.getKey()) {
            node.setRight(remove(node.getRight(), key));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            node.setKey(succesor(node.getRight()));
            node.setRight(remove(node.getRight(), node.getKey()));
        }
        return node;
    }

    private static int succesor(Node node) {
        int minimum = node.getKey();

        while (node.getLeft() != null) {
            minimum = node.getLeft().getKey();
            node = node.getLeft();
        }
        return minimum;
    }

    public void leftRotate(Node x) {
        Node rightChild = x.getRight();
        x.setRight(rightChild.getLeft());
        
        if (rightChild.getLeft() != null) {
            rightChild.getLeft().setParent(x);
        }
        
        rightChild.setParent(x.getParent());
        
        if (x.getParent() == null) {
            root = rightChild;
        } else if (x == x.getParent().getLeft()) {
            x.getParent().setLeft(rightChild);
        } else {
            x.getParent().setRight(rightChild);
        }
        
        rightChild.setLeft(x);
        x.setParent(rightChild);
    }
    
    

    public void rightRotate(Node y) {
        Node leftChild = y.getLeft();
        y.setLeft(leftChild.getRight());
        
        if (leftChild.getRight() != null) {
            leftChild.getRight().setParent(y);
        }
        
        leftChild.setParent(y.getParent());
        
        if (y.getParent() == null) {
            root = leftChild;
        } else if (y == y.getParent().getLeft()) {
            y.getParent().setLeft(leftChild);
        } else {
            y.getParent().setRight(leftChild);
        }
        
        leftChild.setRight(y);
        y.setParent(leftChild);
    }
    
    

    public void BalancingTree(Node node) {
        while (node != null && node.isRed() && node.getParent() != null && node.getParent().isRed()) {
            Node parent = node.getParent();
            Node grandparent = parent.getParent();
            
            if (parent == grandparent.getLeft()) {
                Node uncle = grandparent.getRight();
                
                if (uncle != null && uncle.isRed()) {
                    parent.setRed(false);
                    uncle.setRed(false);
                    grandparent.setRed(true);
                    node = grandparent;
                } else {
                    if (node == parent.getRight()) {
                        node = parent;
                        leftRotate(node);
                        parent = node.getParent();
                    }
                    
                    parent.setRed(false);
                    grandparent.setRed(true);
                    rightRotate(grandparent);
                }
            } else {
                // Symmetric case: parent is the right child of grandparent
                Node uncle = grandparent.getLeft();
                
                if (uncle != null && uncle.isRed()) {
                    parent.setRed(false);
                    uncle.setRed(false);
                    grandparent.setRed(true);
                    node = grandparent;
                } else {
                    if (node == parent.getLeft()) {
                        node = parent;
                        rightRotate(node);
                        parent = node.getParent();
                    }
                    
                    parent.setRed(false);
                    grandparent.setRed(true);
                    leftRotate(grandparent);
                }
            }
        }
        
        root.setRed(false);
    }
    
    

    public void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.getLeft());
            System.out.print(node.getKey() + " ");
            inorderTraversal(node.getRight());
        }
    }

    public void preorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getKey() + " ");
        preorderTraversal(node.getLeft());
        preorderTraversal(node.getRight());
    }

    public void postorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.getLeft());
        postorderTraversal(node.getRight());
        System.out.print(node.getKey() + " ");
    }

    public Node getRoot() {
        return root;
    }

    public void display(Node root, String prefix, boolean isLeft) {
        if (root != null) {
            System.out.println(prefix + (isLeft ? "|---" : "`--- ") + root.getKey());
            display(root.getLeft(), prefix + (isLeft ? "│ " : " "), true);
            display(root.getRight(), prefix + (isLeft ? "│ " : " "), false);
        }
    }

    public void display() {
        display(root, "", true);
    }
}
