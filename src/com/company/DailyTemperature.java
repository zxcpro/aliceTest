package com.company;

import java.util.Stack;

public class DailyTemperature {

    public int[] daily(int[] temperatures) {

        int[] ans = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        //栈中只保存未找到比其大的日期范围，保存index
        stack.push(0);


        for (int i = 1; i < temperatures.length; i++) {

            //如果当前温度低于或等于栈顶温度，则入栈
            if (stack.isEmpty() || temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
                continue;
            }

            //如果高于栈顶温度，则出栈栈顶温度，讲其位置的ans更新
            //继续判断，是否比上一个数字要大，直到栈顶元素比当前元素大
            while(!stack.isEmpty() &&
                    temperatures[i] > temperatures[stack.peek()]) {
                int currentPeekIndex = stack.peek();
                ans[currentPeekIndex] = i - currentPeekIndex;
                stack.pop();
            }
        }

        return ans;
    }

}
