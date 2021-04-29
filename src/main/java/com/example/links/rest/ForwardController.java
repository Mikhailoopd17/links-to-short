package com.example.links.rest;

import com.example.links.base.PageParams;
import com.example.links.exception.UserExceptions;
import com.example.links.pojo.ForwardStatistic;
import com.example.links.pojo.Link;
import com.example.links.service.ForwardService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@Scope("request")
@RequestMapping(produces = "application/json; charset=UTF-8")
public class ForwardController {
    private ForwardService forwardService;

    public ForwardController(ForwardService forwardService) {
        this.forwardService = forwardService;
    }

    @GetMapping("/{shortLink}")
    public void forwardToLink(HttpServletRequest request, HttpServletResponse response, @PathVariable String shortLink) throws Exception {
        if (shortLink == null || shortLink.isBlank()) {
            throw new UserExceptions.RestException("Short link not set!");
        }
        forwardService.forward(request, response, shortLink);
    }

    @PostMapping("/{shortLink}/statistic")
    public ForwardStatistic getStatistic(@RequestBody PageParams params, @PathVariable String shortLink) {
        if (shortLink == null || shortLink.isBlank()) {
            throw new UserExceptions.RestException("Short link not set!");
        }
        return forwardService.getStatistic(params, shortLink);
    }
}
