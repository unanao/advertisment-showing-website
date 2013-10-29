package com.bancai.dao;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserProductFavourite entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_product_favourite", catalog = "bancai")
public class UserProductFavourite implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5572924616304506424L;
	private Integer id;
	private Integer user;
	private Integer product;
	private Timestamp time;
	private String reserved;

	// Constructors

	/** default constructor */
	public UserProductFavourite() {
	}

	/** full constructor */
	public UserProductFavourite(Integer user, Integer product, Timestamp time,
			String reserved) {
		this.user = user;
		this.product = product;
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

	@Column(name = "product")
	public Integer getProduct() {
		return this.product;
	}

	public void setProduct(Integer product) {
		this.product = product;
	}

	@Column(name = "time")
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