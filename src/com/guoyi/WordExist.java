package com.guoyi;

public class WordExist {

    /*
    79 单词搜索
    给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
    https://leetcode.cn/problems/word-search/solutions/2361646/79-dan-ci-sou-suo-hui-su-qing-xi-tu-jie-5yui2/?envType=study-plan-v2&envId=top-100-liked
    思考：
    矩阵不要想太复杂，矩阵.length就是行数，矩阵[0].length就是列数
    把每个元素取出来，和word的第k个字符比较，看能不能一直有匹配得上的结果
    能匹配到最后，就是有解
     */
    public boolean wordExist(char[][] board, String word) {
        char[] charWord = word.toCharArray();
        //board.length 是行数，
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, charWord, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, char[] word, int i, int j, int k) {
        //1、记录解
        if (k == word.length - 1) {
            return true;
        }
        //2、剪枝
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        //3、尝试解，把走过的路重置一下，避免重复使用
        board[i][j] = '\0';
        //回溯可能的解
        boolean res = backtrack(board, word, i + 1, j, k + 1) || backtrack(board, word, i - 1, j, k + 1) ||
                backtrack(board, word, i, j + 1, k + 1) || backtrack(board, word, i, j - 1, k + 1);
        //4、再重置回来
        board[i][j] = word[k];
        return res;

    }

}
