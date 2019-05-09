package com.example.webserver.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.webserver.service.UserInfoService;
import com.example.webserver.service.imple.UserInfoServiceImple;

@Configuration
public class WebServiceConfig {

	@SuppressWarnings({ "all" })
	@Bean
	public ServletRegistrationBean adispatcherServlet() {
		return new ServletRegistrationBean(new CXFServlet(), "/*");
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}

	// 把实现类交给spring管理
	@Bean 
	public UserInfoService userInfoService() { 
		return new UserInfoServiceImple(); 
	}

	// 终端路径
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), userInfoService());
//		endpoint.getInInterceptors().add(new AuthInterceptor());// 添加校验拦截器
		endpoint.publish("/user");
		return endpoint;
	}

}
