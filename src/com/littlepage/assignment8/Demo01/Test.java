package com.littlepage.assignment8.Demo01;

public class Test {
    public static void main(String[] args) {
        MatrixGraph mg=new MatrixGraph(5);
        mg.insertEdge(1,2,2);
        mg.removeVertex(4);
        System.out.println(mg.toString());

    }
}
