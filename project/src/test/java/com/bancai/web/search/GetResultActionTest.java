package com.bancai.web.search;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bancai.constants.BancaiConstants;
import com.bancai.dao.Enterprise;
import com.bancai.dao.Product;
import com.bancai.service.EnterpriseService;
import com.bancai.web.base.BaseAction;
import com.bancai.web.pcenter.UpdateEnterpriseAction;

import junit.framework.Assert;
import junit.framework.TestCase;

public class GetResultActionTest extends TestCase {
	private String NAME1 = "hello";
	private String PROVINCE1 = "山东";
	private String CITY1 = "临沂";
	private String COUNTY1 = "兰山区";
	private String ADDR1 = "杭州路398号";
	private String INTRODUCE1 = "绝好的板材";
	private String CONTACTER1 = "新板材";
	private Integer enterpriseId1;
	
	private String NAME2 = "山东临沂板材";
	private String PROVINCE2 = "山东";
	private String CITY2 = "临沂";
	private String COUNTY2 ="费县";
	private String ADDR2 = "河北路39号";
	private String INTRODUCE2 = "绝无仅有";
	private String CONTACTER2 = "宗方";
	private Integer enterpriseId2;
	
	private void createEnterprise(String name,  String province, String city, String county, 
			                                     String address, String introduction, String contacter) {
		UpdateEnterpriseAction enterpriseAction = new UpdateEnterpriseAction();
		
		enterpriseAction.setEnterpriseId(BancaiConstants.DEFAULT_ID);
		enterpriseAction.setName(NAME1);

		enterpriseAction.setProvince(province);
		enterpriseAction.setCity(city);
		enterpriseAction.setCounty(county);
		enterpriseAction.setAddress(address);
		enterpriseAction.setScale(20);
		enterpriseAction.setIntroduction(introduction);
		enterpriseAction.setContacter(contacter);
		enterpriseAction.setNumber("18612259320");
		
		 Assert.assertEquals(enterpriseAction.execute(), "success");
	}
		
	 @Before
	  public void setUp() throws Exception {  
		 BaseAction baseAction = new BaseAction();
		 
		 createEnterprise(NAME1, PROVINCE1, CITY1, COUNTY1, ADDR1, INTRODUCE1, CONTACTER1);
		 enterpriseId1 = baseAction.getEnterpriseId();
		 
		 createEnterprise(NAME2, PROVINCE2, CITY2, COUNTY2, ADDR2, INTRODUCE2, CONTACTER2);
		 enterpriseId2 = baseAction.getEnterpriseId();
	    } 
	 
	 @After
	 public void tearDown() throws Exception {
		 EnterpriseService service = new EnterpriseService();
		 
		 service.deleteEnterprise(enterpriseId1);
		 service.deleteEnterprise(enterpriseId2);
	 }
	 
	 private void checkEnterprise(List<Enterprise> enterprises, int id) {
		 Iterator<Enterprise> iter = enterprises.iterator();
		 Enterprise enterprise;
		 boolean isExist = false;
			
			while(iter.hasNext())
			{
				enterprise = iter.next();
				if (id == enterprise.getId() ) {
					isExist = true;
				}
			}
			
			Assert.assertEquals(isExist, true);
	 }
	 
	 private void checkProducts(List<Product> Products, int id) {
		 Iterator<Product> iter = Products.iterator();
		 Product product;
		 boolean isExist = false;
			
			while(iter.hasNext())
			{
				product = iter.next();
				if (id == product.getId() ) {
					isExist = true;
				}
			}
			
			Assert.assertEquals(isExist, true);
	 }
	 
	 @Test
	 public void testContentSearch() {
		 GetResultAction searchAction  = new GetResultAction();
		 
		 searchAction.setContent(INTRODUCE1);
		 try  {
			 searchAction.execute();
		 } catch (Exception e) {
			 List<Enterprise> enterprises = searchAction.getEnterprises();
			 checkEnterprise(enterprises, enterpriseId1);
			 
			 List<Product> products =  searchAction.getProducts();
		 }
		 
	 }
	 
}
