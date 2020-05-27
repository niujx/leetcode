package com.rock.leetcode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yanshi
 * Date: 2020-05-21
 * Time: 17:41
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if(s == null || s.equals("")){
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] result = new int[2];

        for(int i = 0; i<s.length(); i++) dp[i][i] = true;

        for(int i = s.length()-1; i>=0; i--){
            for(int j = i+1; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j)) {
                    if(j-i == 1){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else{
                    dp[i][j] = false;
                }
                if(dp[i][j]){
                    if(result[1]-result[0] <= j - i){
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
        }
        return s.substring(result[0],result[1]+1);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("babad"));
        System.out.println(new LongestPalindrome().longestPalindrome("cbbd"));
        System.out.println(new LongestPalindrome().longestPalindrome("ac"));
        System.out.println(new LongestPalindrome().longestPalindrome("ccd"));

    }

}
