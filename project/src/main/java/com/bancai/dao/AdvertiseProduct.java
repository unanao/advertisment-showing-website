package com.bancai.dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AdvertiseProduct entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "advertise_product", catalog = "bancai")
public class AdvertiseProduct implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = -504020335033706951L;
	private Integer id;
	private Integer productId;
	private Integer purchaseId;
	private String reserved;
	private String category;
	private Timestamp startTime;
	private Timestamp endTime;

	// Constructors

	/** default constructor */
	public AdvertiseProduct() {
	}

	/** minimal constructor */
	public AdvertiseProduct(Timestamp startTime, Timestamp endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/** full constructor */
	public AdvertiseProduct(Integer productId, Integer purchaseId,
	        String reserved, String category, Timestamp startTime,
	        Timestamp endTime) {
		this.productId = productId;
		this.purchaseId = purchaseId;
		this.reserved = reserved;
		this.category = category;
		this.startTime = startTime;
		this.endTime = endTime;
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

	@Column(name = "purchase_id")
	public Integer getPurchaseId() {
		return this.purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	@Column(name = "reserved")
	public String getReserved() {
		return this.reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	@Column(name = "category")
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "start_time", nullable = false, length = 19)
	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	@Column(name = "end_time", nullable = false, length = 19)
	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

}