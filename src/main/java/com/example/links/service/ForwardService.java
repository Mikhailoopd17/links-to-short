package com.example.links.service;

import com.example.links.base.PageParams;
import com.example.links.dao.ForwardDAO;
import com.example.links.dao.LinkDAO;
import com.example.links.exception.UserExceptions;
import com.example.links.pojo.ForwardStatistic;
import com.example.links.pojo.Link;
import com.example.links.pojo.StatisticResult;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Service
public class ForwardService {
    private ForwardDAO forwardDAO;
    private LinkDAO linkDAO;

    public ForwardService(ForwardDAO forwardDAO, LinkDAO linkDAO) {
        this.forwardDAO = forwardDAO;
        this.linkDAO = linkDAO;
    }

    public void forward(HttpServletRequest request, HttpServletResponse response, String shortLink) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("shortLink", shortLink);
        params.put("limit", 1);

        List<Link> links = linkDAO.getListByParams(params);
        if (links == null || links.isEmpty()) {
            throw new UserExceptions.RestException("Error! Link not found!");
        }
        forwardDAO.forward(links.get(0).getId(), UUID.randomUUID().toString());
        response.sendRedirect(links.get(0).getOriginalLink());
    }

    public ForwardStatistic getStatistic(PageParams param, String shortLink) {
        if (!linkDAO.isExistShortLink(shortLink)) {
            throw new UserExceptions.RestException(String.format("Short link %s not found!", shortLink));
        }
        ForwardStatistic forwardStatistic = new ForwardStatistic();

        Map<String, Object> params = new HashMap<>();
        params.put("orderParam", param.getOrderParam().getValue());
        params.put("link", shortLink);

        List<StatisticResult> statistic = forwardDAO.getStatistic(params);
        forwardStatistic.setStatistic(StatisticResult.toMap(statistic));
        forwardStatistic.setType(param.getOrderParam());
        return forwardStatistic;
    }
}
