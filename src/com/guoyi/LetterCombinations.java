package com.guoyi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    /*
    17 电话号码的字母组合
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
    给出数字到字母的映射如下（与电话按键9宫格相同，1没有任何字母，7、9对4个，其余对3个字母）。
    示例 1：
    输入：digits = "23"
    输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     */

    //回溯算法  digits 是给出的数字串
    /*
    时间复杂度：O(3^m * 4^n)，m是3个字母的数字个数，n是4个字母的数字个数
    空间复杂度：O(m+n)，其中 m 是输入中对应 3 个字母的数字个数，n 是输入中对应 4 个字母的数字个数
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        backtrack(res, digits, 0, new StringBuilder());
        return res;
    }

    public void backtrack(List<String> res, String digits, int index, StringBuilder builder) {
        //index是当前数字index，记录解的条件，记录解
        if (index == digits.length()) {
            res.add(builder.toString());
        }
        char numChar = digits.charAt(index);
        String letters = phoneMap.get(numChar);
        //这里是回溯
        for (int i = 0; i < letters.length(); i++) {
            //尝试这一步和下一步
            builder.append(letters.charAt(i));
            //index+1，去尝试下一个数字
            backtrack(res, digits, index + 1, builder);
            //回退
            //当记录解回到上一步，或者i走完回到上一步，都会走到这里的回退逻辑
            builder.deleteCharAt(index);
        }
    }

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

    public static Map<Character,String> map = new HashMap<Character, String>(){{put('2',"abc");}};

    public static void main(String[] args) {
        LetterCombinations combinations = new LetterCombinations();
        List<String> strings = combinations.letterCombinations("234");
        System.out.println(strings);
    }



    /* 回溯模版代码
    void backtrack(State state,List<Choice> choices,List<State> res){
        //1、记录解
        if(isSolution(state)){
            res.add(state);
            return;
        }
        for(Choice choice :choices){
            //2、剪枝，判断选择是否和特殊要求
            if(isVaild(state,choice)){
                //3、尝试
                makeChoice(state,choice);
                backtrack(state,choices,res);
                //4、回退
                undoChoice(state, choice);
            }
        }
    }
     */


}
