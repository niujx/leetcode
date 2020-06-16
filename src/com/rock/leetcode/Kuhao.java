package com.rock.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yanshi
 * Date: 2020-06-16
 * Time: 09:42
 */
public class Kuhao {
    Map<Character, Character> dict = new HashMap<>();

    {
        dict.put('}', '{');
        dict.put(')', '(');
        dict.put(']', '[');
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (dict.containsKey(c)) {
                if (stack.isEmpty() || dict.get(c) != stack.pop()) {
                    return false;
                }
            } else {
                stack.add(c);
            }

        }

        return stack.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(new Kuhao().isValid("()"));
        System.out.println(new Kuhao().isValid("()[]{}"));
        System.out.println(new Kuhao().isValid("(]"));
        System.out.println(new Kuhao().isValid("([)]"));
        System.out.println(new Kuhao().isValid("{[]}"));


    }
}
