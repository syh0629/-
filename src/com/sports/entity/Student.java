package com.sports.entity;
/**
 * 学生的实体类
 *
 */
public class Student {
	//学生id
	private Integer sid;
	//学生姓名
	private String sname;
	//学生密码
	private String spwd;
	//当前学生的老师id
	private Integer tid;
	//当前学生训练场id
	private Integer tgid;
	//当前学生运动项目id
	private Integer sportid;
	//当前学生角色id
	private Integer rid;
	/**
	 * 获取当前类的属性
	 * @return
	 */
	public Integer getSid() {
		return sid;
	}
	/**
	 * 设置当前类的属性
	 * @param mid
	 */
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	/**
	 * 获取当前类的属性
	 * @return
	 */
	public String getSname() {
		return sname;
	}
	/**
	 * 设置当前类的属性
	 * @param mid
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}
	/**
	 * 获取当前类的属性
	 * @return
	 */
	public String getSpwd() {
		return spwd;
	}
	/**
	 * 设置当前类的属性
	 * @param mid
	 */
	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}
	/**
	 * 获取当前类的属性
	 * @return
	 */
	public Integer getTid() {
		return tid;
	}
	/**
	 * 设置当前类的属性
	 * @param mid
	 */
	public void setTid(Integer tid) {
		this.tid = tid;
	}
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
	public Integer getRid() {
		return rid;
	}
	/**
	 * 设置当前类的属性
	 * @param mid
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	/**
	 * 获取当前类的属性
	 * @return
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
	 * 获取当前类的所有信息并格式化为字符串
	 */
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", spwd=" + spwd + ", tid=" + tid + ", tgid=" + tgid
				+ ", sportid=" + sportid + ", rid=" + rid + "]";
	}
	
	
}
