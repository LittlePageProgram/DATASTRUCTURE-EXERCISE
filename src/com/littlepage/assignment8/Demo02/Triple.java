package com.littlepage.assignment8.Demo02;

import java.util.Objects;

public class Triple{
    private int vertex;
    private int vertex2;
    private int path;

    public Triple() {
    }

    public Triple(int vertex, int vertex2, int path) {
        this.vertex = vertex;
        this.vertex2 = vertex2;
        this.path = path;
    }

    public int getVertex() {
        return vertex;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    public int getVertex2() {
        return vertex2;
    }

    public void setVertex2(int vertex2) {
        this.vertex2 = vertex2;
    }

    public int getPath() {
        return path;
    }

    public void setPath(int path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Triple{" +
                "vertex=" + vertex +
                ", vertex2=" + vertex2 +
                ", path=" + path +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(o.getClass()!=getClass()){
            return false;
        }
        Triple tri=(Triple)o;
        if(tri.getVertex()==vertex&&tri.getVertex2()==vertex2&&tri.getPath()==getPath()){
            return true;
        }
        if(tri.getVertex()==vertex2&&tri.getVertex()==vertex2&&tri.getPath()==getPath()){
            return true;
        }
        return false;
    }

}
