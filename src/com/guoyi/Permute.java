package com.guoyi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permute {

    // 46 全排列
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> ans = new ArrayList<Integer>();
        //当前状态解应该是正序赋值这个就是初始值
        for(int num : nums){
            ans.add(num);
        }
        //回溯的条件，原信息，解空间，当前状态解+当前状态
        backtrack(nums, 0, ans, res);
        return res;
    }

    public void backtrack(int[] nums,int index ,List<Integer> ans,List<List<Integer>> res){
        //1、记录解，index是我们填写到了第几位
        if(index == nums.length -1){
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        //2、剪枝，假设排到index时候，前面的组合都已经排过了，所以后面的从index后排列就可以了，不然会重复
        for(int i = index;i<nums.length;i++){
            //3、尝试解的步骤，把第i位尝试放在第index位，然后再去排列下一位
            Collections.swap(ans,index,i);
            backtrack(nums,index+1,ans,res);
            //4、回退，把当前i位和index位再回退回去,复原到原位
            Collections.swap(ans,index,i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permute permute = new Permute();
        List<List<Integer>> list = permute.permute(nums);
        System.out.println(list.toString());

    }
}
