package com.guoyi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    /*
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
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

    //办法1 动态规划
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

    //回溯+队列 感觉这个不好
    public List<String> letterCombinations2(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
        List<String> res = new ArrayList<>();
        //先往队列中加入一个空字符
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            //由当前遍历到的字符，取字典表中查找对应的字符串
            String letters = phoneMap.get(digits.charAt(i));
            int size = res.size();
            //计算出队列长度后，将队列中的每个元素挨个拿出来
            for (int j = 0; j < size; j++) {
                //每次都从队列中拿出第一个元素
                String tmp = res.remove(0);
                //然后跟"def"这样的字符串拼接，并再次放到队列中
                for (int k = 0; k < letters.length(); k++) {
                    res.add(tmp + letters.charAt(k));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LetterCombinations combinations = new LetterCombinations();
        List<String> strings = combinations.letterCombinations("2345");
        System.out.println(strings);
    }

    /*

     */

}
