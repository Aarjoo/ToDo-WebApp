package com.tcs.todoapp.Service;

import org.springframework.stereotype.Service;

@Service
public class LoginService
{
	public boolean isloggedIn(String username, String password)
	{
		return (username.equals("Admin") && password.equals("12345"));
	}
}