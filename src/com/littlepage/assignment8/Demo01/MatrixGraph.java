package com.littlepage.assignment8.Demo01;


public class MatrixGraph {
    //member variable
    private int[][] data;
    private int vertex;

    //constructor
    private final int DEFAULT_VERTEX=0;

    public MatrixGraph() {
        vertex=DEFAULT_VERTEX;
        data=new int[vertex][vertex];
    }

    public MatrixGraph(int vertex) {
        this.vertex=vertex;
        data=new int[vertex][vertex];
    }

    public void insertEdge(int vertex,int vertex2,int pathLength){
        if(vertex>this.vertex||vertex2>this.vertex) throw new RuntimeException("VertexOutOfBoundsException");
        else{
            data[vertex][vertex2]=pathLength;
            data[vertex2][vertex]=pathLength;
        }
    }

    public void insertVertex(){
        vertex++;
        int[][] newData=new int[vertex][vertex];
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[i].length;j++){
                newData[i][j]=data[i][j];
            }
        }
        data=newData;
    }

    public void removeEdge(int vertex,int vertex2){
        if(vertex>this.vertex||vertex2>this.vertex) throw new RuntimeException("VertexOutOfBoundsException");
        else{
            data[vertex][vertex2]=0;
            data[vertex2][vertex]=0;
        }
    }

    public void removeVertex(int vertex){
        if(vertex>this.vertex) throw new RuntimeException("VertexOutOfBoundsException");
        else{
            this.vertex--;
            int[][] newData=new int[this.vertex][this.vertex];
            for(int i=0;i<vertex;i++){
                for(int j=0;j<vertex;j++){
                    newData[i][j]=data[i][j];
                }
            }
            for(int i=vertex+1;i<this.vertex;i++){
                for(int j=vertex+1;j<this.vertex;j++){
                    newData[i-1][j-1]=data[i][j];
                }
            }
            data=newData;
        }
    }
    @Override
    public String toString() {
        String res="";
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data.length;j++){
                res+=data[i][j]+"\t";
            }
            res+="\n";
        }
        return res;
    }
}
