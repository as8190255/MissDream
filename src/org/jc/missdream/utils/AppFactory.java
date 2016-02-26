package org.jc.missdream.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * ����
 * @author Jc
 *
 */
public class AppFactory {
	private static Properties properties;
	static {
		properties=new Properties();
		try {
			properties.load(AppFactory.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��ȡָ��ʵ����
	 * @param clazz �ӿ���
	 * @return ʵ��
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getImpl(Class <T> clazz) {
		String key = clazz.getSimpleName();
		String className = properties.getProperty(key);
		try {
			return  (T)Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
