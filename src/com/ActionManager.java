package com;

/**
 * 使用反射机制根据字符串类型的类名获取到具体的类
 * 
 * @author zx
 * 
 */
public class ActionManager {

	public static Action getActionClass(String classname) {
		Class clazz = null;
		Action action = null;
		// 获取当前线程的类加载器
		try {
			// 如果线程中的有那么一个类，直接根据类名获取该类的类型
			clazz = Thread.currentThread().getContextClassLoader().loadClass(
					classname);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (clazz == null) {
			try {
				// 如果该线程中没有，那么使用class.forname方法获取
				clazz = Class.forName(classname);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (action == null) {
			try {
				// 将获取到的类型转换为action，调用无参构造函数，某种程度上相当于new，不过new需要指定类型
				action = (Action) clazz.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return action;
	}
}