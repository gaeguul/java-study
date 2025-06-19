package org.scoula.controller;

import org.scoula.domain.ChatMessage;
import org.scoula.domain.GreetingMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class ChatController {
	// 수신
	@MessageMapping("/hello") // /app/hello
	@SendTo("/topic/greetings")
	public GreetingMessage greeting(GreetingMessage message) throws Exception {
		log.info("greeting: " + message);
		return message;
	}

	@MessageMapping("/chat") // /app/chat
	@SendTo("/topic/chat")
	public ChatMessage chat(ChatMessage message) throws Exception {
		log.info("chat received: " + message);
		return message;
	}
}
