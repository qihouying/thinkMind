package com.qhy.design;

/**
 * @Author dream
 * @Date 2020/1/18 10:14 PM
 * @Description []   Topics: []  companies: []
 */

//idler man pattern
public class Singleton2 {

    private static Singleton2 singleton = null;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (null == singleton) {
            synchronized (Singleton.class) {
                if (null == singleton) {
                    singleton = new Singleton2();
                }
            }
        }
        return singleton;
    }
}
