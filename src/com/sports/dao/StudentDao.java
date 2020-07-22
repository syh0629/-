package com.sports.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sports.entity.Student;
import com.sports.entity.Teacher;
import com.sports.util.JDBCUtil;



public class StudentDao {
	public static Connection connection =null;//静态的连接对象变量
	static{//静态代码块 会在类加载时首先执行此代码块
		connection=JDBCUtil.getConnection();//获取一个jdbc连接对象
	}
	/**
	 * 根据名称和密码查学生
	 * @param name
	 * @param pwd
	 * @return
	 */
	public Student selectStudentByNameAndPwd(String name,String pwd){
		//学生对象
		Student s=null;
		try{
			String sql="select * from student where username=? and spwd=?";//sql语句
			PreparedStatement p = connection.prepareStatement(sql);//获取sql执行器
			p.setString(1, name);//设置参数
			p.setString(2, pwd);//设置参数
			ResultSet eq = p.executeQuery();//执行sql语句
			while(eq.next()){//循环遍历
				s=new Student();//new 一个学生对象
				s.setSid(eq.getInt(1));//设置属性
				s.setSname(eq.getString(2));//设置属性
				s.setSpwd(eq.getString(3));//设置属性
				s.setTid(eq.getInt(4));//设置属性
				s.setTgid(eq.getInt(5));//设置属性
				s.setSportid(eq.getInt(6));//设置属性
				s.setRid(eq.getInt(7));//设置属性
				s.setUsername(eq.getString(8));//设置属性
				s.setPhone(eq.getString(9));//设置属性
			}
		}catch(Exception e){//异常捕获
			e.printStackTrace();//打印堆栈
		}
		//返回值
		return s;
	}
	/**
	 * 增加学生
	 * @param s
	 * @return
	 */
	public int insertStudent(Student s){
		int result=0;
		//sql语句
		String sql = "insert into student(rid,sname,sportid,spwd,tgid,tid,username,phone) values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);//获取sql执行器
			prepareStatement.setInt(1, s.getRid());//设置参数
			prepareStatement.setString(2, s.getSname());//设置参数
			prepareStatement.setString(4, s.getSpwd());//设置参数
			prepareStatement.setInt(3, s.getSportid());//设置参数
			prepareStatement.setInt(5, s.getTgid());//设置参数
			prepareStatement.setInt(6, s.getTid());//设置参数
			prepareStatement.setString(7, s.getUsername());//设置参数
			prepareStatement.setString(8, s.getPhone());//设置参数
			result = prepareStatement.executeUpdate();//执行sql语句
		} catch (SQLException e) {//异常捕获
			//打印堆栈信息
			e.printStackTrace();
		}
		return result;//返回值
	}
	/**
	 * 更新学生
	 * @param s
	 * @return
	 */
	public int updateStudent(Student s){
		int result=0;
		String sql = "update student set spwd=? where sid=?";//sql语句
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);//获取sql执行器
			prepareStatement.setString(1, s.getSpwd());//设置参数
			prepareStatement.setInt(2, s.getSid());//设置参数
			result= prepareStatement.executeUpdate();//执行sql语句
		} catch (SQLException e) {//异常捕获
			//打印堆栈信息
			e.printStackTrace();
		}
		return result;//返回值
	}
	/**
	 * 更换老师
	 * @param s
	 * @return
	 */
	public int updateStudentTeacher(Student s){
		int result=0;
		String sql = "update student set tid=? where sid=?";//sql语句
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);//获取sql执行器
			prepareStatement.setInt(1, s.getTid());//设置参数
			prepareStatement.setInt(2, s.getSid());//设置参数
			result= prepareStatement.executeUpdate();//执行sql语句
		} catch (SQLException e) {//异常捕获
			//打印堆栈信息
			e.printStackTrace();
		}
		return result;//返回值
	}
	public int deleteStudent(Student s){
		int result=0;
		String sql = "delete from student where sid=?";//sql语句
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);//获取sql执行器
			prepareStatement.setInt(1, s.getSid());//设置参数
			result= prepareStatement.executeUpdate();//执行sql语句
		} catch (SQLException e) {//异常捕获
			//打印堆栈信息
			e.printStackTrace();
		}
		return result;//返回值
	}
	/**
	 * 查询所有学生
	 * @param t
	 * @return
	 */
	public List<Student> selectStudentByTid(Teacher t) {
		Student s=null;//student变量
		List<Student> ss = new ArrayList<Student>();//集合对象
		try{
			String sql="select * from student where tid=?";//sql语句
			PreparedStatement p = connection.prepareStatement(sql);//获取sql执行器
			p.setInt(1, t.getTid());//设置参数
			ResultSet eq = p.executeQuery();//执行sql语句
			while(eq.next()){//遍历结果集
				s=new Student();//new一个学生对象
				s.setSid(eq.getInt(1));//设置属性
				s.setSname(eq.getString(2));//设置属性
				s.setSpwd(eq.getString(3));//设置属性
				s.setTid(eq.getInt(4));//设置属性
				s.setTgid(eq.getInt(5));//设置属性
				s.setSportid(eq.getInt(6));//设置属性
				s.setRid(eq.getInt(7));//设置属性
				s.setUsername(eq.getString(8));//设置属性
				s.setPhone(eq.getString(9));//设置属性
				ss.add(s);//添加到集合中
			}
		}catch(Exception e){//异常捕获
			//打印堆栈信息
			e.printStackTrace();
		}
		return ss;
	}
	/**
	 * 根据id查学生
	 * @param hperson
	 * @return
	 */
	public Student selectStudentBySid(Integer hperson) {
		Student s=null;//学生变量
		
		try{
			String sql="select * from student where sid=?";//sql语句
			PreparedStatement p = connection.prepareStatement(sql);//获取sql执行器
			p.setInt(1, hperson);//设置参数
			ResultSet eq = p.executeQuery();//执行sql语句
			while(eq.next()){//遍历结果集
				s=new Student();//new 学生对象
				s.setSid(eq.getInt(1));//设置属性
				s.setSname(eq.getString(2));//设置属性
				s.setSpwd(eq.getString(3));//设置属性
				s.setTid(eq.getInt(4));//设置属性
				s.setTgid(eq.getInt(5));//设置属性
				s.setSportid(eq.getInt(6));//设置属性
				s.setRid(eq.getInt(7));//设置属性
				s.setUsername(eq.getString(8));//设置属性
				s.setPhone(eq.getString(9));//设置属性
			}
		}catch(Exception e){//异常捕获
			//打印堆栈信息
			e.printStackTrace();
		}
		return s;//返回值
	}
	/**
	 * 根据username查学生
	 * @param hperson
	 * @return
	 */
	public Student selectStudentByUsername(String username) {
		Student s=null;//学生变量
		
		try{
			String sql="select * from student where username=?";//sql语句
			PreparedStatement p = connection.prepareStatement(sql);//获取sql执行器
			p.setString(1, username);//设置参数
			ResultSet eq = p.executeQuery();//执行sql语句
			while(eq.next()){//遍历结果集
				s=new Student();//new 学生对象
				s.setSid(eq.getInt(1));//设置属性
				s.setSname(eq.getString(2));//设置属性
				s.setSpwd(eq.getString(3));//设置属性
				s.setTid(eq.getInt(4));//设置属性
				s.setTgid(eq.getInt(5));//设置属性
				s.setSportid(eq.getInt(6));//设置属性
				s.setRid(eq.getInt(7));//设置属性
				s.setUsername(eq.getString(8));//设置属性
				s.setPhone(eq.getString(9));//设置属性
			}
		}catch(Exception e){//异常捕获
			//打印堆栈信息
			e.printStackTrace();
		}
		return s;//返回值
	}
	/**
	 * 查询所有学生
	 * @return
	 */
	public List<Student> selectAllStudent() {
		Student s=null;//student变量
		List<Student> ss = new ArrayList<Student>();//集合对象
		try{
			String sql="select * from student";//sql语句
			PreparedStatement p = connection.prepareStatement(sql);//获取sql执行器
			ResultSet eq = p.executeQuery();//执行sql语句
			while(eq.next()){//遍历结果集
				s=new Student();//new一个学生对象
				s.setSid(eq.getInt(1));//设置属性
				s.setSname(eq.getString(2));//设置属性
				s.setSpwd(eq.getString(3));//设置属性
				s.setTid(eq.getInt(4));//设置属性
				s.setTgid(eq.getInt(5));//设置属性
				s.setSportid(eq.getInt(6));//设置属性
				s.setRid(eq.getInt(7));//设置属性
				s.setUsername(eq.getString(8));//设置属性
				s.setPhone(eq.getString(9));//设置属性
				ss.add(s);//添加到集合中
			}
		}catch(Exception e){//异常捕获
			//打印堆栈信息
			e.printStackTrace();
		}
		return ss;
	}
}
