package com.example.links;

import com.example.links.pojo.Link;
import com.example.links.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.util.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

@SpringBootTest
public class LinksToShortApplicationTests extends AbstractTestNGSpringContextTests {

    private Link link;

    @Autowired
    private LinkService linkService;

    @BeforeClass
    public void create() {
        System.out.println("start");
        Link link = new Link();
        link.setOriginalLink("http://test");
        linkService.create(link);
        this.link = link;
    }

    @AfterClass
    public void delete() {
        System.out.println("end");
        linkService.delete(this.link.getId());
    }

    @Test
    public void checkLink() {
        List<Link> linksFromDb = linkService.getListByParams(Collections.singletonMap("id", this.link.getId()));
        Assert.isTrue(linksFromDb != null || !linksFromDb.isEmpty(), "Ссылка не создана");
        Assert.isTrue(linksFromDb.get(0) != null, "Ссылка не создана");
        Assert.isTrue(this.link.getShortLink().equals(linksFromDb.get(0).getShortLink()), "Ссылки не равны!");
    }

    @Test
    public void updateLink() {
        List<Link> linksFromDb = linkService.getListByParams(Collections.singletonMap("id", this.link.getId()));
        Link link = linksFromDb.get(0);
        String oldLink = link.getShortLink();
        link.setOriginalLink("http://test-2");
        linkService.update(link, true);
        this.link = link;

        Link newLink = linkService.getListByParams(Collections.singletonMap("id", this.link.getId())).get(0);
        Assert.isTrue(newLink.getOriginalLink().equals(link.getOriginalLink()), "Ссылки не равны");
        Assert.isTrue(!newLink.getShortLink().equals(oldLink), "Новая короткая ссылка не сгенерирована");
    }
}
