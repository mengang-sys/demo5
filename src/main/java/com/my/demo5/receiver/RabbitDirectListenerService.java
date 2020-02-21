package com.my.demo5.receiver;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue("DirectQueue")
        , exchange = @Exchange(value = "DirectExchange", type = ExchangeTypes.DIRECT)
        , key = "direct.key"))
public class RabbitDirectListenerService {
    @RabbitHandler
    public void getMessage(@Payload String message, Channel channel, @Headers Map<String, Object> headers) throws Exception {

        long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
        try {
            //业务逻辑处理......
            System.out.println("幂等处理 & 业务处理 getMessage消费者String收到deliveryTag : " + deliveryTag + ", 收到消息: " + message);
            //消息确认，deliveryTag:该消息的index，multiple：是否批量.true:将一次性ack所有小于deliveryTag的消息。
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            //deliveryTag:该消息的index，multiple：是否批量.true:将一次性拒绝所有小于deliveryTag的消息，requeue：被拒绝的是否重新入队列(false:不进入，true:进入)
            channel.basicNack(deliveryTag , false,true);
            throw new RuntimeException(e);
        }
    }

    @RabbitHandler
    public void getMessage(@Payload byte[] message, Channel channel, @Headers Map<String, Object> headers) throws Exception {

        long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
        //做拒绝查看demo，没有死信队列，所以拒绝后会一直重发，方便查看rabbimq消息
        if(deliveryTag > 4) {
            System.out.println("deliveryTag:" + deliveryTag + "，---------消息拒绝 : " + (new String(message)));
            //消息拒绝deliveryTag:该消息的index，requeue：被拒绝的是否重新入队列(false:不进入，true:进入)
            channel.basicReject(deliveryTag, true);
//            channel.basicNack(deliveryTag , false,true);
        } else {
            System.out.println("幂等处理 & 业务处理 getMessage消费者byte收到deliveryTag : " + deliveryTag + "消费者byte收到消息  : " + (new String(message)));
            channel.basicAck(deliveryTag, false);
        }
    }
}
