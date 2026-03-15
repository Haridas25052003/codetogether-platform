package com.demo.controller;

import com.demo.model.CodeMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Controller
public class CodeEditorController {

    private final SimpMessagingTemplate messagingTemplate;

    public CodeEditorController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/join")
    public void joinRoom(CodeMessage message) {

        messagingTemplate.convertAndSend(
                "/topic/editor/" + message.getRoomId(),
                message
        );
    }

    @MessageMapping("/code-change")
    public void handleCodeChange(CodeMessage message) {

        messagingTemplate.convertAndSend(
                "/topic/editor/" + message.getRoomId(),
                message
        );
    }

    @MessageMapping("/leave")
    public void leaveRoom(CodeMessage message) {

        messagingTemplate.convertAndSend(
                "/topic/editor/" + message.getRoomId(),
                message
        );
    }
}