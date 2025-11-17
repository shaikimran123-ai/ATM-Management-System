package com.cg.backend;

public interface UserService {
	
	   public User login(String userId, String pin) throws InvalidPinException;
	
}
