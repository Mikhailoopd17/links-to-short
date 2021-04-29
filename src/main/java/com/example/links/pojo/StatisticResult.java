package com.example.links.pojo;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticResult {
    private String key;
    private Integer value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public static Map<String, Integer> toMap(List<StatisticResult> list) {
        if (list == null) {
            return Collections.emptyMap();
        }
        return list.parallelStream().collect(Collectors.toMap(StatisticResult::getKey, StatisticResult::getValue));
    }
}
