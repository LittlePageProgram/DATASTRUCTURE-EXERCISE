package com.littlepage.assignment4;

public class CountNumber {
    public static void main(String[] args) {
        countNumber(new MyString("Good morning!"));
        countNumber(new MyString("Shanghai 2010"));
    }
    public static void countNumber(MyString myString){
        int[] count=new int[128];
        for(int i=0;i<myString.size();i++){
            if(myString.charAt(i)>128||myString.charAt(i)<0) continue;
            count[myString.charAt(i)]++;
        }
        System.out.println("count result:");
        for(int i=0;i<128;i++){
            if(count[i]!=0) System.out.print("['"+(char)(i)+"' : "+count[i]+"] ");
        }
        System.out.println();
    }
}
