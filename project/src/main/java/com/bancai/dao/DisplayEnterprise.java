package com.bancai.dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DisplayEnterprise entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "display_enterprise", catalog = "bancai")
public class DisplayEnterprise implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 6051993540383628188L;
	private Integer id;
	private Integer enterpriseId;
	private Integer purchaseId;
	private String reserved;
	private String area;
	private Timestamp startTime;
	private Timestamp endTime;

	// Constructors

	/** default constructor */
	public DisplayEnterprise() {
	}

	/** minimal constructor */
	public DisplayEnterprise(Timestamp startTime, Timestamp endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/** full constructor */
	public DisplayEnterprise(Integer enterpriseId, Integer purchaseId,
	        String reserved, String area, Timestamp startTime, Timestamp endTime) {
		this.enterpriseId = enterpriseId;
		this.purchaseId = purchaseId;
		this.reserved = reserved;
		this.area = area;
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

	@Column(name = "enterprise_id")
	public Integer getEnterpriseId() {
		return this.enterpriseId;
	}

	public void setEnterpriseId(Integer enterpriseId) {
		this.enterpriseId = enterpriseId;
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

	@Column(name = "area")
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
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