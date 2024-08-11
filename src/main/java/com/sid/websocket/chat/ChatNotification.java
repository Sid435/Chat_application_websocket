package com.sid.websocket.chat;

import lombok.*;
import org.springframework.web.service.annotation.GetExchange;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatNotification {
    private String Id;
    private String senderId;
    private String recipientId;
    private String content;
}
