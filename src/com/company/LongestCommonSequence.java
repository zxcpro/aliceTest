package com.company;

public class LongestCommonSequence {

    public int longestCommonSubsequence(String text1, String text2) {

        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();


        int[][] dp = new int[charArray1.length][charArray2.length];

        //使用dp[i][j]表示text1从开始到i位置 与 text2从开始到j位置的最大共同子序列
        //如果当前字符相同，则dp[i][j] = dp[i-1][j-1] + 1

        //如果不同，则dp[i][j] = max(dp[i-1][j] + dp[i][j-1])
        for (int i = 0; i < charArray1.length; i++) {
            for (int j = 0; j < charArray2.length; j++) {
                if (charArray1[i] == charArray2[j]) {
                    dp[i][j] = getVal(dp,i-1, j-1) + 1;
                } else {
                    dp[i][j] = Math.max(getVal(dp, i-1, j), getVal(dp, i, j-1));
                }
            }
        }


        return dp[charArray1.length - 1][charArray2.length - 1];

    }

    private int getVal(int[][] dp, int row, int col) {
        if (row < 0 || col < 0) {
            return 0;
        }
        return dp[row][col];
    }

}
