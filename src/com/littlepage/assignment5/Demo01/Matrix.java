package com.littlepage.assignment5.Demo01;

import java.util.Arrays;

public class Matrix {
    //member variable
     private int[][] data;

    //constructor
    public Matrix(int row ,int column){
        data=new int[column][row];
    }

    public Matrix(int[][] data) {
        this.data = data;
    }

    //toString method
    @Override
    public String toString() {
        StringBuilder ret=new StringBuilder();
        for(int i=0;i<data.length;i++) {
            for (int j = 0; j < data[i].length; j++) {
                ret.append(data[i][j]+"\t");
            }
            ret.replace(ret.lastIndexOf("\t"),ret.lastIndexOf("\t")+1,"\n");
        }
        return ret.toString();
    }

    /**
     * transpose the matrix
     * change the row and column's index
     * @return true if transpose success and false if not
     */
    public boolean transpose(){
        if(data==null) return false;
        int temp;
        for(int i=1;i<data.length;i++){
            for(int j=0;j<i;j++){
                temp=data[i][j];
                data[i][j]=data[j][i];
                data[j][i]=temp;
            }
        }
        return true;
    }

    /**
     * judge the matrix is or not upper triangular matrix
     * @return true if is upper triangular matrix and false if not
     */
    public boolean isUpperTriangularMatrix(){
        if(data==null) return false;
        if(data.length!=data[0].length) return false;
        for(int i=1;i<data.length;i++){
            for(int j=0;j<i;j++){
                if(data[i][j]!=0) return false;
            }
        }
        return true;
    }

    /**
     * judge the matrix is or not lower triangular matrix
     * @return true if is lower triangular matrix and false if not
     */
    public boolean isLowerTriangularMatrix(){
        if(data==null) return false;
        if(data.length!=data[0].length) return false;
        transpose();
        for(int i=1;i<data.length;i++){
            for(int j=0;j<i;j++){
                if(data[i][j]!=0) return false;
            }
        }
        return true;
    }

    /**
     * judge the matrix is or not symmetric
     * @return true if is symmetric and false if not
     */
    public boolean isSymmetricMatrix(){
        for(int i=1;i<data.length;i++){
            for(int j=0;j<i;j++){
                if(data[i][j]!=data[j][i]) return false;
            }
        }
        return true;
    }

    /**
     * judge the two Matrix is or not equals
     * @param o
     * @return true if equals and false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        for(int i=0;i<matrix.data.length;i++){
            for(int j=0;j<matrix.data[0].length;j++){
                if(matrix.data[i][j]!=data[i][j]) return false;
            }
        }
        return true;
    }

    /**
     * Compute the matrix hashcode
     * @return the data's hashcode
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }

    /**
     * Compute two matrix product
     * @param matrix
     * @return the matrix of two matrix product
     */
    public Matrix mutiply(Matrix matrix){
        if(data==null||matrix==null) return null;
        if(data[0].length!=matrix.data.length) return null;
        int[][] result=new int[data.length][matrix.data[0].length];
        for(int i=0;i<data.length;i++){
            for(int j=0;j<matrix.data[0].length;j++){
                for(int k=0;k<matrix.data.length;k++){
                    result[i][j]+=data[i][k]*matrix.data[k][j];
                }
            }
        }
        return new Matrix(result);
    }
}
