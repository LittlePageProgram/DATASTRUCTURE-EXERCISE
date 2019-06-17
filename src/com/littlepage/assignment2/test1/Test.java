package com.littlepage.assignment2.test1;

public class Test {
	public static void main(String[] args) {
		Integer[] arr1={3,5,8,11};
		SeqList<Integer> seq1=new SeqList<Integer>(arr1);
		Integer[] arr2={2,6,8,9,11,15,20};
		SeqList<Integer> seq2=new SeqList<Integer>(arr2);
		seq1.unionAndSort(seq2);
		System.out.println(seq1);
	}
}
