package com.littlepage.assignment8.Demo02;

        public class Test {
            public static void main(String[] args) {
                Graph graph=new Graph();
                graph.insertVertex();
                graph.insertVertex();
                graph.insertVertex();
                graph.addEdge(1,2,5);
                graph.addEdge(1,0,3);
                //广度
                System.out.println("广度遍历");
                graph.borderFirstTraversal();
                //深度
                System.out.println("深度遍历");
                graph.depthFirstTraversal();
            }
}
