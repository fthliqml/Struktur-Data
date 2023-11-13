package Kamus;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private Node root;

    public void root(Node root) {
        this.root = root;
    }

    public boolean isRed(String key) {
        Node node = isExist(root, key);

        boolean red = node.isRed();

        if (!red) {
            System.out.println("Node is Black " + key);
        } else {
            System.out.println("Node is Red " + key);
        }
        return red;
    }

    public boolean isExist(String key) {
        Node node = isExist(root, key);
        boolean exist = true;
        if (node == null) {
            exist = false;
            System.out.println(exist);
            return exist;
        }
        System.out.println(node.getKey() + " " + exist);
        return exist;
    }

    public Node isExist(Node parent, String key) {
        if (parent == null) {
            return parent;
        } else {
            if (parent.getKey().compareTo(key) == 0) {
                return parent;
            }
            if (parent.getKey().compareTo(key) > 0) {
                return isExist(parent.getLeft(), key);
            } else {
                return isExist(parent.getRight(), key);
            }
        }
    }

    public boolean search(String key) {
        boolean found = search(root, key);
        return found;
    }

    public boolean search(Node parent, String key) {
        if (parent == null) {
            return false;
        } else {
            if (parent.getKey().compareTo(key) == 0) {
                return true;
            }
            if (parent.getKey().compareTo(key) > 0) {
                return search(parent.getLeft(), key);
            } else {
                return search(parent.getRight(), key);
            }
        }
    }

    public boolean add(String key, String value, String descEn, String descId) {
        Node node = new Node(key, value, descEn, descId);
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
        if (node.getKey().compareTo(parent.getKey()) < 0) {
            parent.setLeft(insert(parent.getLeft(), node));
            parent.getLeft().setParent(parent);
        } else if (node.getKey().compareTo(parent.getKey()) > 0) {
            parent.setRight(insert(parent.getRight(), node));
            parent.getRight().setParent(parent);
        }
        return parent;
    }

    public boolean remove(String key) {
        if (root == null) {
            System.out.println("Tree still Empty");
            return false;
        }
        if (!search(root, key)) {
            System.out.println("Couldnt found " + key + " Node in Tree");
            return false;
        }
        root = remove(root, key);
        BalancingTree(root);
        System.out.println("Succeded Deleted " + key + " node");

        return true;
    }

    public Node remove(Node node, String key) {
        if (node == null) {
            return node;
        }
        if (key.compareTo(node.getKey()) < 0) {
            node.setLeft(remove(node.getLeft(), key));
        } else if (key.compareTo(node.getKey()) > 0) {
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

    private static String succesor(Node node) {
        String minimum = node.getKey();

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
        while (root != node && node.getParent() != null && node.getParent().isRed()) {
            if (node.getParent() == node.getParent().getParent().getLeft()) {
                if (node.getParent().getParent().getRight() != null && node.getParent().getParent().isRed()) {
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
                    if (node.getParent().getParent().getLeft() != null
                            && node.getParent().getParent().getLeft().isRed()) {
                        node.getParent().getParent().getLeft().setRed(false);
                        node.getParent().getParent().setRed(true);
                        node.getParent().setRed(false);
                        node = node.getParent().getParent();
                    } else {
                        if (node == node.getParent().getLeft()) {
                            rightRotate(node.getParent());
                            node = node.getRight();

                        }
                        node.getParent().setRed(false);
                        node.getParent().getParent().setRed(true);
                        leftRotate(node.getParent().getParent());
                    }
                }
            }
            root.setRed(false);
        }
    }

    public String getValue(String key) {
        if (key == null) {
            return null;
        }
        boolean exist = search(root, key);
        if (!exist) {
            System.out.println("not exist");
            List<String> similiar = similiarList(root, key);
            return similiar.get(0);
        }
        Node node = isExist(root, key);
        String result = node.getValue();
        return result;
    }

    public String getDescriptionId(String key) {
        if (key == null) {
            return null;
        }
        boolean exist = search(root, key);
        if (!exist) {
            System.out.println("not exist");
            List<String> similiar = similiarList(root, key);
            return similiar.get(0);
        }
        Node node = isExist(root, key);
        String result = node.getDescId();
        return result;
    }

    public String getDescriptionEn(String key) {
        if (key == null) {
            return null;
        }
        boolean exist = search(root, key);
        if (!exist) {
            System.out.println("not exist");
            List<String> similiar = similiarList(root, key);
            return similiar.get(0);
        }
        Node node = isExist(root, key);
        String result = node.getDescEn();
        return result;
    }

    public void similiar(Node parent, String key, List<String> similarKey) {
        if (parent == null) {
            return;
        }
        if (parent.getKey().compareTo(key) >= 0 && parent.getKey().startsWith(key)) {
            similarKey.add(parent.getKey());
        }
        if (parent.getKey().compareTo(key) > 0) {
            similiar(parent.getLeft(), key, similarKey);
        } else {
            similiar(parent.getRight(), key, similarKey);
        }
    }

    public List<String> similiarList(Node parent, String key) {
        List<String> similarKey = new ArrayList<>();
        similiar(parent, key, similarKey);
        return similarKey;

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

}
