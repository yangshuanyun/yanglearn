package com.yangs.yangsspringbootproject;

import java.util.UUID;

/**
 * @Author Ys
 * @Date 2021年04月22日 17:06
 * @Version 1.0
 */
public class UuidTool {



        // 生成UUID
        public static String get(){
            return UUID.randomUUID().toString();
        }

        public static void main(String[] args) {
            String uuid = UuidTool.get();
            System.out.println("==> 处理前 uuid（原生）: \n" + uuid);
            System.out.println("\n==> 处理后 uuid（32位）: \n" + uuid.replaceAll("-", ""));
        }

}
