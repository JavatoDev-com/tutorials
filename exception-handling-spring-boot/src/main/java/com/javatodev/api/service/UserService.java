package com.javatodev.api.service;

import com.javatodev.api.client.InstantWebToolsApiClient;
import com.javatodev.api.common.UserStatus;
import com.javatodev.api.dto.User;
import com.javatodev.api.entity.UserEntity;
import com.javatodev.api.exception.EntityNotFoundException;
import com.javatodev.api.exception.UserAlreadyRegisteredException;
import com.javatodev.api.exception.config.GlobalErrorCode;
import com.javatodev.api.repository.UserRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final InstantWebToolsApiClient instantWebToolsApiClient;

    public void createUser(User user){
        Optional<UserEntity> userEntitiesByUsername = userRepository.findUserEntitiesByUsername(user.getUsername());
        if (userEntitiesByUsername.isPresent()) {
            throw new UserAlreadyRegisteredException("exception.user.already.registered", GlobalErrorCode.ERROR_USER_ALREADY_REGISTERED);
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(UUID.randomUUID().toString());
        userEntity.setUserStatus(UserStatus.PENDING);
        userEntity.setAirlineId(user.getAirlineId());
        userRepository.save(userEntity);
    }

    public User readUserByUsername(String username) {
        UserEntity userEntity = userRepository.findUserEntitiesByUsername(username).orElseThrow(EntityNotFoundException::new);
        User user = new User();
        BeanUtils.copyProperties(userEntity, user);
        user.setAirlineId(readAirline(user.getAirlineId()));
        return user;
    }

    public String readAirline (String id){
        return instantWebToolsApiClient.readAirLineById(id);
    }
}
