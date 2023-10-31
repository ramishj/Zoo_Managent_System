package org.example;

import java.util.ArrayList;

public class Special_Deals {
    public static ArrayList<Special_Deals> deals = new ArrayList<>();
    int quantity;
    int discountPercent;

    public Special_Deals(int quantity, int discountPercent) {
        this.quantity = quantity;
        this.discountPercent = discountPercent;
        deals.add(this);
    }

    @Override
    public String toString() {
        return String.format("Buy %d get %d%% Discount\n", quantity, discountPercent);
    }
}
