package com.littlepage.assignment6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LinkedBinaryTree<T> implements BinaryTree<T>,Cloneable {
    //member variable
    private BinaryNode<T> root;

    //constructor
    public LinkedBinaryTree() {
    }

    @Override
    public LinkedBinaryTree<T> clone() throws CloneNotSupportedException {
        LinkedBinaryTree<T> binaryTree=(LinkedBinaryTree<T>)super.clone();
        binaryTree.setRoot((BinaryNode<T>)binaryTree.getRoot().clone());
        return binaryTree;
    }

    public LinkedBinaryTree(BinaryNode<T> root) {
        this.root = root;
    }

    //getters and setters
    public BinaryNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryNode<T> root) {
        this.root = root;
    }

    //other method
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(BinaryNode<T> node) {
        if (node != null) {
            int sl = size(node.getLeftChild());
            int sr = size(node.getRightChild());
            return sl + sr + 1;
        }
        return 0;
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(BinaryNode<T> node) {
        if (node != null) {
            int hl = height(node.getLeftChild());
            int hr = height(node.getRightChild());
            return hl > hr ? hl + 1 : hr + 1;
        }
        return 0;
    }

    @Override
    public void preOrderTraverse() {
        //先序遍历
        System.out.println("前序遍历：");
        preOrderTraverse(root);
        System.out.println();
    }

    private void preOrderTraverse(BinaryNode<T> node) {
        if (node != null) {
            System.out.print(node.getData() + "  ");
            preOrderTraverse(node.getLeftChild());
            preOrderTraverse(node.getRightChild());
        }
    }

    @Override
    public void inorderTraverse() {
        //中序遍历
        System.out.println("中序遍历");
        inorderTraverse(root);
        System.out.println();
    }

    private void inorderTraverse(BinaryNode<T> node) {
        //中序遍历
        if (node != null) {
            //遍历左子树
            inorderTraverse(node.getLeftChild());
            //输出根的值
            System.out.print(node.getData() + "  ");
            //遍历右子树
            inorderTraverse(node.getRightChild());
        }
    }

    @Override
    public void postOrderTraverse() {
        System.out.println("后序遍历：");
        postOrderTraverse(root);
        System.out.println();
    }

    private void postOrderTraverse(BinaryNode<T> node) {
        //后序遍历
        if (node != null) {
            //遍历左子树
            postOrderTraverse(node.getLeftChild());
            //遍历右子树
            postOrderTraverse(node.getRightChild());
            //输出根的值
            System.out.print(node.getData() + "  ");
        }
    }

    public void inOrderByStack() {
        System.out.println("中序栈遍历");
        //中序栈遍历
        Stack<BinaryNode> stack = new Stack<>();
        BinaryNode<T> current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeftChild();
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                System.out.print(current.getData() + "  ");
                current = current.getRightChild();
            }
        }
        System.out.println();
    }

    @Override
    public void levelOrder() {
        System.out.println("层级遍历：");
        Queue<BinaryNode<T>> queue=new LinkedList<>();
        BinaryNode<T> p=root;
        while(p!=null){
            System.out.print(p.getData()+"  ");
            if(p.getLeftChild()!=null) queue.add(p.getLeftChild());
            if(p.getRightChild()!=null) queue.add(p.getRightChild());
            p=queue.poll();
        }
        System.out.println();
    }

    @Override
    public BinaryNode<T> insert(T x) {
        return root = new BinaryNode<T>(x, root, null);
    }

    @Override
    public BinaryNode<T> insert(BinaryNode<T> parent, T x, boolean leftChild) {
        if (x == null) return null;
        if (leftChild) {
            parent.setLeftChild(new BinaryNode<>(x, parent.getLeftChild(), null));
            return parent.getLeftChild();
        }
        parent.setRightChild(new BinaryNode<>(x, null, parent.getRightChild()));
        return parent.getRightChild();
    }

    @Override
    public void remove(BinaryNode<T> parent, boolean leftChild) {
        if(leftChild) {
            parent.setLeftChild(null);
        }
        else parent.setRightChild(null);
    }

    @Override
    public void clear() {
        root=null;
    }

    @Override
    public BinaryNode<T> search(T key) {
        return search(key,root);
    }

    private BinaryNode<T> search(T key,BinaryNode node){
        BinaryNode<T> temp=null;
        if(node!=null) {
            if(node.getData().equals(key)) return node;
            if (node.getLeftChild() != null)
                temp = search(key,node.getLeftChild());
            if (node.getRightChild() != null&&temp==null)
                temp = search(key,node.getRightChild());
        }
        return temp;
    }

    @Override
    public int level(T key) {
        return level(key,root);
    }

    private int level(T key,BinaryNode node){
        return height()-new LinkedBinaryTree<>(search(key)).height();
    }

    public void printLeaf(){
        //先序遍历
        System.out.println("前序遍历叶子节点：");
        printLeaf(root);
        System.out.println();
    }

    private void printLeaf(BinaryNode<T> node) {
        if (node != null) {
            if(node.isLeaf()){
                System.out.print(node.getData() + "  ");
            }
            printLeaf(node.getLeftChild());
            printLeaf(node.getRightChild());
        }
    }

    public int leafSize() {
        return leafSize(root);
    }

    private int leafSize(BinaryNode<T> node){
        if (node != null) {
            int sl = leafSize(node.getLeftChild());
            int sr = leafSize(node.getRightChild());
            if(node.isLeaf()) return sl + sr + 1;
            else return sl+sr;
        }
        return 0;
    }

    public void changeLeftChildAndRightChild(){
        //先序遍历
        changeLeftChildAndRightChild(root);
        System.out.println();
    }
    private void changeLeftChildAndRightChild(BinaryNode<T> node){
        BinaryNode temp;
        if (node != null) {
            if(node.getLeftChild()!=null&&node.getRightChild()!=null){
                temp=node.getLeftChild();
                node.setLeftChild(node.getRightChild());
                node.setRightChild(temp);
            }
            if(node.getLeftChild()==null&&node.getRightChild()!=null){
                node.setLeftChild(node.getRightChild());
                node.setRightChild(null);
            }
            if(node.getLeftChild()!=null&&node.getRightChild()==null){
                node.setRightChild(node.getLeftChild());
                node.setLeftChild(null);
            }
            changeLeftChildAndRightChild(node.getLeftChild());
            changeLeftChildAndRightChild(node.getRightChild());
        }
    }

    public boolean isCompleteBinaryTree(){
        return ((int)(Math.pow(2,height())-1))==size();
    }
}
