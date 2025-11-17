package com.cg.backend;

import java.util.HashMap;

public class UserServiceImpl implements UserService {
    private HashMap<String, User> users = new HashMap<>();

    public UserServiceImpl() {
        users.put("imran", new User("imran", "1234", 10000));
        users.put("shiva", new User("shiva", "5678", 8000));
        users.put("akash", new User("akash","8888",9000));
    }

    @Override
    public User login(String userId, String pin) throws InvalidPinException {
        User user = users.get(userId);
        if (user == null || !user.getPin().equals(pin)) {
            throw new InvalidPinException("Invalid user ID or PIN.");
        }
        return user;
    }
}
