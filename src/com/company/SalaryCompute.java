package com.company;

public class SalaryCompute {

    public static final double BYTE_OFFICIAL_PRICE = 190;
    public static final double BYTE_FACT_PRICE = 140;
    public static final double USD_TO_CNY_RATE = 6.66;
    public static final int TEN_THOUSAND = 10000;

    public static void main(String[] args) {
        compute(7.9, 15, 1000/4);
    }

    //给offer价（月base，股票数，算出）
    public static void compute(double monthlyCash, int month, double stockPerYear) {
        SalarySolution s = new SalarySolution(monthlyCash, month, stockPerYear);
        s.print();
    }


    private static class SalarySolution {

        private double monthlyCash;
        private int month;
        private double stockPerYear; //USD为单位

        public SalarySolution(double monthlyCash, int month, double stockPerYear) {
            this.monthlyCash = monthlyCash;
            this.month = month;
            this.stockPerYear = stockPerYear;
        }

        public String f(double d) {
            //转成万
            //格式两位小数点
            return String.format("%,.2f", d/TEN_THOUSAND);
        }

        public double computeCash() {
            return monthlyCash * TEN_THOUSAND * month;
        }

        public double computeStock190() {
            return stockPerYear * BYTE_OFFICIAL_PRICE * USD_TO_CNY_RATE;
        }

        public double computeStock140() {
            return stockPerYear * BYTE_FACT_PRICE * USD_TO_CNY_RATE;
        }

        //计算总包，按照190美金计算
        public double computePackage190() {
            return computeCash() + computeStock190();
        }

        public double convert2Pkg140() {
            return computeCash() + computeStock190() * BYTE_FACT_PRICE/BYTE_OFFICIAL_PRICE;
        }

        //计算总包，按照140美金计算
        public double computePackage140() {
            return computeCash() + computeStock140();
        }

        public void print() {
            System.out.println("薪资方案");
            System.out.println("现金：" + f(computeCash()));
            System.out.println("期权190：" + f(computeStock190()) + "总包：" + f(computePackage190()) + " 现金比：" + computeCash()/computePackage190());
            System.out.println("期权140：" + f(computeStock140()) + "总包：" + f(computePackage140()) + " 现金比：" + computeCash()/computePackage140());
        }

    }
}
