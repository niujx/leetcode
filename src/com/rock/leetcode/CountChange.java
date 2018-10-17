package com.rock.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: SICP硬币问题
 * User: yanshi
 * Date: 2018-10-17
 * Time: 11:44
 */
public class CountChange {

    private Map<Integer, Integer> kindOfConins = new HashMap<>();

    {
        kindOfConins.put(1, 1);
        kindOfConins.put(2, 5);
        kindOfConins.put(3, 10);
        kindOfConins.put(4, 25);
        kindOfConins.put(5, 50);
    }

    public int calculate(int amount, int kindOfCoin) {
        if (amount == 0) {
            return 1;
        } else if (amount < 0 || kindOfCoin == 0) {
            return 0;
        } else {
            //1 计算除第一个币值之外的所有组合
            //2 计算减去第一个币值金额之后的所有组合
            //3 两种组合相加
            return calculate(amount, kindOfCoin - 1) +
                    calculate(amount - kindOfConins.get(kindOfCoin), kindOfCoin);
        }l's
    }

    public static void main(String[] args) {
        System.out.println(new CountChange().calculate(6, 5));
        System.out.println(new CountChange().calculate(100, 5));
    }

}
