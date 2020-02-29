package com.my.demo5.decimal;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Decimal {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("1.22");
        System.out.println("bigDecimal is:"+bigDecimal);

        BigDecimal a = new BigDecimal("1.11");
        BigDecimal b = new BigDecimal("2.22");
        BigDecimal ab = a.add(b);
        BigDecimal subtract = a.subtract(b);
        BigDecimal multiply = a.multiply(b);
        BigDecimal divide = b.divide(a);
        System.out.println("a/b="+divide);
        System.out.println("a*b="+multiply);
        System.out.println("a+b="+ab);
        System.out.println("a-b="+subtract);
        System.out.println("============");
        BigDecimal divide1 = a.divide(b, 2);
        BigDecimal divide2 = a.divide(b, 2, 3);
        System.out.println(divide2);
        System.out.println(divide1);
        System.out.println("================");
        NumberFormat currency = NumberFormat.getCurrencyInstance();//货币格式化引用
        NumberFormat percent = NumberFormat.getPercentInstance();//百分比格式化引用
        percent.setMaximumFractionDigits(3);//百分比小数点最多三位
        BigDecimal loanAmount = new BigDecimal("15000.48");//贷款金额
        BigDecimal interestRate = new BigDecimal("0.008");//利率
        BigDecimal interest = loanAmount.multiply(interestRate);
        System.out.println("贷款金额：\t"+currency.format(loanAmount));
        System.out.println("利率:\t"+percent.format(interestRate));
        System.out.println("利息:\t"+currency.format(interest));
        System.out.println("====比较大小======");
        BigDecimal a1 = new BigDecimal("1");
        BigDecimal b1 = new BigDecimal("2");
        BigDecimal c1 = new BigDecimal("1");
        int result1 = a1.compareTo(b1);
        int result2 = a1.compareTo(c1);
        int result3 = b1.compareTo(c1);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println("===保留两位小数====");
        BigDecimal bd = new BigDecimal("3.2255468");
        BigDecimal s = bd.setScale(2, BigDecimal.ROUND_UP);
        System.out.println(s);


    }
}
