package ru.hw;

public class Tree<V extends Comparable<V>> {
    private Node root;

    public class Node {
        private V value;
        private Node leftChild;
        private Node rightChild;
        private Color color;
    }

    // маркеры
    private enum Color {
        RED,
        BLACK
    }

    // добавленееи элемента
    public boolean add(V value) {
        if (root == null) {
            root = new Node();
            root.value = value;
            root.color = Color.BLACK;
            return true;
        }

        return addNode(root, value);
    }

    // балансировка
    private Node balancing(Node node) {
        Node result = node;
        boolean needBalance;

        do {
            needBalance = false;
            if (result.rightChild != null && result.color == Color.RED &&
                    (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
                needBalance = true;
                result = rightTurn(result);
            }

            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED) {
                needBalance = true;
                result = leftTurn(result);
            }

            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.rightChild != null && result.rightChild.color == Color.RED) {
                needBalance = true;
                colorSwap(result);
            }
        } while (needBalance);

        return result;
    }

    private boolean addNode(Node node, V value) {
        if (node.value.equals(value)) {
            return false;
        }

        if (node.value.compareTo(value) > 0) {
            if (node.leftChild != null) {
                boolean result = addNode(node.leftChild, value);
                node.leftChild = balancing(node.leftChild);
                return result;
            } else {
                node.leftChild = new Node();
                node.leftChild.value = value;
                node.leftChild.color = Color.RED;
                return true;
            }
        } else {
            if (node.rightChild != null) {
                boolean result = addNode(node.rightChild, value);
                node.rightChild = balancing(node.rightChild);
                return result;
            } else {
                node.rightChild = new Node();
                node.rightChild.value = value;
                node.color = Color.RED;
                return true;
            }
        }
    }

    // левый поворот
    private Node leftTurn(Node node) {
        Node left = node.leftChild;
        Node right = left.rightChild;
        left.rightChild = node;
        node.leftChild = right;
        left.color = node.color;
        node.color = Color.RED;
        return left;
    }

    // правый поворот
    private Node rightTurn(Node node) {
        Node right = node.rightChild;
        Node left = right.leftChild;
        right.leftChild = node;
        node.rightChild = left;
        right.color = node.color;
        node.color = Color.RED;
        return right;
    }


    // обмен
    private void colorSwap(Node node) {
        node.color = Color.RED;
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
    }

    public boolean contains(V value) {
        Node node = root;
        if (root != null) {
            while (node != null) {
                if (node.value.equals(value)) {
                    return true;
                }
                if (node.value.compareTo(value) > 0) {
                    node = node.leftChild;
                } else {
                    node = node.rightChild;
                }
            }
        }
        return false;
    }


}
