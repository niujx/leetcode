package com.rock.leetcode.dp;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yanshi
 * Date: 2020-05-28
 * Time: 14:50
 */
public class Fib {

    //简单递归
    public int fib1(int i) {
        if (i == 0) return 0;
        if (i == 1) return 1;
        return fib1(i - 1) + fib1(i - 2);
    }


    //递归加记忆表
    public int fib2(int i) {
        return fib2(i, new int[i + 1]);
    }

    private int fib2(int i, int[] array) {
        if (i == 0) return 0;
        if (i == 1) return 1;
        if (array[i] == 0) {
            array[i] = fib2(i - 1, array) + fib2(i - 2, array);
        }

        return array[i];
    }

    //动态规划
    public int fib3(int i) {
        if (i < 2) return i;
        int[] array = new int[i + 1];
        array[0] = 0;
        array[1] = 1;
        for (int z = 2; z <= i; z++) {
            array[z] = array[z - 1] + array[z - 2];
        }
        return array[i];
    }

    //动态规划优化
    public int fib4(int i) {
        if (i < 2) return i;
        int pre = 0;
        int prepre = 1;
        int temp;
        for (int z = 0; z < i; z++) {
            temp = pre;
            pre = pre + prepre;
            prepre = temp;
        }
        return pre;
    }


    public static void main(String[] args) {
        System.out.println(new Fib().fib1(20));
        System.out.println(new Fib().fib2(20));
        System.out.println(new Fib().fib3(20));
        System.out.println(new Fib().fib4(20));
    }
}
