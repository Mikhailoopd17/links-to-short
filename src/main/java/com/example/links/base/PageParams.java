package com.example.links.base;

import com.example.links.pojo.OrderParams;

public class PageParams {
    /**
     * параметр группировки: day, hour, minute
     */
    private OrderParams orderParam = OrderParams.DAY;

    public OrderParams getOrderParam() {
        return orderParam;
    }

    public void setOrderParam(String value) {
        this.orderParam = OrderParams.fromValue(value);
    }
}
