package com.daniel.tfg.controller;

import com.daniel.tfg.model.dto.ChatMessage;

public interface WebSocketController {
    ChatMessage chat(String roomId, ChatMessage message);
}
