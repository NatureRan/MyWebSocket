package com.nature.myWebSocket.controller;

import com.nature.myWebSocket.handler.MyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

/**
 * @author nature
 * @date 2020/6/22 9:05 下午
 */
@RestController
@RequestMapping(value = "/socket")
public class SocketController {

    @Autowired
    MyHandler handler;

    @RequestMapping("/message")
    public String sendMessage(String msg) {
        boolean flag = handler.sendMessageToAllUsers(new TextMessage(msg));
        System.out.println(flag);
        return "发送成功";
    }
}
