package com.qhy.design;

/**
 * @Author dream
 * @Date 2020/1/18 10:45 PM
 * @Description []   Topics: []  companies: []
 */
//指挥者：调用建造者中的方法完成复杂对象的创建。
public class Director {

    private Builder builder;
    public Director(Builder builder)
    {
        this.builder=builder;
    }
    //产品构建与组装方法
    public Product construct()
    {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
