package com.littlepage.assignment3.test1;

import java.util.EmptyStackException;

public class SeqStack<E> {
	//member variable
	private Object[] element;
	private int size;
	private int capacity;
	
	//constant variable;
	private int INITIALCAPACITY=10;
	private int INITTIALSIZE=0;
	
	//constructor
	public SeqStack() {
		capacity=INITIALCAPACITY;
		size=INITTIALSIZE;
		element=new Object[capacity];
	}
	
	//getters and setters
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	//other method
	public void push(Object obj){
		element[size]=obj;
		size++;
		//enlarge capacity
		if(size==capacity-1) capacity*=2;
		Object[] newElement=new Object[capacity];
		//copy element
		for(int i=0;i<size;i++){
			newElement[i]=element[i];
		}
		element=newElement;
	}
	
	@SuppressWarnings("unchecked")
	public E pop(){
		if(size==0) throw new EmptyStackException();
		size--;
		return (E)element[size];
	}
	
	public boolean isEmpty(){
		return size==0;
	}
}
