package com.my.demo5.dao;

import com.github.pagehelper.Page;
import com.my.demo5.po.Product;
import com.my.demo5.po.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer productId);

    List<Product> selectAll();

    Page<Product> selectWithPage();

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    Page<Product> selectWithPageAndName(String name);

    int batchDelete(@Param("productIds") List<Integer> productIds);
}