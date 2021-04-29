package com.example.links.pojo;

import com.example.links.base.BaseEntity;

public class Link extends BaseEntity {
    private String originalLink;
    private String shortLink;
    private Integer forwards;

    public String getOriginalLink() {
        return originalLink;
    }

    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public Integer getForwards() {
        return forwards;
    }

    public void setForwards(Integer forwards) {
        this.forwards = forwards;
    }
}
