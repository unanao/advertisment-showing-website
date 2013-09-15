package com.bancai.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "product", catalog = "bancai")
public class Product implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -311555940632037765L;
	private Integer id;
	private String name;
	private Integer enterprise;
	private Integer favourite;
	private Integer hits;
	private Integer score;
	private String introduction;
	private String icon;
	private String reserved;
	private String category;
	private String detail;
	private String property1;
	private String property2;
	private String property3;
	private String property4;
	private String property5;
	// Constructors

	/** default constructor */
	public Product() {
	}

	/** full constructor */
	public Product(String name, Integer enterprise, Integer favourite,
			Integer hits, Integer score, String introduction, String icon,
			String reserved) {
		this.name = name;
		this.enterprise = enterprise;
		this.favourite = favourite;
		this.hits = hits;
		this.score = score;
		this.introduction = introduction;
		this.icon = icon;
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

	@Column(name = "enterprise")
	public Integer getEnterprise() {
		return this.enterprise;
	}

	public void setEnterprise(Integer enterprise) {
		this.enterprise = enterprise;
	}

	@Column(name = "favourite")
	public Integer getFavourite() {
		return this.favourite;
	}

	public void setFavourite(Integer favourite) {
		this.favourite = favourite;
	}

	@Column(name = "hits")
	public Integer getHits() {
		return this.hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

	@Column(name = "score")
	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Column(name = "introduction")
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Column(name = "icon")
	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(name = "reserved")
	public String getReserved() {
		return this.reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
	@Column(name = "property1")
	public String getProperty1() {
		return this.property1;
	}

	public void setProperty1(String property1) {
		this.property1 = property1;
	}
	@Column(name = "property2")
	public String getProperty2() {
		return this.property2;
	}

	public void setProperty2(String property2) {
		this.property2 = property2;
	}
	@Column(name = "property3")
	public String getProperty3() {
		return this.property3;
	}

	public void setProperty3(String property3) {
		this.property3 = property3;
	}
	@Column(name = "property4")
	public String getProperty4() {
		return this.property4;
	}

	public void setProperty4(String property4) {
		this.property4 = property4;
	}
	@Column(name = "property5")
	public String getProperty5() {
		return this.property5;
	}

	public void setProperty5(String property5) {
		this.property5 = property5;
	}
	@Column(name = "category")
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	@Column(name = "detail")
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}