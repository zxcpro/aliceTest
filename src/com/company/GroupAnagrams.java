package com.company;

import java.util.*;

public class GroupAnagrams {
    /* 49. 字母异位词分组
    给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
    字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
    示例 1:
    输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
    示例 2:
    输入: strs = [""]
    输出: [[""]]
    示例 3:
    输入: strs = ["a"]
    输出: [["a"]]
     */

    /* 思考，排序去重，然后拿排序去重key的value list
    1、初始化map
    2、遍历strs，把str的字符toCharArray后排序Arrays.sort
    3、排序后的字符串做key，从map中get，并加入到get出的list里重新put进去
    4、结束遍历后，map.values的字符串就是分隔好的字符集合
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
