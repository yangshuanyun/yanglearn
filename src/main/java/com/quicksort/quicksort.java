package com.quicksort;

import netscape.security.UserTarget;

/**
 * @Author:Ys
 * @description
 * @date 2021/6/30 14:20
 */
public class quicksort {
    static int[] arr=new int[] { 20, 3, 5, 18, 90, 100, 30, 21, 8, 191};

    public static void main(String[] args){
        quickSort1(arr, 0, arr.length - 1);
        for (int i: arr){
            System.out.println(i);
        }
    }
    public static void quickSort1(int[] arr, int left, int right){

        if (arr == null || arr.length==0  ){
            return;
        }
        if(left>right){
            return;
        }
        int key =arr[left];
        int l = left;
        int r = right;
        while (l!=r){

            while (arr[r]>=key && l<r){

                r--;
            }
            while (arr[l]<=key && l<r){

                l++;
            }

            if (l<r){

                int temp = arr[l];
                arr[l]= arr[r];
                arr[r] = temp;
            }

        }
        arr[left]= arr[l];
        arr[l]=key;
        quickSort1(arr,left,l-1);
        quickSort1(arr,l+1,right);
    }


}
