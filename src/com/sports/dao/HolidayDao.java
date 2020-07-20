package com.sports.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sports.entity.Holiday;
import com.sports.entity.Student;
import com.sports.util.JDBCUtil;

public class HolidayDao {
	public static Connection connection =null;//静态的连接对象变量
	static{//静态代码块 会在类加载时首先执行此代码块
		connection=JDBCUtil.getConnection();//获取一个jdbc连接对象
	}

	/**
	 * 查找请假信息
	 * 
	 * @return
	 */
	public List<Holiday> selectAllHolid() {
		// 新建一个list集合对象储存假期实体类对象
		List<Holiday> holidays = new ArrayList<Holiday>();
		try {
			// sql语句
			String sql = "select * from holiday";
			// 获取sql执行器
			PreparedStatement p = connection.prepareStatement(sql);
			// 执行sql语句
			ResultSet eq = p.executeQuery();
			// 便利结果集,并赋值给假期对象
			while (eq.next()) {
				// new一个假期对象
				Holiday h = new Holiday();
				// 给属性赋值
				h.setHid(eq.getInt(1));
				// 给属性赋值
				h.setHdate(eq.getInt(2));
				// 给属性赋值
				h.setHperson(eq.getInt(3));
				// 给属性赋值
				h.setHsta(eq.getString(4));
				// 给属性赋值
				h.setRole(eq.getInt(5));
				// 添加到集合中
				holidays.add(h);
			}
			// 异常捕获
		} catch (Exception e) {
			// 打印堆栈信息
			e.printStackTrace();
		}
		// 返回集合对象
		return holidays;
	}

	/**
	 * 填加请假信息
	 * 
	 * @param h
	 * @return
	 */
	public int insertHoliday(Holiday h) {
		// 准备一个返回值
		int result = 0;
		// sql语句
		String sql = "insert into holiday(hperson,hdate,role,hsta) values(?,?,?,?)";
		try {
			// 获取sql执行器
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			// 设置参数
			prepareStatement.setInt(1, h.getHperson());
			// 设置参数
			prepareStatement.setInt(2, h.getHdate());
			// 设置参数
			prepareStatement.setInt(3, h.getRole());
			// 设置参数
			prepareStatement.setString(4, h.getHsta());
			// 执行sql语句
			result = prepareStatement.executeUpdate();
		} // 异常捕获
		catch (Exception e) {
			// 打印堆栈信息
			e.printStackTrace();
		}
		// 返回
		return result;
	}

	/**
	 * 更新请假信息
	 * 
	 * @param h
	 * @return
	 */
	public int updateHoliday(Holiday h) {
		int result = 0;//返回值
		String sql = "update holiday set hsta=? where hid=?";//sql语句
		try {// 获取sql执行器
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			// 设置参数
			prepareStatement.setInt(2, h.getHid());
			// 设置参数
			prepareStatement.setString(1, h.getHsta());
			// 执行sql语句
			result = prepareStatement.executeUpdate();
		} catch (SQLException e) {//异常捕获
			//打印堆栈信息
			e.printStackTrace();
		}
		//返回
		return result;
	}

	/**
	 * 查找单个请假信息
	 * 
	 * @param s
	 * @return
	 */
	public Holiday selectOneHoliday(Student s) {
		Holiday holiday = null;//假期对象变量
		try {
			String sql = "select * from holiday where hperson=? and role=?";//sql语句
			PreparedStatement p = connection.prepareStatement(sql);//获取sql执行器
			// 设置参数
			p.setInt(1, s.getSid());
			// 设置参数
			p.setInt(2, s.getRid());
			//执行sql语句获取结果集
			ResultSet eq = p.executeQuery();
			while (eq.next()) {//循环遍历结果集
				//new一个holiday对象
				holiday = new Holiday();
				//设置属性
				holiday.setHid(eq.getInt(1));
				//设置属性
				holiday.setHdate(eq.getInt(2));
				//设置属性
				holiday.setHperson(eq.getInt(3));
				//设置属性
				holiday.setHsta(eq.getString(4));
				//设置属性
				holiday.setRole(eq.getInt(5));

			}
		} catch (Exception e) {//异常捕获
			e.printStackTrace();//打印堆栈信息
		}
		return holiday;//返回
	}
}
