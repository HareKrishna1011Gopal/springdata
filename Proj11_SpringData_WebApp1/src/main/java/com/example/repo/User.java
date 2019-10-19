package com.example.repo;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.UserEntity;

@Repository
public interface User extends JpaRepository<UserEntity,Serializable>{
	
	@Query(value = "Select email from UserEntity")
       public List<String> findAllEmail();
	
	@Query(value = "Select email from UserEntity where uid=:uid")
	public String findEmailById(Integer uid);
	
	@Query(value = "update UserEntity set deletedFlag=0 where uid=:uid")
	@Modifying
	@Transactional
	public void updateDelete(Integer uid);
	
	@Query(value = "Select u from UserEntity u where u.deletedFlag=true")
	public Page<UserEntity> getUserAfterSoftDelete(PageRequest pg);
}
