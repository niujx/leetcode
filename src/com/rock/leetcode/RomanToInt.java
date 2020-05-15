package com.rock.leetcode;

public class RomanToInt {

    private int getCode(char c){
        switch(c){
            case 'I': return 1;
            case 'V':return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M':return 1000;
            default : return 0;
        }
    }

    public int romanToInt(String s) { 
        char[] vals = s.toCharArray();
        int res=getCode(vals[0]);
        for(int i=1;i<vals.length;i++){
            int p = 0;
            int pre = getCode(vals[i-1]);
            int current = getCode(vals[i]);
            if(pre < current){
                p =-2 *pre;
            }
            res = res +p+ current;
        }

        
     return res;   
    }

    public static void main(String[] args){
        System.out.println(new RomanToInt().romanToInt("MCMXCIV"));
    }

}