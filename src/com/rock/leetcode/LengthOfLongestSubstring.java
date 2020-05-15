package com.rock.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yanshi
 * Date: 2019-12-13
 * Time: 17:15
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串
 * <p>
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> sequence = new HashSet<>();
        int length = 0, start = 0, end = 0, size = s.length();
        while (start < size && end < size) {
            if(!sequence.contains(s.charAt(end))){
                sequence.add(s.charAt(end++));
                length = Math.max(length,end-start);
            }else{
                sequence.remove(s.charAt(start++));
            }
        }

        return length;

    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("bbbbb"));
    }
}
