package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSplit {

    public static void main(String[] args) {

        List<String> dict = new ArrayList<String>();
        dict.add("cats");
        dict.add("dog");
        dict.add("sand");
        dict.add("and");
        dict.add("cat");

        System.out.println(new WordSplit().workSplit("catsandog", dict));
    }

    //字典可以重复，通过缩小s的范围来缩小问题
    public boolean workSplit(String s, List<String> dict) {
        Set<String> dictSet = new HashSet<>(dict);
        return workSplit(s, dictSet);

    }

    public boolean workSplit(String s, Set<String> dict) {

        if (s.isEmpty()) {
            return true;
        }

        //尝试截断s，如果存在dict之中，则截断后继续求解
        //自顶向下求解
        for (int i = 1; i <= s.length(); i++) {
            String cut = s.substring(0, i);
            //如果不在dict中，则继续拆解
            if (!dict.contains(cut)) {
                continue;
            }
            //如果在dict中，则拆解后继续遍历
            String remains = s.substring(i, s.length());
            boolean res = workSplit(remains, dict);
            if (!res) {
                //如果不存在，则继续遍历
                continue;
            } else {
                return true;
            }
        }
        return false;
    }
}
