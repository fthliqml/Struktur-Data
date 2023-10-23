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
        Node rightTemp = x.getRight();
        x.setRight(rightTemp.getLeft());
        if (rightTemp.getLeft() != null) {
            rightTemp.getLeft().setParent(x);
        }
        rightTemp.setParent(x.getParent());
        if (x.getParent() == null) {
            root(rightTemp);
        } else if (x == x.getParent().getLeft()) {
            x.getParent().setLeft(rightTemp);
        } else {
            x.getParent().setRight(rightTemp);
        }
        rightTemp.setLeft(x);
        x.setParent(rightTemp);
    }

    public void rightRotate(Node y) {
        Node leftTemp = y.getLeft();
        y.setLeft(leftTemp.getRight());

        if (leftTemp.getRight() != null) {
            leftTemp.getRight().setParent(y);
        }

        leftTemp.setParent(y.getParent());

        if (y.getParent() == null) {
            root(leftTemp);
        } else if (y == y.getParent().getLeft()) {
            y.getParent().setLeft(leftTemp);
        } else {
            y.getParent().setRight(leftTemp);
        }

        leftTemp.setRight(y);
        y.setParent(leftTemp);
    }

    public void BalancingTree(Node node) {
        while (node != root && node.getParent() != null && node.getParent().getParent().isRed()) {
            if (node.getParent() == node.getParent().getParent().getLeft()) {
                if (node.getParent().getParent().getRight().isRed()) {
                    node.getParent().getParent().getRight().setRed(false);
                    node.getParent().getParent().setRed(true);
                    node.getParent().setRed(false);
                    node = node.getParent().getParent();
                } else {
                    if (node == node.getParent().getRight()) {
                        leftRotate(node.getParent());
                        node = node.getLeft();
                    }
                    node.getParent().setRed(false);
                    node.getParent().getParent().setRed(true);
                    rightRotate(node.getParent().getParent());
                }
            } else {
                if (node.getParent() == node.getParent().getParent().getRight()) {
                    System.out.println("First conditional passed");
                    if (node.getParent().getParent().getLeft().isRed()) {
                        node.getParent().getParent().getLeft().setRed(false);
                        node.getParent().getParent().setRed(true);
                        node.getParent().setRed(false);
                        node = node.getParent().getParent();
                        System.out.println("Second Conditional passed");
                    } else {
                        if (node == node.getParent().getLeft()) {
                            rightRotate(node.getParent());
                            System.out.println("Third conditial pased");
                        }
                        node.getParent().setRed(false);
                        node.getParent().getParent().setRed(true);
                        leftRotate(node.getParent());
                        System.out.println("4 conditional pass");
                    }
                }
            }
            System.out.println("Finishing");
            root.setRed(false);
        }
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
