package com.guoyi;

public class Rotate {

    /*
    48. 旋转图像
    给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
    你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
    示例 1：
    输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
    输出：[[7,4,1],[8,5,2],[9,6,3]]
    示例 2：
    输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
    输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

    思考：
    matrix[i][j] ->  matrix[j][n-i-1]，matrix[i][j]移动90度到matrix[j][n-i-1]的位置
    要在原地，那么不能引入新的矩阵来存储遍历，需要考虑这个值赋值过去新位置后，新位置的值放在哪里，怎么循环遍历以及停止。1-3-9-7-1，循环一次，所以循环的条件也是取1/4循环，就可以把所有值赋值一遍。

    1、如果是奇数，中心不变，以n为3举例，12即为1/4，n为4时，1256位即为1/4。
    2、暂存tmp=matrix[i][j]
    matrix[i][j]←matrix[n−1−j][i]←matrix[n−1−i][n−1−j]←matrix[j][n−1−i]←tmp
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate.rotate(matrix);
    }
}
