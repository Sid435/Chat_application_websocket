package com.sid.websocket.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    public void saveUser(User user){
        user.setStatus(Status.ONLINE);
        repository.save(user);
    }

    public void disconnect(User user){
        var stored = repository.findById(user.getNickName())
                .orElse(null);
        if(stored!= null){
            stored.setStatus(Status.OFFLINE);
            repository.save(stored);
        }

    }
    public List<User> findConnectedUsers(){
        return repository.findByStatus(Status.ONLINE);
    }
}
