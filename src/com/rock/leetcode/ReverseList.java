package com.rock.leetcode;

import static java.lang.System.out;

public class ReverseList {

    public void reverse(ListNode1 node){
        ListNode1 pre = null; 
        ListNode1 next;
        while(node!=null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
       
         }

        ListNode1 temp  =  pre;
        while(temp!=null){
            out.println(temp.val);
            temp = temp.next;
        }
    }
    
    public static void main(final String[] args) {
        final ListNode1 node=new ListNode1(1);
        node.next = new ListNode1(2);
        node.next.next = new ListNode1(3);
        node.next.next.next = new ListNode1(4);
        new ReverseList().reverse(node);
    }
    static class ListNode1 {
        int val;
        ListNode1 next;
    
        public ListNode1(final int val){
            this.val =val;
        }
    }
}

