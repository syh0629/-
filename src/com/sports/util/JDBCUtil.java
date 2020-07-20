package com.sports.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCUtil {
	/**
	 * 获取数据库连接的静态方法
	 * @return
	 */
	public static Connection getConnection() {
		//一个空的连接对象
		Connection conn = null;
		try {
			//加驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接对象
			conn = DriverManager.getConnection(
					//            计算机IP地址     端口                                                                                                                                                      用户名                 密码                    
					"jdbc:mysql://localhost:3306/sports? useUnicode=yes&characterEncoding=utf8", "root", "root");
		} catch (ClassNotFoundException e) {//异常捕获
			//打印异常堆栈信息
			e.printStackTrace();
		} catch (SQLException e) {//异常捕获
			//打印异常堆栈信息
			e.printStackTrace();
		}
		//返回连接对象
		return conn;
	}
	
}
