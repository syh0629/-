package com.sports.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sports.entity.Teacher;
import com.sports.util.JDBCUtil;



public class TeacherDao {
	public static Connection connection =null;//静态的连接对象变量
	static{//静态代码块 会在类加载时首先执行此代码块
		connection=JDBCUtil.getConnection();//获取一个jdbc连接对象
	}
	/**
	 * 根据名称和密码查教练
	 * @param name
	 * @param pwd
	 * @return
	 */
	public Teacher selectTeacherByNameAndPwd(String name,String pwd){
		Teacher t=null;//老师变量
		try{
			String sql="select * from teacher where tname=? and tpwd=?";//sql语句
			PreparedStatement p = connection.prepareStatement(sql);//获取sql执行器
			//设置sql参数
			p.setString(1, name);
			//设置sql参数
			p.setString(2, pwd);
			//执行sql语句 获取结果集
			ResultSet eq = p.executeQuery();
			while(eq.next()){//遍历结果集
				t=new Teacher();//new一个老师对象
				t.setTid(eq.getInt(1));//设置属性
				t.setRid(eq.getInt(2));//设置属性
				t.setTgid(eq.getInt(3));//设置属性
				t.setSportid(eq.getInt(4));//设置属性
				t.setTname(eq.getString(5));//设置属性
				t.setTpwd(eq.getString(6));//设置属性
			}
		}catch(Exception e){//异常捕获
			e.printStackTrace();//打印堆栈
		}
		//返回
		return t;
	}
	/**
	 * 增加教练
	 * @param t
	 * @return
	 */
	public int insertTeacher(Teacher t){
		int result=0;//返回值
		String sql = "insert into teacher(rid,sportid,tgid,tname,tpwd) values(?,?,?,?,?)";//sql语句
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);//获取sql执行器
			prepareStatement.setInt(1, t.getRid());
			//设置sql参数
			prepareStatement.setString(4, t.getTname());
			//设置sql参数
			prepareStatement.setString(5, t.getTpwd());
			//设置sql参数
			prepareStatement.setInt(2, t.getSportid());
			//设置sql参数
			prepareStatement.setInt(3, t.getTgid());
			//执行sql语句 获取结果集
			result = prepareStatement.executeUpdate();
		} catch (SQLException e) {//异常捕获
			// 打印堆栈
			e.printStackTrace();
		}
		//返回
		return result;
	}
	/**
	 * 更新教练
	 * @param t
	 * @return
	 */
	public int updateTeacher(Teacher t){
		int result=0;//返回值
		String sql = "update teacher set tpwd=? where tid=?";//sql语句
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);//获取sql执行器
			//设置sql参数
			prepareStatement.setString(1, t.getTpwd());
			//设置sql参数
			prepareStatement.setInt(2,t.getTid());
			//执行sql语句 获取结果集
			result= prepareStatement.executeUpdate();
		} catch (SQLException e) {//异常捕获
			// 打印堆栈
			e.printStackTrace();
		}
		//返回
		return result;
	}
	/**
	 * 删除教练
	 * @param s
	 * @return
	 */
	public int deleteTeacher(Teacher s){
		int result=0;//返回值
		String sql = "delete from teacher where tid=?";//sql语句
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);//获取sql执行器
			//设置sql参数
			prepareStatement.setInt(1, s.getTid());
			//执行sql语句 获取结果集
			result= prepareStatement.executeUpdate();
		} catch (SQLException e) {//异常捕获
			// 打印堆栈
			e.printStackTrace();
		}
		//返回
		return result;
	}
	/**
	 * 查询所有教练
	 * @return
	 */
	public List<Teacher> selectAllTeacher(){
		Teacher t=null;//老师变量
		List<Teacher> ts = new ArrayList<Teacher>();//集合对象
		try{ 
			String sql="select * from teacher";//sql语句
			PreparedStatement p = connection.prepareStatement(sql);//获取sql执行器
			//执行sql语句 获取结果集
			ResultSet eq = p.executeQuery();
			while(eq.next()){//遍历结果集
				t=new Teacher();//new一个老师对象
				t.setTid(eq.getInt(1));//设置属性
				t.setRid(eq.getInt(2));//设置属性
				t.setTgid(eq.getInt(3));//设置属性
				t.setSportid(eq.getInt(4));//设置属性
				t.setTname(eq.getString(5));//设置属性
				t.setTpwd(eq.getString(6));//设置属性
				ts.add(t);//添加到集合
			}
		}catch(Exception e){//异常捕获
			// 打印堆栈
			e.printStackTrace();
		}
		//返回
		return ts;
	}
	/**
	 * 根据id查教练
	 * @param tid
	 * @return
	 */
	public Teacher selectTeacherbyTid(Integer tid) {
		Teacher t=null;//老师对象
		try{
			String sql="select * from teacher where tid=?";//sql语句
			PreparedStatement p = connection.prepareStatement(sql);//获取sql执行器
			//设置sql参数
			p.setInt(1, tid);
			//执行sql语句 获取结果集
			ResultSet eq = p.executeQuery();
			while(eq.next()){//遍历结果集
				t=new Teacher();//new一个老师对象
				t.setTid(eq.getInt(1));//设置属性
				t.setRid(eq.getInt(2));//设置属性
				t.setTgid(eq.getInt(3));//设置属性
				t.setSportid(eq.getInt(4));//设置属性
				t.setTname(eq.getString(5));//设置属性
				t.setTpwd(eq.getString(6));//设置属性
			}
		}catch(Exception e){//异常捕获
			// 打印堆栈
			e.printStackTrace();
		}
		//返回
		return t;
	}
}
