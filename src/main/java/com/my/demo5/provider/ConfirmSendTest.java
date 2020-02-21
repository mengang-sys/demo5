package com.my.demo5.provider;

import com.rabbitmq.client.*;
import com.sun.deploy.net.proxy.ProxyUnavailableException;
import org.springframework.amqp.rabbit.connection.CorrelationData;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * 制的网上例子 作为平时批量发送-确认模式测试类  channel.basicPublish发送
 */
public class ConfirmSendTest {

    public static void main(String[] args) {
        String exchangeName = "DirectExchange";
        String queueName = "DirectQueue";
        String routingKey = "direct.key";
        String bindingkey = "direct.key";
        int count = 4;

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");

        //创建生产者

    }

class Sender{
    private ConnectionFactory factory;
    private int count;
    private String exchangeName;
    private String 	queueName;
    private String routingKey;
    private String bindingKey;

    public Sender(ConnectionFactory factory, int count, String exchangeName, String queueName, String routingKey, String bindingKey) {
        this.factory = factory;
        this.count = count;
        this.exchangeName = exchangeName;
        this.queueName = queueName;
        this.routingKey = routingKey;
        this.bindingKey = bindingKey;
    }

    public void run(){
        Channel channel = null;
        try{
            Connection connection = factory.newConnection();
            channel = connection.createChannel();
            //创建exchange
            channel.exchangeDeclare(exchangeName, "direct", true, false, null);
            //创建队列
            channel.queueDeclare(queueName, true, false, false, null);
            //绑定exchange和queue
            channel.queueBind(queueName, exchangeName, bindingKey);
            channel.confirmSelect();
            //发送持久化消息
            for(int i = 0;i < count;i++) {
                //id + 时间戳 全局唯一
                CorrelationData correlationData = new CorrelationData("oldwang" + new Date());
                //第一个参数是exchangeName(默认情况下代理服务器端是存在一个""名字的exchange的,
                //因此如果不创建exchange的话我们可以直接将该参数设置成"",如果创建了exchange的话
                //我们需要将该参数设置成创建的exchange的名字),第二个参数是路由键
                channel.basicPublish(exchangeName, routingKey, MessageProperties.PERSISTENT_BASIC, ("第"+(i+1)+"条消息").getBytes());
            }
            long start = System.currentTimeMillis();
            channel.addConfirmListener(new ConfirmListener() {
                @Override
                public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                    System.out.println("ack: deliveryTag = "+deliveryTag+" multiple: "+multiple);
                }

                @Override
                public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                    System.out.println("nack: deliveryTag = "+deliveryTag+" multiple: "+multiple);
                }
            });

            System.out.println("执行waitForConfirmsOrDie耗费时间: "+(System.currentTimeMillis()-start)+"ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


}
