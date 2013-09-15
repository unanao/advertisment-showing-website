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
@Table(name = "product_picture", catalog = "bancai")
public class ProductPicture implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 9024094541884959915L;
	private Integer id;
	private Integer productId;
	private String path;
	private Integer status;
	private String reserved;

	// Constructors

	/** default constructor */
	public ProductPicture() {
	}

	/** full constructor */
	public ProductPicture(Integer productId, String path, Integer status,String reserved) {
		this.productId = productId;
		this.path = path;
		this.status = status;
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

	@Column(name = "product_id")
	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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