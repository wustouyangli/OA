package com.table.personmanage.user;

import java.util.Date;

/**
 * TbUser entity. @author MyEclipse Persistence Tools
 */

public class TbUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String alias;
	private String password;
	private String authority;
	private String name;
	private String sex;
	private Date birthday;
	private String department;
	private String job;
	private String email;
	private String officeTel;
	private String tel;
	private String familyTel;
	private String address;
	private String bestEmployee;

	// Constructors

	/** default constructor */
	public TbUser() {
	}

	/** minimal constructor */
	public TbUser(String alias, String password) {
		this.alias = alias;
		this.password = password;
	}

	/** full constructor */
	public TbUser(String alias, String password, String authority, String name, String sex, Date birthday,
			String department, String job, String email, String officeTel, String tel, String familyTel, String address,
			String bestEmployee) {
		this.alias = alias;
		this.password = password;
		this.authority = authority;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.department = department;
		this.job = job;
		this.email = email;
		this.officeTel = officeTel;
		this.tel = tel;
		this.familyTel = familyTel;
		this.address = address;
		this.bestEmployee = bestEmployee;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOfficeTel() {
		return this.officeTel;
	}

	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFamilyTel() {
		return this.familyTel;
	}

	public void setFamilyTel(String familyTel) {
		this.familyTel = familyTel;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBestEmployee() {
		return this.bestEmployee;
	}

	public void setBestEmployee(String bestEmployee) {
		this.bestEmployee = bestEmployee;
	}

}