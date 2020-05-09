package com.google.shinyay;

import com.google.shinyay.entity.User;

import java.util.List;

public interface UserService {

    public void add(User user);

    public User find(int id);

    public List<User> findAll();
}