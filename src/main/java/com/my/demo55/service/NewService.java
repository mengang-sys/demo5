package com.my.demo55.service;

import com.github.pagehelper.Page;
import com.my.demo55.dao.NewMapper;
import com.my.demo55.po.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewService {


    @Autowired
    private NewMapper newMapper;


    public Page<New> selectWithPage() {
        return newMapper.selectWithPage();
    }


    public int add(New news) {
       return newMapper.insert(news);
    }
}
