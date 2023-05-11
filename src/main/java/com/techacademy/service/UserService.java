package com.techacademy.service;




import java.util.List;

import org.springframework.stereotype.Service;

import com.techacademy.repository.UserRepository;
import com.techacademy.entity.Authentication;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    /** 全件を検索して返す */
    public List<Authentication> getUserList() {
        // リポジトリのfindAllメソッドを呼び出す
        return userRepository.findAll();
    }

    }
