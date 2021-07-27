package com.testcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author:Ys
 * @description
 * @date 2021/7/5 22:53
 */
public class testcode {


        public static void main(String args[]) {

            Scanner scan =new Scanner(System.in);

            System.out.println("输入一个整数");

            int a = scan.nextByte();

            if(a%2 != 0){

                System.out.printf("%d是奇数", a);
            }

            else{
                System.out.printf("%d是偶数", a);
            }
            ArrayList arrayList= new ArrayList();
            HashMap hashMap = new HashMap();




    }
}
