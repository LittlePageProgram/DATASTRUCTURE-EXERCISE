package com.littlepage.assignment5.Demo02;

public class Test {
    public static void main(String[] args) {
        LinkedMatrix lm=new LinkedMatrix(5,5);
        lm.add(new Data(0,1,5));
        lm.add(new Data(3,4,2));
        System.out.println(lm);

        LinkedMatrix lm2=new LinkedMatrix(5,5);
        lm2.add(new Data(3,4,2));
        lm2.add(new Data(0,1,5));

        System.out.println(lm.equals(lm2));


        LinkedMatrix lm3=new LinkedMatrix(5,5);
        lm3.add(new Data(3,4,2));
        lm3.add(new Data(0,1,5));
        System.out.println(lm3.isSymmetricMatrix());
        lm3.add(new Data(4,3,2));
        lm3.add(new Data(1,0,5));
        System.out.println(lm3.isSymmetricMatrix());
    }
}
