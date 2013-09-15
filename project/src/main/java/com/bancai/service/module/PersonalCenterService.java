package com.bancai.service.module;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.bancai.service.PhoneService;
import com.bancai.service.UserService;
import com.free4lab.utils.sql.entitymanager.EntityManagerHelper;

public class PersonalCenterService {
	Logger logger = Logger.getLogger(PersonalCenterService.class);
	
	public void editPersonalInfo(Integer userId, String nickName, String name, String gender, 
			String qq, String mobile, String officePhone) {
		UserService accountsService = new UserService();
		PhoneService phoneService = new PhoneService();
		
		EntityManagerHelper.beginTransaction();
		try 
		{
			accountsService.editPersonalInfo(userId, nickName, name, gender, qq);
			phoneService.editMobileByUserIdNoTransaction(mobile, userId);
			phoneService.editOfficePhoneByUserIdNoTransaction(officePhone, userId);
			
			EntityManagerHelper.commit();
		} 
		catch (RuntimeException re) 
		{
			EntityManagerHelper.rollback();
			logger.log(Level.FATAL, "update error", re);
			throw re;
		}
	}
}
