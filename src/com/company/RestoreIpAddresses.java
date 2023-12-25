package com.company;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {


    /*
    93. 复原 IP 地址
    有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
    例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
    给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
    示例 1：
    输入：s = "25525511135"
    输出：["255.255.11.135","255.255.111.35"]

    https://leetcode.cn/problems/restore-ip-addresses/solutions/100433/hui-su-suan-fa-hua-tu-fen-xi-jian-zhi-tiao-jian-by/
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() > 12 || s.length() < 4) {
            return res;
        }
        backtrack(res, s, 0,4, new ArrayList<String>());
        return res;
    }

    private void backtrack(List<String> res, String s, int index,int residue, List<String> ans){
        if(index == s.length()){
            if(residue == 0 ){
                res.add(String.join(".",ans));
            }
            return;
        }
        for(int i = index;i<index+3;i++){
            if(i>=s.length()){
                break;
            }
            if (residue * 3 < s.length() - i) {
                continue;
            }
            if (judgeIpSegment(s, index, i)) {
                String currentIpSegment = s.substring(index, i + 1);
                ans.add(currentIpSegment);

                backtrack(res,s, i + 1, residue - 1, ans);
                ans.remove(ans.size() -1);
            }
        }
    }

    private boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }

        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }

        return res >= 0 && res <= 255;
    }

}
