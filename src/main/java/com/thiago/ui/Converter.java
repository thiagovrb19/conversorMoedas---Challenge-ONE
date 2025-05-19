package main.java.com.thiago.ui;

public class Converter {
    public static double convert(double amount, double rateBase, double rateTarget) {
        double amountInUsd = amount / rateBase;
        return amountInUsd * rateTarget;
    }
}
