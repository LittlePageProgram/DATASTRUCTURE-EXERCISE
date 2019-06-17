package com.littlepage.assignment4;

public class FindCommon {
    public static void main(String[] args) {
        findCommon(new MyString("Hello my name is 55"),new MyString("this is Steve"));
    }
    public static void findCommon(MyString myString1,MyString myString2){
        int[] count1=new int[128];
        int[] count2=new int[128];
        for(int i=0;i<myString1.size();i++){
            if(myString1.charAt(i)>128||myString1.charAt(i)<0) continue;
            count1[myString1.charAt(i)]++;
        }
        for(int i=0;i<myString2.size();i++){
            if(myString2.charAt(i)>128||myString2.charAt(i)<0) continue;
            count2[myString2.charAt(i)]++;
        }
        for(int i=0;i<128;i++){
            if(count1[i]!=0&&count2[i]!=0) System.out.print((char)(i));
        }
    }
}
