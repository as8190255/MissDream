package org.jc.missdream.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * 工厂
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
	 * 获取指定实现类
	 * @param clazz 接口类
	 * @return 实现
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
