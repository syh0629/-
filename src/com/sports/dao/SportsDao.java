package com.sports.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sports.entity.Role;
import com.sports.entity.Sport;
import com.sports.util.JDBCUtil;



public class SportsDao {
	public static Connection connection =null;//静态的连接对象变量
	static{//静态代码块 会在类加载时首先执行此代码块
		connection=JDBCUtil.getConnection();//获取一个jdbc连接对象
	}
	/**
	 * 查询所有运动项目
	 * @return
	 */
	public List<Sport> selectSport(){
		Sport s =null;//运动对象
		List<Sport> ss = new ArrayList<Sport>();//集合对象
		try{
			String sql="select * from sport";//sql语句
			PreparedStatement p = connection.prepareStatement(sql);//获取sql执行器
			ResultSet eq = p.executeQuery();//执行sql语句 获取结果集
			while(eq.next()){//循环遍历结果集
				s=new Sport();//new 一个运动对象
				s.setSportid(eq.getInt(1));//设置属性
				s.setSportname(eq.getString(2));//设置属性
				ss.add(s);//添加到集合中
			}
		}catch(Exception e){//异常捕获
			e.printStackTrace();//打印堆栈
		}
		return ss;//返回值
	}
	/**
	 * 新增运动项目
	 * @param s
	 * @return
	 */
	public int insertSport(Sport s){
		int result=0;//返回结果
		String sql = "insert into Sport(sportname) values(?)";//sql语句
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);//获取sql执行器
			//设置参数
			prepareStatement.setString(1, s.getSportname());
			result = prepareStatement.executeUpdate();//执行sql语句 获取结果集
		} catch (SQLException e) {//异常捕获
			e.printStackTrace();//打印堆栈
		}
		return result;//返回值
	}
	/**
	 * 更新运动项目
	 * @param s
	 * @return
	 */
	public int updateSport(Sport s){
		int result=0;//返回值
		String sql = "update Sport set sportname=? where sportid=?";//sql语句
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);//获取sql执行器
			prepareStatement.setString(1, s.getSportname());	//设置参数
			prepareStatement.setInt(2, s.getSportid());	//设置参数
			result= prepareStatement.executeUpdate();//执行sql语句 获取结果集
		} catch (SQLException e) {//异常捕获
			e.printStackTrace();//打印堆栈
		}
		return result;//返回值
	}
	/**
	 * 删除运动项目
	 * @param s
	 * @return
	 */
	public int deleteSport(Sport s){
		int result=0;//返回值
		String sql = "delete form sport where sportid=?";//sql语句
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);//获取sql执行器
			prepareStatement.setInt(1, s.getSportid());	//设置参数
			result= prepareStatement.executeUpdate();//执行sql语句
		} catch (SQLException e) {//异常捕获
			e.printStackTrace();//打印堆栈
		}
		return result;//返回值
	}
}
