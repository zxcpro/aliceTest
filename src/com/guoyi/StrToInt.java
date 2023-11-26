package com.guoyi;

public class StrToInt {

    public int strToInt(String s) {
        if(s.isEmpty()){
            return 0;
        }
        char[] c = s.trim().toCharArray();
        int res = 0;
        int i = 1,sign = 1;
        if(c[0] == '-'){
            sign = -1;
        }
        else if(c[0]!='+'){
            i = 0;
        }
        for(int j = i;j < c.length;j++){
            if(c[j]<'0'||c[j]>'9') break;
            if(res>Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE/10 && c[j]>'7'){
                return sign == 1? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res = res*10 + (s.charAt(j) - '0');
        }
        return sign *res;
    }

}
