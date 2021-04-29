package com.example.links.rest;

import com.example.links.exception.UserExceptions;
import com.example.links.pojo.Link;
import com.example.links.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Scope("request")
@RequestMapping(value = "/links", produces = "application/json; charset=UTF-8")
public class LinkController {

    private final LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/top")
    public List<String> getTop(@RequestParam(defaultValue = "20", value = "count") Integer count) {
        Map<String, Object> params = new HashMap<>();
        params.put("limit", count);
        return linkService.getTop(params);
    }

    @GetMapping
    public List<Link> getAll(@RequestParam(value = "with_deleted", defaultValue = "false") Boolean withDeleted,
                             @RequestParam(value = "with_forwards", defaultValue = "false") Boolean withForwards) {
        Map<String, Object> params = new HashMap<>();
        params.put("withDeleted", withDeleted);
        params.put("withForwards", withForwards);
        return linkService.getListByParams(params);
    }

    @PostMapping
    public Link create(@RequestBody Link link) {
        return linkService.create(link);
    }

    @PutMapping("/{id}")
    public Link update(@RequestParam(value = "change_link", defaultValue = "false") Boolean changeLink,
                       @RequestBody Link link,
                       @PathVariable Integer id) {
        if (link.getId() != null && !link.getId().equals(id)) {
            throw new UserExceptions.RestException("Link entity identifier not equals path variable!");
        }
        link.setId(id);
        return linkService.update(link, changeLink);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        linkService.delete(id);
    }
}
