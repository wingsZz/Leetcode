package com.practice.leetcode;

/**
 * @author : yueqi.zhou
 * @date : 2020-04-27 09:20
 * describe :
 */
class SumTwoNum {

    public static void main(String[] args) {
        Node num10 = new Node();
        num10.data = 3;
        Node num11 = new Node();
        num11.data = 2;
        Node num12 = new Node();
        num12.data = 3;
        num10.next = num11;
        num11.next = num12;

        Node num20 = new Node();
        num20.data = 7;
        Node num21 = new Node();
        num21.data = 7;
        Node num22 = new Node();
        num22.data = 6;
        num20.next = num21;
        num21.next = num22;

        Node resultHead = sum(num10, num20);
        while (resultHead != null) {
            System.out.println("result = " + resultHead.data);
            resultHead = resultHead.next;
        }
    }

    public static Node sum(Node num1, Node num2) {
        Node head = new Node();
        int carry = 0;
        head.data = num1.data + num2.data;
        if (head.data >= 10) {
            carry = 1;
            head.data -= 10;
        }

        Node temp = head;
        while (num1.next != null || num2.next != null || carry > 0) {
            Node next = new Node();
            if (num1.next == null && num2.next == null) {
                next.data = carry;
            } else if (num2.next == null) {
                next.data = num1.next.data + carry;
                num1 = num1.next;
            } else if (num1.next == null) {
                next.data = num2.next.data + carry;
                num2 = num2.next;
            } else {
                next.data = num1.next.data + num2.next.data + carry;
                num1 = num1.next;
                num2 = num2.next;
            }
            if (next.data >= 10) {
                carry = 1;
                next.data -= 10;
            } else {
                carry = 0;
            }
            temp.next = next;
            temp = temp.next;
        }
        return head;
    }


    private static class Node {
        int data;
        Node next;
    }
}
