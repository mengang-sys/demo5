package com.my.demo55.dao;

import com.github.pagehelper.Page;
import com.my.demo55.po.New;
import com.my.demo55.po.NewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewMapper {
    long countByExample(NewExample example);

    int deleteByExample(NewExample example);

    int deleteByPrimaryKey(Long id);

    int insert(New record);

    int insertSelective(New record);

    List<New> selectByExample(NewExample example);

    New selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") New record, @Param("example") NewExample example);

    int updateByExample(@Param("record") New record, @Param("example") NewExample example);

    int updateByPrimaryKeySelective(New record);

    int updateByPrimaryKey(New record);

    Page<New> selectWithPage();

    boolean add(New news);
}