package com.you07.util;
import java.util.ResourceBundle;

/**
 * 
 * <p>读取jdbc.properties文件辅助类</p>
 * @author LH
 * 
 */
public class JDBCConfiguration {
	private static JDBCConfiguration configuration = null;
	private static ResourceBundle resourceBundle = null;
	private static final String CONFIG_FILE = "jdbc";
	public JDBCConfiguration() {
		resourceBundle = ResourceBundle.getBundle(CONFIG_FILE);
	}
	public synchronized static JDBCConfiguration getInstance() {
		if (null == configuration) {
			configuration = new JDBCConfiguration();
		}
		return (configuration);
	}
	public  String getValue(String key) {
		return (resourceBundle.getString(key));
	}
}
