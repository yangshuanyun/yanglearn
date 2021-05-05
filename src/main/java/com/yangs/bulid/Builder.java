package com.yangs.bulid;

import java.util.HashMap;

/**
 * @Author Ys
 * @Date 2021年04月25日 20:44
 * @Version 1.0
 */
public abstract class Builder {

    Long a= 2L;


    abstract void builda();//打地基

    abstract void buildb();//铺钢筋

    abstract void buildc();//刷墙
}
