package com.company;

import java.util.*;

public class PhoneNumIterate17 {

    final char[][] mapping = {
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();

        char[] chars = digits.toCharArray();
        System.out.println("chars:"+ Arrays.toString(chars));
        iterateString(chars, 0, list, sb);
        return list;
    }

    private void iterateString(char[] digits, int charIndex, List<String> result, StringBuilder sb) {
        if (charIndex > digits.length - 1) {
            return;
        }

        //逐个遍历字母
        int currentDigit = Integer.parseInt(String.valueOf(digits[charIndex]));
        char[] characterOfDigit = mapping[currentDigit - 2];
        for (char c : characterOfDigit) {
            sb.append(c);
            if (charIndex == digits.length - 1) {
                result.add(sb.toString());
            }
            iterateString(digits, charIndex + 1, result, sb);
            sb.deleteCharAt(charIndex);
        }
    }


    public static void main(String[] args) {
        System.out.println(new PhoneNumIterate17().letterCombinations("23"));
    }
}
