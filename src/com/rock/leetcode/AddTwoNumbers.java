package com.rock.leetcode;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode root = new ListNode(0);
        ListNode current = root;
        int crray = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;

            int sum = v1 + v2 + crray;
            if (sum >= 10) {
                crray = 1;
                sum = sum % 10;
            } else {
                crray = 0;
            }

            current.next = new ListNode(sum);
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (crray > 0) {
            current.next = new ListNode(crray);
        }
        return root.next;
    }

     public static void main(String[] args) {

        ListNode node=new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);

        ListNode node1=new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode n = addTwoNumbers.addTwoNumbers(node,node1);
        System.out.println(n.val);
        System.out.println(n.next.val);
        System.out.println(n.next.next.val);
        
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

}
