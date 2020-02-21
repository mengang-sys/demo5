package com.my.demo5.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.demo5.dao.ProductMapper;
import com.my.demo5.po.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Queue;

@RestController
@RequestMapping("/product")
@EnableAutoConfiguration
public class ProductController {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${mq.config.exchange}")
    String EXCHANGE;
    @Value("${mq.config.queue.info}")
    String QUEUE;
    @Value("${mq.config.queue.info.routing.key}")
    String ROUTINGKEY;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/getAll")
    public List<Product> getAll(){
        List<Product> products = productMapper.selectAll();
        return products;
    }

    @GetMapping("/getWithPage")
    public PageInfo<Product> getWithPage(@RequestParam(required = false,defaultValue = "1")Integer pageNum){
        PageHelper.startPage(pageNum,2);
        Page<Product> products = productMapper.selectWithPage();
        PageInfo<Product> productPageInfo = products.toPageInfo();
        return productPageInfo;
    }

    @GetMapping("/getWithPageAndName")
    public PageInfo<Product> getWithPageAndName(
            @RequestParam(required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(required = false,defaultValue = "")  String name
                                                ){
        PageHelper.startPage(pageNum,2);
        Page<Product> products = productMapper.selectWithPageAndName(name);
        PageInfo<Product> productPageInfo = products.toPageInfo();
        return productPageInfo;
    }

    @PostMapping("/create")
    public void create(@RequestBody Product product){
        logger.info("product value{},product id{}",product,product.getProductId());
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTINGKEY,product);
    }

    @PostMapping("/update")
    public void update(@RequestBody Product product){
        productMapper.updateByPrimaryKey(product);
    }

    @GetMapping("/getById")
    public Product getById(Integer productId){
        Product product = productMapper.selectByPrimaryKey(productId);
        return product;
    }

    @PostMapping("/batchDelete")
    public void batchDelete(@RequestBody List<Integer> productIds){
        productMapper.batchDelete(productIds);
    }


}
