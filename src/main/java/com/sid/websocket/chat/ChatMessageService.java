package com.sid.websocket.chat;

import com.sid.websocket.ChattersApplication;
import com.sid.websocket.chatroom.ChatRoom;
import com.sid.websocket.chatroom.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    @Autowired
    private final ChatMessageRepository repository;
    @Autowired
    private final ChatRoomService service;

    public ChatMessage save(ChatMessage chatMessage){
        var chatId = service.getChatRoomId(
                chatMessage.getSenderId(),
                chatMessage.getRecipientId(),
                true
        ).orElseThrow();
        chatMessage.setChatId(chatId);
        repository.save(chatMessage);
        return chatMessage;
    }

    public List<ChatMessage> findChatMessages(
            String senderId, String recipientId
    ){
        var chatId = service.getChatRoomId(
                senderId,
                recipientId,
                false);

        return chatId.map(
                repository::findByChatId
        ).orElse(new ArrayList<>());
    }

}
