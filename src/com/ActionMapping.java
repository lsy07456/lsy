package com;

import java.util.HashMap;
import java.util.Map;

public class ActionMapping {

	/*
	 * 对应framework.xml中action的节点
	 */
	private String name;
	private String classname;
	//result节点有多个
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
