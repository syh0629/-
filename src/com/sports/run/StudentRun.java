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
	// 登录的学生信息
	Student s = null;
	// 当前学生的请假信息
	Holiday h = null;

	/**
	 * 学生的登录方法
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 */
	public int Login(String name, String pwd) {
		// 表示用户名存在与否的布尔值
		Boolean flag = false;
		// 根据用户名查用户
		if (std.selectStudentByUsername(name) == null) {
			//在控制台提示信息
			System.out.print("此用户不存在     ");
		} else {
			//有此用户 flag=true
			flag = true;
		}
		if (flag) {
			// 根据姓名和密码查询学生数据
			Student i = std.selectStudentByNameAndPwd(name, pwd);
			// 保存当前登录的学生信息
			s = i;
			// 返回值为空证明登录失败,否则登录成功
			if (i == null) {
				// 登录失败返回0
				return 0;
			} else {
				// 否则返回1 表示登录成功
				return 1;
			}
		}else{
			// 返回0
			return 0;
		}

	}

	/**
	 * 查看老师的方法
	 */
	public void lookTeacher() {
		// 根据老师id查询老师的信息
		Teacher t = ted.selectTeacherbyTid(s.getTid());
		// 在控制台打印老师信息
		System.out.println("教练是:" + t.getTname() + "---手机号码: " + t.getPhone());

	}

	/**
	 * 查看运动场的方法
	 */
	public void looktg() {
		// 根据运动场id查询运动场信息
		Tgtable tg = td.selectTgByTgid(s.getTgid());
		// 在控制台打印运动场信息
		System.out.println(tg.getTgname() + "---" + tg.getTgadd());

	}

	/**
	 * 修改密码的方法
	 */
	public void updatepwd() {
		// 在控制台打印提示信息
		System.out.println("请输入原始密码,输入0退出");
		// 表示用户输入原始密码正确与否的flag
		Boolean flag = false;
		// 一个死循环,当用户输入0或密码正确是退出此循环
		while (true) {
			// 接收控制台输入的内容
			String a = sc.next();
			// 判断控制台输入的内容
			if (s.getSpwd().equals(a) || "0".equals(a)) {
				// 当输入是0时 flag=false不变,否则 flag=true
				if (!"0".equals(a)) {
					// flag变成true
					flag = true;
				}
				// 退出死循环
				break;
				// 否则打印信息
			} else {
				// 在控制台打印提示信息
				System.out.println("输入有误请重新输入");
			}
		}
		if (flag) {
			// 在控制台输出提示语句
			System.out.println("请输入新密码");
			// 一个死循环直到两次输入密码正确是退出
			while (true) {
				// 接收控制台输入的内容
				String a = sc.next();
				// 接收控制台输入的内容
				System.out.println("请再输入一次");
				// 判断两次输入的密码是否一致
				if (a.equals(sc.next())) {
					// 接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
					s.setSpwd(a);
					// 退出
					break;
					// 否则不退出
				} else {
					// 在控制台打印提示信息
					System.out.println("两次输入不一致,请重新输入");
				}
			}
			// 执行数据库更新操作
			int i = std.updateStudent(s);
			// 操作成功返回1否则表示操作失败
			if (i == 1) {
				// 在控制台打印提示信息
				System.out.println("修改成功");
			} else {
				// 在控制台打印提示信息
				System.out.println("请重新修改");
			}
		}
		// 执行数据库更新操作
		int i = std.updateStudent(s);
		// 操作成功返回1否则表示操作失败
		if (i == 1) {
			// 在控制台打印提示信息
			System.out.println("修改成功");
		} else {
			// 在控制台打印提示信息
			System.out.println("请重新修改");
		}
	}

	/**
	 * 请假的方法
	 */
	public void lookHoliday() {
		// 在控制台打印提示信息
		System.out.println("请选择请假功能: 1 请假  2 查看请假结果");
		// 根据控制台输入的数字选择不同的功能
		switch (sc.nextInt()) {
		// 控制台输入1时
		case 1:
			// new一个请假对象
			Holiday ho = new Holiday();
			// 在控制台打印提示信息
			System.out.println("请输入请假天数");
			// 获取控制台输入的数据并设置到请假对象中
			ho.setHdate(sc.nextInt());
			/// 获取控制台输入的数据并设置到请假对象中
			ho.setHperson(s.getSid());
			// 设置当前的请假状态为申请中
			ho.setHsta("申请中");
			// 设置请假人的角色信息,就是当前登录用户的rid
			ho.setRole(s.getRid());
			// 执行数据新增操作
			int i = hd.insertHoliday(ho);
			// 新增成功返回1 否则表示新增失败
			if (i == 1) {
				// 在控制台打印提示信息
				System.out.println("申请已提交");
			}
			// 退出
			break;
		// 控制台输入2时
		case 2:
			// 查询当前学生的请假情况
			List<Holiday> hs = hd.selectListHoliday(s);
			for (Holiday holiday : hs) {
				// 在控制台打印请假状态
				System.out.println("请假编号---"+holiday.getHid()+"请假状态----" + holiday.getHsta());
			}
			// 退出
			break;
		}
	}
}
