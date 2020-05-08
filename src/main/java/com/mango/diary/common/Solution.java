package com.mango.diary.common;

/**
 * Author: Mango Cheng
 * Date: 2019/12/18
 * Time: 23:00
 * Description:
 */
public class Solution {

    public static void reverseString(int left,int right,char[] s){

        if(left>=right){
            return;
        }

        char temp=s[left];
        s[left++]=s[right];
        s[right--]=temp;
        reverseString(left,right,s);

    }

    public static void main(String[] args){

        char[] s = {'H','e','l','l','0'};
        reverseString(0,s.length-1,s);
        System.out.println(s);

    }
}
