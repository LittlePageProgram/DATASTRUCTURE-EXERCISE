package com.littlepage.assignment1.test3;

/**
 * 复数类
 * 
 * @author LittlePage
 */
public class ComplexNum{
	private double realPart;
	private double imaginaryPart;

	public ComplexNum() {
	}

	public ComplexNum(double realPart, double imaginaryPart) {
		super();
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}

	public double getRealPart() {
		return realPart;
	}

	public void setRealPart(double realPart) {
		this.realPart = realPart;
	}

	public double getImaginaryPart() {
		return imaginaryPart;
	}

	public void setImaginaryPart(double imaginaryPart) {
		this.imaginaryPart = imaginaryPart;
	}

	@Override
	public String toString() {
		if (imaginaryPart > 0) {
			return realPart + "+" + imaginaryPart + "i";
		} else if (imaginaryPart == 0) {
			return String.valueOf(realPart);
		} else
			return "" + realPart + imaginaryPart + "i";
	}

	public ComplexNum plusNum(ComplexNum complexNum) {
		double tempRealPart = realPart + complexNum.getRealPart();
		double tempImaginaryPart = imaginaryPart + complexNum.getImaginaryPart();
		return new ComplexNum(tempRealPart, tempImaginaryPart);
	}

	public ComplexNum subNum(ComplexNum complexNum) {
		double tempRealPart = realPart - complexNum.getRealPart();
		double tempImaginaryPart = imaginaryPart - complexNum.getImaginaryPart();
		return new ComplexNum(tempRealPart, tempImaginaryPart);
	}

	/**
	 * compareTo方法,小于0则为小于号，大于0为大于号，等于0为等于号
	 */
	public double compareTo(ComplexNum complexNum) {
		return (Math.sqrt(realPart*realPart+imaginaryPart*imaginaryPart)-
				Math.sqrt(complexNum.getRealPart()*complexNum.getRealPart()-complexNum.getImaginaryPart()*complexNum.getImaginaryPart()));
	}

	@Override
	public boolean equals(Object obj) {
		ComplexNum temp = (ComplexNum) obj;
		return realPart == temp.getRealPart() && imaginaryPart == temp.getImaginaryPart();
	}

	public ComplexNum conjugateNum() {
		return new ComplexNum(realPart, -imaginaryPart);
	}
}
