package com.bancai.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comment", catalog = "bancai")
public class Comment implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5809580182037957132L;
	private Integer id;
	private Integer resource;
	private String content;
	private String reserved;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(Integer resource, String content, String reserved) {
		this.resource = resource;
		this.content = content;
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

	@Column(name = "resource")
	public Integer getResource() {
		return this.resource;
	}

	public void setResource(Integer resource) {
		this.resource = resource;
	}

	@Column(name = "content")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "reserved")
	public String getReserved() {
		return this.reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

}