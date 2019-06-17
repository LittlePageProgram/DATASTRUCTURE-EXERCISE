package com.littlepage.assignment7;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * The Huffman tree used the Node<T> for encoding
 * Huffman树只需要一个build方法，于是我get方法，set方法也没写
 * toString方法是用到层级队列遍历（方法上标明了注释）
 * Node方法没有限制权限，但是调用了Comparable接口，可以来进行weight加权的比较
 */
public class HuffmanTree<T> {
    //member variable
    private Node<T> root;

    //constructor
    public HuffmanTree() {
    }

    /**
     * get the root node
     * @return root node
     */
    public Node<T> getRoot() {
        return root;
    }

    /**
     * level traverse by stack
     * @return
     */
    public String toString() {
        StringBuilder res=new StringBuilder();
        Queue<Node<T>> queue=new LinkedList<>();
        Node<T> p=root;
        while(p!=null){
            res.append(p.getData()+"  ");
            if(p.getLeftChild()!=null) queue.add(p.getLeftChild());
            if(p.getRightChild()!=null) queue.add(p.getRightChild());
            p=queue.poll();
        }
        res.append("\n");
        return res.toString();
    }



    private String getCoding(T data){
       return getCoding(data,root);
    }
    private String getCoding(T data, Node<T> node){
        StringBuilder res=new StringBuilder();
        Queue<Node<T>> queue=new LinkedList<>();
        Node<T> p=root;
        while(p!=null){
            if(p.getCoding()!=0) res.append(p.getCoding());
            if(p.getData()==data) {
                if(p.getCoding()==0) res.append(0);
                return res.toString();
            }
            if(p.getLeftChild()!=null) queue.add(p.getLeftChild());
            if(p.getRightChild()!=null) queue.add(p.getRightChild());
            p=queue.poll();
        }
        res.append("\n");
        return null;
    }

    /**
     * use arrNode built tree
     * @param arrNode
     */
    //build ArrayList<Node<T>>
    public void build(ArrayList<Node<T>> arrNode){
        //bubble sort by weight
        for(int i=0;i<arrNode.size()-1;i++){
            for(int j=0;j<arrNode.size()-1;j++){
                if(arrNode.get(j).compareTo(arrNode.get(j+1))>0){
                    Node<T> temp=arrNode.get(j);
                    arrNode.set(j,arrNode.get(j+1));
                    arrNode.set(j+1,temp);
                }
            }
        }
        if(arrNode.size()<2) throw new RuntimeException("NotEnoughHuffmanNodeException");
        //The first two node solution
        Node<T> parent=null;
        while(arrNode.size()!=1){
            Node<T> node1=arrNode.get(0);
            node1.setCoding(1);
            Node<T> node2=arrNode.get(1);
            node2.setCoding(0);
            parent=new Node<>(null,node1.getWeight()+node2.getWeight());
            parent.setLeftChild(node2);
            parent.setRightChild(node1);
            node1.setParent(parent);
            node2.setParent(parent);
            arrNode.remove(1);
            arrNode.set(0,parent);
        }
        parent.setCoding(1);
        root=parent;
    }

    /**
     *get the Node by stack
     */
    public Node<T> getNode(T data) {
        //中序栈遍历
        Stack<Node> stack = new Stack<>();
        Node<T> current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeftChild();
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                if(data.equals(current.getData())) return current;
                current = current.getRightChild();
            }
        }
        return null;
    }

    /**
     * encoding the HuffmanTree
     * @param data data the coding of arr
     * @return the encoded String
     */
    public String encoding(ArrayList<T> data){
        String res="";
        for(int i=0;i<data.size();i++){
            if(getCoding(data.get(i))==null) throw new RuntimeException("输入含有非法字符，只能输入小写字符");
            res+=getCoding(data.get(i));
        }
        return res;
    }

    /**
     *  unEncoding the HuffmanTree
     * @param  arrCoding the coding of arr
     * @return the unencoded String
     */
    public String unEncoding(ArrayList<Integer> arrCoding){
        //cut the coding
        String cutCoding="";
        String res="";
        for(int i=0;i<arrCoding.size();i++){
            cutCoding+=arrCoding.get(i);
            // the length equals height then end
            // or end with '0' character
            if(cutCoding.endsWith("0")||cutCoding.length()==height()){
                //start coding
                //traverse the node by stack
                Stack<Node> stack = new Stack<>();
                Node<T> current = root;
                while (current != null || !stack.isEmpty()) {
                    while (current != null) {
                        stack.push(current);
                        current = current.getLeftChild();
                    }
                    if (!stack.isEmpty()) {
                        current = stack.pop();
                        if(cutCoding.equals((""+getCoding(current.getData())))) {
                            res+=current.getData();
                            cutCoding="";
                            continue;
                        }
                        current = current.getRightChild();
                    }
                }
            }
        }
        return res;
    }

    /**
     * get the height of the HuffmanTree
     * @return
     */
    public int height() {
        return height(root);
    }

    private int height(Node<T> node) {
        if (node != null) {
            int hl = height(node.getLeftChild());
            int hr = height(node.getRightChild());
            return hl > hr ? hl + 1 : hr + 1;
        }
        return 0;
    }
}
