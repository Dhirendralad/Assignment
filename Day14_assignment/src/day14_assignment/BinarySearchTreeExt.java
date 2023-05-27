package day14_assignment;

public class BinarySearchTreeExt {

    public static void main(String[] args) {
        MyBinaryNode<Integer> root = new MyBinaryNode<>(56);
        root.left = new MyBinaryNode<>(30);
        root.right = new MyBinaryNode<>(70);

        root.left.left = new MyBinaryNode<>(22);
        root.left.right = new MyBinaryNode<>(40);

        root.right.left = new MyBinaryNode<>(60);
        root.right.right = new MyBinaryNode<>(95);

        root.left.left.left = new MyBinaryNode<>(11);

        root.right.left.right = new MyBinaryNode<>(65);

        root.left.left.left.left = new MyBinaryNode<>(3);
        root.left.left.left.right = new MyBinaryNode<>(16);

        root.right.left.right.left = new MyBinaryNode<>(63);
        root.right.left.right.right = new MyBinaryNode<>(67);

        System.out.println("Binary search tree created successfully!");

        int size = root.size();
        int eSize = 10;
        if (size == eSize) {
            System.out.println("All " + eSize + " nodes have been added to the binary search tree.");
        } else {
            System.out.println("Expected " + eSize + " nodes but found " + size + " nodes in the binary search tree.");
        }
    }
}

class MyBinaryNode<T extends Comparable<T>> implements INode<T> {

    T key;
    MyBinaryNode<T> left, right;

    public MyBinaryNode(T key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    @Override
    public T getKey() {
        return key;
    }

    @Override
    public void setKey(T key) {
        this.key = key;
    }

    @Override
    public INode<T> getLeft() {
        return left;
    }

    @Override
    public void setLeft(INode<T> left) {
        this.left = (MyBinaryNode<T>) left;
    }

    @Override
    public INode<T> getRight() {
        return right;
    }

    @Override
    public void setRight(INode<T> right) {
        this.right = (MyBinaryNode<T>) right;
    }

    public int size() {
        if (left == null && right == null) {
            return 1;
        } else if (left == null) {
            return 1 + right.size();
        } else if (right == null) {
            return 1 + left.size();
        } else {
            return 1 + left.size() + right.size();
        }
    }
}

interface INode<T extends Comparable<T>> {
    T getKey();
    void setKey(T key);

    INode<T> getLeft();
    void setLeft(INode<T> left);

    INode<T> getRight();
    void setRight(INode<T> right);
}
