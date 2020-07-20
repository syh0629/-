package com.sports.run;

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

public class StudentRun {
	// new一个请假的数据库操作对象
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
	//登录的学生信息
	Student s = null;
	//当前学生的请假信息
	Holiday h = null;
	/**
	 * 学生的登录方法
	 * @param name
	 * @param pwd
	 * @return
	 */
	public int Login(String name, String pwd) {
		//根据姓名和密码查询学生数据
		Student i = std.selectStudentByNameAndPwd(name, pwd);
		//保存当前登录的学生信息
		s = i;
		//返回值为空证明登录失败,否则登录成功
		if (i == null) {
			//登录失败返回0
			return 0;
		} else {
			//否则返回1 表示登录成功
			return 1;
		}
	}
	/**
	 * 查看老师的方法
	 */
	public void lookTeacher() {
		//根据老师id查询老师的信息
		Teacher t = ted.selectTeacherbyTid(s.getTid());
		//在控制台打印老师信息
		System.out.println("教练是:" + t.getTname());

	}
	/**
	 * 查看运动场的方法
	 */
	public void looktg() {
		//根据运动场id查询运动场信息
		Tgtable tg = td.selectTgByTgid(s.getTgid());
		//在控制台打印运动场信息
		System.out.println(tg.getTgname() + "---" + tg.getTgadd());

	}
	/**
	 * 修改密码的方法
	 */
	public void updatepwd() {
		//在控制台输出提示语句
		System.out.println("请输入新密码");
		//获取控制台输入的数据并将其设置到当前登录的用户中
		s.setSpwd(sc.next());
		//执行数据库更新操作
		int i = std.updateStudent(s);
		//操作成功返回1否则表示操作失败
		if (i == 1) {
			//在控制台打印提示信息
			System.out.println("修改成功");
		} else {
			//在控制台打印提示信息
			System.out.println("请重新修改");
		}
	}
	/**
	 * 请假的方法
	 */
	public void lookHoliday() {
		//在控制台打印提示信息
		System.out.println("请选择请假功能: 1 请假  2 查看请假结果");
		//根据控制台输入的数字选择不同的功能
		switch (sc.nextInt()) {
		//控制台输入1时
		case 1:
			//new一个请假对象
			Holiday ho = new Holiday();
			//在控制台打印提示信息
			System.out.println("请输入请假天数");
			//获取控制台输入的数据并设置到请假对象中
			ho.setHdate(sc.nextInt());
			///获取控制台输入的数据并设置到请假对象中
			ho.setHperson(s.getSid());
			//设置当前的请假状态为申请中
			ho.setHsta("申请中");
			//设置请假人的角色信息,就是当前登录用户的rid
			ho.setRole(s.getRid());
			//执行数据新增操作
			int i = hd.insertHoliday(ho);
			//新增成功返回1 否则表示新增失败
			if (i == 1) {
				//在控制台打印提示信息
				System.out.println("申请已提交");
			}
			//退出
			break;
		//控制台输入2时
		case 2:
			//查询当前学生的请假情况
			h = hd.selectOneHoliday(s);
			//在控制台打印请假状态
			System.out.println("请假状态----" + h.getHsta());
			//退出
			break;
		}
	}
}
