package com.sports.entity;

public class Tgtable {
	//运动场id
	private Integer tgid;
	//运动场名称
	private String tgname;
	//运动场地址
	private String tgadd;
	/**
	 * 设置当前类的属性
	 * @param mid
	 */
	public Integer getTgid() {
		return tgid;
	}
	/**
	 * 设置当前类的属性
	 * @param mid
	 */
	public void setTgid(Integer tgid) {
		this.tgid = tgid;
	}
	/**
	 * 设置当前类的属性
	 * @param mid
	 */
	public String getTgname() {
		return tgname;
	}
	/**
	 * 设置当前类的属性
	 * @param mid
	 */
	public void setTgname(String tgname) {
		this.tgname = tgname;
	}
	/**
	 * 设置当前类的属性
	 * @param mid
	 */
	public String getTgadd() {
		return tgadd;
	}
	/**
	 * 设置当前类的属性
	 * @param mid
	 */
	public void setTgadd(String tgadd) {
		this.tgadd = tgadd;
	}
	/**
	 * 获取当前类的所有信息并格式化为字符串
	 */
	public String toString() {
		return "Tgtable [tgid=" + tgid + ", tgname=" + tgname + ", tgadd=" + tgadd + "]";
	}
	
}
