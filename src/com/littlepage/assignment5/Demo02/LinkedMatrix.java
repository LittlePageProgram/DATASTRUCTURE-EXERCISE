package com.littlepage.assignment5.Demo02;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedMatrix  {
    //member variable
    private LinkedList<Data> matrix=new LinkedList<>();
    private int row;
    private int column;

    //constructor
    public LinkedMatrix(){}

    public LinkedMatrix(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * add the Data
     * @param data
     * @return
     */
    public boolean add(Data data){
        if(data.getRow()>=row||data.getColumn()>=column) return false;
        Iterator<Data> it=matrix.iterator();
        while(it.hasNext()){
            Data temp=it.next();
            if(temp.getRow()==data.getRow()&&temp.getColumn()==data.getColumn()){
                temp.setData(data.getData());
                return true;
            }
        }
        matrix.add(data);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        LinkedMatrix lm = (LinkedMatrix) o;
        if(row!=lm.row||column!=lm.column) return false;
        Iterator<Data> it1=matrix.iterator();
        while(it1.hasNext()){
            boolean flag=false;
            Data temp1=it1.next();
            Iterator<Data> it2=lm.matrix.iterator();
            while(it2.hasNext()){
                Data temp2=it2.next();
                if(temp1.equals(temp2)) {
                    flag=true;
                    break;
                }
            }
            if(flag==false) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        int[][] result=new int[row][column];
        Iterator<Data> it=matrix.iterator();
        while(it.hasNext()){
            Data temp=it.next();
            result[temp.getRow()][temp.getColumn()]=temp.getData();
        }
        return Arrays.deepToString(result);
    }

    public boolean isSymmetricMatrix(){
        Iterator<Data> it1=matrix.iterator();
        while(it1.hasNext()){
            boolean flag=false;
            Data temp=it1.next();
            Iterator<Data> it2=matrix.iterator();
            while(it2.hasNext()){
                Data temp2=it2.next();
                if(temp.getRow()==temp2.getColumn()
                        &&temp.getColumn()==temp2.getRow()
                        &&temp.getData()==temp2.getData())
                    flag=true;
            }
            if(flag==false) return false;
        }
        return true;
    }
}
