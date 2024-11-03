package com.guoyi;

import java.util.HashMap;

public class IsAnagram {
    //242 有效的字母异位词

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int len1 = s.length();
        int len2 = t.length();
        if (len1 == len2) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < len1; i++) {
                if (map.get(s.charAt(i)) == null) {
                    map.put(s.charAt(i), 1);
                } else{
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                }
                //以上可以一行代替
                //map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
            }

            for (int i = 0; i < len2; i++) {
                if (map.get(t.charAt(i)) == null) {
                    map.put(t.charAt(i), -1);
                } else{
                    map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                }
            }

            for (int val : map.values()) {
                if (val != 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
