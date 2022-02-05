package com.propify.challenge;

import java.util.Map;

public class PropertyReport {

    Integer totalQuantity;

    Map<PropertyType, Integer> quantityPerType;

    double averageRentPrice;

    Integer illinoisQuantity;

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Map<PropertyType, Integer> getQuantityPerType() {
        return quantityPerType;
    }

    public void setQuantityPerType(Map<PropertyType, Integer> quantityPerType) {
        this.quantityPerType = quantityPerType;
    }

    public double getAverageRentPrice() {
        return averageRentPrice;
    }

    public void setAverageRentPrice(double averageRentPrice) {
        this.averageRentPrice = averageRentPrice;
    }

    public Integer getIllinoisQuantity() {
        return illinoisQuantity;
    }

    public void setIllinoisQuantity(Integer illinoisQuantity) {
        this.illinoisQuantity = illinoisQuantity;
    }
}
