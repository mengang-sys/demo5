package com.my.demo5.controller;

import com.my.demo5.dao.DepartmentMapper;
import com.my.demo5.vo.DepatmentNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
@EnableAutoConfiguration
public class DepartmentController {

    @Autowired
    private DepartmentMapper departmentMapper;

    @GetMapping("/getDepartmentTreeById")
    public List<DepatmentNode> getDepartmentTreeById(Integer departmentId){
        List<DepatmentNode> depatmentNodes = departmentMapper.selectChildren(departmentId);
        return depatmentNodes;
    }
}
