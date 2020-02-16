package com.qhy.design;

import java.util.Collection;
import java.util.HashMap;

/**
 * @Author dream
 * @Date 2020/1/18 8:57 PM
 * @Description []   Topics: []  companies: []
 */
public class Father {
    public Collection doSomething(HashMap map) {
        System.out.println("father class is executed");
        return map.values();
    }
}
