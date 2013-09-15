package com.bancai.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Phone entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "phone", catalog = "bancai")
public class Phone implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1831140741425723048L;
	private Integer id;
	private String contacter;
	private String type;
	private String number;
	private Integer user;
	private Integer enterprise;

	// Constructors

	/** default constructor */
	public Phone() {
	}

	/** full constructor */
	public Phone(String contacter, String type, String number, Integer user,
			Integer enterprise) {
		this.contacter = contacter;
		this.type = type;
		this.number = number;
		this.user = user;
		this.enterprise = enterprise;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "contacter")
	public String getContacter() {
		return this.contacter;
	}

	public void setContacter(String contacter) {
		this.contacter = contacter;
	}

	@Column(name = "type", length = 7)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "number")
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
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

}