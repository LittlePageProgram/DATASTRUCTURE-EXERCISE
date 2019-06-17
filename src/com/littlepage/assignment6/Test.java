package com.littlepage.assignment6;


public class Test{
    public static void main(String[] args) {
        LinkedBinaryTree linkedBinaryTree = new LinkedBinaryTree();

        //中序遍历栈，层次遍历队列
        BinaryNode<Integer> node7 = new BinaryNode<>(7, null, null);
        BinaryNode<Integer> node6 = new BinaryNode<>(6, null, node7);
        BinaryNode<Integer> node5 = new BinaryNode<>(5, null, null);
        BinaryNode<Integer> node4 = new BinaryNode<>(4, null, node5);
        BinaryNode<Integer> node3 = new BinaryNode<>(3, null, null);
        BinaryNode<Integer> node2 = new BinaryNode<>(2, node3, node6);
        BinaryNode<Integer> node1 = new BinaryNode<>(1, node4, node2);

        linkedBinaryTree.setRoot(node1);
        System.out.println(linkedBinaryTree.isEmpty());

        linkedBinaryTree.preOrderTraverse();

        linkedBinaryTree.inorderTraverse();

        linkedBinaryTree.postOrderTraverse();

        System.out.println("高度");
        System.out.println(linkedBinaryTree.height());
        System.out.println("大小");
        System.out.println(linkedBinaryTree.size());

        linkedBinaryTree.inOrderByStack();

        BinaryNode bn=linkedBinaryTree.search(4);
        System.out.println(bn.getData());

        System.out.println("level："+linkedBinaryTree.level(5));

        linkedBinaryTree.levelOrder();

        linkedBinaryTree.printLeaf();
    }


}
