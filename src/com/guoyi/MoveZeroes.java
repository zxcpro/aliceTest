package com.guoyi;


/**
 * Created by xuanchen.zhao on 2023/9/17.
 */
public class MoveZeroes {

    /*
    283 移动0
    双指针移动零解法
    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    请注意 ，必须在不复制数组的情况下原地对数组进行操作。
    示例 1:
    输入: nums = [0,1,0,3,12]
    输出: [1,3,12,0,0]
     */

    /*
    思路，左指针指向第一个0，右指针指向最后一个0，双指针控制边界，左右差+1就是0的个数（或没0），这样保证0都被换在差值里
    1、起始双指针一起开始
    2、右指针右移找到第一个非0
    3、左右值交换，保证左指针此时为非0，左指针右移指向0（如果没有0，左右指针会一直在一起，不会有差）
    4、右指针继续右移，找下一个非0
    */
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {0, 1, 3, 2};
        moveZeroes.moveZeroes(nums);
    }




    //以下写着玩，不如上面好
    /*
    思考：双指针+复制数值，先把非0的按照顺序记录下来，后面的补0
    循环两次，先记录非0，再补充0
     */
    public void moveZeroes1(int[] nums) {
        if (nums == null) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[left]
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for (int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    //写着玩，不推荐，时间复杂度不好
    //冒泡排序法，每次把最大/最小/目标数升到最后一位，每循环一次排好最后一位。
    //升序条件改成==0，也可以做移动零
    public void moveZeroesPop(int[] nums) {
        //需要循环数组长度那么多遍
        for (int i = 0; i < nums.length; i++) {
            //每遍需要让当前的这个数字，向后移动到移动不了为止
            for (int j = 0; j < nums.length - 1 - i; j++) {
                //下面注释的行，这是升序的冒泡排序
                //if(nums[j] > nums[j+1]){
                if (nums[j] == 0) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

}
