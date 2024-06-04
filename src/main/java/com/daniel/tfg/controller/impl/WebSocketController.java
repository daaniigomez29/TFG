package com.daniel.tfg.controller.impl;

import com.daniel.tfg.model.dto.ChatMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Controlador que maneja las distintas peticiones relacionadas con chat
 */
@Controller
public class WebSocketController {

    /**
     * Envia mensaje a la sala
     */
    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public ChatMessage chat(@DestinationVariable String roomId, ChatMessage message) {
        return new ChatMessage(message.getMessage(), message.getUser());
    }
}
