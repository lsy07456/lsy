package com;

import java.util.HashMap;
import java.util.Map;

public class ActionMapping {

	/*
	 * ��Ӧframework.xml��action�Ľڵ�
	 */
	private String name;
	private String classname;
	//result�ڵ��ж��
	private Map<String, String> results=new HashMap<String, String>();
	
	public void addResult(String name,String value){
		results.put(name, value);
	}
	
	
	public String getResults(String name){
		return results.get(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	
}
