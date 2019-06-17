package com.littlepage.assignment1;


/**
 * 寻找鞍点
 * 
 * @author LittlePage
 *
 */
public class Test2 {
	public static void main(String[] args) {
		/**
		 * 生成随机测试数组
		 */
		int[][] testArray = { 
				{ 2, 5, 4, 2, 1 }, 
				{ 3, 7, 6, 2, 9 },
				{ 6, 9, 5, 1, 0 }, 
				{ 6, 8, 7, 8, 0 },
				{ 9, 8, 7, 6, 0 }, };
		/**
		 * 打印数组
		 */
		for (int i = 0; i < testArray.length; i++) {
			for (int j = 0; j < testArray[i].length; j++) {
				System.out.print(testArray[i][j] + "\t");
			}
			System.out.println();
		}
		printSaddlePoint(testArray);// 调用打印鞍点方法
	}

	/**
	 * 打印鞍点
	 * 
	 * @param array
	 */
	public static void printSaddlePoint(int[][] array) {
		int[][] maxArray = new int[array.length][3];// 三行存储每行最大数，以及最大数的index
		for (int i = 0; i < array.length; i++) {
			maxArray[i][0] = findMaxNum(array[i]);
		}
		// 存储最大数的索引
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (maxArray[i][0] == array[i][j]) {
					maxArray[i][1] = i;
					maxArray[i][2] = j;
				}
			}
		}
		//检查是否为每列最小
		for(int i=0;i<maxArray.length;i++){
			int column=maxArray[i][2];
			for (int j = 0; j < array[column].length; j++) {
				if(array[j][column]<maxArray[i][0]){
					maxArray[i][0]=-1;
				}
			}
		}
		//打印鞍点
		boolean flag=false;
		System.out.println("鞍点有：");
		for(int i=0;i<maxArray.length;i++){
			if(maxArray[i][0]!=-1){
				System.out.println(maxArray[i][0]+"在第"+maxArray[i][1]+"行第"+maxArray[i][2]+"列");
				flag=true;
			}
		}
		if(flag==false) System.out.println("该矩阵没有鞍点");
	}

	/**
	 * 求最大数
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
