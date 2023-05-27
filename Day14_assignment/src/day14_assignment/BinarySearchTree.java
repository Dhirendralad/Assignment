package day14_assignment;

public class BinarySearchTree {

    public static void main(String[] args) {
        MyBinaryNode<Integer> root = new MyBinaryNode<>(56);
        root.left = new MyBinaryNode<>(30);
        root.right = new MyBinaryNode<>(70);

        System.out.println("Binary search tree created successfully!");
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
}

interface INode<T extends Comparable<T>> {
    T getKey();

    void setKey(T key);

    INode<T> getLeft();

    void setLeft(INode<T> left);

    INode<T> getRight();

    void setRight(INode<T> right);
}
