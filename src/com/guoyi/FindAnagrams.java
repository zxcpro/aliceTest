package com.guoyi;

import java.util.*;

public class FindAnagrams {

    /*
    438 找到字符串中所有字母异位词
    给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
    异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

    示例 1:
    输入: s = "cbaebabacd", p = "abc"
    输出: [0,6]
    解释:
    起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
    起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。

    示例 2:
    输入: s = "abab", p = "ab"
    输出: [0,1,2]
    解释:
    起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
    起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
    起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
     */

    public List<Integer> findAnagrams(String s, String p) {
        //异位词即其中包含的字母与每个字母出现的次数都相同，滑动窗口记录遍历字符中的各字符出现次数
        //s是原字符串，p是子串
        List<Integer> ans = new ArrayList();
        if(p.length() > s.length()) {
            return ans;
        }

        //1、记录目标子串p中的字符出现的次数
        Map<Character, Integer> targetCountMap = new HashMap();
        for(char c : p.toCharArray()) {
            Integer count = targetCountMap.get(c);
            if(count == null){
                count = 0;
            }
            count++;
            targetCountMap.put(c, count);
        }
        char[] sCharArray = s.toCharArray();
        Map<Character, Integer> currentCharCount = new HashMap();
        //使用第一个长度匹配的子串初始化currentCharCount
        for(int left = 0, right = 0; right < s.length(); right++) {
            char c = sCharArray[right];
            Integer cCount = currentCharCount.get(c);
            if(cCount == null) {
                cCount = 0;
            }
            cCount++;
            currentCharCount.put(c, cCount);
            //达到了符合条件的长度
            if(right >= p.length()) {
                //把start位置上的字符移除
                Character r = sCharArray[left];
                Integer rCount = currentCharCount.get(r);
                //不可能为0
                rCount--;
                if(rCount == 0) {
                    currentCharCount.remove(r);
                } else {
                    currentCharCount.put(r, rCount);
                }
                left++;
            }
            //判断currentCharCount和targetCountMap
            if(isMatch(currentCharCount, targetCountMap)) {
                ans.add(left);
            }
        }
        return ans;
    }

    public boolean isMatch(Map<Character, Integer> fir, Map<Character, Integer> sec) {
        //需要维护当元素数为0时，删除该key
        if(fir.size() != sec.size()) {
            return false;
        }
        for(char c : fir.keySet()) {
            if(!fir.get(c).equals(sec.get(c))) {
                return false;
            }
        }
        return true;
    }

    //维护这个位置的字母出现的次数
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] sc = new int[26], pc = new int[26];
        for (int i = 0; i < p.length(); i++){
            pc[p.charAt(i) - 'a']++;
        }
        for (int l = 0, r = 0; r < s.length(); r++) {
            sc[s.charAt(r) - 'a']++;
            if (r - l + 1 > p.length()) {
                sc[s.charAt(l++) - 'a']--;
            }
            if (check(sc, pc)){
                ans.add(l);
            }
        }
        return ans;
    }
    boolean check(int[] c1, int[] c2) {
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        List<Integer> list = findAnagrams.findAnagrams2("fghjkabcbaiuyt", "abc");
        System.out.println(list.toString());
    }
}
