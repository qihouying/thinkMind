package com.qhy.design;

/**
 * @Author dream
 * @Date 2020/1/18 10:11 PM
 * @Description []   Topics: []  companies: []
 */

//hungry man pattern
public class Singleton {
    private static final Singleton singleton = new Singleton();
    private  Singleton() {}
    public static Singleton getInstance() {
        return singleton;
    }
}
