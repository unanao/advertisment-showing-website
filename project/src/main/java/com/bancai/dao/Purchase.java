package com.bancai.dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "purchase", catalog = "bancai")
public class Purchase implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 4030356295815652900L;
	private Integer id;
	private Integer enterprise;
	private Integer package_;
	private Double amount;
	private Timestamp time;
	private Timestamp startTime;
	private Timestamp endTime;
	private String valid;
	private String reserved;

	// Constructors

	/** default constructor */
	public Purchase() {
	}

	/** minimal constructor */
	public Purchase(Integer enterprise, Integer package_, Double amount,
			Timestamp time, Timestamp startTime, Timestamp endTime, String valid) {
		this.enterprise = enterprise;
		this.package_ = package_;
		this.amount = amount;
		this.time = time;
		this.startTime = startTime;
		this.endTime = endTime;
		this.valid = valid;
	}

	/** full constructor */
	public Purchase(Integer enterprise, Integer package_, Double amount,
			Timestamp time, Timestamp startTime, Timestamp endTime,
			String valid, String reserved) {
		this.enterprise = enterprise;
		this.package_ = package_;
		this.amount = amount;
		this.time = time;
		this.startTime = startTime;
		this.endTime = endTime;
		this.valid = valid;
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

	@Column(name = "enterprise", nullable = false)
	public Integer getEnterprise() {
		return this.enterprise;
	}

	public void setEnterprise(Integer enterprise) {
		this.enterprise = enterprise;
	}

	@Column(name = "package", nullable = false)
	public Integer getPackage_() {
		return this.package_;
	}

	public void setPackage_(Integer package_) {
		this.package_ = package_;
	}

	@Column(name = "amount", nullable = false, precision = 22, scale = 0)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name = "time", nullable = false, length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
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

	@Column(name = "valid", nullable = false, length = 7)
	public String getValid() {
		return this.valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	@Column(name = "reserved")
	public String getReserved() {
		return this.reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

}