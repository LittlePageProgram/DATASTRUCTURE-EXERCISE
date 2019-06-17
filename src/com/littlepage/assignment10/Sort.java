package com.littlepage.assignment10;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] a=new int[] {1,9,45,2,5,92,3,10,20};
        mergeSort(a);
    }

    public static void insertSort(int[] arr) {
        for(int i=2;i<arr.length;i++) {
            int temp=arr[i];//�ݴ�λ��
            for(int j=i;j>0;j--) {
                if(temp>arr[j-1]) {
                    arr[j]=temp;
                    break;
                }else {
                    arr[j]=arr[j-1];
                }
            }
        }
        System.out.println(Arrays.toString(arr));;
    }

    public static void heapSort(int[] value, boolean minheap) {
        for (int i = (value.length) / 2 - 1; i >= 0; i--) {
            sift(value, i, value.length - 1, minheap);
        }
        for (int j = value.length - 1; j > 0; j--) {
            swap(value, 0, j);

            sift(value, 0, j - 1, minheap);
        }
        System.out.println(Arrays.toString(value));;
    }

    public static void sift(int[] value, int parent, int end, boolean minheap) {
        int child = 2 * parent + 1;
        while (child <= end) {
            if (child + 1 <= end) {
                if (minheap ? value[child] > value[child + 1] : value[child] < value[child + 1])
                    child++;
            }
            if (minheap ? value[parent] > value[child] : value[parent] < value[child]) {
                swap(value, parent, child);

                parent = child;
                child = 2 * parent + 1;
            } else
                break;

        }
    }


    public static void swap(int[] value, int i, int j) {
        int t = 0;

        t = value[i];
        value[i] = value[j];
        value[j] = t;
    }

    public static void quickSort(int[] value, int begin, int end) {

        if (begin >= 0 && begin < value.length && end >= 0 && end < value.length && begin < end) {// �±���Ч
            int i = begin, j = end;
            int base = value[i];// ��׼��

            while (i != j) {// i��j�������м�ƽ������i==jʱ����ѭ��
                while (i < j && value[j] >= base) {// j�Ӻ���ǰ�ƽ�
                    j--;
                }
                if (i < j) {// ��value[j]<=value[i]������СԪ���Ƶ�ǰ��
                    value[i] = value[j];
                    i++;
                }

                while (i < j && value[i] <= base)// i��ǰ����ƽ�
                    i++;
                if (i < j) {// ��value[i]>=value[j]�����ϴ�Ԫ���Ƶ�����
                    value[j] = value[i];
                    j--;
                }

            }
            value[i] = base;// ��������λ�ã���׼�㸳ֵ

            quickSort(value, begin, i - 1);// ���ӱ�
            quickSort(value, i + 1, end);
        }
        System.out.println(Arrays.toString(value));
    }

    public static void mergeSort(int[] value) {
        int[] valueSorted = new int[value.length];
        int n = 1;
        while (n < value.length) {
            mergeAll(value, valueSorted, n);
            n = 2 * n;
            if (n < value.length) {
                mergeAll(valueSorted, value, n);
                n = 2 * n;
            }
        }
        System.out.println(Arrays.toString(value));
    }

    public static void mergeAll(int[] value, int[] valueSorted, int n) {
        for (int i = 0; i < value.length; i += 2 * n) {
            merge(value, valueSorted, i, i + n, n);
        }
    }

    public static void merge(int[] value, int[] valueSorted, int begin1, int begin2, int n) {
        int i = begin1, j = begin2, k = begin1;

        while (i < begin1 + n && j < begin2 + n && j < value.length) {

            if (value[i] < value[j])// ����
                valueSorted[k++] = value[i++];
            else
                valueSorted[k++] = value[j++];

        }

        while (i < begin1 + n && i < value.length) {
            valueSorted[k++] = value[i++];
        }
        while (j < begin2 + n && j < value.length) {
            valueSorted[k++] = value[j++];
        }

    }
}


