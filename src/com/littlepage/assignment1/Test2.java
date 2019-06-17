package com.littlepage.assignment1;


/**
 * Ѱ�Ұ���
 * 
 * @author LittlePage
 *
 */
public class Test2 {
	public static void main(String[] args) {
		/**
		 * ���������������
		 */
		int[][] testArray = { 
				{ 2, 5, 4, 2, 1 }, 
				{ 3, 7, 6, 2, 9 },
				{ 6, 9, 5, 1, 0 }, 
				{ 6, 8, 7, 8, 0 },
				{ 9, 8, 7, 6, 0 }, };
		/**
		 * ��ӡ����
		 */
		for (int i = 0; i < testArray.length; i++) {
			for (int j = 0; j < testArray[i].length; j++) {
				System.out.print(testArray[i][j] + "\t");
			}
			System.out.println();
		}
		printSaddlePoint(testArray);// ���ô�ӡ���㷽��
	}

	/**
	 * ��ӡ����
	 * 
	 * @param array
	 */
	public static void printSaddlePoint(int[][] array) {
		int[][] maxArray = new int[array.length][3];// ���д洢ÿ����������Լ��������index
		for (int i = 0; i < array.length; i++) {
			maxArray[i][0] = findMaxNum(array[i]);
		}
		// �洢�����������
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (maxArray[i][0] == array[i][j]) {
					maxArray[i][1] = i;
					maxArray[i][2] = j;
				}
			}
		}
		//����Ƿ�Ϊÿ����С
		for(int i=0;i<maxArray.length;i++){
			int column=maxArray[i][2];
			for (int j = 0; j < array[column].length; j++) {
				if(array[j][column]<maxArray[i][0]){
					maxArray[i][0]=-1;
				}
			}
		}
		//��ӡ����
		boolean flag=false;
		System.out.println("�����У�");
		for(int i=0;i<maxArray.length;i++){
			if(maxArray[i][0]!=-1){
				System.out.println(maxArray[i][0]+"�ڵ�"+maxArray[i][1]+"�е�"+maxArray[i][2]+"��");
				flag=true;
			}
		}
		if(flag==false) System.out.println("�þ���û�а���");
	}

	/**
	 * �������
	 * 
	 * @param array
	 * @return maxNum
	 */
	public static int findMaxNum(int[] array) {
		int maxNum = array[0];
		for (int i = 0; i < array.length; i++) {
			if (maxNum < array[i])
				maxNum = array[i];
		}
		return maxNum;
	}
}
