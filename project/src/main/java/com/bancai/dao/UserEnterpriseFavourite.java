package com.bancai.dao;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserEnterpriseFavourite entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_enterprise_favourite", catalog = "bancai")
public class UserEnterpriseFavourite implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2086970854500580756L;
	private Integer id;
	private Integer user;
	private Integer enterprise;
	private Timestamp time;
	private String reserved;

	// Constructors

	/** default constructor */
	public UserEnterpriseFavourite() {
	}

	/** full constructor */
	public UserEnterpriseFavourite(Integer user, Integer enterprise,
			Timestamp time, String reserved) {
		this.user = user;
		this.enterprise = enterprise;
		this.time = time;
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

	@Column(name = "user")
	public Integer getUser() {
		return this.user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	@Column(name = "enterprise")
	public Integer getEnterprise() {
		return this.enterprise;
	}

	public void setEnterprise(Integer enterprise) {
		this.enterprise = enterprise;
	}

	@Column(name = "time",nullable = false)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "reserved")
	public String getReserved() {
		return this.reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

}