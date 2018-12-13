package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	//定义两个静态字符串常量（逻辑视图名）
	public static final String SUCCESS="success";
	
	public static final String LOGIN="login";
	
	public static final String ERROR="error";
	
	public String execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
	
}
