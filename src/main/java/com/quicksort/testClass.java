package com.quicksort;

import com.alibaba.fastjson.JSONArray;
import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;

/**
 * @Author:Ys
 * @description
 * @date 2021/7/1 15:04
 */
public class testClass {

    public static  void  main(String[] args){
        test();
    }

    public static void  test (){
        BigDecimal bigDecimal = new BigDecimal(10);
        BigDecimal bigDecimal1 = new BigDecimal(0);
        BigDecimal bigDecimal2 = new BigDecimal(0);

        System.out.println(bigDecimal1.equals(bigDecimal2));

        //上层
        JSONArray jsonArray =new JSONArray();
        jsonArray.add(1);
        jsonArray.add(2);
        jsonArray.add(3);
        jsonArray.add(4);


        //底层
        JSONArray jsonArray1 =new JSONArray();
        jsonArray1.add(3);
        jsonArray1.add(4);
        jsonArray1.add(5);
        jsonArray1.add(6);
        jsonArray1.add(7);

        JSONArray jsonArray2 = new JSONArray();
        jsonArray2.addAll(jsonArray);
        jsonArray2.addAll(jsonArray1);
        System.out.println(jsonArray2.toJSONString());

        //移除
         jsonArray2.removeAll(jsonArray);

        System.out.println(jsonArray2.toJSONString());
    }

}
