package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		
		if ("1".equals(name)) {//ÖØÃû
			return SUCCESS;
		}else if("tologin".equals(name)){
			return LOGIN;
		}else {
			return ERROR;
		}
	}

}
