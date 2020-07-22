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
	// 存储当前登录的老师的信息
	Teacher t = null;

	/**
	 * 登录的方法
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 */
	public int Login(String name, String pwd) {
		// 表示用户名存在与否的布尔值
		Boolean flag = false;
		// 根据用户名查用户
		if (ted.selectTeacherbyUsername(name) == null) {
			// 在控制台打印提示信息
			System.out.print("此用户不存在     ");
		} else {
			// 存在此用户flag=true
			flag = true;
		}
		if (flag) {
			// 根据姓名和密码查询老师信息
			Teacher i = ted.selectTeacherByNameAndPwd(name, pwd);
			// 将查到的数据赋值给t
			t = i;
			// 如果查到数据表示登录成功 登录成功返回1 失败返回0
			if (i == null) {
				// 返回0
				return 0;
			} else {
				// 返回1
				return 1;
			}
		} else {
			// 返回0
			return 0;
		}

	}

	/**
	 * 查看学生的方法
	 */
	public void lookStudent() {
		// new一个list集合储存学生信息
		List<Student> s = std.selectStudentByTid(t);
		// 循环遍历学生集合
		for (Student student : s) {
			// 在控制台打印学生姓名
			System.out.println(student.getSname() + "---手机号码: " + student.getPhone());
		}
	}

	/**
	 * 查看运动场的方法
	 */
	public void looktg() {
		// 查询运动场并存在list集合中
		List<Tgtable> ts = td.selectTgtable();
		// 循环遍历集合中的数据
		for (Tgtable t : ts) {
			// 在控制台上打印数据
			System.out.println(t.getTgname() + "---" + t.getTgadd());
		}
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
			if (t.getTpwd().equals(a) || "0".equals(a)) {
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
			// 在控制台打印提示信息
			System.out.println("请输入新密码");
			while (true) {
				// 接收控制台输入的内容
				String a = sc.next();
				// 接收控制台输入的内容
				System.out.println("请再输入一次");
				// 判断两次输入的密码是否一致
				if (a.equals(sc.next())) {
					// 接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
					t.setTpwd(a);
					// 退出
					break;
					// 否则不退出
				} else {
					// 在控制台打印提示信息
					System.out.println("两次输入不一致,请重新输入");
				}
			}
			;
			// 执行数据库更新方法
			int i = ted.updateTeacher(t);
			// 执行成功返回1否则执行失败
			if (i == 1) {
				// 控制台打印提示信息
				System.out.println("修改成功");
			} else {
				// 控制台打印提示信息
				System.out.println("修改失败");
			}
		}

	}

	/**
	 * 查询假期的方法
	 */
	public void lookHoliday() {
		// 查询假期信息
		List<Holiday> hs = hd.selectAllHolid();
		Holiday ho = null;
		System.out.println("请选择假期相关操作: 1  审批假期    2  查看请假申请");
		switch (sc.nextInt()) {
		case 1:
			System.out.println("请选择要审批的请假申请");
			for (Holiday holiday : hs) {
				System.out.println(
						"申请编号:" + holiday.getHid() + ",请假人:" + std.selectStudentBySid(holiday.getHperson()).getSname()
								+ ",请假时长:" + holiday.getHdate() + "天,请假状态:" + holiday.getHsta());
			}
			int num = sc.nextInt();
			System.out.println("请选择审批结果 : 1  通过   2  不通过");
			int res = sc.nextInt();
			for (Holiday holiday : hs) {
				if (holiday.getHid() == num) {
					switch (res) {
					case 1:
						holiday.setHsta("通过"); break;
					case 2:
						holiday.setHsta("不通过");break;
					}
					ho = holiday;
				}
			}
			hd.updateHoliday(ho); break;
		case 2:// 循环遍历查询到的数据
			for (Holiday h : hs) {
				// 只打印学生的请假信息,所以需要在角色上进行限定,学生的角色id是3
				switch (h.getRole()) {
				// 角色id=3时
				case 3:
					// 根据请假人id查询数据
					Student s = std.selectStudentBySid(h.getHperson());
					// 在控制台打印请假信息
					System.out.println(s.getSname() + "---" + h.getHdate() + "天" + ",申请状态: " + h.getHsta());
					// 退出
					break;
				}

			}
		}

	}
}
