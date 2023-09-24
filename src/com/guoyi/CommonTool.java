package com.guoyi;

public class CommonTool {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {}

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class ListNodeTest{
        int value;
        ListNodeTest next;

        public ListNodeTest(){}

        public ListNodeTest(int val){
            value = val;
        }

        public ListNodeTest(int val,ListNodeTest nextListNode){
            int value = val;
            next = nextListNode;
        }

    }
}
