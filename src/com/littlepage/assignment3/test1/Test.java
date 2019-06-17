package com.littlepage.assignment3.test1;

public class Test {
	public static void main(String[] args) {
		System.out.println(toBinary(4));
	}
	/**
	 * the method is from decimal to Binary
	 * @param decimal
	 * @return the to Binary String
	 */
	public static String toBinary(int decimal){
		SeqStack<Integer> numStack=new SeqStack<Integer>();
		while(decimal!=0){
			numStack.push(decimal%2);
			decimal/=2;
		}
		String returnNum="";
		while(!numStack.isEmpty()){
			returnNum+=numStack.pop();
		}
		return returnNum;
	}
}
