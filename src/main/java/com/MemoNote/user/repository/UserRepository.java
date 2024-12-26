package com.MemoNote.user.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserRepository {

	public int insertUser(
			@Param("loginId") String loginId
			,@Param("password")String password
			,@Param("name")String name
			,@Param("phoneNumber")String phoneNumber);
		
	
}
