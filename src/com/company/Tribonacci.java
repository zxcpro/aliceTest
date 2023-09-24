package com.company;

class Tribonacci {

    public static void main(String[] args) {
        System.out.println(new Tribonacci().tribonacci(4));
    }

    public int tribonacci(int n) {

        //记录前3个计算的结果 n-2  n-1  n-3
        //对于每个数字，取数组中的三个数相加，之后把当前数字加到队列末尾
        ThreeSizeQueue queue = new ThreeSizeQueue();

        //依次从0开始求解到n
        for(int i = 0; i <= n; i++) {
            int result;

            if(i == 0) {
                result = 0;
            } else if(i == 1 || i == 2) {
                result = 1;
            } else {
                result = queue.sum();
            }
            queue.add(result);
        }
        return queue.last();
    }

    private static class ThreeSizeQueue {

        private int p;
        private int q;
        private int r;

        public void add(int result) {
            p = q;
            q = r;
            r = result;
        }

        public int sum() {
            return p + q + r;
        }

        public int last() {
            return r;
        }
    }
}
