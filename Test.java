package com.example.wb.tkandroid.modules.fabu.activity;

/**
 * Created by mac on 2019/7/23.
 */

public class Test {
    public static void main(String[] args) {
        String email = "940422068@qq.com";
        boolean res = validateEmail(email);
        System.out.println(""+res);
        String newEmail = changeEmail(email);
        System.out.println(newEmail);
    }

    public static boolean validateEmail(String email) {
         boolean flag = false;
         int pos = email.indexOf("@");
         if (pos == -1 || pos == 0 || pos == email.length() - 1) {
            return false;
         }
         String[] strings = email.split("@");
         if (strings.length != 2) {// 如果邮箱不是xxx@xxx格式
            return false;
         }
         CharSequence cs = strings[0];
         for (int i = 0; i < cs.length(); i++) {
             char c = cs.charAt(i);
             if (!Character.isLetter(c) && !Character.isDigit(c)) {
                return false;
             }
         }
         pos = strings[1].indexOf(".");// 如果@后面没有.，则是错误的邮箱。
         if (pos == -1 || pos == 0 || pos == email.length() - 1) {
            return false;
         }
         strings = strings[1].split(".");
         for (int j = 0; j < strings.length; j++) {
             cs = strings[j];
             if (cs.length() == 0) {
                 return false;
             }
             for (int i = 0; i < cs.length(); i++) {//如果保护不规则的字符，表示错误
                 char c = cs.charAt(i);
                 if (!Character.isLetter(c) && !Character.isDigit(c)) {
                    return false;
                 }
             }
         }
        return true;
    }

    public static String changeEmail(String email) {
        String[] strings = email.split("@");
        StringBuilder builder = new StringBuilder();
        String cs = strings[0];
        for (int i = 0; i < cs.length(); i++) {
            builder.append("*");
        }
        String[] strings_2 = strings[1].split("\\.");
        String bs = strings_2[0];
        builder.append("@");
        for (int i = 0; i < bs.length(); i++) {
            builder.append("*");
        }
        builder.append(".");
        builder.append(strings_2[1]);
        return builder.toString();
    }
}
