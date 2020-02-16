package com.qhy.design;

/**
 * @Author dream
 * @Date 2020/1/18 10:44 PM
 * @Description []   Topics: []  companies: []
 */
//具体建造者：实现了抽象建造者接口。
public class ConcreteBuilder extends Builder
{
    public void buildPartA()
    {
        product.setPartA("建造 PartA");
    }
    public void buildPartB()
    {
        product.setPartA("建造 PartB");
    }
    public void buildPartC()
    {
        product.setPartA("建造 PartC");
    }
}
