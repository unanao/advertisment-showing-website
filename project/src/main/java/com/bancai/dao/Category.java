package  com.bancai.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "category", catalog = "bancai")
public class Category implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4922222532104812621L;
	private Integer id;
	private String name;
	private String property1;
	private String property2;
	private String property3;
	private String property4;
	private String property5;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(String name, String property1, String property2,
			String property3, String property4, String property5) {
		this.name = name;
		this.property1 = property1;
		this.property2 = property2;
		this.property3 = property3;
		this.property4 = property4;
		this.property5 = property5;
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

}