package com.rock.leetcode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yanshi
 * Date: 2020-06-16
 * Time: 10:04
 */
public class RemoveDuplicates {

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (char a : S.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(a);
            } else if (a == stack.peek()) {
                stack.pop();
            } else {
                stack.add(a);
            }
        }
        Character[] characters = stack.toArray(new Character[0]);
        StringBuilder a = new StringBuilder();
        for (Character c : characters) {
            a.append(c);
        }
        return a.toString();
    }

    public String removeDuplicates2(String S) {
        char[] stack = S.toCharArray();
        int top = -1;
        for (char c : stack) {
            if (top > -1 && c == stack[top]) {
                top--;
            } else {
                stack[++top] = c;
            }
        }
        return new String(stack, 0, top + 1);
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates("abbaca"));
        System.out.println(new RemoveDuplicates().removeDuplicates2("abbaca"));

    }
}
