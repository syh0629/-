package com.sports.run;

import java.util.Scanner;

public class RunClas {

	public static void main(String[] args) {
		// 管理员操作方法的封装对象
		ManagerRun mr = new ManagerRun();
		// 学生操作方法的封装对象
		StudentRun sr = new StudentRun();
		// 老师操作方法的封装对象
		TeacherRun tr = new TeacherRun();
		// 控制台提示信息
		System.out.println("----------------运动员管理系统--------------------");
		// new一个scanner对象 用来接收控制台输入的信息
		Scanner sc = new Scanner(System.in);
		// 死循环表示系统一直在持续运行
		while (true) {
			// 控制台提示信息
			System.out.println("请选择登陆的用户角色输入角色的代码: 1  管理员    2 教练   3  学员 ");
			int a = sc.nextInt();
			System.out.println("请选择功能  1 登录   2 忘记密码");
			if(sc.nextInt()==2){
				switch (a) {
				case 1: mr.passwordForget(); break;
				case 2: break;
				case 3: break;
				}
				continue;
			}
			// 控制台提示信息
			System.out.println("请输入用户名");
			String name = sc.next();
			// 控制台提示信息
			System.out.println("请输入密码");
			String pwd = sc.next();
			int i = 0;
			switch (a) {
			case 1:
				i = mr.Login(name, pwd);
				if (i == 1) {
					// 控制台提示信息
					System.out.println(name + " :欢迎登录");
					while (true) {
						// 控制台提示信息
						System.out.println("请选择所需功能: 1 新增教练   2 新增学生   3 新增训练场  4 修改密码  5  修改学生教练   0 退出");
						//接口控制台输入的信息并赋值给a
						a = sc.nextInt();
						//根据a的值不同选择不同的功能
						switch (a) {
						case 0:break;
						//当a=1
						case 1:
							//调用新增老师方法
							mr.newTeacher();
							//退出
							break;
						//当a=2	
						case 2:
							//调用新增学生方法
							mr.newStudent();
							//退出
							break;
						//当a=3
						case 3:
							//调用新增运动场方法
							mr.newtg();
							//退出
							break;
						//当a=4
						case 4:
							//调用修改密码方法
							mr.updatepwd();
							//退出
							break;
						case 5:
							//调用修改密码方法
							mr.changeStudentTeacher();
							//退出
							break;
							// 控制台提示信息
						default: System.out.println("输入有误,请重新输入");
						}
						//当a=0
						if (a == 0) {
							//退出当前循环
							break;
						}
					}
				} else {
					// 控制台提示信息
					System.out.println("用户名密码错误 请重新登录");
				}
				//退出
				break;
			//当a=2	
			case 2:
				//调用老师的登录方法
				i = tr.Login(name, pwd);
				//返回1表示登录成功 否则表示登录失败
				if (i == 1) {
					// 控制台提示信息
					System.out.println(name + " :欢迎登录");
					//登录成功进入老师功能的死循环
					while (true) {
						// 控制台提示信息
						System.out.println("请选择所需功能: 1 查看学生   2 查看场地   3 修改密码  4 查看请假   0 退出");
						//获取控制台输入的信息并赋值给a
						a = sc.nextInt();
						//根据a的值不同选择不同的功能
						switch (a) {
						case 0:break;
						//a=1
						case 1:
							//调用查看学生的方法
							tr.lookStudent();
							//退出
							break;
						//a=2
						case 2:
							//调用查询运动场的方法
							tr.looktg();
							//退出
							break;
						//a=3
						case 3:
							//调用修改密码的方法
							tr.updatepwd();
							//退出
							break;
						//a=4
						case 4:
							//调用查看请假的方法
							tr.lookHoliday();
							//退出
							break;
							// 控制台提示信息
						default: System.out.println("输入有误,请重新输入");
						}
						//a=0
						if (a == 0) {
							//退出
							break;
						}
					}
				} else {
					// 控制台提示信息
					System.out.println("用户名密码错误 请重新登录");
				}
				//退出
				break;
			//当a==3	
			case 3:
				//调用学生的登录方法
				i = sr.Login(name, pwd);
				//登录成功返回1 否则表示登录失败
				if (i == 1) {
					// 控制台提示信息
					System.out.println(name + " :欢迎登录");
					//进入学生功能调用的死循环
					while (true) {
						// 控制台提示信息
						System.out.println("请选择所需功能: 1 查看教练   2 查看场地   3 修改密码  4 请假   0 退出");
						//接收控制台输入的信息,并赋值给a
						a = sc.nextInt();
						//根据a的值选择调用不同的功能
						switch (a) {
						case 0:break;
						//a=1
						case 1:
							//调用查看老师的方法
							sr.lookTeacher();
							//退出
							break;
						//a=2
						case 2:
							//调用查看运动场的方法
							sr.looktg();
							//退出
							break;
						//a=3
						case 3:
							//调用修改密码的方法
							sr.updatepwd();
							//退出
							break;
						//a=4
						case 4:
							//调用查看请假的方法
							sr.lookHoliday();
							//退出
							break;
							// 控制台提示信息
						default: System.out.println("输入有误,请重新输入");
						}
						
						//a=0
						if (a == 0) {
							//退出
							break;
						}
					}
				} else {
					// 控制台提示信息
					System.out.println("用户名密码错误 请重新登录");
				}
				//退出
				break;
			}
		}
	}

}
