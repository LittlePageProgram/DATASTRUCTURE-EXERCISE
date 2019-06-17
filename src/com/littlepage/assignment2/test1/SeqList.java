package com.littlepage.assignment2.test1;


public class SeqList<T extends Comparable<T>>{
	//member variable
	private Object[] element;
	private int size;
	private int capacity;
	
	//constant variable
	private final int INITIAL_CAPACITY=10;
	
	//constructor
	public SeqList() {
		size=0;
		capacity=INITIAL_CAPACITY;
		element=new Object[capacity];
	}
	
	public SeqList(int length){
		size=length;
		capacity=length*2;
		element=new Object[capacity];
	}
	
	public SeqList(T[] array){
		this();
		for(int i=0;i<array.length;i++){
			insert(array[i]);
		}
	}
	//getters and setters
	public int getSize() {
		return size;
	}

	public int getCapacity() {
		return capacity;
	}

	//toString method
	public String toString() {
		StringBuilder str=new StringBuilder();
		str.append("[");
		for (int i=0;i<size;i++) {
			if(element[i]==null) str.append("null"+",");
			else str.append(element[i].toString()+",");
		}
		str.replace(str.lastIndexOf(","),str.lastIndexOf(",")+1, "]");
		return str.toString();
	}

	//other method
	public boolean isEmpty(){
		return size==0;
	}

	public int insert(int index,T value){
		if(value==null) throw new RuntimeException("x==null");
		if(index<0) index=0;
		if(index>size) index=size;
		//enlarge capacity
		size++;
		if(size==capacity) capacity*=2;
		//copy
		Object[] temp=new Object[capacity];
		for(int j=0;j<index;j++){
			if(element[j]!=null) temp[j]=element[j];
		}
		temp[index]=value;
		for(int j=index+1;j<size;j++){
			if(element[j]!=null) temp[j]=element[j-1];
		}
		element=temp;
		return index;
	}

	public int insert(T value){
		return insert(size,value);
	}

	@SuppressWarnings("unchecked")
	public T remove(int index){
		if(index<0) index=0;
		if(index>=size) index=size-1;
		Object retu=element[index];
		for(int j=index;j<size;j++){
			if(element[j+1]!=null) element[j]=element[j+1];
			else element[j]=null;
		}
		size--;
		return (T)retu;
	}

	public T remove(T value){
		for(int i=0;i<size;i++){
			if(value.equals(element[i])) {
				remove(i);
				return value;
			}
		}
		return null;
	}
	
	public void removeAll(){
		size=0;
		capacity=INITIAL_CAPACITY;
	}
	public void set(int index,T value){
		if(index>=size) index=size-1;
		if(index<0) index=0;
		element[index]=value;
	}

	@SuppressWarnings("unchecked")
	public T get(int index){
		return (T)element[index];
	}
	
	//remove repeat element
	public void union(SeqList<T> seq){
		boolean repeat=false;
		for(int i=0;i<seq.size;i++){
			for(int j=0;j<size;j++){
				if(element[j].equals(seq.get(i))) repeat=true;
			}
			if(repeat){
				repeat=false;
				continue;
			}
			insert(seq.get(i));
		}
	}
	
	//not remove repeat element
	@SuppressWarnings("unchecked")
	public void unionAndSort(SeqList<T> seq){
		Object[] obj=new Object[size+seq.getSize()];
		int point1=0,point2=0;//point1 represents this class's point and point2 represents seq's point.
		for(int i=0;i<obj.length;i++){
			if(get(point1)==null){
				obj[i]=seq.get(point2);
				point2++;
				continue;
			}
			if(seq.get(point2)==null){
				obj[i]=seq.get(point1);
				point1++;
				continue;
			}
			if(get(point1).compareTo(seq.get(point2))<0) {
				obj[i]=get(point1);
				point1++;
			}
			else {
				obj[i]=seq.get(point2);
				point2++;
			}
		}
		removeAll();
		for(int i=0;i<obj.length;i++) insert((T)obj[i]);
	}

	/**
	 * find the last index of value
	 * @param value
	 * @return the last index of value
	 */
	public int lastIndexOf(T value){
		int index=-1;
		for(int i=0;i<size;i++){
			if(element[i].equals(value)){
				index=i;
			}
		}
		return index;
	}





}
