package com.guoyi;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    /*
    763 划分字母区间  贪心
    给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
    注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
    返回一个表示每个字符串片段的长度的列表。
    示例 1：
    输入：s = "ababcbacadefegdehijhklij"
    输出：[9,7,8]
    解释：
    划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
    每个字母最多出现在一个片段中。
    像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
    示例 2：
    输入：s = "eccbbbbdec"
    输出：[10]
    */
    /*
    思路
    1、标出每个字母出现的最后的位置，记录下来
    2、遍历s，记录当前位置i前所有字母的最后位置，判断当前位置是否是记录的最后位置，符合即可以分割。
     */
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;
        List<Integer> partition = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end,last[s.charAt(i) - 'a']);
            if(end == i){
                partition.add(end-start+1);
                start = end+1;
            }
        }
        return partition;
    }
}
