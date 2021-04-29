package com.example.links.pojo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum  OrderParams {
    DAY("day"),
    HOUR("hour"),
    MINUTE("minute");

    private String value;

    OrderParams(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static OrderParams fromValue(String value) {
        for (OrderParams p : OrderParams.values()) {
            if (p.getValue().equals(value)) {
                return p;
            }
        }
        return DAY;
    }
}
