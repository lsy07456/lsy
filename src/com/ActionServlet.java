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

		// ��ȡActionMapping����//����action
		ActionMapping actionMapping = man.getActionMapping(path);//��ȡ���������ļ��е�action ������ȡ��ѡ���·��
		// ��ȡaction�ӿڷ������
		Action action = ActionManager.getActionClass(actionMapping//"com.LoginAction"
				.getClassname());//����classname ��ȡloginAction ������ȡ���ص��ַ���
		try {
			String message = action.execute(request, response);//success.error.fail
			String results = actionMapping.getResults(message);//index.jsp/login.jsp
			response.sendRedirect(results);//�ض��򡢡�������ת��
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * ��ȡ�����·����
	 */
	public String getPath(HttpServletRequest request) {
		// ��Ŀ+�����ַ
		String requestURI = request.getRequestURI();
		// ��Ŀ����
		String contextPath = request.getContextPath();
		// ��������
		String path = requestURI.substring(contextPath.length());
		//�����action��
		String filename = path.substring(1, path.lastIndexOf("."));

		return filename;//
	}

	/*
	 * ��дinit,�������м���������
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {

		// config������javax.servlet.ServletConfig�Ķ��󣬹����ǻ�ó�ʼ��������Ϣ
		// config.getInitParameter��ȡ��ָ�����Ƶĳ�ʼ����������
		String filename = config.getInitParameter("config");//a.xml,b.xml
		String[] filenames = null;
		if (filename == null) {
			// ���Ϊ�� ,
			filenames = new String[] { "framework.xml" };
		} else {
			// ���������������ò�����Ϣ����ô�ԣ��ָ�����������
			filenames = filename.split(",");
		}
		// ʹ��init�������г�ʼ��
		man = new ActionMappingManager(filenames);//������
	}

}
