package com.sc.util;

import java.util.Scanner;

public class InputUtil {
    //键盘输入对象
    static Scanner sc = new Scanner(System.in);
    //static静态方法不用再修改的方法；属于类，不用创建对象调用
    //接收String类型的方法
    public static String getString() {
        //接收输入结果
        String str = sc.next();
        return str;
    }

    //接收int类型的方法
    public static int getInt() {
        //接收输入结果
        int i = sc.nextInt();
        return i;
    }
}
