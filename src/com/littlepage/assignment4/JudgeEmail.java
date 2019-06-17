package com.littlepage.assignment4;

public class JudgeEmail {
    public static void main(String[] args) {
        System.out.println(judgeEmail(new MyString("2233@qq.com")));;
        System.out.println(judgeEmail(new MyString("zid444@outlook.com")));
        System.out.println(judgeEmail(new MyString("baidu.com")));
    }

    public static boolean judgeEmail(MyString myString){
        char[] charArray=myString.toCharArray();
        //以.com结尾
        if(!myString.endsWith(new MyString(".com"))){
            System.out.println("99");
            System.out.println("ss");
            return false;
        }
        if(!myString.contains('@')){
            return false;
        }
        for(int i=0;i<myString.size()-5;i++){
            //判断其他是否字母，数字，@，下划线，点或美元构成
            if(!(myString.charAt(i)=='.'||myString.charAt(i)=='@'||
                     myString.charAt(i)=='_'||myString.charAt(i)=='$'||
                    (myString.charAt(i)>='a'&&myString.charAt(i)<='z')||
                    (myString.charAt(i)>='A'&&myString.charAt(i)<='Z')||
                    (myString.charAt(i)>='0'&&myString.charAt(i)<='9'))){
                    return false;
            }
        }
        return true;
    }
}
