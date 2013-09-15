package com.bancai.web.admin.pkg;

import java.sql.Timestamp;

import com.bancai.constants.PackageConstants;
import com.bancai.dao.Package;
import com.bancai.service.PackageService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 增加新套餐
 * 
 * @author unanao
 *
 */
public class UpdatePackageAction extends ActionSupport {
	private static final long serialVersionUID = 1259971393440178013L;
	String name;
	int adNum;
	int displayProductNum;
	int displayEnterpriseNum;
	String area;
	String productCategory;
	int duration;
	double price;
	Timestamp startTime;
	Timestamp endTime;

	public String execute() throws Exception {
		PackageService pkgService = new PackageService();
		Package pkg = pkgService.getPackageByName(name);
		
		if (null == pkg) {
			addActionError("套餐不存在");
			return INPUT;
		}
		
		pkg.setName(name);
		pkg.setAdNum(adNum);
		pkg.setDisplayProductNum(displayProductNum);
		pkg.setDisplayEnterpriseNum(displayEnterpriseNum);
		
		if ((null == area) || (0 == area.length()))
		{
			area = PackageConstants.ALL_AREA;
		}
		pkg.setEnterpriseArea(area);
		
		if ((null == productCategory) || (0 == productCategory.length()))
		{
			productCategory = PackageConstants.ALL_PRODUCT;
		}
		pkg.setProductCategory(productCategory);
		
		pkg.setTime(duration);
		pkg.setPrice(price);
		pkg.setStartTime(startTime);
		pkg.setEndTime(endTime);
		pkg.setStatus(PackageConstants.PACKAGE_STATUS_OPEN);
		pkgService.updateNewPackage(pkg);
		
		return SUCCESS;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getAdNum() {
		return adNum;
	}

	public void setAdNum(int adNum) {
		this.adNum = adNum;
	}

	public int getDisplayProductNum() {
		return displayProductNum;
	}

	public void setDisplayProductNum(int displayProductNum) {
		this.displayProductNum = displayProductNum;
	}

	public int getDisplayEnterpriseNum() {
		return displayEnterpriseNum;
	}

	public void setDisplayEnterpriseNum(int displayEnterpriseNum) {
		this.displayEnterpriseNum = displayEnterpriseNum;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
}
