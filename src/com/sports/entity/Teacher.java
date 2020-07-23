package com.sports.entity;

/**
 * 教师的实体类
 *
 */
public class Teacher {
	// 老师id
	private Integer tid;
	// 老师的角色id
	private Integer rid;
	// 老师所在的训练场id
	private Integer tgid;
	// 老师的运动项目id
	private Integer sportid;
	// 老师姓名
	private String tname;
	// 老师密码
	private String tpwd;
	// 老师用户名
	private String username;
	// 老师手机号
	private String phone;
	/**
	 * 获取当前类的属性
	 * 
	 * @return
	 */
	public Integer getTid() {
		return tid;
	}

	/**
	 * 设置当前类的属性
	 * 
	 * @param mid
	 */
	public void setTid(Integer tid) {
		this.tid = tid;
	}

	/**
	 * 获取当前类的属性
	 * 
	 * @return
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * 设置当前类的属性
	 * 
	 * @param mid
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	/**
	 * 获取当前类的属性
	 * 
	 * @return
	 */
	public Integer getTgid() {
		return tgid;
	}

	/**
	 * 设置当前类的属性
	 * 
	 * @param mid
	 */
	public void setTgid(Integer tgid) {
		this.tgid = tgid;
	}

	/**
	 * 获取当前类的属性
	 * 
	 * @return
	 */
	public Integer getSportid() {
		return sportid;
	}

	/**
	 * 设置当前类的属性
	 * 
	 * @param mid
	 */
	public void setSportid(Integer sportid) {
		this.sportid = sportid;
	}

	/**
	 * 获取当前类的属性
	 * 
	 * @return
	 */
	public String getTname() {
		return tname;
	}

	/**
	 * 设置当前类的属性
	 * 
	 * @param mid
	 */
	public void setTname(String tname) {
		this.tname = tname;
	}

	/**
	 * 获取当前类的属性
	 * 
	 * @return
	 */
	public String getTpwd() {
		return tpwd;
	}

	/**
	 * 设置当前类的属性
	 * 
	 * @param mid
	 */
	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}
	/**
	 * 获取当前类的属性
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置当前类的属性
	 * 
	 * @param mid
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取当前类的属性
	 * 
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设置当前类的属性
	 * 
	 * @param mid
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取当前类的所有信息并格式化为字符串
	 */

	@Override
	public String toString() {
		return "老师列表 [老师编号=" + tid + ", 用户名=" + username + ", 手机号=" + phone + "]";
	}
	

}
