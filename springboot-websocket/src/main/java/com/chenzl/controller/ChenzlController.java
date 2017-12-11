package com.chenzl.controller;

import com.chenzl.domain.ChenzlMessage;
import com.chenzl.domain.ChenzlResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * Created by chenzl on 2017/12/11.
 */
@Controller
public class ChenzlController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;//SimpMessagingTemplate用于向浏览器发送信息。

   @MessageMapping("/wellcom") // 用于设置URL映射地址，浏览器向服务器发起请求，需要通过该地址
   @SendTo("/topic/getResponse") //如果服务器接受到了消息，就会对订阅了@SendTo括号中的地址传送消息。
    public ChenzlResponse sendSay(ChenzlMessage chenzlMessage) throws Exception{
        return new ChenzlResponse("wellcom,"+chenzlMessage.getName()+"!");
    }

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) { //在spring mvc中，principal包含了登录用户的信息，在这里我们直接用。
        if (principal.getName().equals("czl")) {
            //如果登录的用户是dzz,那就将消息发送给zbb,通过convertAndSendToUser（）方法进行发送，第一个参数是信息接收的目标，
            // 第二个参数是要发送的地址，第三个参数是要发送的信息。
            messagingTemplate.convertAndSendToUser("ffk",
                    "/queue/notifications", principal.getName() + "-send:"
                            + msg);
        } else {
            messagingTemplate.convertAndSendToUser("czl",
                    "/queue/notifications", principal.getName() + "-send:"
                            + msg);
        }
    }
}
