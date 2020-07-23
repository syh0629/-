package com.sports.run;

import java.util.List;
import java.util.Scanner;

import com.sports.dao.ManagerDao;
import com.sports.dao.SportsDao;
import com.sports.dao.StudentDao;
import com.sports.dao.TeacherDao;
import com.sports.dao.TgtableDao;
import com.sports.entity.Manager;
import com.sports.entity.Sport;
import com.sports.entity.Student;
import com.sports.entity.Teacher;
import com.sports.entity.Tgtable;

public class ManagerRun {
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
	// 准备一个空的管理员对象用于保存当前登录的管理员信息
	Manager m = null;

	/**
	 * 登录的操作方法
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 */
	public int Login(String name, String pwd) {
		// 表示用户名存在与否的布尔值
		Boolean flag = false;
		// 根据用户名查用户
		if (md.selectManagerByUserName(name) == null) {
			// 在控制台打印信息
			System.out.print("此用户不存在     ");
		} else {
			// 有此用户 flag=true
			flag = true;
		}
		if (flag) {
			// 根据姓名和密码查询管理员信息
			Manager i = md.selectManagerByNameAndPwd(name, pwd);
			// 将查询到的管理员的信息存储
			m = i;
			// 如果没有查询到数据
			if (i == null) {
				// 返回 0
				return 0;
			} else {// 否则返回1
					// 返回1
				return 1;
			}
		} else {
			// 返回0
			return 0;
		}

	}

	/**
	 * 新增老师的方法
	 */
	public void newTeacher() {
		// new一个老师对象
		Teacher t = new Teacher();
		// 在控制台打印提示信息
		System.out.println("请输入教练用户名");
		// 检测输入的用户名是否存在
		while (true) {
			// 获取控制台输入的内容
			String a = sc.next();
			// 根据用户名查老师
			if (ted.selectTeacherbyUsername(a) == null) {
				// 查询结果是null 表示没有重复
				t.setUsername(a);
				// 退出循环
				break;
				// 否则提示信息
			} else {
				// 在控制台打印提示信息
				System.out.println("此用户名已存在,请重新输入");
			}
		}
		// 在控制台打印提示信息
		System.out.println("请输入教练姓名");
		// 接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		t.setTname(sc.next());
		// 在控制台打印提示信息
		System.out.println("请输入教练手机号");
		// 接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		t.setPhone(sc.next());
		// 在控制台打印提示信息
		System.out.println("请输入教练密码");
		// 接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		t.setTpwd(sc.next());
		// 设置角色id为2
		t.setRid(2);
		// 在控制台打印提示信息
		System.out.println("请选择运动项目");
		// 查询所以运动项目并打印至控制台
		List<Sport> sports = sd.selectSport();
		// 循环遍历运动项目
		for (Sport sport : sports) {
			// 打印到控制台
			System.out.println(sport.toString());
		}
		// 接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		t.setSportid(sc.nextInt());
		// 在控制台打印提示信息
		System.out.println("请选择训练场地");
		// 查询所有的运动场信息并打印到控制台
		List<Tgtable> tg = td.selectTgtable();
		// 循环遍历所有运动场
		for (Tgtable tgtable : tg) {
			// 打印到控制台
			System.out.println(tgtable.toString());
		}
		// 接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		t.setTgid(sc.nextInt());
		// 调用数据库操作对象的新增数据方法
		int re = ted.insertTeacher(t);
		// 新增数据成功返回1
		if (re == 1) {
			// 在控制台打印提示信息
			System.out.println("新增成功");
		} else {
			// 在控制台打印提示信息
			System.out.println("请重新添加");
		}

	}

	/**
	 * 新增学生方法
	 */
	public void newStudent() {
		// new一个学生对象
		Student s = new Student();
		// 在控制台打印提示信息
		System.out.println("请输入学生用户名");
		// 检测输入的用户名是否存在
		while (true) {
			// 获取控制台输入的内容
			String a = sc.next();
			// 根据用户名查老师
			if (std.selectStudentByUsername(a) == null) {
				// 查询结果是null 表示没有重复
				s.setUsername(a);
				// 退出循环
				break;
				// 否则提示信息
			} else {
				// 在控制台打印提示信息
				System.out.println("此用户名已存在,请重新输入");
			}
		}
		// 在控制台打印提示信息
		System.out.println("请输入学生姓名");
		// 接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		s.setSname(sc.next());
		// 在控制台打印提示信息
		System.out.println("请输入学生手机号");
		// 接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		s.setPhone(sc.next());
		// 在控制台打印提示信息
		System.out.println("请输入学生密码");
		// 接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		s.setSpwd(sc.next());
		// 在控制台打印提示信息
		System.out.println("请选择运动项目");
		// 查询所以运动项目并打印至控制台
		List<Sport> sports = sd.selectSport();
		// 循环遍历运动项目
		for (Sport sport : sports) {
			// 打印到控制台
			System.out.println(sport.toString());
		}
		// 接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		s.setSportid(sc.nextInt());
		// 在控制台打印提示信息
		System.out.println("请输入教练编号");
		// 查询所有教师信息并打印至控制台
		List<Teacher> teachers = ted.selectAllTeacher();
		for (Teacher teacher : teachers) {
			System.out.println(teacher.toString());
		}
		// 接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		s.setTid(sc.nextInt());
		// 在控制台打印提示信息
		System.out.println("请选择训练场地");
		// 查询所有的运动场信息并打印到控制台
		List<Tgtable> tg = td.selectTgtable();
		// 循环遍历所有运动场
		for (Tgtable tgtable : tg) {
			// 打印到控制台
			System.out.println(tgtable.toString());
		}
		// 接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		s.setTgid(sc.nextInt());
		// 设置角色id为3
		s.setRid(3);
		// 调用数据库操作方法保存数据信息
		int i = std.insertStudent(s);
		// 新增成功返回1 否则表示失败
		if (i == 1) {
			// 在控制台打印提示信息
			System.out.println("添加成功");
		} else {
			// 在控制台打印提示信息
			System.out.println("请重新填加");
		}
	}

	/**
	 * 新增运动场的方法
	 */
	public void newtg() {
		// new一个运动场对象
		Tgtable t = new Tgtable();
		// 在控制台打印提示信息
		System.out.println("请输入运动场名称");
		// 接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		t.setTgname(sc.next());
		// 在控制台打印提示信息
		System.out.println("请输入运动场地址");
		// 接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
		t.setTgadd(sc.next());
		// 调用数据库操作对象的新增方法将数据添加到数据库
		int i = td.insertTgtable(t);
		// 添加成功返回1 否则表示添加失败
		if (i == 1) {
			// 在控制台打印提示信息
			System.out.println("添加成功");
		} else {
			// 在控制台打印提示信息
			System.out.println("请重新填加");
		}
	}

	/**
	 * 修改密码
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
			if (m.getMpwd().equals(a) || "0".equals(a)) {
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
					m.setMpwd(a);
					// 退出
					break;
					// 否则不退出
				} else {
					// 在控制台打印提示信息
					System.out.println("两次输入不一致,请重新输入");
				}
			}
			// 更新数据库的信息
			int i = md.updateManager(m);
			// 更新成功返回1否则更新失败
			if (i == 1) {
				// 在控制台打印提示信息
				System.out.println("修改成功");
			} else {
				// 在控制台打印提示信息
				System.out.println("请重新修改");
			}
		}
	}

	public void changeStudentTeacher() {
		// 查询所有学生
		List<Student> sts = std.selectAllStudent();
		// 要修改的学生
		Student stu = null;
		// 循环遍历学生
		for (Student student : sts) {
			// 在控制台输入
			System.out.println(student.toString());
		}
		// 在控制台输入
		System.out.println("请选择要更改的学生");
		// 接收控制台输入的信息
		int num = sc.nextInt();
		// 循环遍历学生
		for (Student student : sts) {
			// 等于控制台输入的id
			if (student.getSid() == num) {
				// 赋值给stu
				stu = student;
				// 退出
				break;
			}
		}
		// 查询所以老师
		List<Teacher> tes = ted.selectAllTeacher();
		// 循环遍历
		for (Teacher teacher : tes) {
			// 在控制台输入
			System.out.println("老师编号:" + teacher.getTid() + ",老师姓名:" + teacher.getTname());
		}
		// 在控制台输出
		System.out.println("请选择要更改的老师");
		// 获取控制台的输入信息
		stu.setTid(sc.nextInt());
		// 执行更新的方法
		int b = std.updateStudentTeacher(stu);
		if (b == 1) {
			// 在控制台打印提示信息
			System.out.println("修改成功");
		} else {
			// 在控制台打印提示信息
			System.out.println("请重新修改");
		}
	}

	public void passwordForget() {
		// 控制台输出提示
		System.out.println("请输入用户名");
		// 接收控制台输入的内容
		String username = sc.next();
		// 控制台输出提示
		System.out.println("请输入姓名");
		// 接收控制台输入的内容
		String name = sc.next();
		// 控制台输出提示
		System.out.println("请输入手机号");
		// 接收控制台输入的内容
		String phone = sc.next();
		//查询管理员信息
		Manager forgermanager = md.passwordForget(username, name, phone);
		//判断成功与否
		if (forgermanager == null) {
			//在控制台输出信息
			System.out.println("此用户不存在");
		} else {
			//保存到全局变量
			m = forgermanager;
			// 控制台输出提示
			System.out.println("---------------信息核验成功----------");
			while(true){
				// 控制台输出提示
				System.out.println("请输入新密码");
				// 接收控制台输入的内容
				String a = sc.next();
				// 接收控制台输入的内容
				System.out.println("请再输入一次");
				// 判断两次输入的密码是否一致
				if (a.equals(sc.next())) {
					// 接收控制台输入的信息并调用当前对象的set方法将控制台输入的信息设置给实体类对象
					m.setMpwd(a);
					break;
					// 否则不退出
				} else {
					// 在控制台打印提示信息
					System.out.println("两次输入不一致,请重新输入");
				}
			}
			// 更新数据库的信息
			int i = md.updateManager(m);
			// 更新成功返回1否则更新失败
			if (i == 1) {
				// 在控制台打印提示信息
				System.out.println("修改成功");
			} else {
				// 在控制台打印提示信息
				System.out.println("请重新修改");
			}
		}

	}
}
