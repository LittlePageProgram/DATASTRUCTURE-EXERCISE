package com.littlepage.assignment8.Demo02;

import java.util.ArrayList;

public class Graph {
    private ArrayList<ArrayList<Triple>> data;

    public Graph() {
        data =new ArrayList<>();
    }

    public void insertVertex(){
        data.add(new ArrayList<>());
    }

    public  void insertVertex(int index){
        data.add(index,new ArrayList<>());
    }

    public void removeVertex(int index){
        data.remove(index);
    }


    public void addEdge(int vertex,int vertex2,int path){
        if(vertex>data.size()||vertex2>data.size()) throw new RuntimeException("VertexOutOfBoundsException");
        if(findTriple(vertex,vertex2)==null) {
            data.get(vertex).add(new Triple(vertex, vertex2, path));
            data.get(vertex2).add(new Triple(vertex2, vertex, path));
        }else{
            Triple triple=findTriple(vertex,vertex2);
            triple.setPath(path);
            Triple triple1=findTriple(vertex2,vertex);
            triple1.setPath(path);
        }
    }

    public void removeEdge(int vertex,int vertex2){
        ArrayList<Triple> arr= data.get(vertex);
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).getVertex2()==vertex2) arr.remove(i);
        }
        arr=data.get(vertex2);
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).getVertex()==vertex2) arr.remove(i);
        }
    }

    private Triple findTriple(int vertex,int vertex2){
        ArrayList<Triple> arr= data.get(vertex);
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).getVertex2()==vertex2) return arr.get(i);
        }
        return null;
    }

    public void depthFirstTraversal(){
        ArrayList<Triple> alreadyExist=new ArrayList<>();
        addDepthFirstTraversal(data.get(0).get(0).getVertex(),alreadyExist);
        for (Triple tri:alreadyExist) {
            System.out.println(tri);
        }
    }

    //使用一个vertex进行递归，返回一个ArrayList即可
    private  ArrayList<Triple> addDepthFirstTraversal(int vertex,ArrayList<Triple> arr){
        boolean flag=false;
        for (Triple triple:data.get(vertex)) {
            flag=false;
            for (Triple temp:arr) {
                if(temp.equals(triple)) flag=true;
            }
            if (flag==false) {
                arr.add(triple);
                addDepthFirstTraversal(triple.getVertex2(),arr);
            }else{
                return arr;
            }
        }
        return arr;
    }

    public void borderFirstTraversal(){
        boolean flag=false;
        ArrayList<Triple> alreadyExist=new ArrayList<>();
        for (ArrayList<Triple> arrTri:data) {
            for (Triple tri:arrTri) {
                flag=false;
                for (Triple addedTri:alreadyExist) {
                    if(addedTri.equals(tri)) flag=true;
                }
                if(flag==false) alreadyExist.add(tri);
            }
        }

        for (Triple triple:alreadyExist) {
            System.out.println(triple);
        }
    }
    @Override
    public String toString() {
        return "Graph{" +
                "data=" + data +
                '}';
    }


}
