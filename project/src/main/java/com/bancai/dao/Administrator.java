package com.bancai.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Administrator entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "administrator", catalog = "bancai")
public class Administrator implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -832544881333622334L;
	private Integer id;
	private String name;
	private String password;
	private Integer group;
	private String reserve;

	// Constructors

	/** default constructor */
	public Administrator() {
	}

	/** minimal constructor */
	public Administrator(Integer group) {
		this.group = group;
	}

	/** full constructor */
	public Administrator(String name, String password, Integer group,
			String reserve) {
		this.name = name;
		this.password = password;
		this.group = group;
		this.reserve = reserve;
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

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "admin_group", nullable = false)
	public Integer getGroup() {
		return this.group;
	}

	public void setGroup(Integer group) {
		this.group = group;
	}

	@Column(name = "reserve")
	public String getReserve() {
		return this.reserve;
	}

	public void setReserve(String reserve) {
		this.reserve = reserve;
	}

}