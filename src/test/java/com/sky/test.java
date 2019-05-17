package com.sky;


import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Date;


public class test {
    public static void main(String[] args) {
        //String aa = "3";
        //boolean s = isNumber(aa);
        // System.out.println(s);
        //teststring();
        //test2();
        //test3();
        test4();
    }


    //金额验证
    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // 判断小数点后2位的数字的正则表达式
        Matcher match = pattern.matcher(str);
        if (match.matches() == false) {
            return false;
        } else {
            return true;
        }
    }


    public static void teststring() {
        String s = "(0.83,2。9394]";
        String s1 = s.substring(0, 1);
        int j = s.indexOf(",");
        String s2 = s.substring(1, j);
        String s3 = s.substring(j + 1, s.length() - 1);
        String s4 = s.substring(s.length() - 1, s.length());

        System.out.println("s1:" + s1 + " s2:" + s2 + " s3:" + s3 + " s4:" + s4);


    }


    public static void test2() {
        List<String> lis = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String a = new String();
            a = "MAX1234" + i + ", ";
            lis.add(a);
        }

        StringBuffer sql = new StringBuffer();
        for (String list : lis) {
            sql.append(list);
        }

        int leng = sql.length();
        //sql.replace(98,100," ");
        sql.replace(sql.length() - 2, sql.length() - 1, " ");

        System.out.println(sql + "    leng:" + leng);
    }

    public static void test3() {
        String date1 = "1987-01-01";

        String date2 = "2019-04-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d3 = sdf.parse(date2, new ParsePosition(0));
        Date d1 = new Date();

        Date d2 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String cc = format.format(d1);

        long daysBetween = (d2.getTime() - d3.getTime()) / (3600 * 24 * 1000);

        System.out.println("1987-01-01 与 2010-01-01 相隔 " + daysBetween + " 天");
        System.out.println(cc);

    }

    public static void test4(){
        String a = "";
        a = a.replace("/",".");
        System.out.println(a+  "   " + a );
    }
}
