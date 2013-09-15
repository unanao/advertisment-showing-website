package com.bancai.dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Enterprise entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "enterprise", catalog = "bancai")
public class Enterprise implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2689965616178752956L;
	private Integer id;
	private String name;
	private String introduction;
	private String logo;
	private String province;
	private String city;
	private String county;
	private String town;
	private String address;
	private Integer scale;
	private Timestamp time;
	private Integer picNum;
	private String reserved;

	// Constructors

	/** default constructor */
	public Enterprise() {
	}

	/** minimal constructor */
	public Enterprise(Timestamp time) {
		this.time = time;
	}

	/** full constructor */
	public Enterprise(String name, String introduction, String logo,
			String province, String city, String county, String town,
			String address, Integer scale, Timestamp time, Integer picNum,
			String reserved) {
		this.name = name;
		this.introduction = introduction;
		this.logo = logo;
		this.province = province;
		this.city = city;
		this.county = county;
		this.town = town;
		this.address = address;
		this.scale = scale;
		this.time = time;
		this.picNum = picNum;
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

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "introduction")
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Column(name = "logo")
	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Column(name = "province")
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "city")
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "county")
	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	@Column(name = "town")
	public String getTown() {
		return this.town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "scale")
	public Integer getScale() {
		return this.scale;
	}

	public void setScale(Integer scale) {
		this.scale = scale;
	}

	@Column(name = "time", nullable = false, length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "pic_num")
	public Integer getPicNum() {
		return this.picNum;
	}

	public void setPicNum(Integer picNum) {
		this.picNum = picNum;
	}

	@Column(name = "reserved")
	public String getReserved() {
		return this.reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

}