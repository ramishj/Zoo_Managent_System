package org.example;

import java.util.ArrayList;

public class Discounts {
    public String Coupon;
    public static ArrayList<Discounts> disc = new ArrayList<>();
    String Category;
    int Percent;

    public Discounts(String Category, int Percent) {
        this.Category = Category;
        this.Percent = Percent;
        this.Coupon = this.Category + String.valueOf(this.Percent);  // Initialize here
        disc.add(this);
    }

    @Override
    public String toString() {
        return String.format(" %s (%d%% discount) - %s%s\n", Category, Percent, Category, Integer.toString(Percent));
    }
}
