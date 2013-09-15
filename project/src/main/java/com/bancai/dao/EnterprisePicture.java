package com.bancai.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Picture entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "enterprise_picture", catalog = "bancai")
public class EnterprisePicture implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8976973470397707392L;
	private Integer id;
	private Integer enterpriseId;
	private String path;
	private Integer status;
	private String reserved;

	// Constructors

	/** default constructor */
	public EnterprisePicture() {
	}

	/** full constructor */
	public EnterprisePicture(Integer enterpriseId, String path, String reserved) {
		this.enterpriseId = enterpriseId;
		this.path = path;
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

	@Column(name = "enterprise_id")
	public Integer getEnterpriseId() {
		return this.enterpriseId;
	}

	public void setEnterpriseId(Integer enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	@Column(name = "path")
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	@Column(name = "reserved")
	public String getReserved() {
		return this.reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
}