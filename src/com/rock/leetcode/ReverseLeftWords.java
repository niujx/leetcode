package com.rock.leetcode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yanshi
 * Date: 2020-05-20
 * Time: 18:58
 */
public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        char[] temp = new char[chars.length];
        int j = 0,z = chars.length-n;
        for (int i = 0; i < chars.length; i++) {
            if (i < n) {
                temp[z+i] = chars[i];
            } else {
                temp[j++] = chars[i];
            }
        }
        return new String(temp);

    }

    public static void main(String[] args) {
        System.out.println(new ReverseLeftWords().reverseLeftWords("abcdefg", 2));
        System.out.println(new ReverseLeftWords().reverseLeftWords("lrloseumgh", 6));

    }
}
