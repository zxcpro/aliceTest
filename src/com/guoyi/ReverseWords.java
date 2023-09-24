package com.guoyi;

/**
 * Created by xuanchen.zhao on 2023/9/17.
 */
public class ReverseWords {

    /*
    151. 反转字符串中的单词
    给你一个字符串 s ，请你反转字符串中 单词 的顺序。
    单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
    返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
    注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。

    示例 1：
    输入：s = "the sky is blue"
    输出："blue is sky the"
    示例 2：
    输入：s = "  hello world  "
    输出："world hello"
    解释：反转后的字符串中不能存在前导空格和尾随空格。
     */

    /*
    方法一：双指针
    倒序遍历字符串 sss ，记录单词左右索引边界 iii , jjj 。
    每确定一个单词的边界，则将其添加至单词列表 resresres 。
    最终，将单词列表拼接为字符串，并返回即可。
    复杂度分析：
    时间复杂度 O(N) ： 其中 N为字符串 sss 的长度，线性遍历字符串。
    空间复杂度 O(N) ： 新建的 StringBuilder(Java) 中的字符串总长度 ≤N ，占用 O(N) 大小的额外空间。
     */
    public String reverseWords(String s) {
        s = s.trim();                                    // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;     // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while (i >= 0 && s.charAt(i) == ' ') i--;     // 跳过单词间空格
            j = i;                                       // j 指向下个单词的尾字符
        }
        return res.toString().trim();                    // 转化为字符串并返回
    }




}
