package com.chenzl.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * 消息监听
 * Created by chenzl on 2017/12/7.
 */
@Component
public class Receiver {
   /* private CountDownLatch latch=new CountDownLatch(1);
    public void receiverMessage(String message){
        System.out.println("Receiver>>>>>"+message);
        latch.countDown();
    }

    public CountDownLatch getLatch(){
        return latch;
    }*/
   @RabbitListener(queues = "my-queue")
    public void receiverMessage(String message){
       System.out.println("Receiver<"+message+">");
   }
}
