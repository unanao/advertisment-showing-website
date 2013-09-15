package com.bancai.dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Package entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "package", catalog = "bancai")
public class Package implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8073236070747907152L;
	private Integer id;
	private String name;
	private Integer time;
	private Double price;
	private Timestamp startTime;
	private Timestamp endTime;
	private Integer status;
	private String reserved;
	private String productCategory;
	private Integer adNum;
	private Integer displayProductNum;
	private Integer displayEnterpriseNum;
	private String enterpriseArea;

	// Constructors

	/** default constructor */
	public Package() {
	}

	/** minimal constructor */
	public Package(Timestamp startTime, Timestamp endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/** full constructor */
	public Package(String name, Integer time, Double price,
	        Timestamp startTime, Timestamp endTime, Integer status,
	        String reserved, String productCategory, Integer adNum,
	        Integer displayProductNum, Integer displayEnterpriseNum,
	        String enterpriseArea) {
		this.name = name;
		this.time = time;
		this.price = price;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
		this.reserved = reserved;
		this.productCategory = productCategory;
		this.adNum = adNum;
		this.displayProductNum = displayProductNum;
		this.displayEnterpriseNum = displayEnterpriseNum;
		this.enterpriseArea = enterpriseArea;
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

	@Column(name = "time")
	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	@Column(name = "price", precision = 22, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	@Column(name = "product_category")
	public String getProductCategory() {
		return this.productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	@Column(name = "ad_num")
	public Integer getAdNum() {
		return this.adNum;
	}

	public void setAdNum(Integer adNum) {
		this.adNum = adNum;
	}

	@Column(name = "display_product_num")
	public Integer getDisplayProductNum() {
		return this.displayProductNum;
	}

	public void setDisplayProductNum(Integer displayProductNum) {
		this.displayProductNum = displayProductNum;
	}

	@Column(name = "display_enterprise_num")
	public Integer getDisplayEnterpriseNum() {
		return this.displayEnterpriseNum;
	}

	public void setDisplayEnterpriseNum(Integer displayEnterpriseNum) {
		this.displayEnterpriseNum = displayEnterpriseNum;
	}

	@Column(name = "enterprise_area")
	public String getEnterpriseArea() {
		return this.enterpriseArea;
	}

	public void setEnterpriseArea(String enterpriseArea) {
		this.enterpriseArea = enterpriseArea;
	}

}