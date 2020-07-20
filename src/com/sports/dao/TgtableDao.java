package com.sports.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sports.entity.Role;
import com.sports.entity.Teacher;
import com.sports.entity.Tgtable;
import com.sports.util.JDBCUtil;



public class TgtableDao {
	public static Connection connection =null;//静态的连接对象变量
	static{//静态代码块 会在类加载时首先执行此代码块
		connection=JDBCUtil.getConnection();//获取一个jdbc连接对象
	}
	/**
	 * 查询所有运动场地
	 * @return
	 */
	public List<Tgtable> selectTgtable(){
		Tgtable r =null;//运动场对象
		List<Tgtable> rs = new ArrayList<Tgtable>();//集合对象
		try{
			String sql="select * from tgtable";//sql语句
			PreparedStatement p = connection.prepareStatement(sql);//获取sql语句执行器
			ResultSet eq = p.executeQuery();//执行sql语句 获取结果集
			while(eq.next()){//循环遍历结果集
				r=new Tgtable();//new一个运动场对象
				r.setTgid(eq.getInt(1));//设置属性
				r.setTgname(eq.getString(2));//设置属性
				r.setTgadd(eq.getString(3));//设置属性
				rs.add(r);//添加到集合中
			}
		}catch(Exception e){//异常捕获
			e.printStackTrace();//打印堆栈信息
		}
		return rs;//返回
	}
	/**
	 * 新增运动场
	 * @param t
	 * @return
	 */
	public int insertTgtable(Tgtable t){
		int result=0;//返回值
		String sql = "insert into tgtable(tgname,tgadd) values(?,?)";//sql语句
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);//获取sql语句执行器
			prepareStatement.setString(1, t.getTgname());//设置sql参数
			prepareStatement.setString(2, t.getTgadd());//设置sql参数
			result = prepareStatement.executeUpdate();//执行sql语句 获取结果集
		} catch (SQLException e) {//异常捕获
			e.printStackTrace();//打印堆栈信息
		}
		return result;//返回
	}
	/**
	 * 更新运动场
	 * @param t
	 * @return
	 */
	public int updateTgtable(Tgtable t){
		int result=0;//返回值
		String sql = "update role set tname=?,tgadd=? where tgid=?";//sql语句
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);//获取sql语句执行器
			prepareStatement.setString(1, t.getTgname());//设置sql参数
			prepareStatement.setString(2, t.getTgadd());//设置sql参数
			prepareStatement.setInt(3, t.getTgid());//设置sql参数
			result= prepareStatement.executeUpdate();//执行sql语句 获取结果集
		} catch (SQLException e) {//异常捕获
			e.printStackTrace();//打印堆栈信息
		}
		return result;//返回
	}
	/**
	 * 删除运动场
	 * @param t
	 * @return
	 */
	public int deleteTgtable(Tgtable t){
		int result=0;//返回值
		String sql = "delete from tgtable where tgid=?";//sql语句
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);//获取sql语句执行器
			prepareStatement.setInt(1, t.getTgid());//设置sql参数
			result= prepareStatement.executeUpdate();//执行sql语句 获取结果集
		} catch (SQLException e) {//异常捕获
			e.printStackTrace();//打印堆栈信息
		}
		return result;
	}
	/**
	 * 根据id查运动场
	 * @param tgid
	 * @return
	 */
	public Tgtable selectTgByTgid(Integer tgid) {
		Tgtable r =null;//运动场对象变量
		try{
			String sql="select * from tgtable where tgid=?";//sql语句
			PreparedStatement p = connection.prepareStatement(sql);//获取sql语句执行器
			p.setInt(1, tgid);//设置sql参数
			ResultSet eq = p.executeQuery();//执行sql语句 获取结果集
			while(eq.next()){//循环遍历结果集
				r=new Tgtable();//new一个运动场对象
				r.setTgid(eq.getInt(1));//设置属性
				r.setTgname(eq.getString(2));//设置属性
				r.setTgadd(eq.getString(3));//设置属性
			}
		}catch(Exception e){//异常捕获
			e.printStackTrace();//打印堆栈信息
		}
		return r;
	}
}
