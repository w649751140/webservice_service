package com.example.webserver.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.example.webserver.bean.UserInfo;

@WebService
public interface UserInfoService {
	
	@WebMethod
	String getUserInfo(UserInfo userInfo);
	
	@WebMethod
	String getUserId(String userId);
	
	@WebMethod
	String getName(@WebParam(name = "name") String name);

}
