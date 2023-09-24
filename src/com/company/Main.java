package com.company;

import com.guoyi.AddTwoNumbers;
import com.guoyi.BracketMatch;
import com.guoyi.TwoSum;

public class Main {

    public static void main(String[] args) {

//        TwoSum twoSum = new TwoSum();
//        int[] ints = {0,2,7,9,10};
//        int[] ints1 = twoSum.twoSum2(ints, 11);
//        System.out.println(ints1[0]+","+ints1[1]);


//        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
//        AddTwoNumbers.ListNode listNode1 = new AddTwoNumbers.ListNode(1);
//        AddTwoNumbers.ListNode listNode2 = new AddTwoNumbers.ListNode(2, listNode1);
//        AddTwoNumbers.ListNode listNode = new AddTwoNumbers.ListNode(7, listNode2);
//        AddTwoNumbers.ListNode listNode3 = addTwoNumbers.addTwoNumbers(listNode, listNode);
//        System.out.println(listNode3.toString());

        BracketMatch bracketMatch = new BracketMatch();
        boolean valid = bracketMatch.isValid("[[{}]]");
        System.out.println(valid);
    }
}

