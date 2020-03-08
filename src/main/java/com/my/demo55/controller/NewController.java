package com.my.demo55.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.demo5.po.Product;
import com.my.demo55.po.New;
import com.my.demo55.service.NewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/new")
@EnableAutoConfiguration
public class NewController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NewService newService;
    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/getWithPage")
    public PageInfo<New> getWithPage(@RequestParam(required = false,defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum,4);
        Page<New> news = newService.selectWithPage();
        PageInfo<New> newPageInfo = news.toPageInfo();
        return newPageInfo;
    }

    @PostMapping("/add")
    public int add(New news){
        int result = newService.add(news);
        return result;
    }
}
