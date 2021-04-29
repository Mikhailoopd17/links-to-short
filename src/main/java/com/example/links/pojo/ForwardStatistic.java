package com.example.links.pojo;

import java.util.Map;

public class ForwardStatistic {
    private OrderParams type;
    private Map<String, Integer> statistic;

    public OrderParams getType() {
        return type;
    }

    public void setType(OrderParams type) {
        this.type = type;
    }

    public Map<String, Integer> getStatistic() {
        return statistic;
    }

    public void setStatistic(Map<String, Integer> statistic) {
        this.statistic = statistic;
    }
}
