package com.guoyi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    /*
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
    给出数字到字母的映射如下（与电话按键9宫格相同，1没有任何字母，7、9对4个，其余对3个字母）。
    示例 1：
    输入：digits = "23"
    输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     */

    public static Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    //回溯算法  digits 是数字串
    /*
    时间复杂度：O(3^m * 4^n)，m是3个字母的数字个数，n是4个字母的数字个数
    空间复杂度：O(m+n)，其中 m 是输入中对应 3 个字母的数字个数，n 是输入中对应 4 个字母的数字个数
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0) {
            return res;
        }
        backtrack(res, digits, 0, new StringBuffer());
        return res;
    }

    public void backtrack(List<String> res, String digits, int index, StringBuffer letter) {
        if (index == digits.length()) {
            res.add(letter.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                letter.append(letters.charAt(i));
                backtrack(res, digits, index + 1, letter);
                letter.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinations combinations = new LetterCombinations();
        List<String> strings = combinations.letterCombinations("2345");
        System.out.println(strings);
    }

}
