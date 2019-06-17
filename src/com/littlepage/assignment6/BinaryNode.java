package com.littlepage.assignment6;

public class BinaryNode<T> implements Cloneable{
    //member variable
    private T data;
    private BinaryNode<T> leftChild;
    private BinaryNode<T> rightChild;

    //constructor
    public BinaryNode(T data) {
        this.data = data;
    }

    public BinaryNode(T data, BinaryNode<T> leftChild, BinaryNode<T> rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    //getters and setters
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    //judge is or not leaf
    public boolean isLeaf(){
        return leftChild ==null&& rightChild ==null;
    }

    @Override
    public BinaryNode<T> clone() throws CloneNotSupportedException {
        BinaryNode<T> binaryNode=(BinaryNode<T>)super.clone();
        if(binaryNode.getLeftChild()!=null)binaryNode.setLeftChild((BinaryNode<T>)binaryNode.getLeftChild().clone());
        if(binaryNode.getRightChild()!=null)binaryNode.setRightChild((BinaryNode<T>) binaryNode.getRightChild().clone());
        return binaryNode;
    }

}
