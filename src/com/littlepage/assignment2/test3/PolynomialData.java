package com.littlepage.assignment2.test3;

public class PolynomialData implements Comparable<Object>{
	//member variable
	private double coefficient;
	private int exponent;
	
	//constructor
	public PolynomialData() {
	}

	//getters and setters
	public PolynomialData(double coefficient, int exponent) {
		super();
		this.coefficient = coefficient;
		this.exponent = exponent;
	}

	public double getCoefficient() {
		return coefficient; 	
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	public int getExponent() {
		return exponent;
	}

	public void setExponent(int exponent) {
		this.exponent = exponent;
	}

	//toString
	@Override
	public String toString() {
		return coefficient+"X^"+exponent;
	}

	@Override
	public int compareTo(Object o) {
		PolynomialData polynomial=(PolynomialData)o;
		return exponent-polynomial.getExponent();
	}
}
