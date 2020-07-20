package com.sports.entity;
/**
 * 请假的实体类
 * @author
 *
 */
public class Holiday {
	//编号
	private Integer hid;
	//时间 以天为单位
	private Integer hdate;
	//请假人的id
	private Integer hperson;
	//请假人的角色
	private Integer role;
	//请假状态
	private String hsta;
	/**
	 * 获取当前类的属性
	 * @return
	 */
	public Integer getHid() {
		return hid;
	}
	/**
	 * 设置当前类的属性
	 * @param hid
	 */
	public void setHid(Integer hid) {
		this.hid = hid;
	}
	/**
	 * 获取当前类的属性
	 * @return
	 */
	public Integer getHdate() {
		return hdate;
	}
	/**
	 * 设置当前类的属性
	 * @param hid
	 */
	public void setHdate(Integer hdate) {
		this.hdate = hdate;
	}
	/**
	 * 获取当前类的属性
	 * @return
	 */
	public Integer getHperson() {
		return hperson;
	}
	/**
	 * 设置当前类的属性
	 * @param hid
	 */
	public void setHperson(Integer hperson) {
		this.hperson = hperson;
	}
	/**
	 * 获取当前类的属性
	 * @return
	 */
	public Integer getRole() {
		return role;
	}
	/**
	 * 设置当前类的属性
	 * @param hid
	 */
	public void setRole(Integer role) {
		this.role = role;
	}
	/**
	 * 获取当前类的属性
	 * @return
	 */
	public String getHsta() {
		return hsta;
	}
	/**
	 * 设置当前类的属性
	 * @param hid
	 */
	public void setHsta(String hsta) {
		this.hsta = hsta;
	}
	/**
	 * 获取当前类的所有信息并格式化为字符串
	 */
	public String toString() {
		return "Holiday [hid=" + hid + ", hdate=" + hdate + ", hperson=" + hperson + ", role=" + role + ", hsta=" + hsta
				+ "]";
	}
	
	

}
