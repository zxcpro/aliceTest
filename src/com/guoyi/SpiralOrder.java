package com.guoyi;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

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
