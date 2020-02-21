package com.my.demo5.consumer;

import com.my.demo5.dao.ProductMapper;
import com.my.demo5.po.Product;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConsumer {

    @Autowired
    private ProductMapper productMapper;
    @RabbitListener(
            bindings = @QueueBinding(
                    value=@Queue(value="${mq.config.queue.info}",autoDelete = "true"),
                    exchange = @Exchange(value="${mq.config.exchange}",type = ExchangeTypes.DIRECT),
                    key="${mq.config.queue.info.routing.key}"
            )
    )
    public void create(Product product){
        productMapper.insert(product);
    }
}
