package com.littlepage.assignment2.test3;

import com.littlepage.assignment2.test2.SinglyLinkedList;

public class PolynomialList {
	//member variable
	private SinglyLinkedList<PolynomialData> list;
	
	//constructor
	public PolynomialList() {
		list=new SinglyLinkedList<>();
	}
	public PolynomialList(PolynomialData[] polynomials) {
		list=new SinglyLinkedList<PolynomialData>(polynomials);
	}
	
	//getters and setters
	public SinglyLinkedList<PolynomialData> getList() {
		return list;
	}
	
	//toString method
	@Override
	public String toString() {
		return list.toString().replace("[", "").replace("]", "").replace(",", "+").replace("+-", "-");
	}
	
	//sort method
	public void bubbleSort(){
		for(int i=0;i<list.getSize()-1;i++){
			for(int j=0;j<list.getSize()-1;j++){
				if(list.getElement(j).compareTo(list.getElement(j+1))>0){
					PolynomialData temp=list.getElement(j);
					list.set(j, list.getElement(j+1));
					list.set(j+1, temp);
				}
			}
		}
	}
	//add method
	public void add(PolynomialList polynomial){
		SinglyLinkedList<PolynomialData> newSinglyLinkedList=new SinglyLinkedList<>();
		bubbleSort();
		polynomial.bubbleSort();
		int point1=0;
		int point2=0;
		PolynomialData tempData=list.getElement(point1);
		PolynomialData tempData2=polynomial.getList().getElement(point2);
		while(tempData!=null&&tempData2!=null){
			tempData=list.getElement(point1);
			tempData2=polynomial.getList().getElement(point2);
			if(tempData==null){
				if(tempData2!=null) newSinglyLinkedList.add(tempData2);
				point2++;
				continue;
			}
			if(tempData2==null){
				if(tempData!=null) newSinglyLinkedList.add(tempData);
				point1++;
				continue;
			}
			if(tempData.compareTo(tempData2)==0){
				newSinglyLinkedList.add(new PolynomialData(tempData.getCoefficient()+tempData2.getCoefficient(),tempData.getExponent()));
				point1++;
				point2++;
			}else if(tempData.compareTo(tempData2)>0){
				newSinglyLinkedList.add(tempData2);
				point2++;
			}else{
				newSinglyLinkedList.add(tempData);
				point1++;
			}
			
		}
		list=newSinglyLinkedList;
	}
	
	public void sub(PolynomialList polynomial){
		SinglyLinkedList<PolynomialData> newSinglyLinkedList=new SinglyLinkedList<>();
		bubbleSort();
		polynomial.bubbleSort();
		int point1=0;
		int point2=0;
		PolynomialData tempData=list.getElement(point1);
		PolynomialData tempData2=polynomial.getList().getElement(point2);
		while(tempData!=null&&tempData2!=null){
			tempData=list.getElement(point1);
			tempData2=polynomial.getList().getElement(point2);
			if(tempData==null){
				if(tempData2!=null) newSinglyLinkedList.add(tempData2);
				point2++;
				continue;
			}
			if(tempData2==null){
				if(tempData!=null) newSinglyLinkedList.add(tempData);
				point1++;
				continue;
			}
			if(tempData.compareTo(tempData2)==0){
				if(tempData.getCoefficient()-tempData2.getCoefficient()==0) {
					point1++;
					point2++;
					continue;
				}
				else{
					newSinglyLinkedList.add(new PolynomialData(tempData.getCoefficient()-tempData2.getCoefficient(),tempData.getExponent()));
					point1++;
					point2++;
				}
			}else if(tempData.compareTo(tempData2)>0){
				newSinglyLinkedList.add(tempData2);
				point2++;
			}else{
				newSinglyLinkedList.add(tempData);
				point1++;
			}
			
		}
		list=newSinglyLinkedList;
	}
}
