package com.yangs.gof23.abstractFactory;

/**
 * @Author Ys
 * @Date 2021年04月24日 20:21
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        OppoFactory oppoFactory = new OppoFactory();
        IphneProduct iphneProduct =  oppoFactory.IphneProduct();
        IRouterProduct iRouterProduct =  oppoFactory.IRouterProduct();
        iphneProduct.start();
        iphneProduct.call();
    }
}
