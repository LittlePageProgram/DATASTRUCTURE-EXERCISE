package com.littlepage.assignment5.Demo03;

public class Test {
    public static void main(String[] args) {
        LinkedMatrix lm=new LinkedMatrix(5,5);
        lm.add(new Data(2,3,5));
        System.out.println(lm);
        lm.transposition();
        System.out.println(lm);
        LinkedMatrix lm2=new LinkedMatrix(5,5);
        lm2.add(new Data(1,1,2));
        lm2.add(new Data(3,2,5));
        lm.plus(lm2);
        System.out.println(lm);
    }
}
