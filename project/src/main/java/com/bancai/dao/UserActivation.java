package com.bancai.dao;
// default package

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserActivation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_activation", catalog = "bancai")
public class UserActivation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer userId;
	private String code;
	private long time;
	private Integer counts;

	// Constructors

	/** default constructor */
	public UserActivation() {
	}

	/** full constructor */
	public UserActivation(Integer userId, String code, long time, Integer counts) {
		this.userId = userId;
		this.code = code;
		this.time = time;
		this.counts = counts;
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

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "code", nullable = false)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "time", nullable = false, length = 19)
	public long getTime() {
		return this.time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	
	public Integer getCounts() {
		return this.counts;
	}
}