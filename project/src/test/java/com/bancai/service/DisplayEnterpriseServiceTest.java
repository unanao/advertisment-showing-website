package com.bancai.service;

import java.util.List;

import com.bancai.dao.Enterprise;

import junit.framework.TestCase;

public class DisplayEnterpriseServiceTest extends TestCase{
	
	public void testDelete() throws Exception{
		DisplayEnterpriseService service = new DisplayEnterpriseService();
		List<Enterprise> enterprises = service.getEnterprises("巨鹿", 6);
		for (Enterprise enterprise : enterprises) {
			System.out.println(enterprise.getId());
		}
	}
}
