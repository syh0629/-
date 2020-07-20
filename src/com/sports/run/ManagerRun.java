package com.sports.run;


import java.util.Scanner;

import com.sports.dao.ManagerDao;
import com.sports.dao.SportsDao;
import com.sports.dao.StudentDao;
import com.sports.dao.TeacherDao;
import com.sports.dao.TgtableDao;
import com.sports.entity.Manager;
import com.sports.entity.Student;
import com.sports.entity.Teacher;
import com.sports.entity.Tgtable;

public class ManagerRun {
	//new一个scanner对象 用于接收控制台输入的内容
	Scanner sc = new Scanner(System.in);
	//new一个运动的数据库操作对象
	SportsDao sd = new SportsDao();
	//new一个运动场的数据库操作对象
	TgtableDao td = new TgtableDao();
	//new一个老师的数据库操作对象
	TeacherDao ted = new TeacherDao();
	//new一个学生的数据库操作对象
	StudentDao std = new StudentDao();
	//new一个管理员的数据库操作对象
	ManagerDao md = new ManagerDao();
	//准备一个空的管理员对象用于保存当前登录的管理员信息
	Manager m =null;
	/**
	 * 登录的操作方法
	 * @param name
	 * @param pwd
	 * @return
	 */
	public int Login(String name,String pwd){
		//根据姓名和密码查询管理员信息
		Manager i = md.selectManagerByNameAndPwd(name, pwd);
		//将查询到的管理员的信息存储
		m=i;
		//如果没有查询到数据
		if(i==null){
			//返回 0
			return 0;
		}else{//否则返回1
			//返回1
			return 1;
		}
	}
	/**
	 * 新增老师的方法
	 */
	public void newTeacher(){
		//new一个老师对象
		Teacher t = new Teacher();
		//在控制台打印提示信息
		System.out.println("请输入教练姓名");
		//接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		t.setTname(sc.next());
		//在控制台打印提示信息
		System.out.println("请输入教练密码");
		//接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		t.setTpwd(sc.next());
		//设置角色id为2
		t.setRid(2);
		//在控制台打印提示信息
		System.out.println("请选择运动项目");
		//查询所以运动项目并打印至控制台
		System.out.println(sd.selectSport().toString());
		//接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		t.setSportid(sc.nextInt());
		//在控制台打印提示信息
		System.out.println("请选择训练场地");
		//查询所有的运动场信息并打印到控制台
		System.out.println(td.selectTgtable().toString());
		//接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		t.setTgid(sc.nextInt());
		//调用数据库操作对象的新增数据方法
		int re = ted.insertTeacher(t);
		//新增数据成功返回1
		if(re==1){
			//在控制台打印提示信息
			System.out.println("新增成功");
		}else{
			//在控制台打印提示信息
			System.out.println("请重新添加");
		}
		
	}
	/**
	 * 新增学生方法
	 */
	public void newStudent(){
		//new一个学生对象
		Student s = new Student();
		//在控制台打印提示信息
		System.out.println("请输入学生姓名");
		//接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		s.setSname(sc.next());
		//在控制台打印提示信息
		System.out.println("请输入学生密码");
		//接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		s.setSpwd(sc.next());
		//在控制台打印提示信息
		System.out.println("请选择运动项目");
		//查询所有运动项目并打印至控制台
		System.out.println(sd.selectSport().toString());
		//接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		s.setSportid(sc.nextInt());
		//在控制台打印提示信息
		System.out.println("请输入教练编号");
		//查询所有教师信息并打印至控制台
		System.out.println(ted.selectAllTeacher().toString());
		//接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		s.setTid(sc.nextInt());
		//在控制台打印提示信息
		System.out.println("请选择训练场地");
		//查询所有训练场信息并打印至控制台
		System.out.println(td.selectTgtable().toString());
		//接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		s.setTgid(sc.nextInt());
		//设置角色id为3
		s.setRid(3);
		//调用数据库操作方法保存数据信息
		int i = std.insertStudent(s);
		//新增成功返回1 否则表示失败
		if(i==1){
			//在控制台打印提示信息
			System.out.println("添加成功");
		}else{
			//在控制台打印提示信息
			System.out.println("请重新填加");
		}
	}
	/**
	 * 新增运动场的方法
	 */
	public void newtg() {
		//new一个运动场对象
		Tgtable t= new Tgtable();
		//在控制台打印提示信息
		System.out.println("请输入运动场名称");
		//接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		t.setTgname(sc.next());
		//在控制台打印提示信息
		System.out.println("请输入运动场地址");
		//接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		t.setTgadd(sc.next());
		//调用数据库操作对象的新增方法将数据添加到数据库
		int i = td.insertTgtable(t);
		//添加成功返回1 否则表示添加失败
		if(i==1){
			//在控制台打印提示信息
			System.out.println("添加成功");
		}else{
			//在控制台打印提示信息
			System.out.println("请重新填加");
		}		
	}
	/**
	 * 修改密码
	 */
	public void updatepwd() {
		//在控制台打印提示信息
		System.out.println("请输入新密码");
		//接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		m.setMpwd(sc.next());
		//更新数据库的信息
		int i = md.updateManager(m);	
		//更新成功返回1否则更新失败
		if(i==1){
			//在控制台打印提示信息
			System.out.println("修改成功");
		}else{
			//在控制台打印提示信息
			System.out.println("请重新修改");
		}
	}
}
