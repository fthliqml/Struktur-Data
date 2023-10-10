
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
        return true;
    }

    private boolean insert(Node parent, Node node) {
        if (parent.getKey() > node.getKey()) {
            if (parent.getLeft() == null) {
                parent.setLeft(node);
            } else {
                insert(parent.getLeft(), node);
            }
        } else {
            if (parent.getRight() == null) {
                parent.setRight(node);
            } else {
                insert(parent.getRight(), node);
            }
        }
        return true;

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
    // public void display(Node root, String prefix, boolean isLeft) {
    // if (root != null) {
    // System.out.println(prefix + (isLeft ? "|---" : "\--- ") + root.getKey());
    // display(root.getLeft(), prefix + (isLeft ? "│ " : " "), true);
    // display(root.getRight(), prefix + (isLeft ? "│ " : " "), false);
    // }
    // }

    // public void display() {
    // display(root, "", true);
    // }
}
