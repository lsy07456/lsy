package com;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	ActionMappingManager man = null;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path=getPath(request);//loginAction

		// 获取ActionMapping对象//代表action
		ActionMapping actionMapping = man.getActionMapping(path);//获取配置配置文件中的action 用来获取可选择的路径
		// 获取action接口反射机制
		Action action = ActionManager.getActionClass(actionMapping//"com.LoginAction"
				.getClassname());//根据classname 获取loginAction 用来获取返回的字符串
		try {
			String message = action.execute(request, response);//success.error.fail
			String results = actionMapping.getResults(message);//index.jsp/login.jsp
			response.sendRedirect(results);//重定向、、还可以转发
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 获取请求的路径名
	 */
	public String getPath(HttpServletRequest request) {
		// 项目+请求地址
		String requestURI = request.getRequestURI();
		// 项目名称
		String contextPath = request.getContextPath();
		// 具体请求
		String path = requestURI.substring(contextPath.length());
		//请求的action名
		String filename = path.substring(1, path.lastIndexOf("."));

		return filename;//
	}

	/*
	 * 重写init,程序运行加载所有类
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {

		// config对象是javax.servlet.ServletConfig的对象，功能是获得初始化配置信息
		// config.getInitParameter是取得指定名称的初始化参数内容
		String filename = config.getInitParameter("config");//a.xml,b.xml
		String[] filenames = null;
		if (filename == null) {
			// 如果为空 ,
			filenames = new String[] { "framework.xml" };
		} else {
			// 若果有其他的配置参数信息，那么以，分隔存入数组中
			filenames = filename.split(",");
		}
		// 使用init方法进行初始化
		man = new ActionMappingManager(filenames);//传数组
	}

}
