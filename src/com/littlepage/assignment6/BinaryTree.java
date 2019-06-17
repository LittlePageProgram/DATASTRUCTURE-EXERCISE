package com.littlepage.assignment6;

public interface BinaryTree<T> {
    boolean isEmpty();

    int size();

    int height();

    void preOrderTraverse();

    void inorderTraverse();

    void postOrderTraverse();

    void inOrderByStack();

    void levelOrder();

    BinaryNode<T> insert(T x);

    BinaryNode<T> insert(BinaryNode<T> parent, T x, boolean leftChild);

    void remove(BinaryNode<T> parent, boolean leftChild);

    void clear();

    BinaryNode<T> search(T key);

    int level(T key);
}
