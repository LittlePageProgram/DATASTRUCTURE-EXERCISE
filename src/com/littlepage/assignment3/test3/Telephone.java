package com.littlepage.assignment3.test3;

/**
 * Telephone∂‘œÛ
 * 
 * @author littlepage
 *
 */
public class Telephone {
	private char type;
	// the type of telephone,M missed call,R received call,D dialed call
	private String phoneNumber;
	// the number of phonecalls
	private String time;

	public Telephone(char type, String phoneNumber, String time) {
		super();
		this.type = type;
		this.phoneNumber = phoneNumber;
		this.time = time;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Telephone [type=" + type + ", phoneNumber=" + phoneNumber + ", time=" + time + "]\n";
	}
}
