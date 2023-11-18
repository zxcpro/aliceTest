package com.guoyi;

public class FindMedianSortedArrays {

    /*
    4. 寻找两个正序数组的中位数
    给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
    算法的时间复杂度应该为 O(log (m+n)) 。
    示例 1：
    输入：nums1 = [1,3], nums2 = [2]
    输出：2.00000
    解释：合并数组 = [1,2,3] ，中位数 2
    示例 2：
    输入：nums1 = [1,2], nums2 = [3,4]
    输出：2.50000
    解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     */

    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        //left和right是标记2个中位数，偶数是len/2和 len/2+1都用，奇数是（len+1）/2 ，也就是int(len/2 ) + 1，right
        int left = -1, right = -1;
        //aStart 和 bStart 分别表示当前指向 A 数组和 B 数组的位置
        //如果 aStart 还没有到最后并且此时 A 位置的数字小于 B 位置的数组，那么就可以后移了。也就是aStart＜m&&A[aStart]< B[bStart]
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        //& 与运算，如果相对应位都是1，则结果为1，判断最后1位是不是1，0就是偶数，要加（）不然会优先算后面的等式
        //偶数就是两个中位数的平均数，奇数就是int(len/2 ) + 1的那个数，也就是right
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }

}
