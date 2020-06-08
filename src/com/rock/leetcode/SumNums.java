package com.rock.leetcode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yanshi
 * Date: 2020-06-02
 * Time: 14:38
 */
public class SumNums {

    public int sumNums(int n) {
        int sum = 0;
        boolean flag = n > 0 && (sum = n + sumNums(n - 1)) > 0;
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(new SumNums().sumNums(9));
    }
}
