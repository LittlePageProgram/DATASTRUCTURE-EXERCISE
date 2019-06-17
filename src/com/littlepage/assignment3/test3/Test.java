package com.littlepage.assignment3.test3;

import java.util.Calendar;

/**
 * Use seqQueue to simulate the phone calls
 * 
 * @author littlepage
 *
 */
public class Test {
	public static void main(String[] args) {
		SeqQueue<Telephone> missedPhoneCalls=new SeqQueue<Telephone>();
		SeqQueue<Telephone> receivedPhoneCalls=new SeqQueue<Telephone>();
		SeqQueue<Telephone> DialedPhoneCalls=new SeqQueue<Telephone>();
		
		for(int i=0;i<10;i++){
			Telephone tempTele=new Telephone(randomType(), randomPhone(),getCurrentTime());
			switch (tempTele.getType()) {
			case 'M':
				missedPhoneCalls.add(tempTele);
				break;
			case 'R':
				receivedPhoneCalls.add(tempTele);
				break;
			case 'D':
				DialedPhoneCalls.add(tempTele);
				break;
			}
		}
		
		System.out.println("未接电话："+missedPhoneCalls);
		System.out.println("已接电话："+receivedPhoneCalls);
		System.out.println("已拨电话："+DialedPhoneCalls);
	}

	/**
	 * generate the telephone number
	 * 
	 * @return the 11 digit telephone number
	 */
	public static String randomPhone() {
		String returnStr = "";
		int tempNum = 0;
		for (int i = 0; i < 11; i++) {
			tempNum = (int) (Math.random() * 10);
			returnStr += tempNum;
		}
		if(returnStr.matches("1[38][15789]\\d+")){
			return returnStr;
		}else{
			return randomPhone();
		}
	}
	/**
	 * generate the type of the phone calls
	 * 
	 * @return the type of phone calls
	 */
	public static char randomType() {
		char[] returnType = { 'M', 'R', 'D' };
		return returnType[(int) (Math.random() * 3)];
	}

	/**
	 * get the current time
	 * 
	 * @return the current time
	 */
	public static String getCurrentTime() {
		Calendar ca = Calendar.getInstance();
		return "" + ca.get(Calendar.YEAR) + "-" + (ca.get(Calendar.MONTH) + 1) + "-" + ca.get(Calendar.DAY_OF_MONTH)
				+ " " + ca.get(Calendar.HOUR) + ":" + ca.get(Calendar.MINUTE) + ":" + ca.get(Calendar.SECOND);
	}
}
