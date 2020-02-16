package com.qhy.design;

/**
 * @Author dream
 * @Date 2020/1/18 8:05 PM
 * @Description []   Topics: []  companies: []
 */
public class ProductFactory {
    //material processing
    private String materialProcessing(String material) {
        return material + "reinforce";
    }
    //produce product A
    public String productA(String material) {
        return materialProcessing(material) + "produce product A";
    }
    //produce product B
    public String productB(String material) {
        return materialProcessing(material) + "produce product B";
    }

}
