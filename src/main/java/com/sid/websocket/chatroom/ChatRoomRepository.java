package com.sid.websocket.chatroom;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {
    @Query("{'senderId' : ?0 , 'recipientId' : ?1}")
    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
