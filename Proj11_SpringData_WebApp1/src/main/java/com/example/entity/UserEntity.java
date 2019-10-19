package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Entity
@Table(name="User_Table4")
//@Where(clause = "deleted!='true'")
public class UserEntity{

@Id
@GeneratedValue
@Column(name ="id")
private Integer uid;

@Column(name="username")
private String username;

@Column(name = "pwd")
private String pwd;

@Column(name = "email")
private String email;

@Column(name="phno")
private Long phno;

@Column(name="deleted")
private Boolean deletedFlag=true;



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

public Long getPhno() {
	return phno;
}



public void setPhno(Long phno) {
	this.phno = phno;
}


public Boolean getDeletedFlag() {
	return deletedFlag;
}

public void setDeletedFlag(Boolean deletedFlag) {
	this.deletedFlag = deletedFlag;
}

@Override
public String toString() {
	return "UserEntity [uid=" + uid + ", username=" + username + ", pwd=" + pwd + ", email=" + email + ", phno=" + phno
			+ ", deletedFlag=" + deletedFlag + "]";
}


}
