package com.practice.leetcode.recursive;

/**
 * @author : yueqi.zhou
 * @date : 2020-01-19 15:59
 * describe :
 */
class MergeTwoList {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        ListNode l21 = new ListNode(5);

        l11.next = l12;
        l12.next = l13;

        ListNode resultHead = mergeTwoList(l11,l21);
        while (resultHead != null){
            System.out.println(resultHead.val);
            resultHead = resultHead.next;
        }
    }

    private static ListNode mergeTwoList(ListNode l1,ListNode l2){
        if (l1 == null){
            return l2;
        }

        if (l2 == null){
            return l1;
        }

        if (l1.val <= l2.val){
            ListNode next = l1.next;
            l1.next = mergeTwoList(next,l2);
            return l1;
        }else {
            ListNode next = l2.next;
            l2.next = mergeTwoList(l1,next);
            return l2;
        }
    }

//    private static ListNode mergeTwoListByIterator(ListNode l1,ListNode l2){
//
//    }

    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }
}
