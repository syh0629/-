package com.sports.run;

import java.util.List;
import java.util.Scanner;

import com.sports.dao.HolidayDao;
import com.sports.dao.ManagerDao;
import com.sports.dao.SportsDao;
import com.sports.dao.StudentDao;
import com.sports.dao.TeacherDao;
import com.sports.dao.TgtableDao;
import com.sports.entity.Holiday;
import com.sports.entity.Student;
import com.sports.entity.Teacher;
import com.sports.entity.Tgtable;

public class TeacherRun {
	//new一个请假的数据库操作对象
	HolidayDao hd = new HolidayDao();
	// new一个scanner对象 用于接收控制台输入的内容
	Scanner sc = new Scanner(System.in);
	// new一个运动的数据库操作对象
	SportsDao sd = new SportsDao();
	// new一个运动场的数据库操作对象
	TgtableDao td = new TgtableDao();
	// new一个老师的数据库操作对象
	TeacherDao ted = new TeacherDao();
	// new一个学生的数据库操作对象
	StudentDao std = new StudentDao();
	// new一个管理员的数据库操作对象
	ManagerDao md = new ManagerDao();
	//存储当前登录的老师的信息
	Teacher t = null;
	/**
	 * 登录的方法
	 * @param name
	 * @param pwd
	 * @return
	 */
	public int Login(String name, String pwd) {
		//根据姓名和密码查询老师信息
		Teacher i = ted.selectTeacherByNameAndPwd(name, pwd);
		//将查到的数据赋值给t
		t = i;
		//如果查到数据表示登录成功 登录成功返回1 失败返回0
		if (i == null) {
			//返回0
			return 0;
		} else {
			//返回1
			return 1;
		}
	}
	/**
	 * 查看学生的方法
	 */
	public void lookStudent() {
		//new一个list集合储存学生信息
		List<Student> s = std.selectStudentByTid(t);
		//循环遍历学生集合
		for (Student student : s) {
			//在控制台打印学生姓名
			System.out.println(student.getSname());
		}
	}
	/**
	 * 查看运动场的方法
	 */
	public void looktg() {
		//查询运动场并存在list集合中
		List<Tgtable> ts = td.selectTgtable();
		//循环遍历集合中的数据
		for (Tgtable t : ts) {
			//在控制台上打印数据
			System.out.println(t.getTgname() + "---" + t.getTgadd());
		}
	}
	/**
	 * 修改密码的方法
	 */
	public void updatepwd() {
		//在控制台输出提示信息
		System.out.println("请输入新密码");
		//获取控制台输入的信息并设置到登录的用户中
		t.setTpwd(sc.next());
		//执行数据库更新方法
		int i = ted.updateTeacher(t);
		//执行成功返回1否则执行失败
		if (i == 1) {
			//控制台打印提示信息
			System.out.println("修改成功");
		} else {
			//控制台打印提示信息
			System.out.println("修改失败");
		}

	}
	/**
	 * 查询假期的方法
	 */
	public void lookHoliday() {
		//查询假期信息
		List<Holiday> hs = hd.selectAllHolid();
		//循环遍历查询到的数据
		for (Holiday h : hs) {
			//只打印学生的请假信息,所以需要在角色上进行限定,学生的角色id是3
			switch (h.getRole()) {
			//角色id=3时
			case 3:
				//根据请假人id查询数据
				Student s = std.selectStudentBySid(h.getHperson());
				//在控制台打印请假信息
				System.out.println(s.getSname() + "---" + h.getHdate() + "天");
				//退出
				break;
			}

		}
	}
}
