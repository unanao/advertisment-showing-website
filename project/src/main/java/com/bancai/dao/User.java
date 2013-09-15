package com.bancai.dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "bancai")
public class User implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String email;
	private String password;
	private String nickname;
	private String name;
	private String gender;
	private Timestamp time;
	private String qq;
	private Integer enterprise;
	private Integer status;
	private Integer loginTimes;
	private long lastLogin;
	private String reserved;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Timestamp time) {
		this.time = time;
	}

	/** full constructor */
	public User(String email, String password, String nickname, String name, String gender,
			Timestamp time, String qq, Integer enterprise, Integer emailActivate, 
			Integer loginTimes, long lastLogin, String reserved) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.name = name;
		this.gender = gender;
		this.time = time;
		this.qq = qq;
		this.enterprise = enterprise;
		this.status = emailActivate;
		this.loginTimes = loginTimes;
		this.lastLogin = lastLogin;
		this.reserved = reserved;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "nickname")
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "gender", length = 6)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "time", length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "qq")
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "enterprise")
	public Integer getEnterprise() {
		return this.enterprise;
	}

	public void setEnterprise(Integer enterprise) {
		this.enterprise = enterprise;
	}
	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Column(name = "login_times")
	public Integer getLoginTimes() {
		return this.loginTimes;
	}

	public void setLoginTimes(Integer loginTimes) {
		this.loginTimes = loginTimes;
	}
	
	@Column(name = "last_login")
	public Long getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(long lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "reserved")
	public String getReserved() {
		return this.reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

}