package com.qhy.FLag;

/**
 * 实现单例
 *
 * Created by dream on 2019/3/20.
 */
public class Singleton {
    private Singleton() {}
    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
    public static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }
}
