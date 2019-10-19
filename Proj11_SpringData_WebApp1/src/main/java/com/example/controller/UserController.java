package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.UserEntity;
import com.example.model.UserModel;
import com.example.repo.User;


@Controller
public class UserController {
	@Autowired
	private User users;
	
	@RequestMapping(value= {"/registerUser","/"})
	public String userReg(Model model) {
		UserModel userModel=null;
		userModel=new UserModel();
		model.addAttribute("user",userModel);
		return "show";
	}
	
	@RequestMapping(value = "/registerUser",method=RequestMethod.POST)
	public String regtUser(@ModelAttribute("user") UserModel user,Model model){
		UserEntity userEntity=new UserEntity();
		String msg=null;
		System.out.println(user);
		//copy model object to entity object
		BeanUtils.copyProperties(user, userEntity);
		//invoke entity class
		UserEntity result=users.save(userEntity);
		System.out.println(result);
		if(result.getUid()!=null) {
			msg="Registration success";
		}
		else {
			 msg="Registration Failed";
		}
		model.addAttribute("resultMsg",msg);
		return "redirect:registerUser";
	}

	//pagenation
	@RequestMapping(value ="/viewUser1")
	public String displayAll(@RequestParam("pn")Integer currPage,Model model){
		Integer pageSize=3;
	//	Integer currPage=1;
	 	Pageable pg=PageRequest.of(currPage-1,pageSize);
	 	Page<UserEntity> pageData=users.getUserAfterSoftDelete((PageRequest) pg);
	 	List<UserEntity> list=pageData.getContent();
	 	int totalPage=pageData.getTotalPages();
	 	model.addAttribute("tp",totalPage);
	 	model.addAttribute("cp",currPage);
	 	
		List<UserModel> listUser=new ArrayList();
		for(UserEntity entity:pageData) {
			UserModel userModel=new UserModel();
			BeanUtils.copyProperties(entity, userModel);
			listUser.add(userModel);
			System.out.println("user model"+userModel);
		}
		System.out.println(listUser);
		model.addAttribute("userData",listUser);
		return "displayUser";
	}
	
@RequestMapping(value = "/editUser")  
	  public String editUserById(@RequestParam("uid")Integer uid,Model model){
		  UserModel userModel=new UserModel();
		  Optional<UserEntity> optEntity=users.findById(uid);
		  if(optEntity.isPresent()) {
			  UserEntity entity=optEntity.get();
			  BeanUtils.copyProperties(entity, userModel);
		  }
		  //loadForm(model);
		  model.addAttribute("editMsg",userModel);
		  return "edit";
	  }

  /*  @RequestMapping(value ="/deleteUser")
    public String deleteUserById(@RequestParam("uid") Integer uid) {
    	users.deleteById(uid);
    	return "redirect:viewUser1?pn=1";
    }
    */
    @RequestMapping(value = "/softdelete")
    public String softDeleteUSer(@RequestParam("uid") Integer uid) {
    	users.updateDelete(uid);
    	 return "redirect:viewUser1?pn=1";
    }
    
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("editMsg") UserModel userModel,Model model) {
    	UserEntity entity=new UserEntity();
    	BeanUtils.copyProperties(userModel, entity);
    	users.save(entity);
    	model.addAttribute("msg","Update Successfully!!!");
    	return "redirect:viewUser1?pn=1";
    }
    
    @RequestMapping(value = "viewUser")
	public String displayAll1(Model model) {
		Iterable<UserEntity> userEntity=users.findAll();
		System.out.println(userEntity);
		List<UserModel> listUser=new ArrayList();
		for(UserEntity entity:userEntity) {
			UserModel userModel=new UserModel();
			BeanUtils.copyProperties(entity, userModel);
			listUser.add(userModel);
			System.out.println("user model"+userModel);
		}
		System.out.println(listUser);
		model.addAttribute("userData",listUser);
		return "displayUser";
	}
        
    @RequestMapping(value ="/getEmail")
    public @ResponseBody List<String> getAllUserEmail(){
    	return users.findAllEmail();
    }
    
    @RequestMapping(value = "/getemailbyid")
    public @ResponseBody String getUserEmailById(@RequestParam("id") Integer uid) {
    	return users.findEmailById(uid);
    }
/*	
   public String loadForm(Model model) {
	   List<String> list=new ArrayList<String>();
	   list.add("India");
	   list.add("USA");
	   list.add("German");
	   list.add("SA");
	   model.addAttribute("countriesList",list);
	   return "show";
   }
*/
}
