package com.company;

import java.util.ArrayList;
import java.util.List;

public class Salary {

    public static void main(String[] args) {

        enumSolutions();

    }

    //月薪base，输入190期权价格

    private static void enumSolutions() {
        List<SalarySolution> solutions = new ArrayList<>();

        double yPackage = 200.0;
        //200总包
        solutions.add(new SalarySolution(yPackage, 0.8, 190.0));
        solutions.add(new SalarySolution(yPackage, 0.8, 140.0));
        solutions.add(new SalarySolution(yPackage, 0.7, 190.0));
        solutions.add(new SalarySolution(yPackage, 0.7, 140.0));
        solutions.add(new SalarySolution(yPackage, 0.6, 190.0));
        solutions.add(new SalarySolution(yPackage, 0.6, 140.0));
        solutions.add(new SalarySolution(yPackage, 0.5, 190.0));
        solutions.add(new SalarySolution(yPackage, 0.5, 140.0));

        yPackage = 190.0;
        //190总包
        solutions.add(new SalarySolution(yPackage, 0.8, 190.0));
        solutions.add(new SalarySolution(yPackage, 0.8, 140.0));
        solutions.add(new SalarySolution(yPackage, 0.7, 190.0));
        solutions.add(new SalarySolution(yPackage, 0.7, 140.0));
        solutions.add(new SalarySolution(yPackage, 0.6, 190.0));
        solutions.add(new SalarySolution(yPackage, 0.6, 140.0));
        solutions.add(new SalarySolution(yPackage, 0.5, 190.0));
        solutions.add(new SalarySolution(yPackage, 0.5, 140.0));

        yPackage = 180.0;
        //180总包
        solutions.add(new SalarySolution(yPackage, 0.8, 190.0));
        solutions.add(new SalarySolution(yPackage, 0.8, 140.0));
        solutions.add(new SalarySolution(yPackage, 0.7, 190.0));
        solutions.add(new SalarySolution(yPackage, 0.7, 140.0));
        solutions.add(new SalarySolution(yPackage, 0.6, 190.0));
        solutions.add(new SalarySolution(yPackage, 0.6, 140.0));
        solutions.add(new SalarySolution(yPackage, 0.5, 190.0));
        solutions.add(new SalarySolution(yPackage, 0.5, 140.0));

        yPackage = 170.0;
        //170总包
        solutions.add(new SalarySolution(yPackage, 0.8, 190.0));
        solutions.add(new SalarySolution(yPackage, 0.8, 140.0));
        solutions.add(new SalarySolution(yPackage, 0.7, 190.0));
        solutions.add(new SalarySolution(yPackage, 0.7, 140.0));
        solutions.add(new SalarySolution(yPackage, 0.6, 190.0));
        solutions.add(new SalarySolution(yPackage, 0.6, 140.0));
        solutions.add(new SalarySolution(yPackage, 0.5, 190.0));
        solutions.add(new SalarySolution(yPackage, 0.5, 140.0));

        yPackage = 160.0;
        //160总包
        solutions.add(new SalarySolution(yPackage, 0.8, 190.0));
        solutions.add(new SalarySolution(yPackage, 0.8, 140.0));
        solutions.add(new SalarySolution(yPackage, 0.7, 190.0));
        solutions.add(new SalarySolution(yPackage, 0.7, 140.0));
        solutions.add(new SalarySolution(yPackage, 0.6, 190.0));
        solutions.add(new SalarySolution(yPackage, 0.6, 140.0));
        solutions.add(new SalarySolution(yPackage, 0.5, 190.0));
        solutions.add(new SalarySolution(yPackage, 0.5, 140.0));

        System.out.println("总包,期权价格,现金比例,月base,每年归属");
        for (SalarySolution s : solutions) {
            s.printCSV();
        }
    }


    private static class SalarySolution {

        public static final int SALARY_MONTH_PER_YEAR = 15;
        public static final double USE_TO_CNY_RATE = 6.69;

        private double yPackage;
        private double cashRatio;
        private double stockPrice; //USD为单位

        public SalarySolution(double yPackage, double cashRatio, double stockPrice) {
            this.yPackage = yPackage;
            this.cashRatio = cashRatio;
            this.stockPrice = stockPrice;
        }

        public double basePerMonth() {
            return yPackage * cashRatio / SALARY_MONTH_PER_YEAR;
        }

        public double stockPerYear() {
            return (yPackage * 10000 * (1 - cashRatio) / (stockPrice * USE_TO_CNY_RATE));
        }

        public void print() {
            System.out.println("薪资方案 总包：" + yPackage + " 现金比例：" + cashRatio  + " 期权价格:" + stockPrice);
            System.out.println("月薪:" + basePerMonth() + " 年归属期权数:" + stockPerYear());
        }

        public void printCSV() {
            System.out.println(yPackage + "," + stockPrice + "," + cashRatio + ","
                    + String.format("%,.2f",basePerMonth()) + ","
                    + String.format("%,.2f",stockPerYear()));
        }
    }

}
