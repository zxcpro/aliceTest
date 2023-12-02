package com.guoyi;

public class LongestCommonPrefix {
    /*
    14 最长公共子串
     */

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String longestCommonPrefixStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            longestCommonPrefixStr = getLongestCommonPrefix(longestCommonPrefixStr, strs[i]);
        }
        return longestCommonPrefixStr;
    }

    private String getLongestCommonPrefix(String longestCommonPrefixStr, String str) {
        char[] strCharArray = str.toCharArray();
        char[] longestCommonPrefixChar = longestCommonPrefixStr.toCharArray();
        int i = 0;
        //此处注意，只需要循环两者最短次数即可，超过的长度另一个就是溢出了
        for (; i < longestCommonPrefixStr.length() && i < str.length(); i++) {
            if (strCharArray[i] != longestCommonPrefixChar[i]) {
                break;
            }
        }
        //一定比当前的最长公共前缀短，所以用它来截取即可
        return longestCommonPrefixStr.substring(0, i);
    }
}
