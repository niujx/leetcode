package com.rock.leetcode;

/**
 *  判断回文数字
 */
public class IsPralindrome {

    public boolean isPralindrome(int x){
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int res = 0;
        while (x > res) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return res == x || res/10 == x;
    }
    
    public static void main(String [] args){
        System.out.println( new IsPralindrome().isPralindrome(11211));
    }
}