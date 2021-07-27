package com.testcode;

/**
 * @Author:Ys
 * @description
 * @date 2021/7/5 22:53
 */
public class test {

    static int [] arr = new int []{2,5,9,7,5};
    static int target = 16;
    public static void main (String [] args){
        int  arr4 [] = twoSum(arr,target);
        System.out.print(arr4);
    }
    public static int[] twoSum(int[] nums, int target) {
        int arr2 [] = new int[2];
        for(int i=0;i<nums.length;i++){
            int key =arr[i] ;
            for(int j=1;j<nums.length;j++){
                int result = key+arr[j];
                if(result==target){

                    arr2[0]=i;
                    arr2[1]=j;
                    return arr2;
                }
            }

        }
        return arr2;
    }
}
