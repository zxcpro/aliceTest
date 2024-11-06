package com.guoyi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LengthOfLongestSubstring {

    /*
    3 最长不重复子串
    给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
    示例1:
    输入: s = "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */

    /*
    滑动窗口解法
    时间复杂度：O(n)
    空间复杂度：O(∣Σ∣)
    */
    public int lengthOfLongestSubstring(String str) {
        int res = 0;
        //1、初始化char，int的map，记录char出现的位置
        Map<Character, Integer> map = new HashMap<>();
        //2、左右窗口从0开始初始化，for循环，右窗口持续++
        int left = 0;
        for (int right = 0; right < str.length(); right++) {
            char cur = str.charAt(right);
            //3、左窗口遇到已出现的字符，左窗口移到最后出现该字符的后一个位置，把重复字符排除出去的那个位置
            if (map.containsKey(cur)) {
                left = Math.max(map.get(cur) + 1, left);
            }
            //4、结果取已存在的结果最大值，+1是要包括字符本身的长度
            res = Math.max(res, right - left + 1);
            //5、把当前char和位置放进map
            map.put(str.charAt(right), right);
        }
        return res;
    }

    public static void main(String[] args) {
        String str = new String("ab");
        LengthOfLongestSubstring lols = new LengthOfLongestSubstring();
        int i = lols.lengthOfLongestSubstring1(str);
        System.out.println(i);
    }

    //自己写的
    public int lengthOfLongestSubstring1(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                start = Math.max(start,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            end = i;
            res = Math.max(res,end-start+1);
        }
        return res;

    }

}
