package com.guoyi;

import java.util.HashSet;
import java.util.List;

public class WordBreak {

    /*
    139 单词拆分
    给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
    注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     示例 1：
    输入: s = "leetcode", wordDict = ["leet", "code"]
    输出: true
    解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。

    示例 2：
    输入: s = "applepenapple", wordDict = ["apple", "pen"]
    输出: true
    解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
         注意，你可以重复使用字典中的单词。

    示例 3：
    输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
    输出: false
     */

    public boolean wordBreak(String s, List<String> wordDict) {
        //1、把wordDict放进set，这样contains比较快
        HashSet<String> wordDictSet = new HashSet<String>(wordDict);
        //2、初始化s.length() + 1的boolean数组，记录每个位置有没有解，并且赋值0为true
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        //3、遍历字符串s，从第一个字符开始遍历到s.length()，记录每个i长度的字符串有没有解
        for (int i = 1; i <= s.length(); i++) {
            //4、拆解i长度的字符串，从0开始切割，尝试各种组合，有一个有解就结束
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        //5、返回最后一位，s.length()位置的答案
        return dp[s.length()];
    }

}
