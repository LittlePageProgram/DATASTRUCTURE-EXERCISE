package com.littlepage.assignment1.test3;
public class Test3 {
	public static void main(String[] args) {
		System.out.println("Team 6:");
		System.out.println("Çó¹²éî£º");
		ComplexNum cn1=new ComplexNum(0, 0);
		ComplexNum cn2=new ComplexNum(4, 0);
		ComplexNum cn3=new ComplexNum(3, 1.5);
		ComplexNum cn4=new ComplexNum(-4, 3.4);
		ComplexNum cn5=new ComplexNum(-5.4, 1.2);
		System.out.println(cn1.conjugateNum());
		System.out.println(cn2.conjugateNum());
		System.out.println(cn3.conjugateNum());
		System.out.println(cn4.conjugateNum());
		System.out.println(cn5.conjugateNum());
	}
}
