package com.qhy.insist.dynamicPrograming.class_04;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author houyingqi
 * @Date 2019-10-02 20:02
 * @Description [hard] Topics: [Dynamic Programming]
 *
 * A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone.
 * The frog can jump on a stone, but it must not jump into the water.
 *
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the
 * river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.
 *
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog
 * can only jump in the forward direction.
 *
 * Note:
 *
 * The number of stones is ≥ 2 and is < 1,100.
 * Each stone's position will be a non-negative integer < 231.
 * The first stone's position is always 0.
 * Example 1:
 *
 * [0,1,3,5,6,8,12,17]
 *
 * There are a total of 8 stones.
 * The first stone at the 0th unit, second stone at the 1st unit,
 * third stone at the 3rd unit, and so on...
 * The last stone at the 17th unit.
 *
 * Return true. The frog can jump to the last stone by jumping
 * 1 unit to the 2nd stone, then 2 units to the 3rd stone, then
 * 2 units to the 4th stone, then 3 units to the 6th stone,
 * 4 units to the 7th stone, and 5 units to the 8th stone.
 *
 * Example 2:
 *
 * [0,1,2,3,4,8,9,11]
 *
 * Return false. There is no way to jump to the last stone as
 * the gap between the 5th and 6th stone is too large.
 **/
public class FrogJump_403 {

    /**
     * Thoughts:
     *
     * 对于每一个石头，设置一个set，用来记录从左边调过来得步数有哪几种，然后根据这个set再算，从当前石头上，可以跳到右边哪些石头上
     * 注意出口：1.只需要在遍历过程中判断，是否可以跳到最后一个石头上即可；2.最后只要判断最后一个石头的set是否为空，就可以判断青蛙能否跳过和
     */

    public boolean canCross(int[] stones) {
        if (stones.length == 0) {
            return true;
        }

        //"Use map to represent a mapping from the stone (not index) to the steps that can be taken from this stone."
        //The key of the map is stone. The value is, if the frog stand on this stone, how many steps this frog can jump.
        Map<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>(stones.length);
        map.put(0, new HashSet<Integer>());
        map.get(0).add(1);
        //为了后面判断set != null，map中stones集合中的石头对应的value一定不是null
        for (int i = 1; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>() );
        }

        //这里，注意判断条件是i < stones.length - 1，最后一个石头无需向右跳
        for (int i = 0; i < stones.length - 1; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                int reach = step + stone;
                if (reach == stones[stones.length - 1]) {
                    return true;
                }
                HashSet<Integer> set = map.get(reach);

                if (set != null) {
                    set.add(step);
                    if (step - 1 > 0) set.add(step - 1);
                    set.add(step + 1);
                }
//                System.out.println("i="+i+",step="+step+",set="+set+",map="+map);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] stones = {0,1,2,3,4,8,9,11};
        int[] stones1 = {0,1,3,5,6,8,12,17};
        FrogJump_403 frogJump = new FrogJump_403();
        System.out.println(frogJump.canCross(stones1));
//        System.out.println(frogJump.canCross(stones));
    }
}
