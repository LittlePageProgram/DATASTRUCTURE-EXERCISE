package com.littlepage.assignment6;

public class HomeWorkTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        LinkedBinaryTree<Integer> linkedBinaryTree = new LinkedBinaryTree();

        BinaryNode<Integer> node7 = new BinaryNode<>(7, null, null);
        BinaryNode<Integer> node6 = new BinaryNode<>(6, null, node7);
        BinaryNode<Integer> node5 = new BinaryNode<>(5, null, null);
        BinaryNode<Integer> node4 = new BinaryNode<>(4, null, node5);
        BinaryNode<Integer> node3 = new BinaryNode<>(3, null, null);
        BinaryNode<Integer> node2 = new BinaryNode<>(2, node3, node6);
        BinaryNode<Integer> node1 = new BinaryNode<>(1, node4, node2);

        linkedBinaryTree.setRoot(node1);

        linkedBinaryTree.preOrderTraverse();

        linkedBinaryTree.printLeaf();

        System.out.println("叶子节点个数:");
        System.out.println(linkedBinaryTree.leafSize());


        System.out.println("执行交换左右子树");
        linkedBinaryTree.changeLeftChildAndRightChild();
        linkedBinaryTree.preOrderTraverse();
        System.out.println("执行交换左右子树");
        linkedBinaryTree.changeLeftChildAndRightChild();
        linkedBinaryTree.preOrderTraverse();

        System.out.println("node7的层次");
        System.out.println(linkedBinaryTree.level(node7.getData()));

        System.out.println("深克隆树：");
        LinkedBinaryTree<Integer> copy= linkedBinaryTree.clone();
        copy.preOrderTraverse();

        System.out.println("判断是否为完全二叉树：");
        System.out.println(linkedBinaryTree.isCompleteBinaryTree());
    }
}
