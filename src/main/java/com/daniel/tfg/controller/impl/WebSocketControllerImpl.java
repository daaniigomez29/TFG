package com.daniel.tfg.controller.impl;

import com.daniel.tfg.controller.WebSocketController;
import com.daniel.tfg.model.dto.ChatMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador que maneja las distintas peticiones relacionadas con chat
 */
@Controller
@RequestMapping("/api/v1")
public class WebSocketControllerImpl implements WebSocketController {

    /**
     * Envia mensaje a la sala
     */
    @Override
    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public ChatMessage chat(@DestinationVariable String roomId, ChatMessage message) {
        return new ChatMessage(message.getMessage(), message.getUser());
    }
}
