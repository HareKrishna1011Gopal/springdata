package com.example.rest;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.UserEntity;
import com.example.model.UserModel;
import com.example.repo.User;

@RestController
public class UserRestController {
	
   @Autowired
	private User users;
   
   @GetMapping(value ="/getUser", produces = {"application/json","application/xml"})
    public UserModel getUserEmailById(@RequestParam("id") Integer uid){
    	Optional<UserEntity> opt= users.findById(uid);
    	UserModel userModel=new UserModel();
    	UserEntity entity=opt.get();
    	System.out.println(entity);
    	BeanUtils.copyProperties(entity, userModel);
    	System.out.println(userModel);
    	return userModel;
    }

}
