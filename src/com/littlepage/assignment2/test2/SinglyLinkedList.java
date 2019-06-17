package com.littlepage.assignment2.test2;

public class SinglyLinkedList<T> {
	//member variable
	private Node<T> head;
	private int size;
	
	//constructor
	public SinglyLinkedList() {
		head=new Node<>();
	}
	
	public SinglyLinkedList(T[] element) {
		head=new Node<T>();
		for(int i=0;i<element.length;i++){
			if(head.getData()==null) head.setData(element[i]);
			else {
				Node<T> temp=head;
				while(temp.getNext()!=null){
					temp=temp.getNext();
				}
				temp.setNext(new Node<T>(element[i]));
			}
		}
		size=element.length;
	}
	
	public SinglyLinkedList(SinglyLinkedList<T> singlyLinkedList){
		head=singlyLinkedList.getHead();
		size=singlyLinkedList.getSize();
	}
	
	//getters and setters
	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	//toString
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder("[");
		sb.append(head.getData()+",");
		Node<T> temp=head;
		while(temp.getNext()!=null){
			temp=temp.getNext();
			sb.append(temp.getData()+",");
		}
		sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",")+1, "]");
		return sb.toString();
	}
	
	//others method
	public void concat(SinglyLinkedList<T> list){
		Node<T> temp=head;
		while(temp.getNext()!=null){
			temp=temp.getNext();
		}
		temp.setNext(list.getHead());
		size+=list.getSize();
	}
	
	public Node<T> search(T element){
		Node<T> temp=head;
		if(head.getData().equals(element)) return head;
		while(temp.getNext()!=null){
			if(temp.getNext().getData().equals(element)) return temp.getNext();
			temp=temp.getNext();
		}
		return null;
	}
	
	public boolean contain (T element){
		Node<T> temp=head;
		if(head.getData().equals(element)) return true;
		while(temp.getNext()!=null){
			if(temp.getNext().getData().equals(element)) return true;
			temp=temp.getNext();
		}
		return false;
	}
	
	public void add(T element){
		if(head.getData()==null) head.setData(element);
		else{
			if(head.getNext()==null) head.setNext(new Node<>(element));
			else{
				Node<T> temp=head;
				while(temp.getNext()!=null){
					temp=temp.getNext();
				}
				temp.setNext(new Node<>(element));
			}
		}
		size++;
	}
	
	
	public boolean remove (T element){
		Node<T> temp=head;
		if(head.getData().equals(element)) {
			head=head.getNext();
			size--;
			return true;
		}
		while(temp.getNext()!=null){
			if(temp.getNext().getData().equals(element)) {
				temp.setNext(temp.getNext().getNext());
				return true;
			}
			temp=temp.getNext();
		}
		return false;
	}

	public boolean replace (Object obj, T element){
		Node<T> temp=head;
		if(head.getData().equals(obj)) {
			head.setData(element);
			return true;
		}
		while(temp.getNext()!=null){
			if(temp.getNext().getData().equals(obj)) {
				temp.getNext().setData(element);
				return true;
			}
			temp=temp.getNext();
		}
		return false;
	}

	//getElement
	public T getElement(int index){
		if(index<0||index>=size) return null;
		Node<T> temp=head;
		if(index==0) return head.getData();
		else{
			for(int i=0;i<index;i++){
				temp=temp.getNext();
			}
			return temp.getData();
		}
	}
	
	//getNode
	public Node<T> getNode(int index){
		if(index<0||index>=size) return null;
		Node<T> temp=head;
		if(index==0) return head;
		else{
			for(int i=0;i<index;i++){
				temp=temp.getNext();
			}
			return temp;
		}
	}
	
	public void set(int index,T value){
		if(index<0) index=0;
		if(index>=size) index=size-1;
		Node<T> temp=head;
		if(index==0) head.setData(value);
		else{
			for(int i=0;i<index;i++){
				temp=temp.getNext();
			}
			temp.setData(value);
		}
	}

	@Override
	public boolean equals(Object obj) {
		@SuppressWarnings("unchecked")
		SinglyLinkedList<T> singlyLinkedList=(SinglyLinkedList<T>)obj;
		return head.equals(singlyLinkedList.getHead());
	}




}
