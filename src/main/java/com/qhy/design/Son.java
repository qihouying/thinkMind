package com.qhy.design;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author dream
 * @Date 2020/1/18 8:58 PM
 * @Description []   Topics: []  companies: []
 */
public class Son extends Father {
    public Collection doSomething(Map map) {
        System.out.println("son class is executed");
        return map.values();
    }

    public static void main(String[] args) {
        Father father = new Father();
        HashMap map = new HashMap();
        father.doSomething(map);

        //父类出现的地方，可以用子类代替
        Son son = new Son();
        son.doSomething(map);
    }
}
