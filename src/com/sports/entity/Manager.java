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
	//管理员用户名
	private String username;
	//管理员手机号
	private String phone;
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
	}
	/**
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
	 * 获取当前类的属性
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置当前类的属性
	 * @param mid
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取当前类的属性
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置当前类的属性
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
		return "Manager [mid=" + mid + ", rid=" + rid + ", mname=" + mname + ", mpwd=" + mpwd + ", username=" + username
				+ ", phone=" + phone + "]";
	}
	
	
	
}
