package com.littlepage.assignment2.test3;

public class Test {
	public static void main(String[] args) {
		PolynomialList pl=new PolynomialList(new PolynomialData[]{new PolynomialData(-1,-1),new PolynomialData(5,1),new PolynomialData(3,2),new PolynomialData(1,4)});
		System.out.println("��һ������ʽ:"+pl);
		PolynomialList pl2=new PolynomialList(new PolynomialData[]{new PolynomialData(1,0),new PolynomialData(3,1),new PolynomialData(-1,3),new PolynomialData(1,4)});
		System.out.println("�ڶ�������ʽ:"+pl2);
		pl.sub(pl2);
		System.out.println("��Ϊ:"+pl);
	}
}
