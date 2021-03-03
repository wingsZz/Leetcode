package com.practice.leetcode.recursive;

/**
 * @author : yueqi.zhou
 * @date : 2020-01-17 14:18
 * describe :
 */
class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

//        ListNode head = reverse(node1);
//        while (head != null){
//            System.out.println(head.val);
//            head = head.next;
//        }

        ListNode head2 = reverse2(node1);
        while (head2 != null){
            System.out.println(head2.val);
            head2 = head2.next;
        }
    }

    private static ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode tail = head;
        while (tail.next != null){
            tail = tail.next;
        }

        return reverse(head,tail);
    }

    private static ListNode reverse(ListNode head,ListNode tail){
        if (head == tail){
            return tail;
        }

        ListNode next = head.next;
        head.next = tail.next;
        tail.next = head;
        head = next;
        reverse(head,tail);

        return tail;
    }

    private static ListNode reverse2(ListNode node){
        if(node.next==null){
            return node;
        }

        ListNode newHead = reverse2(node.next);
        node.next.next = node;  //node.next.next 换成 newHead.next 不行，因为node在递归中在追溯上一个节点，仔细体会下
        node.next = null;
        return newHead;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
