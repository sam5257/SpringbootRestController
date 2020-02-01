package com.sameer.service;

import com.sameer.utility.UserRepository;
import com.sameer.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List getAllUsers() {
        List users = new ArrayList();
        userRepository.findAll().forEach(user -> users.add(user));
        return users;
    }


    @Cacheable("user")
    public UserInfo getUserById(int id) {
        try {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        return userRepository.findById(id).get();
    }

    public void saveOrUpdate(UserInfo userInfo) {
        userRepository.save(userInfo);
    }


    public void delete(int id) {
        userRepository.deleteById(id);
    }

}