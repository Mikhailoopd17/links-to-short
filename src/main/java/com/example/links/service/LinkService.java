package com.example.links.service;

import com.example.links.dao.LinkDAO;
import com.example.links.exception.UserExceptions;
import com.example.links.pojo.Link;
import com.example.links.util.LinkUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class LinkService {
    private LinkDAO linkDAO;

    public LinkService(LinkDAO linkDAO) {
        this.linkDAO = linkDAO;
    }

    public List<Link> getListByParams(Map<String, Object> params) {
        return linkDAO.getListByParams(params);
    }

    public Link create(Link link) {
        String shortLink;
        do {
            shortLink = LinkUtils.generateShortLink();
        } while (linkDAO.isExistShortLink(shortLink));

        link.setShortLink(shortLink);
        link.setCreated(LocalDateTime.now());
        linkDAO.create(link);
        return link;
    }

    public Link update(Link link, Boolean changeLink) {
        List<Link> oldLinks = linkDAO.getListByParams(Collections.singletonMap("id", link.getId()));
        if (oldLinks == null || oldLinks.isEmpty()) {
            throw new UserExceptions.RestException(String.format("Link with id %s not found!", link.getId()));
        }

        if (changeLink) {
            String shortLink;
            do {
                shortLink = LinkUtils.generateShortLink();
            } while (linkDAO.isExistShortLink(shortLink));
            link.setShortLink(shortLink);
        } else {
            link.setShortLink(oldLinks.get(0).getShortLink());
        }

        link.setCreated(oldLinks.get(0).getCreated());
        link.setUpdated(LocalDateTime.now());
        linkDAO.update(link);
        return link;
    }

    public void delete(Integer id) {
        linkDAO.delete(id);
    }

    public List<String> getTop(Map<String, Object> params) {
        return linkDAO.getTop(params);
    }
}
