package com.littlepage.assignment3.test2;

import com.littlepage.assignment3.test1.SeqStack;

public class Test {
	public static void main(String[] args) {
		System.out.println(isPalindromicString("abccba"));
		System.out.println(isPalindromicString("pap"));
		System.out.println(isPalindromicString("pool"));
		System.out.println(isPalindromicString("poioo"));
	}
	/**
	 * judge the string is or not a palindromic string
	 * @param str
	 * @return true if is palindromic string
	 */
	public static boolean isPalindromicString(String str){
		char[] strArr=str.toCharArray();
		SeqStack<Character> charStack=new SeqStack<>();
		for(int i=0;i<strArr.length/2;i++){
			charStack.push(strArr[i]);
		}
		if(strArr.length%2==0){
			for(int i=strArr.length/2;i<strArr.length;i++){
				if(strArr[i]!=charStack.pop()) return false;
			}
		}else{
			for(int i=strArr.length/2+1;i<strArr.length;i++){
				if(strArr[i]!=charStack.pop()) return false;
			}
		}
		return true;
	}
}
