package com.qhy.practice.twoSum;

import java.util.*;

/**
 * Desc:
 * author: qihouying@meituan.com
 * Date:   09 10, 2018 11:02
 */
public class OnePassHashTable {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> data = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int remind = target - nums[i];
            if (data.containsKey(remind) && i != data.get(remind)) {
                return new int[]{i, data.get(remind)};
            }
            data.put(nums[i], i);
        }
        throw new IllegalArgumentException("no such sum solution");
    }

    public static void main(String[] args) {
       /* int[] array = new int[]{4, 7, 9, 2, 6};
        int target = 8;
        int[] result = OnePassHashTable.twoSum(array, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }*/
        List<String> list = Arrays.asList("POSITION",
                "NUMRESULTS",
                "DISTANCE",
                "ADISTANCE_BETA",
                "HOUR_OF_DAY",
                "DAY_OF_WEEK",
                "CITY_ID",
                "POI_CTR_DAY7",
                "POI_CVRP_DAY7",
                "POI_CXRP_DAY7",
                "POI_CPR_DAY7",
                "POI_CTR_DAY30",
                "POI_CVRP_DAY30",
                "POI_CXRP_DAY30",
                "POI_CPR_DAY30",
                "POI_CTR_DAY90",
                "POI_CVRP_DAY90",
                "POI_CXRP_DAY90",
                "POI_CPR_DAY90",
                "POI_CATE_PAY_F_CNT_DAY90",
                "POI_CATE_CONSUME_F_CNT_DAY90",
                "POI_CATE_REFUND_F_CNT_DAY90",
                "POI_CATE_PAY_F_CNT_DAY30",
                "POI_CATE_CONSUME_F_CNT_DAY30",
                "POI_CATE_REFUND_F_CNT_DAY30",
                "POI_CATE_PAY_F_CNT_DAY7",
                "POI_CATE_CONSUME_F_CNT_DAY7",
                "POI_CATE_REFUND_F_CNT_DAY7",
                "POI_CATE_PAY_F_CNT_ACC",
                "POI_CATE_PAY_F_CNT_ACC_PURE",
                "POI_ALLCATE_PAY_F_CNT_DAY90",
                "POI_ALLCATE_CONSUME_F_CNT_DAY90",
                "POI_ALLCATE_REFUND_F_CNT_DAY90",
                "POI_ALLCATE_PAY_F_CNT_DAY30",
                "POI_ALLCATE_CONSUME_F_CNT_DAY30",
                "POI_ALLCATE_REFUND_F_CNT_DAY30",
                "POI_ALLCATE_PAY_F_CNT_DAY7",
                "POI_ALLCATE_CONSUME_F_CNT_DAY7",
                "POI_ALLCATE_REFUND_F_CNT_DAY7",
                "POI_PAY_F_CNT_ACC",
                "POI_PAY_F_CNT_ACC_PURE",
                "POI_COMMENT_CNT_DAY30",
                "POI_COMMENT_REPLY_RATIO",
                "POI_COMMENT_PICTURE_RATIO",
                "POI_COMMENT_GOOD_RATIO",
                "POI_CATE_HAS_DEAL_NUM",
                "POI_CATE_DEAL_LOWESTPRICE",
                "POI_CATE_DEAL_MAX_AVGSCORE",
                "POI_CATE_DEAL_MAX_COMMENT_CNT",
                "POI_CATE_COMMENT_CNT_DAY90",
                "POI_CATE_AVGSCORE_DAY90",
                "POI_CATE_DEAL_MAX_CLICK_CNT_DAY7",
                "POI_CATE_DEAL_MAX_CLICK_CNT_DAY",
                "POI_CATE_DEAL_BEST_QUALITY",
                "CATE_INTENTION",
                "TVL_POI_RT_VIEWED_TS","TVL_POI_RT_VIEWED",
                "POI_RANK_GINKGO",
                "TICKET_AVGPRICE",
                "REC_POI_CF_SCORE",
                "REC_POI_CF",
                "POI_SCENE_CTR_DAY7",
                "POI_SCENE_CVRP_DAY7",
                "POI_SCENE_CXRP_DAY7",
                "POI_SCENE_CPR_DAY7",
                "POI_SCENE_CTR_DAY30",
                "POI_SCENE_CVRP_DAY30",
                "POI_SCENE_CXRP_DAY30",
                "POI_SCENE_CPR_DAY30",
                "POI_SCENE_CTR_DAY90",
                "POI_SCENE_CVRP_DAY90",
                "POI_SCENE_CXRP_DAY90",
                "POI_SCENE_CPR_DAY90",
                "POI_VIEW_W_D90",
                "POI_VIEWED_D90",
                "POI_COLLECT_W_D90",
                "POI_COLLECTED_D90",
                "POI_DEAL_VIEW_W_D90",
                "POI_DEAL_VIEWED_D90",
                "POI_DEAL_COLLECT_W_D90",
                "POI_DEAL_COLLECTED_D90",
                "POIDEAL_VIEW_W_D90",
                "POIDEAL_VIEWED_D90",
                "POIDEAL_COLLECT_W_D90",
                "POIDEAL_COLLECTED_D90",
                "POIDEAL_PAY_W_D90",
                "POIDEAL_PAID_D90",
                "POIDEAL_REFUND_W_D90",
                "POIDEAL_REFUNDED_D90",
                "MT_SEL_POI_CTR_DAY7",
                "MT_SEL_POI_CVR_DAY7",
                "MT_SEL_POI_CXR_DAY7",
                "MT_SEL_POI_CPR_DAY7",
                "MT_SEL_POI_CTR_DAY30",
                "MT_SEL_POI_CVR_DAY30",
                "MT_SEL_POI_CXR_DAY30",
                "MT_SEL_POI_CPR_DAY30",
                "MT_SEL_POI_CTR_DAY90",
                "MT_SEL_POI_CVR_DAY90",
                "MT_SEL_POI_CXR_DAY90",
                "MT_SEL_POI_CPR_DAY90");
        for (String str : list) {
            System.out.println("generalFloatFeatureKeys.add(TravelFeatureName." + str + ");");
        }
    }
}
