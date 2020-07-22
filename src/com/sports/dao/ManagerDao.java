package com.sports.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.sports.entity.Manager;
import com.sports.util.JDBCUtil;

public class ManagerDao {
	public static Connection connection = null;// 静态的连接对象变量
	static {// 静态代码块 会在类加载时首先执行此代码块
		connection = JDBCUtil.getConnection();// 获取一个jdbc连接对象
	}

	/**
	 * 查找单个管理员
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 */
	public Manager selectManagerByNameAndPwd(String name, String pwd) {
		// 一个manager变量
		Manager m = null;
		try {
			// sql语句
			String sql = "select * from manager where username=? and mpwd=?";
			// 获取sql执行器
			PreparedStatement p = connection.prepareStatement(sql);
			// 设置参数
			p.setString(1, name);
			// 设置参数
			p.setString(2, pwd);
			// 获取结果集
			ResultSet eq = p.executeQuery();
			// 遍历结果集
			while (eq.next()) {
				// new一个manager对象
				m = new Manager();
				// 设置属性
				m.setMid(eq.getInt(1));
				// 设置属性
				m.setRid(eq.getInt(2));
				// 设置属性
				m.setMname(eq.getString(3));
				// 设置属性
				m.setMpwd(eq.getString(4));
				// 设置属性
				m.setUsername(eq.getString(5));
				// 设置属性
				m.setPhone(eq.getString(6));
			}
		} catch (Exception e) {// 异常捕获
			e.printStackTrace();// 打印堆栈信息
		}
		// 返回
		return m;
	}

	public Manager selectManagerByUserName(String name) {
		// 一个manager变量
		Manager m = null;
		try {
			// sql语句
			String sql = "select * from manager where username=?";
			// 获取sql执行器
			PreparedStatement p = connection.prepareStatement(sql);
			// 设置参数
			p.setString(1, name);
			// 获取结果集
			ResultSet eq = p.executeQuery();
			// 遍历结果集
			while (eq.next()) {
				// new一个manager对象
				m = new Manager();
				// 设置属性
				m.setMid(eq.getInt(1));
				// 设置属性
				m.setRid(eq.getInt(2));
				// 设置属性
				m.setMname(eq.getString(3));
				// 设置属性
				m.setMpwd(eq.getString(4));
				// 设置属性
				m.setUsername(eq.getString(5));
				// 设置属性
				m.setPhone(eq.getString(6));
			}
		} catch (Exception e) {// 异常捕获
			e.printStackTrace();// 打印堆栈信息
		}
		// 返回
		return m;
	}

	/**
	 * 新增管理员
	 * 
	 * @param m
	 * @return
	 */
	public int insertManager(Manager m) {
		int result = 0;
		// sql语句
		String sql = "insert into manager(mname,mpwd,rid,username,phone) values(?,?,?,?,?)";
		try {
			// 获取sql执行器
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			// 设置参数
			prepareStatement.setString(1, m.getMname());
			// 设置参数
			prepareStatement.setString(2, m.getMpwd());
			// 设置参数
			prepareStatement.setInt(3, m.getRid());
			// 设置参数
			prepareStatement.setString(4, m.getUsername());
			// 设置参数
			prepareStatement.setString(5, m.getPhone());
			// 获取结果集
			result = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 返回
		return result;
	}

	/**
	 * 更新管理员
	 * 
	 * @param m
	 * @return
	 */
	public int updateManager(Manager m) {
		int result = 0;
		// sql语句
		String sql = "update manager set mpwd=? where mid=?";
		try {
			// 获取sql执行器
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			// 设置参数
			prepareStatement.setString(1, m.getMpwd());
			// 设置参数
			prepareStatement.setInt(2, m.getMid());
			// 获取结果集
			result = prepareStatement.executeUpdate();
		} catch (SQLException e) {// 异常捕获
			// 打印堆栈信息
			e.printStackTrace();
		}
		// 返回
		return result;
	}

	public Manager passwordForget(String username, String name, String phone) {
		// 一个manager变量
		Manager m = null;
		try {
			// sql语句
			String sql = "select * from manager where username=? and mname=? and phone=?";
			// 获取sql执行器
			PreparedStatement p = connection.prepareStatement(sql);
			// 设置参数
			p.setString(1, username);
			// 设置参数
			p.setString(2, name);
			// 设置参数
			p.setString(3, phone);
			// 获取结果集
			ResultSet eq = p.executeQuery();
			// 遍历结果集
			while (eq.next()) {
				// new一个manager对象
				m = new Manager();
				// 设置属性
				m.setMid(eq.getInt(1));
				// 设置属性
				m.setRid(eq.getInt(2));
				// 设置属性
				m.setMname(eq.getString(3));
				// 设置属性
				m.setMpwd(eq.getString(4));
				// 设置属性
				m.setUsername(eq.getString(5));
				// 设置属性
				m.setPhone(eq.getString(6));
			}
			
		} catch (Exception e) {// 异常捕获
			e.printStackTrace();// 打印堆栈信息
		}
		// 返回
		return m;
	}
}
