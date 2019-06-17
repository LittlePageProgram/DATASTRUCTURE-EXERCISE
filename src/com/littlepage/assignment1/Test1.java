package com.littlepage.assignment1;


/**
 * Ñî»ÔÈı½Ç
 * @author LittlePage
 *
 */
public class Test1 {
	public static void main(String[] args) {
		int[][] mat=new int[6][6];
		for(int i=0;i<mat.length;i++){
			mat[i][0]=1;
			mat[i][i]=1;
		}
		for(int i=2;i<mat.length;i++){
			for(int j=1;j<i;j++){
				mat[i][j]=mat[i-1][j-1]+mat[i-1][j];
			}
		}
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[i].length;j++){
				System.out.print(mat[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
