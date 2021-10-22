package com.gymteam.backend.bff.service.impl;

import com.gymteam.backend.bff.client.UserClient;
import com.gymteam.backend.bff.dto.User;
import com.gymteam.backend.bff.exception.client.ClientException;
import com.gymteam.backend.bff.exception.user.UserNotExistException;
import com.gymteam.backend.bff.service.interfaces.UserService;
import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserClient userClient;

    @Override
    public User get(UUID id) {

        try {
            return userClient.getUser(id);
        }
        catch(FeignException e)
        {
            if (e.status()==404)
            {
                throw new UserNotExistException();
            }
            if(e.status()==-1)
            {
                throw new ClientException("503 : Service Unavailable");
            }
            else
            {
                throw new ClientException(String.format("%d : %s",e.status(),e.getMessage()));
            }
        }

    }

    @Override
    public User update(User user) {
        try {
            return userClient.updateUser(user);
        }
        catch(FeignException e)
        {
            if (e.status()==404)
            {
                throw new UserNotExistException();
            }
            if(e.status()==-1)
            {
                throw new ClientException("503 : Service Unavailable");
            }
            else
            {
                throw new ClientException(String.format("%d : %s",e.status(),e.getMessage()));
            }
        }

    }
}
