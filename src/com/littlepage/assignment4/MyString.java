package com.littlepage.assignment4;

import java.util.Arrays;

public class MyString implements Comparable{
    //member variable
    private final char[] value;

    //constructors
    public MyString(){
        value="".toCharArray();
    }

    public  MyString(String value){
        this.value=value.toCharArray();
    }

    public MyString(char[] value){
        this.value=value;
    }

    //to String method
    @Override
    public String toString() {
        return Arrays.toString(value);
    }

    /**
     * remove all the blank space from MyString
     * @return the removed blank space MyString
     */
    public MyString trim(){
        int len=0,point=0;
        for(int i=0;i<value.length;i++){
            if(value[i]!=' ') len++;
        }
        char[] newValue=new char[len];
        for(int i=0;i<value.length;i++){
            if(value[i]!=' ') {
                newValue[point]=value[i];
                point++;
            }
        }
        return new MyString(newValue);
    }

    /**
     * transfer the MyString to char array
     * @return the transferred char array
     */
    public char[] toCharArray(){
        return value;
    }

    /**
     * transfer the uppercase from MyString to lowercase
     * @return the new transferred MyString
     */
    public MyString toLowerCase(){
        char[] newValue=new char[value.length];
        for(int i=0;i<value.length;i++){
            if (value[i]>='A'&&value[i]<='Z'){
                newValue[i]=(char)(value[i]+32);
            }
            else newValue[i]=value[i];
        }
        return new MyString(newValue);
    }

    /**
     * transfer the lowercase from MyString to uppercase
     * @return the new transferred MyString
     */
    public MyString toUpperCase(){
        char[] newValue=new char[value.length];
        for(int i=0;i<value.length;i++){
            if (value[i]>='a'&&value[i]<='z'){
                newValue[i]= (char) (value[i]-32);
            }else newValue[i]=value[i];
        }
        return new MyString(newValue);
    }

    /**
     * use old char replace the new char from MyString
     * @return the replaced MyString
     */
    public MyString replace(char old, char newc){
        for(int i=0;i<value.length;i++){
            if (value[i]==old){
                value[i]=newc;
            }
        }
        return this;
    }

    /**
     * judge the obj is equals to the original MyString
     * @param obj
     * @return return true if equals, others return false
     */
    public boolean equals(Object obj){
        MyString judgeMyString=(MyString)obj;
        for(int i=0;i<value.length;i++){
            if(judgeMyString.toCharArray()[i]!=value[i]) return false;
        }
        return true;
    }


    /**
     * judge the MyString is equals to the original MyString ignore case
     * @param str
     * @return return true if equals, others return false
     */
    public Boolean equalsIgnoreCase(MyString str){
        return this.toUpperCase().equals(str.toUpperCase());
    }

    /**
     * compare the MyString and the object
     * @param o
     * @return positive if MyString larger than the object, negative if MyString smaller than the object
     */
    @Override
    public int compareTo(Object o) {
        int compare=0;
        MyString newMyString=(MyString)o;
        if(newMyString.toCharArray().length!=value.length) return value.length-newMyString.toCharArray().length;
        for(int i=0;i<value.length;i++){
            compare+=(value[i]-newMyString.toCharArray()[i]);
        }
        return compare;
    }

    /**
     * compare the MyString and the str ignore case
     * @param str
     * @return positive if MyString larger than the str, negative if MyString smaller than the str
     */
    public int compareToIgnoreCase(MyString str){
        return this.toUpperCase().compareTo(str.toUpperCase());
    }

    /**
     * judge the MyString is starts with prefix
     * @param prefix
     * @return true if starts with, and false if not
     */
    public boolean startsWith(MyString prefix){
        if(prefix.toCharArray().length>value.length) return false;
        for(int i=0;i<prefix.toCharArray().length;i++){
            if(prefix.toCharArray()[i]!=value[i]) return false;
        }
        return true;
    }

    /**
     * judge the MyString is ends with prefix
     * @param suffix
     * @return true if ends with, and false if not
     */
    public boolean endsWith(MyString suffix){
        if(suffix.toCharArray().length>value.length) return false;
        for(int i=suffix.toCharArray().length-1,j=value.length-1;i>=0;i--,j--){
            if(suffix.toCharArray()[i]!=value[j]) return false;
        }
        return true;
    }

    /**
     * the size of the MyString
     * @return number is the size of the MyString
     */
    public int size(){
        return value.length;
    }

    /**
     * return the char of index
     * @return the char of index
     */
    public char charAt(int index){
        return value[index];
    }

    /**
     * set the index of the char
     * @return true if set success
     */
    public boolean setChar(int index,char charr){
        if(index<0||index>size()) return false;
        value[index]=charr;
        return true;
    }

    public boolean contains(char c){
        for(int i=0;i<size();i++){
            if(c==value[i]) return true;
        }
        return false;
    }
}
