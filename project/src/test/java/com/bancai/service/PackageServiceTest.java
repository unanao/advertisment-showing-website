/*
package com.bancai.service;

import java.sql.Timestamp;

import com.bancai.common.PackageConstants;
import com.bancai.service.PackageService;
import com.bancai.dao.Package;

import junit.framework.TestCase;

public class PackageServiceTest extends TestCase implements PackageConstants {
	public void testAddNewPackage() {
	
		PackageService pkgService = new PackageService();
		Package pkg = new Package();
		Timestamp startTimestamp = new Timestamp(System.currentTimeMillis());
		Timestamp endTimestamp = new Timestamp(System.currentTimeMillis() + 1000);
		
		pkg.setName("套餐1");
		pkg.setAdNum(0);
		pkg.setDisplayProductNum(1);
		pkg.setDisplayEnterpriseNum(2);
		pkg.setEnterpriseArea("北极");
		pkg.setProductCategory("地球");
		pkg.setTime(10000);
		pkg.setPrice(100d);
		pkg.setStartTime(startTimestamp);
		pkg.setEndTime(endTimestamp);
		pkg.setStatus(PACKAGE_STATUS_OPEN);
		
		pkgService.addNewPackage(pkg);
	
	}
}
*/
