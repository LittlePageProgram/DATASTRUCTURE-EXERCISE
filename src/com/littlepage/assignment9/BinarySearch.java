package com.littlepage.assignment9;

public class BinarySearch{
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6,7};
        System.out.println(binarySearch(arr,8));
        System.out.println(binarySearch(arr,3));
    }

    public static int binarySearch(int[] arr,int t){
        int left=0,right=arr.length-1;
        int middle=(left+right)/2;
        int count=0;
        while(count!=arr.length) {
            if (t == arr[middle]) {
                return middle;
            } else if (t > arr[middle]) {
                left = middle;
                middle = (left + right) / 2;
            } else {
                right = middle;
                middle = (left + right) / 2;
            }
            count++;
        }
        return -1;
    }
}
