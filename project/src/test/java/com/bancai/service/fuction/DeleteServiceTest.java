package com.bancai.service.fuction;

import javax.persistence.Query;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bancai.service.module.DeleteService;
import com.bancai.utils.sql.entitymanager.EntityManagerHelper;

public class DeleteServiceTest extends TestCase {

	DeleteService dService;
	@Before
	public void setUp() throws Exception {
		dService = new DeleteService();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testDeleteAllByUserName() {
		DeleteService deleteService = new DeleteService();
		try {
			deleteService.deleteAllByUserName("jianjiaosun@126.com");
			System.out.println("delete all by user name: success");
		} catch (Exception e) {
			System.out.println("delete all by user name: error");
		}
	}
	
}


