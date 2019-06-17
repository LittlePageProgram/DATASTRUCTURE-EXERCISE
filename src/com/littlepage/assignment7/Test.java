package com.littlepage.assignment7;


import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        test2();
    }

    /**
     * 测试构造，打印方法已经注释
     * test build
     */
    public static HuffmanTree<Character> test1() {
        ArrayList<Node<Character>> arrCoding=new ArrayList<>();
        arrCoding.add(new Node<>(' ',186));
        arrCoding.add(new Node<>('a',64));
        arrCoding.add(new Node<>('b',13));
        arrCoding.add(new Node<>('c',22));
        arrCoding.add(new Node<>('d',32));
        arrCoding.add(new Node<>('e',103));
        arrCoding.add(new Node<>('f',21));
        arrCoding.add(new Node<>('g',15));
        arrCoding.add(new Node<>('h',47));
        arrCoding.add(new Node<>('i',57));
        arrCoding.add(new Node<>('j',1));
        arrCoding.add(new Node<>('k',5));
        arrCoding.add(new Node<>('l',32));
        arrCoding.add(new Node<>('m',20));
        arrCoding.add(new Node<>('n',57));
        arrCoding.add(new Node<>('o',63));
        arrCoding.add(new Node<>('p',15));
        arrCoding.add(new Node<>('q',1));
        arrCoding.add(new Node<>('r',48));
        arrCoding.add(new Node<>('s',51));
        arrCoding.add(new Node<>('t',80));
        arrCoding.add(new Node<>('u',20));
        arrCoding.add(new Node<>('v',8));
        arrCoding.add(new Node<>('w',18));
        arrCoding.add(new Node<>('x',1));
        arrCoding.add(new Node<>('y',16));
        arrCoding.add(new Node<>('z',1));
        HuffmanTree<Character> huffmanCoding=new HuffmanTree<>();
        huffmanCoding.build(arrCoding);
        System.out.println(huffmanCoding);

        System.out.println(huffmanCoding);
        return huffmanCoding;
    }

    /**
     * 测试编码，打印
     * test encoding
     */
    public static String test2() {
        HuffmanTree<Character> huffmanTree=test1();
        char[] ch="j".toCharArray();
        ArrayList<Character> arrChar=new ArrayList<>();
        for(int i=0;i<ch.length;i++){
            arrChar.add(ch[i]);
        }
        String s=huffmanTree.encoding(arrChar);
        System.out.println(s);
        return s;
    }

    /**
     * 测试译码
     * @param s
     * @param huffmanTree
     * 打印译码的结果
     */
    public static void test3(String s,HuffmanTree<Character> huffmanTree){
        char[] ch=s.toCharArray();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<ch.length;i++){
            arr.add(Integer.parseInt(ch[i]+""));
        }
        String unCoding=huffmanTree.unEncoding(arr);
        System.out.println(unCoding);
    }

}
