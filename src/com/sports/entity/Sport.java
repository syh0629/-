package com.sports.entity;
/**
 * 运动类型的实体类
 * @author 
 *
 */
public class Sport {
	private Integer sportid;
	private String sportname;
	/**
	 * 获取当前类的属性
	 * @return
	 */
	public Integer getSportid() {
		return sportid;
	}
	/**
	 * 设置当前类的属性
	 * @param mid
	 */
	public void setSportid(Integer sportid) {
		this.sportid = sportid;
	}
	/**
	 * 获取当前类的属性
	 * @return
	 */
	public String getSportname() {
		return sportname;
	}
	/**
	 * 设置当前类的属性
	 * @param mid
	 */
	public void setSportname(String sportname) {
		this.sportname = sportname;
	}
	/**
	 * 获取当前类的所有信息并格式化为字符串
	 */
	public String toString() {
		return "Sport [sportid=" + sportid + ", sportname=" + sportname + "]";
	}
	
}
