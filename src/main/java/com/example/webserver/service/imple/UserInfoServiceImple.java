package com.example.webserver.service.imple;

import javax.jws.WebService;

import com.example.webserver.bean.UserInfo;
import com.example.webserver.service.UserInfoService;

@WebService(name = "user" ,//对外发布的服务名
			targetNamespace ="http://service.webserver.example.com/" ,//实现接口所在包路径反转
			endpointInterface = "com.example.webserver.service.UserInfoService")//实现接口全路径
public class UserInfoServiceImple implements UserInfoService{

	@Override
	public String getUserId(String userId) {
		return userId;
	}

	@Override
	public String getName(String name) {
		return name;
	}

	@Override
	public String getUserInfo(UserInfo userInfo) {
		return userInfo.toString();
	}
	
}
