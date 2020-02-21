package com.my.demo5.provider;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 消息发送service
 */
@Service
public class SendMessageService implements RabbitTemplate.ConfirmCallback ,RabbitTemplate.ReturnCallback{

    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * 直连交换机消费者
     */
    public void sendString(String message){
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
        System.out.println("**********************************************************");
        System.out.println("发送消息：" + message + "callbackSender UUID: " + correlationData.getId());
        rabbitTemplate.convertAndSend("DirectExchange","direct.key", message, correlationData);
        System.out.println("----------------------------------------------------------");
    }

    /**
     * 通过实现 ConfirmCallback 接口，消息发送到 Broker 后触发回调，确认消息是否到达 Broker 服务器，也就是只确认是否正确到达 Exchange 中
     * @param correlationData 唯一标示符
     * @param ack  结果
     * @param cause 错误信息，正常时返回null
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if(ack) {
            System.out.println("confirm方法: " + correlationData.getId() + ", 发送正常，ack:" + ack + ",cause:" + cause);
        } else {
            System.out.println("confirm方法: " + correlationData.getId() + ", 发送失败，ack:" + ack + ",cause:" + cause);
        }
    }

    /**
     * 通过实现 ReturnCallback 接口，启动消息失败返回，比如路由没有到达到队列时触发回调
     * @param message 消息主体 message
     * @param replyCode 回应编码 replyCode
     * @param replyText 描述
     * @param exchange 消息使用的交换器 exchange
     * @param routingKey 消息使用的路由键 routing
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("消息主体 message : " + message);
        System.out.println("回应编码 replyCode : " + replyCode);
        System.out.println("描述：" + replyText);
        System.out.println("消息使用的交换器 exchange : " + exchange);
        System.out.println("消息使用的路由键 routing : " + routingKey);
    }
}
