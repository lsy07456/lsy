package com;

/**
 * ʹ�÷�����Ƹ����ַ������͵�������ȡ���������
 * 
 * @author zx
 * 
 */
public class ActionManager {

	public static Action getActionClass(String classname) {
		Class clazz = null;
		Action action = null;
		// ��ȡ��ǰ�̵߳��������
		try {
			// ����߳��е�����ôһ���ֱ࣬�Ӹ���������ȡ���������
			clazz = Thread.currentThread().getContextClassLoader().loadClass(
					classname);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (clazz == null) {
			try {
				// ������߳���û�У���ôʹ��class.forname������ȡ
				clazz = Class.forName(classname);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (action == null) {
			try {
				// ����ȡ��������ת��Ϊaction�������޲ι��캯����ĳ�̶ֳ����൱��new������new��Ҫָ������
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