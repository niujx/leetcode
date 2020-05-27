package com.rock.leetcode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yanshi
 * Date: 2020-05-20
 * Time: 18:49
 */
public class BusyStudent {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {

        int busyCount = 0;
        for (int i = 0; i < startTime.length; i++) {
            int s = startTime[i];
            int e = endTime[i];
            if (e - s <= queryTime) {
                busyCount++;
            }
        }
        return busyCount;
    }

    public static void main(String[] args) {

    }

}
