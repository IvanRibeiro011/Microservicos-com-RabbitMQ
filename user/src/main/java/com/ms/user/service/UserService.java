package com.ms.user.service;

import com.ms.user.dtos.UserRecordDto;
import com.ms.user.model.User;
import com.ms.user.producer.UserProducer;
import com.ms.user.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    final UserRepository repository;

    final UserProducer producer;

    public UserService(UserRepository repository,UserProducer producer) {
        this.repository = repository;
        this.producer = producer;
    }

    @Transactional
    public User saveUser(UserRecordDto dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        user = repository.save(user);
        producer.publishMessageEmail(user);
        return user;
    }
}
