package com.littlepage.assignment3.test3;

/**
 * 队列的定义
 * 
 * @author littlepage
 * 
 */
public class SeqQueue<E> {
	// member variable
	private Object[] element;
	private int front;
	private int rear;
	private int capacity;

	// constant number
	private final int INIT_CAPACITY = 10;

	// constructor
	public SeqQueue() {
		capacity = INIT_CAPACITY;
		element = new Object[capacity];
		front = -1;
		rear = -1;
	}

	public SeqQueue(E[] element) {

	}

	// getters and setters
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	// toString method
	@Override
	public String toString() {
		if (front == -1 || rear == -1)
			return "null";
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = front; i != rear + 1; i++) {
			sb.append(element[i] + ",");
		}
		sb.replace(sb.length() - 1, sb.length(), "]");
		return sb.toString();
	}

	// other method
	public boolean add(E element) {
		// judge the arrays is or not null
		if (element == null) {
			return false;
		}
		// enlarge the capacity
		if (front == (rear + 1) % this.element.length) {
			capacity *= 2;
			Object[] obj = new Object[capacity];
			int j = 0;
			for (int i = 0; i != rear; i = (i + 1) % this.element.length) {
				obj[j++] = this.element[i];
			}
			this.element = obj;
			obj[j] = element;
			front = 0;
			rear = j;
			return true;
		}

		// add the element
		if (rear == -1 && front == -1) {
			rear = 0;
			front = 0;
		} else {
			rear++;
		}
		this.element[rear] = element;
		return true;
	}

	@SuppressWarnings("unchecked")
	public E peek() {
		return (E) element[front];
	}

	@SuppressWarnings("unchecked")
	public E poll() {
		E e = (E) element[front];
		front = (front + 1) % capacity;
		return e;
	}
}
