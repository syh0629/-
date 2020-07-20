package com.sports.entity;
/**
 * 角色的实体类
 * @author 
 *
 */
public class Role {
	//角色id
	private Integer rid;
	//角色信息
	private String role;
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
	public String getRole() {
		return role;
	}
	/**
	 * 设置当前类的属性
	 * @param mid
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * 获取当前类的所有信息并格式化为字符串
	 */
	public String toString() {
		return "Role [rid=" + rid + ", role=" + role + "]";
	}
	
}
