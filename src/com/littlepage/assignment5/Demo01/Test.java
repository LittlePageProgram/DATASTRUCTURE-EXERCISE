package com.littlepage.assignment5.Demo01;

public class Test {
    public static void main(String[] args) {
        Matrix ma=new Matrix(new int[][]{{1,2,3},{0,5,6},{0,0,6}});
        System.out.println(ma);
        System.out.println(ma.isUpperTriangularMatrix());
        System.out.println();
        ma.transpose();
        System.out.println(ma);
        System.out.println(ma.isLowerTriangularMatrix());
        System.out.println();

        System.out.println("判断对称");
        System.out.println(ma.isSymmetricMatrix());
        Matrix ma2=new Matrix(new int[][]{{1,2,3},{2,2,3},{3,3,3}});
        System.out.println(ma2.isSymmetricMatrix());

        System.out.println();
        System.out.println("判断相等");
        System.out.println(ma.equals(ma2));
        Matrix ma3=new Matrix(new int[][]{{1,2,3},{2,2,3},{3,3,3}});
        Object o=(Object)ma3;
        System.out.println(ma2.equals(ma3));

        System.out.println();
        System.out.println("计算乘法");
        System.out.println(new Matrix(new int[][]{{1,2,3},{4,5,6}}).mutiply(new Matrix(new int[][]{{1,2},{3,4},{5,6}})));
    }
}
