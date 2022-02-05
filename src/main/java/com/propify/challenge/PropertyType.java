package com.propify.challenge;

import java.util.Objects;

public class PropertyType {

    public static final PropertyType SINGLE_FAMILY = new PropertyType("Single Family");
    public static final PropertyType MULTI_FAMILY = new PropertyType("Multi-family");
    public static final PropertyType CONDOMINIUM = new PropertyType("Condominium");
    public static final PropertyType TOWNHOUSE = new PropertyType("Townhouse");

    public String type;

    public PropertyType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyType that = (PropertyType) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
