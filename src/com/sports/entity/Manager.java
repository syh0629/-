package com.sports.entity;
/**
 * 管理员实体类
 * @author 
 *
 */
public class Manager {
	//管理员id
	private Integer mid;
	//管理员角色
	private Integer rid;
	//管理员姓名
	private String mname;
	//管理员密码
	private String mpwd;
	/**
	 * 获取当前类的属性
	 * @return
	 */
	public Integer getMid() {
		return mid;
	}
	/**
	 * 设置当前类的属性
	 * @param mid
	 */
	public void setMid(Integer mid) {
		this.mid = mid;
	}/**
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
	}/**
	 * 获取当前类的属性
	 * @return
	 */
	public String getMname() {
		return mname;
	}
	/**
	 * 设置当前类的属性
	 * @param mid
	 */
	public void setMname(String mname) {
		this.mname = mname;
	}/**
	 * 获取当前类的属性
	 * @return
	 */
	public String getMpwd() {
		return mpwd;
	}
	/**
	 * 设置当前类的属性
	 * @param mid
	 */
	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}
	/**
	 * 获取当前类的所有信息并格式化为字符串
	 */
	public String toString() {
		return "Manager [mid=" + mid + ", rid=" + rid + ", mname=" + mname + ", mpwd=" + mpwd + "]";
	}
	
}
