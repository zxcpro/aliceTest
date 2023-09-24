package com.company;

import java.util.HashMap;
import java.util.Map;

public class FindTarget {
    private Map<String, Integer> cache = new HashMap<String, Integer>();

    public int findTargetSumWays(int[] nums, int target) {
        //递归减小问题规模
        return findRecur(nums, target, nums.length - 1);
    }

    public int findRecur(int[] nums, int target, int currentIndex) {
        String cacheKey = target+"-"+currentIndex;
        Integer cachedRes = cache.get(cacheKey);
        if(cachedRes != null) {
            return cachedRes;
        }

        // System.out.println("target:" + target + " index:" + currentIndex);
        //遍历完成仍然未找到
        if (currentIndex < 0 && target == 0) {
            return 1;
        }

        if (currentIndex < 0 && target != 0) {
            return 0;
        }


        //当前值取正
        int posRemains = target - nums[currentIndex];
        //System.out.println("currentIndex:" + currentIndex + " pos");
        int posWays = findRecur(nums, posRemains, currentIndex - 1);

        //当前值取负
        int negRemains = target + nums[currentIndex];
        //System.out.println("currentIndex:" + currentIndex + " neg");
        int negWays = findRecur(nums, negRemains, currentIndex - 1);

        int ans = posWays + negWays;
        cache.put(cacheKey,  ans);
        return ans;

    }
}
