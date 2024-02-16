package com.guoyi;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    /*
    54 螺旋矩阵
    给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
    示例 1：
    输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
    输出：[1,2,3,6,9,8,7,4,5]
    示例 2：
    输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    输出：[1,2,3,4,8,12,11,10,9,5,6,7]

    思考
    1、空值处理： 当 matrix 为空时，直接返回空列表 [] 即可。
    2、初始化： 矩阵 左、右、上、下 四个边界 l , r , t , b ，用于打印的结果列表 res 。
    3、循环打印：
    “从左向右、从上向下、从右向左、从下向上” 四个方向循环打印。
    根据边界打印，即将元素按顺序添加至列表 res 尾部。
    边界向内收缩 1 （代表已被打印）。
    判断边界是否相遇（是否打印完毕），若打印完毕则跳出。
    4、返回值： 返回 res 即可。
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0){
            return new ArrayList<>();
        }
        int l, r, t, b;
        l = 0;
        t = 0;
        r = matrix[0].length - 1;
        b = matrix.length - 1;
        List<Integer> res = new ArrayList<>((r+1)*(b+1));
        while(true){
            for(int i = l;i<=r;i++){
                res.add(matrix[t][i]);
            }
            if(++t>b) break;

            for (int i = t;i<=b;i++){
                res.add(matrix[i][r]);
            }
            if(--r<l) break;

            for(int i = r;i>=l;i--){
                res.add(matrix[b][i]);
            }
            if(--b<t) break;

            for(int i = b;i>=t;i--){
                res.add(matrix[i][l]);
            }
            if(++l>r) break;
        }
        return res;
    }


    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> integers = spiralOrder.spiralOrder(matrix);
        System.out.println(integers);

    }
}
