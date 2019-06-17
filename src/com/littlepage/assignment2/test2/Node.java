package com.littlepage.assignment2.test2;

public class Node<T> {
	//member variable
	private T data;
	private Node<T> next;
	
	//constructor
	public Node() {
		data=null;
		next=null;
	}
	
	public Node(T t) {
		data=t;
	}

	//getters and setters
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	//toString
	@Override
	public String toString() {
		return data.toString();
	}

	//equals
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		Node<T> temp1=this;
		Node<T> node=(Node<T>)obj;
		if(!data.equals(node.getData())) return false;
		else if(next==null&&node.getNext()!=null) return false;
		else if(next!=null&&node.getNext()==null) return false;
		else if(next==null&&node.getNext()==null) return true;
		else{
			temp1=temp1.getNext();
			node=node.getNext();
			return temp1.equals(node);
		}
	}
}
