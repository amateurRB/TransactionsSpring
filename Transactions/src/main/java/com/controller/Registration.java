package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Admin;
import com.entity.User;
import com.service.impl.RegisterService;


@RestController
public class Registration {
	
	
	
	@Autowired
	RegisterService registerService;
	
	
	@RequestMapping(path="/register", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerAddUser(@RequestBody User user)
	{
		User Obj;
		Obj=registerService.addUser(user);
		return Obj;
	}
	
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public User doLogin(@RequestBody User user) throws Exception
	{
		String temperorymail = user.getMailid();
		String temperorypassword = user.getPassword();
		User Obj = null;
		if(temperorymail != null && temperorypassword != null)
		{
			Obj = registerService.matchEmailPassword(temperorymail, temperorypassword);
		}
		
		if(Obj == null)
		{
			throw new Exception("====User not exist=====");
		}
		return Obj;
	}
	
	
	@RequestMapping(path = "/admin", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public void doAdminLogin(@RequestBody Admin admin) throws Exception
	{
		String adminemail = admin.getEmailid();
		String adminpassword = admin.getPassword();
		
		if(adminemail.equals("admin") && adminpassword.equals("admin"))
		{
			System.out.println("admin successfully login");
		}
		else
		{
			throw new Exception("credentials are wrong");
		}
		
		
	}
}
