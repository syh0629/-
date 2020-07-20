package com.sports.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sports.entity.Role;
import com.sports.util.JDBCUtil;



public class RoleDao {
	public static Connection connection =null;//静态的连接对象变量
	static{//静态代码块 会在类加载时首先执行此代码块
		connection=JDBCUtil.getConnection();//获取一个jdbc连接对象
	}
	/**
	 * 查询所有角色
	 * @return
	 */
	public List<Role> selectRole(){
		//role类型的变量
		Role r =null;
		//存储role对象的集合
		List<Role> rs = new ArrayList<Role>();
		try{
			//sql语句
			String sql="select * from role";
			//获取sql执行器
			PreparedStatement p = connection.prepareStatement(sql);
			//执行sql语句
			ResultSet eq = p.executeQuery();
			//遍历结果集
			while(eq.next()){
				//new一个role对象
				r=new Role();
				//设置属性
				r.setRid(eq.getInt(1));
				//设置属性
				r.setRole(eq.getString(2));
				//添加到集合中
				rs.add(r);
			}
			//异常捕获
		}catch(Exception e){
			//打印堆栈
			e.printStackTrace();
		}
		//返回值
		return rs;
	}
	/**
	 * 新增角色
	 * @param r
	 * @return
	 */
	public int insertRole(Role r){
		int result=0;//返回值
		//sql语句
		String sql = "insert into role(role) values(?)";
		try {//获取sql执行器
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			//设置参数
			prepareStatement.setString(1, r.getRole());
			//执行sql语句
			result = prepareStatement.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {//异常捕获
			// TODO Auto-generated catch block
			e.printStackTrace();//打印堆栈
		}
		return result;//返回结果
	}
	/**
	 * 更新角色
	 * @param r
	 * @return
	 */
	public int updateRole(Role r){
		int result=0;//返回值
		//sql语句
		String sql = "update role set role=? where rid=?";//sql语句
		try {//获取sql执行器
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, r.getRole());//设置参数
			prepareStatement.setInt(2, r.getRid());//设置参数
			//执行sql语句
			result= prepareStatement.executeUpdate();
		} catch (SQLException e) {//异常捕获
			// TODO Auto-generated catch block
			e.printStackTrace();//打印堆栈
		}
		return result;//返回结果
	}
}
