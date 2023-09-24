package com.company;

import java.util.*;
import java.util.stream.Collectors;

class Test {

    public static List<String> ans = new ArrayList<>();


    public static void main(String[] args) {
        String s = "25525522135";
        //IP地址由4个数字组成，大小从[0,255]
        //依次遍历每个字符，
        List<String> temp = new ArrayList<String>();
        iterate(s, 0, temp);
        System.out.println(ans);

    }

    public static void iterate(String s, int curNumStart, List<String> tempAns) {
        //如果当前ip中已有4个数字
        if (tempAns.size() == 4) {
            if (curNumStart == s.length()) {
                ans.add(tempAns.stream().collect(Collectors.joining(".")));
            } else {
                //cur还没有到达终点，则为非法IP组合，退出
                return;
            }
        }

        //curNumberStart超过了s的最后一个字符
        if (curNumStart == s.length()) {
             //已经遍历到了最后一个数字，但是数组中的元素不足4个，为非法组合
             if (tempAns.size() != 4) {
                 return;
             }
        }

        String curNum;
        //尝试从当前位置选择出一个数字，单个ip数字从1位到3位
        for (int i = 1; i <= 3; i++) {
            if (curNumStart + i > s.length()) {
                //尝试的数字已经超过了最大字符串，终止遍历
                return;
            }
            curNum = s.substring(curNumStart, curNumStart + i);
            int curNumInt = Integer.parseInt(curNum);
            if (curNumInt < 0 || curNumInt > 255) {
                //非法组合，跳过
                return;
            }

            tempAns.add(curNum);
            //递归寻找下一个数字
            iterate(s, curNumStart + i, tempAns);
            //回溯后删除本次临时解，寻找当前位置的下一个数字
            tempAns.remove(tempAns.size() - 1);
        }
    }

}
