package com.demo.controller;

import com.demo.model.CodeMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class CodeEditorController {

    @MessageMapping("/code-change")
    @SendTo("/topic/editor")
    public CodeMessage handleCodeChange(CodeMessage message) {

        return message;
    }
}