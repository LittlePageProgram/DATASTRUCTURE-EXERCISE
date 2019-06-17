package com.littlepage.assignment1;

import java.util.Arrays;

/**
 * Êı×éÄæÖÃ
 * @author LittlePage
 *
 */
public class Test4 {
	public static void main(String[] args) {
		int[] a={1,2,3,4,5};
		for(int i=0;i<a.length/2;i++){
			int temp=a[i];
			a[i]=a[a.length-i-1];
			a[a.length-i-1]=temp;
		}
		System.out.println(Arrays.toString(a));
	}
}
