package com.rock.leetcode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yanshi
 * Date: 2020-06-01
 * Time: 14:57
 */
public class Test {


    public String test(String str) {
        char[] chars = str.toCharArray();
        if (chars.length < 2) return str;
        StringBuilder temp = new StringBuilder(String.valueOf(chars[0]));
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                temp.append(chars[i]);
            }
        }
        return temp.toString();
    }

    public static void main(String[] args) {

        System.out.println(new Test().test("DCBBBABBA"));

    }
}
