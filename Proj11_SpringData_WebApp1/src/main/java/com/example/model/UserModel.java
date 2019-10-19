package com.example.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UserModel")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserModel {

  private Integer uid;
  private String username;
  private String pwd;
  private String email;
  private long phno;
public Integer getUid() {
	return uid;
}
public void setUid(Integer uid) {
	this.uid = uid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getPhno() {
	return phno;
}
public void setPhno(long phno) {
	this.phno = phno;
}
@Override
public String toString() {
	return "UserModel [uid=" + uid + ", username=" + username + ", pwd=" + pwd + ", email=" + email + ", phno=" + phno
			+ "]";
}
  
 
}
