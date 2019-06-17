package com.littlepage.assignment5.Demo03;

import java.util.Objects;

public class Data {
    //member variable
    private int row;
    private int column;
    private int data;

    //constructor
    public Data(){}

    public Data(int row, int column, int data) {
        this.row = row;
        this.column = column;
        this.data = data;
    }

    //getters and setters
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    //equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data1 = (Data) o;
        return row == data1.row &&
                column == data1.column &&
                data == data1.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, data);
    }

    //toString method
    @Override
    public String toString() {
        return "Data{" +
                "row=" + row +
                ", column=" + column +
                ", data=" + data +
                '}';
    }
}
