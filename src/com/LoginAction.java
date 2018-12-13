package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		
		
		if ("1".equals(name) && "1".equals(pwd)) {
			return SUCCESS;
		}else if("tologin".equals(name)){
			return LOGIN;
		}else {
			return ERROR;
		}
	}
}
