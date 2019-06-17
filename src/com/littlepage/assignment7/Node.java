package com.littlepage.assignment7;


/**
 * The node is HuffmanTree's node
 */
public class Node<T> implements Comparable{
    //member variable
    private T data;
    private int weight;
    private Node<T> parent;
    private Node<T> leftChild;
    private Node<T> rightChild;
    private int coding;

    //constructor
    public Node() {
    }

    public Node(T data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    //getters and setters
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public int getCoding() {
        return coding;
    }

    public void setCoding(int coding) {
        this.coding = coding;
    }

    //toString method
    @Override
    public String toString() {
        return ""+data;
    }

    @Override
    public int compareTo(Object o) {
        Node<T> node=(Node<T>)o;
        return weight-node.weight;
    }
}
