package com.littlepage.assignment8.Demo02;

        public class Test {
            public static void main(String[] args) {
                Graph graph=new Graph();
                graph.insertVertex();
                graph.insertVertex();
                graph.insertVertex();
                graph.addEdge(1,2,5);
                graph.addEdge(1,0,3);
                //���
                System.out.println("��ȱ���");
                graph.borderFirstTraversal();
                //���
                System.out.println("��ȱ���");
                graph.depthFirstTraversal();
            }
}
