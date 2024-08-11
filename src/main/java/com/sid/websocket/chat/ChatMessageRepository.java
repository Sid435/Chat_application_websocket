package com.sid.websocket.chat;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    @Query("{'chatId' : ?0}")
    List<ChatMessage> findByChatId(String s);
}
