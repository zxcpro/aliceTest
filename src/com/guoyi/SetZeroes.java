package com.guoyi;

import java.util.HashSet;
import java.util.Set;

public class SetZeroes {

    /*
    73、矩阵清零
    给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用原地算法。
    示例1
    输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
    输出：[[1,0,1],[0,0,0],[1,0,1]]
    失例2
    输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
    输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
     */

    /*
    我们用矩阵的第一行和第一列代替方法一中的两个标记数组，这样空间复杂度O(1)
    但这样会导致原数组的第一行和第一列被修改，无法记录它们是否原本包含 0。
    因此我们需要额外使用两个标记变量分别记录第一行和第一列是否原本包含 0。
     */
    public void setZeroes(int[][] matrix) {
        //m是行数，n是一行的列数
        int m = matrix.length, n = matrix[0].length;
        //column是列，row是行
        boolean flagCol0 = false, flagRow0 = false;
        //1、记录第一列是否原本包含0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        //2、记录第一行原本是否包含0
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }

        //3、从第2行、第2列开始遍历是否有0，状态记录在第一行和第一列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        //4、同样从第2行第2列开始遍历赋值
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //5、如果第一列有0，赋值0，否则保持当前结果
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        //6、如果第一行有0，赋值0，否则保持当前结果
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetZeroes setZeroes = new SetZeroes();
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes.setZeroes(matrix);
        System.out.println(matrix);
    }



}
